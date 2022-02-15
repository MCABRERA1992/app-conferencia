package com.fisagr.gestion.pista.conferencia.service.main;

import com.fisagr.gestion.pista.conferencia.service.utils.UtilsComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author ${milton.cabrera} on 11/2/2022 19:42
 * @project app-gestion-pista-conferencia
 * @Version 1.0
 **/
@Component
public class GestionConferencia implements CommandLineRunner {

    @Autowired
    private UtilsComponent utilsComponent;

    @Override
    public void run(String... args) throws Exception {
        this.utilsComponent.recorriendoCharlas();
    }
}
