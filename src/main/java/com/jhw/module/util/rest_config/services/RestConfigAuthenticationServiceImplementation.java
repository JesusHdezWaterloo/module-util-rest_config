/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.util.rest_config.services;

import com.clean.core.app.services.AuthenticationHandler;
import com.clean.core.app.services.AuthenticationHandlerService;
import java.util.Map;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class RestConfigAuthenticationServiceImplementation implements AuthenticationHandlerService<String, String, Boolean, OAuth2AccessToken> {

    public static RestConfigAuthenticationServiceImplementation init() {
        RestConfigAuthenticationServiceImplementation auth = new RestConfigAuthenticationServiceImplementation();
        AuthenticationHandler.registerAuthHandlerService(auth);
        return auth;
    }

    private RestConfigAuthenticationServiceImplementation() {
    }

    @Override
    public Boolean login(String user, String pass, Map<String, Object> args) {
        return RESTHandler.login(user, pass, args);
    }

}
