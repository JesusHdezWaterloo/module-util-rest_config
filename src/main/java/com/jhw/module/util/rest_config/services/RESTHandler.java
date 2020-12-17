/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.util.rest_config.services;

import com.jhw.module.util.rest_config.core.domain.Configuration;
import com.jhw.module.util.rest_config.core.domain.ConnectionTarget;
import com.jhw.module.util.rest_config.core.module.RestConfigCoreModule;
import com.jhw.module.util.rest_config.core.usecase_def.RestConfigUseCase;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.web.client.RestOperations;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class RESTHandler {

    private static RestConfigUseCase REST_UC = RestConfigCoreModule.init().getImplementation(RestConfigUseCase.class);

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

    public static boolean isConnected() {
        return REST_UC.isConnected();
    }

    public static long pingEveryMillis() {
        try {
            return load().getConnectionPingEveryMillis();
        } catch (Exception e) {
            return 1 * 1000;
        }
    }

    public static String urlActualREST() {
        try {
            return actual().urlREST();
        } catch (Exception e) {
            return "";
        }
    }

    public static String urlActualApache() {
        try {
            return actual().urlApache();
        } catch (Exception e) {
            return "";
        }
    }

    public static RestOperations restTemplate() {
        try {
            return REST_UC.restTemplate();
        } catch (Exception e) {
            return null;
        }
    }

    public static OAuth2RestOperations OAuth2RestTemplate() {
        try {
            return REST_UC.OAuth2RestTemplate();
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean login(String user, String pass) {
        return REST_UC.login(user, pass);
    }

    public static boolean login(String user, String pass, Map<String, Object> args) {
        return REST_UC.login(user, pass, args);
    }

    public static Duration connectTimeOut() throws Exception {
        return load().connectTimeOut();
    }

    public static Duration readTimeOut() throws Exception {
        return load().readTimeOut();
    }
}
