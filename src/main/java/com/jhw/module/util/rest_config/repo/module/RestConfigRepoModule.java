package com.jhw.module.util.rest_config.repo.module;

import com.clean.core.app.modules.DefaultAbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Modulo de licencia-core.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class RestConfigRepoModule extends DefaultAbstractModule {

    private final Injector inj = Guice.createInjector(new InjectionConfigRestConfigRepo());

    private static RestConfigRepoModule INSTANCE;

    private RestConfigRepoModule() {
    }

    public static RestConfigRepoModule getInstance() {
        if (INSTANCE == null) {
            throw new NullPointerException("El modulo de REST-Config no se ha inicializado");
        }
        return INSTANCE;
    }

    public static RestConfigRepoModule init() {
        INSTANCE = new RestConfigRepoModule();
        return getInstance();
    }

    @Override
    protected <T> T getOwnImplementation(Class<T> type) {
        return inj.getInstance(type);
    }

    @Override
    public String getModuleName() {
        return "REST-Config Repo Module";
    }

}
