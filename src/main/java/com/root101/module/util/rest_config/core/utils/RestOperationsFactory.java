/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.module.util.rest_config.core.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.root101.module.util.rest_config.core.usecase_def.RestConfigUseCase;
import com.root101.json.jackson.JACKSON;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
