package com.fisagr.gestion.pista.conferencia.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ${milton.cabrera} on 12/2/2022 11:59
 * @project app-gestion-pista-conferencia
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConferenciaDto {

    private Integer duracionPista;
    private Integer totalPista;
    private Integer totalCharla;
    private List<CharlaDto> charlaDtos;

}
