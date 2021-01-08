/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.root101.module.util.rest_config.services;

import com.root101.clean.core.app.services.ExceptionHandler;
import com.root101.clean.core.app.services.ExceptionHandlerServiceFunctional;
import com.root101.clean.core.app.services.NotificationHandler;
import com.root101.clean.core.app.services.NotificationsGeneralType;
import com.root101.clean.core.domain.services.ResourceHandler;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
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
