package com.fisagr.gestion.pista.conferencia.service.enums;

/**
 * @author ${milton.cabrera} on 11/2/2022 19:44
 * @project app-gestion-pista-conferencia
 * @Version 1.0
 **/
public enum EnumRangoSesion {

    HORARIO_MATUTINO(9, 12),
    HORARIO_VESPERTINO(13, 15);

    private int inicio;
    private int fin;

    private EnumRangoSesion(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    public int getInicio() {
        return inicio;
    }

    public int getFin() {
        return fin;
    }
}
