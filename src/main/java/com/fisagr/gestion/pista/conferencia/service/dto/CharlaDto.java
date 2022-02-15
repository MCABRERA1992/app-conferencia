package com.fisagr.gestion.pista.conferencia.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ${milton.cabrera} on 11/2/2022 19:43
 * @project app-gestion-pista-conferencia
 * @Version 1.0
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CharlaDto {

    private int identificadorCharla;
    private String tituloCharla;
    private boolean salidaAlmuerzo;
    private String tituloNetworking;
    private boolean salidaAlmuerzoCharlaNetworking;
    private int duracionSesion;
    private String tituloAlmuerzo;
    private String tituloPista;
    private String estado = "";
    private String banderaCharla;
}
