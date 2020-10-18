package com.jhw.module.util.rest_config.core.module;

import com.clean.core.app.modules.AbstractModule;
import com.clean.core.app.modules.DefaultAbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Modulo de licencia-core.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class RestConfigCoreModule extends DefaultAbstractModule {

    private final Injector inj = Guice.createInjector(new InjectionConfigRestConfigCore());

    private static RestConfigCoreModule INSTANCE;

    public static RestConfigCoreModule getInstance() {
        if (INSTANCE == null) {
            throw new NullPointerException("El modulo de REST-Config no se ha inicializado");
        }
        return INSTANCE;
    }

    public static RestConfigCoreModule init(AbstractModule repoModule) {
        INSTANCE = new RestConfigCoreModule();
        INSTANCE.registerModule(repoModule);
        return getInstance();
    }

    @Override
    protected <T> T getOwnImplementation(Class<T> type) {
        return inj.getInstance(type);
    }

    @Override
    public String getModuleName() {
        return "REST-Config Core Module";
    }

}
