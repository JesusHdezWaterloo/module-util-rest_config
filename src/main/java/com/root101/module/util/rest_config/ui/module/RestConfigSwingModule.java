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
package com.root101.module.util.rest_config.ui.module;

import com.root101.clean.core.app.services.ExceptionHandler;
import com.root101.clean.swing.app.AbstractSwingApplication;
import com.root101.clean.swing.app.DefaultAbstractSwingMainModule;
import com.root101.clean.swing.app.dashboard.DashBoardSimple;
import com.root101.clean.swing.app.dashboard.DashboardConstants;
import com.root101.module.util.rest_config.services.RESTExceptionHandler;
import com.root101.module.util.rest_config.services.RestConfigResourceServiceImplementation;
import com.root101.module.util.rest_config.ui.connection.ConnectionComponent;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class RestConfigSwingModule extends DefaultAbstractSwingMainModule {

    private final RestConfigModuleNavigator navigator = new RestConfigModuleNavigator();

    private RestConfigSwingModule() {
    }

    public static RestConfigSwingModule init() {
        System.out.println("Iniciando 'Configuracion REST'");
        RESTExceptionHandler.init();
        try {
            RestConfigResourceServiceImplementation.init();
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
        return new RestConfigSwingModule();
    }

    @Override
    public void register(AbstractSwingApplication app) {
        DashBoardSimple dash = app.rootView().dashboard();

        dash.addKeyValue(DashboardConstants.DOWN_ELEMENT, ConnectionComponent.fromComponent(), 0);
    }

    @Override
    public void navigateTo(String string, Object... o) {
        navigator.navigateTo(string, o);
    }

}
