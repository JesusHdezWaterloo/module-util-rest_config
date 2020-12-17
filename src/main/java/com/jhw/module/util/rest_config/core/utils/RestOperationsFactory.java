/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.util.rest_config.core.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jhw.module.util.rest_config.core.usecase_def.RestConfigUseCase;
import com.jhw.utils.jackson.JACKSON;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class RestOperationsFactory {

    public static RestOperationsFactory from(RestConfigUseCase uc) {
        return new RestOperationsFactory(uc);
    }

    private final RestConfigUseCase uc;

    public RestOperationsFactory(RestConfigUseCase uc) {
        this.uc = uc;
    }

    public RestOperations build() {
        ObjectMapper om = new ObjectMapper();
        JACKSON.configureObjectMapper(om);

        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        messageConverter.setPrettyPrint(true);
        messageConverter.setObjectMapper(om);

        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().removeIf(m -> m.getClass().isAssignableFrom(MappingJackson2HttpMessageConverter.class));
        rt.getMessageConverters().add(messageConverter);

        return rt;
    }
}
