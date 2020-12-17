/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.util.rest_config.core.utils;

import com.jhw.module.util.rest_config.core.usecase_def.RestConfigUseCase;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class OAuth2RestOperationsFactory {

    public static OAuth2RestOperationsFactory from(RestConfigUseCase uc) {
        return new OAuth2RestOperationsFactory(uc);
    }

    private final RestConfigUseCase uc;

    public OAuth2RestOperationsFactory(RestConfigUseCase uc) {
        this.uc = uc;
    }

    public OAuth2RestOperations build(String username, String password) throws Exception {
        AccessTokenRequest accessTokenRequest = new DefaultAccessTokenRequest();
        OAuth2ProtectedResourceDetails resource = resource(username, password);
        return new OAuth2RestTemplate(resource, new DefaultOAuth2ClientContext(accessTokenRequest));
    }

    private OAuth2ProtectedResourceDetails resource(String username, String password) throws Exception {
        ResourceOwnerPasswordResourceDetails resource = new ResourceOwnerPasswordResourceDetails();

        resource.setClientId(ClientConstant.CLIENT_ID);
        resource.setClientSecret(ClientConstant.CLIENT_SECRET);
        resource.setScope(ClientConstant.CLIENT_SCOPE);
        resource.setGrantType(ClientConstant.CLIENT_GRANT_TYPE);
        resource.setAccessTokenUri(uc.read().getOauth2TokenURL());
        resource.setUsername(username);
        resource.setPassword(password);

        return resource;
    }
}
