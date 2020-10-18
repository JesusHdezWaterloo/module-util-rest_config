/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.util.rest_config.services;

import com.jhw.module.util.rest_config.core.domain.Configuration;
import com.jhw.module.util.rest_config.core.domain.ConnectionTarget;
import com.jhw.module.util.rest_config.core.module.RestConfigCoreModule;
import com.jhw.module.util.rest_config.repo.module.RestConfigRepoModule;
import com.jhw.module.util.rest_config.core.usecase_def.RestConfigUseCase;
import java.time.Duration;
import java.util.List;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class RESTHandler {

    private static RestConfigUseCase REST_UC = RestConfigCoreModule.init(RestConfigRepoModule.init()).getImplementation(RestConfigUseCase.class);

    private RESTHandler() {
    }

    public static void registerMySQLService(RestConfigUseCase newService) {
        REST_UC = newService;
    }

    public static Configuration load() throws Exception {
        return REST_UC.read();
    }

    public static List<ConnectionTarget> conections() throws Exception {
        return REST_UC.conections();
    }

    public static ConnectionTarget actual() throws Exception {
        return REST_UC.actual();
    }

    public static String urlActual() {
        try {
            return actual().url();
        } catch (Exception e) {
            return "";
        }
    }

    public static Duration connectTimeOut() throws Exception {
        return load().connectTimeOut();
    }

    public static Duration readTimeOut() throws Exception {
        return load().readTimeOut();
    }
}
