/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.util.rest_config.services;

import com.clean.core.app.services.AuthenticationHandler;
import com.clean.core.app.services.AuthenticationHandlerService;
import java.lang.reflect.Method;
import java.util.Map;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class AuthenticationService implements AuthenticationHandlerService<String, String, Boolean, OAuth2AccessToken> {

    public static AuthenticationService init() {
        AuthenticationService auth = new AuthenticationService();
        AuthenticationHandler.registerLoginHandlerService(auth);
        return auth;
    }

    private AuthenticationService() {
    }

    @Override
    public Boolean login(String user, String pass, Map<String, Object> args) {
        return RESTHandler.login(user, pass, args);
    }

    @Override
    public OAuth2AccessToken user() {
        return RESTHandler.OAuth2RestTemplate().getAccessToken();
    }

    @Override
    public boolean checkAccess(Method method) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
