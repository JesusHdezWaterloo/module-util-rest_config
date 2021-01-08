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
package com.root101.module.util.rest_config.core.usecase_impl;

import com.root101.module.util.rest_config.core.utils.RestOperationsFactory;
import com.root101.clean.core.app.usecase.DefaultReadWriteUseCase;
import com.root101.module.util.rest_config.core.domain.Configuration;
import com.root101.module.util.rest_config.core.domain.ConnectionTarget;
import com.root101.module.util.rest_config.core.module.RestConfigCoreModule;
import java.util.List;
import com.root101.module.util.rest_config.core.repo_def.RestConfigRepo;
import com.root101.module.util.rest_config.core.usecase_def.RestConfigUseCase;
import com.root101.module.util.rest_config.core.utils.OAuth2RestOperationsFactory;
import com.root101.utils.others.Network;
import java.util.Map;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.web.client.RestOperations;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class RestConfigUseCaseImpl extends DefaultReadWriteUseCase<Configuration> implements RestConfigUseCase {

    /**
     * Instancia del repo para almacenar las cosas en memoria
     */
    private final RestConfigRepo repo = RestConfigCoreModule.getInstance().getImplementation(RestConfigRepo.class);

    private final RestOperations template;
    private OAuth2RestOperations oauth2Template;

    /**
     * Constructor por defecto, usado par injectar.
     */
    public RestConfigUseCaseImpl() {
        super.setRepo(repo);
        template = RestOperationsFactory.from(this).build();
    }

    @Override
    public List<ConnectionTarget> conections() throws Exception {
        return read().getList();
    }

    @Override
    public ConnectionTarget actual() throws Exception {
        return read().actual();
    }

    @Override
    public RestOperations restTemplate() throws Exception {//TODO
        return template;
    }

    @Override
    public OAuth2RestOperations OAuth2RestTemplate() {
        return oauth2Template;
    }

    @Override
    public boolean login(String user, String pass, Map<String, Object> args) {
        try {
            oauth2Template = OAuth2RestOperationsFactory.from(this).build(user, pass);
            System.out.println(oauth2Template.getAccessToken());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean logout() {
        try {
            oauth2Template = null;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean isConnected() {
        try {
            return Network.isRunning(actual().getIp(), actual().getPortRest());
        } catch (Exception e) {
            return false;
        }
    }
}
