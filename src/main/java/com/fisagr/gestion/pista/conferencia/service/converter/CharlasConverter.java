package com.fisagr.gestion.pista.conferencia.service.converter;

import com.fisagr.gestion.pista.conferencia.service.dto.CharlaDto;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author ${milton.cabrera} on 12/2/2022 12:50
 * @project app-gestion-pista-conferencia
 * @Version 1.0
 **/
public class CharlasConverter {

    public static Function<Object, List<CharlaDto>> objectListFunction = o -> {

        List<CharlaDto> charlaDtoList = new ArrayList<>();

        charlaDtoList.add(CharlaDto.builder().identificadorCharla(1).tituloCharla("Writing Fast Tests Against Enterprise Rails").duracionSesion(60).build());
        charlaDtoList.add(CharlaDto.builder().identificadorCharla(2).tituloCharla("Overdoing it in Python").duracionSesion(45).build());
        charlaDtoList.add(CharlaDto.builder().identificadorCharla(3).tituloCharla("Lua for the Masses").duracionSesion(30).build());
        charlaDtoList.add(CharlaDto.builder().identificadorCharla(4).tituloCharla("Ruby Errors from Mismatched Gem Versions").duracionSesion(45).build());
        charlaDtoList.add(CharlaDto.builder().identificadorCharla(5).tituloCharla("Common Ruby Errors").duracionSesion(45).build());
        charlaDtoList.add(CharlaDto.builder().identificadorCharla(6).tituloCharla("Rails for Python Developers lightning").duracionSesion(0).build());
        charlaDtoList.add(CharlaDto.builder().identificadorCharla(7).tituloCharla("Communicating Over Distance").duracionSesion(60).build());
        charlaDtoList.add(CharlaDto.builder().identificadorCharla(8).tituloCharla("Accounting-Driven Development").duracionSesion(45).build());
        charlaDtoList.add(CharlaDto.builder().identificadorCharla(9).tituloCharla("Woah").duracionSesion(30).build());
        charlaDtoList.add(CharlaDto.builder().identificadorCharla(10).tituloCharla("Sit Down and Write").duracionSesion(30).build());
        charlaDtoList.add(CharlaDto.builder().identificadorCharla(11).tituloCharla("Pair Programming vs Noise").duracionSesion(45).build());
        charlaDtoList.add(CharlaDto.builder().identificadorCharla(12).tituloCharla("Rails Magic").duracionSesion(60).build());
        charlaDtoList.add(CharlaDto.builder().identificadorCharla(13).tituloCharla("Ruby on Rails: Why We Should Move On").duracionSesion(60).build());
        charlaDtoList.add(CharlaDto.builder().identificadorCharla(14).tituloCharla("Clojure Ate Scala (on my project)").duracionSesion(45).build());
        charlaDtoList.add(CharlaDto.builder().identificadorCharla(15).tituloCharla("Programming in the Boondocks of Seattle").duracionSesion(30).build());
        charlaDtoList.add(CharlaDto.builder().identificadorCharla(16).tituloCharla("Ruby vs. Clojure for Back-End Development").duracionSesion(30).build());
        charlaDtoList.add(CharlaDto.builder().identificadorCharla(17).tituloCharla("Ruby on Rails Legacy App Maintenance").duracionSesion(60).build());
        charlaDtoList.add(CharlaDto.builder().identificadorCharla(18).tituloCharla("A World Without HackerNews").duracionSesion(30).build());
        charlaDtoList.add(CharlaDto.builder().identificadorCharla(19).tituloCharla("User Interface CSS in Rails Apps").duracionSesion(30).build());

        return charlaDtoList.isEmpty() ? new ArrayList<>() : charlaDtoList.stream().collect(Collectors.toList());
    };

}
