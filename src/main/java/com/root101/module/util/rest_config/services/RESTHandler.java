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
package com.root101.module.util.rest_config.services;

import com.root101.module.util.rest_config.core.domain.Configuration;
import com.root101.module.util.rest_config.core.domain.ConnectionTarget;
import com.root101.module.util.rest_config.core.module.RestConfigCoreModule;
import com.root101.module.util.rest_config.core.usecase_def.RestConfigUseCase;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.web.client.RestOperations;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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

    public static boolean logout() {
        return REST_UC.logout();
    }

    public static Duration connectTimeOut() throws Exception {
        return load().connectTimeOut();
    }

    public static Duration readTimeOut() throws Exception {
        return load().readTimeOut();
    }
}
