/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.util.rest_config.services;

import com.root101.clean.core.app.services.ExceptionHandlerServiceFunctional;
import org.springframework.web.client.ResourceAccessException;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class ExceptionsRESTType {

    //Excepcion general
    public static final String ACCESS = ExceptionHandlerServiceFunctional.getExceptionType(ResourceAccessException.class);
    public static final String MSG_ACCESS = "msg.rest_config.error.access_exception";

}
