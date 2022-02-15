package com.fisagr.gestion.pista.conferencia.service.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.fisagr.gestion.pista.conferencia.service.converter.CharlasConverter;
import com.fisagr.gestion.pista.conferencia.service.dto.CharlaDto;
import com.fisagr.gestion.pista.conferencia.service.enums.EnumSesion;

import lombok.extern.slf4j.Slf4j;

/**
 * @author ${milton.cabrera} on 11/2/2022 19:46
 * @project app-gestion-pista-conferencia
 * @Version 1.0
 **/
@Slf4j
@Component
public class UtilsComponent {

	public void recorriendoCharlas() throws ParseException {

		log.info("Iniciando proceso de cargar lista de charlas {UtilsComponent.recorriendoCharlas}");
		List<CharlaDto> charlaDtos = CharlasConverter.objectListFunction.apply("");

		try {
			charlaDtos = obtenerCharlasHorarioMatutino(charlaDtos);

			charlaDtos.stream().sorted((x1, x2) -> x1.getBanderaCharla().compareTo(x2.getBanderaCharla()))
					.forEach(e -> {

						if (!e.getTituloCharla().isEmpty() && Objects.nonNull(e.getEstado())) {
							log.info(e.getTituloCharla());
						}

						if (!e.getTituloCharla().isEmpty() && Objects.nonNull(e.getTituloAlmuerzo())) {
							log.info(e.getTituloAlmuerzo());
						}

						if (!e.getTituloCharla().isEmpty() && Objects.nonNull(e.getTituloNetworking())) {
							log.info(e.getTituloNetworking());
							log.info("Jornada Finalizada");
						}
					});
		} catch (Exception e) {
			log.error("Error durante el proceso de recorrer el lista de las charlas {UtilsComponent.recorriendoCharlas}"
					+ e);
		}
	}

	private Calendar obtenerHoraMatutino() {
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.HOUR, 9);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.AM_PM, Calendar.AM);
		return calendar;
	}

	private Calendar obtenerHoraTurnoVespertino() {
		Calendar calendar = new GregorianCalendar();
		calendar.set(Calendar.HOUR, 13);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.AM_PM, Calendar.AM);
		return calendar;
	}

	private List<CharlaDto> obtenerCharlasHorarioMatutino(List<CharlaDto> charlaDtos) throws ParseException {

		int conta = 0;
		String banderaCharla = "C1";
		while (conta == 0) {

			Integer tiempoMatutino = EnumSesion.TURNO_MATUTINO.getDuracionSesion();
			Calendar calendar = obtenerHoraMatutino();
			for (CharlaDto charlaDto : charlaDtos.stream().filter(e -> Objects.isNull(e.getEstado()))
					.collect(Collectors.toList())) {

				if (Objects.isNull(charlaDto.getEstado())) {
					if (charlaDto.getDuracionSesion() == 0) {
						charlaDto.setDuracionSesion(5);
					}

					if (tiempoMatutino >= charlaDto.getDuracionSesion()) {

						tiempoMatutino = tiempoMatutino - charlaDto.getDuracionSesion();
						charlaDto.setTituloCharla(new SimpleDateFormat("HH:mm a").format(calendar.getTime()) + " "
								+ charlaDto.getTituloCharla() + " " + charlaDto.getDuracionSesion() + "min");
						charlaDto.setEstado("A");
						charlaDto.setBanderaCharla(banderaCharla);
						calendar.add(Calendar.MINUTE, charlaDto.getDuracionSesion());

					}

					if (tiempoMatutino == 0 || tiempoMatutino <= charlaDto.getDuracionSesion()) {

						charlaDto.setTituloAlmuerzo("12:00 p. m. Salida Almuerzo");
						charlaDto.setSalidaAlmuerzo(true);
						break;
					}

				}
			}

			Integer tiempoVespertino = EnumSesion.TURNO_VESPERTINO.getDuracionSesion();
			Calendar calendarVes = obtenerHoraTurnoVespertino();
			for (CharlaDto charlaDto1 : charlaDtos.stream().filter(e -> Objects.isNull(e.getEstado()))
					.collect(Collectors.toList())) {

				if (charlaDto1.getDuracionSesion() == 0) {
					charlaDto1.setDuracionSesion(5);
				}

				if (!StringUtils.equalsAnyIgnoreCase("A", charlaDto1.getEstado())) {
					if (charlaDto1.getDuracionSesion() > 0 && tiempoVespertino >= charlaDto1.getDuracionSesion()) {

						tiempoVespertino = tiempoVespertino - charlaDto1.getDuracionSesion();
						charlaDto1.setTituloCharla(new SimpleDateFormat("HH:mm a").format(calendarVes.getTime()) + " "
								+ charlaDto1.getTituloCharla() + " " + charlaDto1.getDuracionSesion() + "min");
						charlaDto1.setEstado("A");
						charlaDto1.setBanderaCharla(banderaCharla);
						calendarVes.add(Calendar.MINUTE, charlaDto1.getDuracionSesion());

					}
				}
				if (tiempoVespertino == 0 || tiempoVespertino <= charlaDto1.getDuracionSesion()) {

					int updateCharla = charlaDto1.getIdentificadorCharla() - 1;

					if (charlaDtos.stream().count() == charlaDtos.stream()
							.filter(t -> StringUtils.equalsIgnoreCase("A", t.getEstado())).count()) {

						charlaDto1.setTituloNetworking("17:00 p. m. Evento NetWorking");
						charlaDto1.setSalidaAlmuerzoCharlaNetworking(true);

					} else if(charlaDtos.stream()
							.filter(t -> StringUtils.equalsIgnoreCase("A", t.getEstado())).count() < charlaDtos.stream().count()){
//						charlaDtos.stream().filter(e -> e.getIdentificadorCharla() == updateCharla).forEach(t -> {
//							t.setTituloNetworking("17:00 p. m. Evento NetWorking");
//							t.setSalidaAlmuerzoCharlaNetworking(true);"
//						});
						charlaDto1.setTituloNetworking("17:00 p. m. Evento NetWorking");
						charlaDto1.setSalidaAlmuerzoCharlaNetworking(true);
					}
					break;
				}
			}

			if (charlaDtos.stream().count() == charlaDtos.stream()
					.filter(t -> StringUtils.equalsIgnoreCase("A", t.getEstado())).count()) {
				conta++;
			} else {
				banderaCharla = "C2";
			}
		}
		return charlaDtos;
	}

}
