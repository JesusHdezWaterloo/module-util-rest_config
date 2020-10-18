package com.jhw.module.util.rest_config.repo.module;

import com.jhw.module.util.rest_config.repo.repo_impl.RestConfigRepoImpl;
import com.google.inject.AbstractModule;
import com.jhw.module.util.rest_config.core.repo_def.RestConfigRepo;

/**
 * Configuracion del injection del modulo de licencia-repo.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class InjectionConfigRestConfigRepo extends AbstractModule {

    @Override
    protected void configure() {
        bind(RestConfigRepo.class).to(RestConfigRepoImpl.class);
    }

}
