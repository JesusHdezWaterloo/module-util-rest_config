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
package com.root101.module.util.rest_config.core.usecase_def;

import com.root101.clean.core.app.usecase.ReadWriteUseCase;
import com.root101.module.util.rest_config.core.domain.Configuration;
import com.root101.module.util.rest_config.core.domain.ConnectionTarget;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.web.client.RestOperations;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public interface RestConfigUseCase extends ReadWriteUseCase<Configuration> {

    public default boolean login(String user, String pass) {
        return login(user, pass, new HashMap<>());
    }

    public boolean login(String user, String pass, Map<String, Object> args);

    public boolean logout();

    public List<ConnectionTarget> conections() throws Exception;

    public ConnectionTarget actual() throws Exception;

    public RestOperations restTemplate() throws Exception;

    public OAuth2RestOperations OAuth2RestTemplate() throws Exception;

    public boolean isConnected();

}
