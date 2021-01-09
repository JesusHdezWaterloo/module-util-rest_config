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
package com.root101.module.util.rest_config.repo.module;

import com.root101.clean.core.app.modules.DefaultAbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.root101.clean.core.domain.services.ResourceHandler;
import com.root101.clean.core.exceptions.AlreadyInitModule;
import com.root101.clean.core.exceptions.NotInitModule;
import static com.root101.module.util.rest_config.services.ResourceKeys.KEY_MODULE_NAME_REST_CONFIG;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class RestConfigRepoModule extends DefaultAbstractModule {

    private final Injector inj = Guice.createInjector(new RestConfigRepoInjectionConfig());

    private static RestConfigRepoModule INSTANCE;

    private RestConfigRepoModule() {
    }

    public static RestConfigRepoModule getInstance() {
        if (INSTANCE == null) {
            throw new NotInitModule(ResourceHandler.getString(KEY_MODULE_NAME_REST_CONFIG));
        }
        return INSTANCE;
    }

    public static RestConfigRepoModule init() {
        if (INSTANCE != null) {
            throw new AlreadyInitModule(ResourceHandler.getString(KEY_MODULE_NAME_REST_CONFIG));
        }
        INSTANCE = new RestConfigRepoModule();
        return getInstance();
    }

    @Override
    protected <T> T getOwnImplementation(Class<T> type) {
        return inj.getInstance(type);
    }

    @Override
    public String getModuleName() {
        return "REST-Config Repo Module";
    }

}
