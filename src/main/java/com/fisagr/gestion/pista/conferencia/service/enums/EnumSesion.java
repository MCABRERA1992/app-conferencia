package com.fisagr.gestion.pista.conferencia.service.enums;

/**
 * @author ${milton.cabrera} on 12/2/2022 12:06
 * @project app-gestion-pista-conferencia
 * @Version 1.0
 **/
public enum EnumSesion {

    TURNO_MATUTINO(180),// total de tiempo de la entrada a las 9 hasta las 12 del dia, cada hora contiene 60 minutos por lo cual el intervalo de 9 a 12 son de 3 horas, por lo cual se mmultiplica 60 * 3 = 180
    TURNO_VESPERTINO(240),//total del tiempo calcula desde las 13pm hasta las 17pm, al igual q la jornada matutina aplicamos el mismo calculo 60 * 4
    JORNADA_COMPLETA(420);//duracion totoal de la jornada completa de las sesiones por dia

    private int duracionSesion;

    private EnumSesion(int duracionSesion) {
        this.duracionSesion = duracionSesion;
    }

    public int getDuracionSesion() {
        return duracionSesion;
    }
}
