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

import com.root101.clean.core.app.services.ExceptionHandler;
import com.root101.clean.core.app.services.ExceptionHandlerServiceFunctional;
import com.root101.clean.core.app.services.NotificationHandler;
import com.root101.clean.core.app.services.NotificationsGeneralType;
import com.root101.clean.core.domain.services.ResourceHandler;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class RESTExceptionHandler extends ExceptionHandlerServiceFunctional {

    public static RESTExceptionHandler init() {
        RESTExceptionHandler excep = new RESTExceptionHandler();
        ExceptionHandler.registerExceptionService(excep);
        return excep;
    }

    private RESTExceptionHandler() {
        addAll();
    }

    @Override
    protected void addAll() {
        addHandler(ExceptionsRESTType.ACCESS, (Throwable e) -> {
            NotificationHandler.showNotification(NotificationsGeneralType.NOTIFICATION_ERROR,
                    ResourceHandler.getString(ExceptionsRESTType.MSG_ACCESS));
        });
    }

}
