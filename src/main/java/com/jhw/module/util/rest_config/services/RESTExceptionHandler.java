/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.util.rest_config.services;

import com.clean.core.app.services.ExceptionHandler;
import com.clean.core.app.services.ExceptionHandlerServiceFunctional;
import com.clean.core.app.services.Notification;
import com.clean.core.app.services.NotificationsGeneralType;
import com.clean.core.domain.services.Resource;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class RESTExceptionHandler extends ExceptionHandlerServiceFunctional {

    public static RESTExceptionHandler init() {
        RESTExceptionHandler excep = new RESTExceptionHandler();
        ExceptionHandler.registerExceptionHandlerService(excep);
        return excep;
    }

    private RESTExceptionHandler() {
        addAll();
    }

    @Override
    protected void addAll() {
        addHandler(ExceptionsRESTType.ACCESS, (Throwable e) -> {
            Notification.showNotification(NotificationsGeneralType.NOTIFICATION_ERROR,
                    Resource.getString(ExceptionsRESTType.MSG_ACCESS));
        });
    }

}
