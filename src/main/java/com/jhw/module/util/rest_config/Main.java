/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.util.rest_config;

import com.clean.core.app.services.ExceptionHandler;
import com.jhw.module.util.rest_config.services.RESTHandler;
import com.jhw.module.util.rest_config.ui.module.RestConfigSwingModule;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        RestConfigSwingModule.init();
        try {
            new RestTemplate().getForObject("http://localhost:8080/gasto/tipo_gastos/find_all", String.class);
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
    }

}
