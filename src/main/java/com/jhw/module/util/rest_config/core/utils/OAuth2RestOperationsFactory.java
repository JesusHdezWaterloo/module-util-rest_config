/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.util.rest_config.core.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jhw.module.util.rest_config.core.usecase_def.RestConfigUseCase;
import com.root101.json.jackson.JACKSON;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.security.oauth2.client.DefaultOAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.AccessTokenRequest;
import org.springframework.security.oauth2.client.token.DefaultAccessTokenRequest;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.web.client.RestTemplate;

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
        OAuth2RestTemplate rt = new OAuth2RestTemplate(resource, new DefaultOAuth2ClientContext(accessTokenRequest));

        ObjectMapper om = new ObjectMapper();
        JACKSON.configureObjectMapper(om);

        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        messageConverter.setPrettyPrint(true);
        messageConverter.setObjectMapper(om);

        rt.getMessageConverters().removeIf(m -> m.getClass().isAssignableFrom(MappingJackson2HttpMessageConverter.class));
        rt.getMessageConverters().add(messageConverter);

        return rt;
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
