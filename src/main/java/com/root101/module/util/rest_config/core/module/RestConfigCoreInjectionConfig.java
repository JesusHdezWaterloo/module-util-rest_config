package com.jhw.module.util.rest_config.core.module;

import com.google.inject.AbstractModule;
import com.jhw.module.util.rest_config.core.usecase_impl.RestConfigUseCaseImpl;
import com.jhw.module.util.rest_config.core.usecase_def.RestConfigUseCase;

/**
 * Configuracion del injection del modulo de licencia-core.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class RestConfigCoreInjectionConfig extends AbstractModule {

    @Override
    protected void configure() {
        bind(RestConfigUseCase.class).to(RestConfigUseCaseImpl.class)/*.in(Singleton.class)*/;
    }

}
