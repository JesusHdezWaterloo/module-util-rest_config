/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.util.rest_config;

import com.clean.core.app.services.ExceptionHandler;
import com.jhw.module.util.rest_config.services.RESTHandler;
import com.jhw.module.util.rest_config.ui.connection.ConnectionComponent;
import com.jhw.module.util.rest_config.ui.module.RestConfigSwingModule;
import com.jhw.swing.bundles.dialog.DialogPanel;
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
        new DialogPanel("123123123", ConnectionComponent.fromComponent()).setResizable(true);
    }

}
