package com.jhw.module.util.rest_config.core.module;

import com.root101.clean.core.app.modules.AbstractModule;
import com.root101.clean.core.app.modules.DefaultAbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.jhw.module.util.rest_config.repo.module.RestConfigRepoModule;

/**
 * Modulo de licencia-core.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class RestConfigCoreModule extends DefaultAbstractModule {

    private final Injector inj = Guice.createInjector(new RestConfigCoreInjectionConfig());

    private static RestConfigCoreModule INSTANCE;

    public static RestConfigCoreModule getInstance() {
        if (INSTANCE == null) {
            throw new NullPointerException("El modulo de REST-Config no se ha inicializado");
        }
        return INSTANCE;
    }

    public static RestConfigCoreModule init() {
        if (INSTANCE != null) {
            return INSTANCE;
        }
        INSTANCE = new RestConfigCoreModule();
        INSTANCE.registerModule(RestConfigRepoModule.init());
        return getInstance();
    }

    /**
     * Usar init() sin repo por parametro para usar el repo por defecto
     *
     * @param repoModule
     * @return
     * @deprecated
     */
    @Deprecated
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
