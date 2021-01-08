package com.jhw.module.util.rest_config.core.utils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.validator.routines.InetAddressValidator;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class Ipv4Register implements ConstraintValidator<Ipv4, String> {

    @Override
    public void initialize(Ipv4 a) {
        ConstraintValidator.super.initialize(a);
    }

    @Override
    public boolean isValid(String ip, ConstraintValidatorContext cvc) {
        return ip.equals("localhost") || InetAddressValidator.getInstance().isValidInet4Address(ip);
    }

}
