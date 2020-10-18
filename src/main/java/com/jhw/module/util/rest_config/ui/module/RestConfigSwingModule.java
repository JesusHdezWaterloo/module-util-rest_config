package com.jhw.module.util.rest_config.ui.module;

import com.clean.core.app.services.ExceptionHandler;
import com.clean.swing.app.AbstractSwingApplication;
import com.clean.swing.app.DefaultAbstractSwingMainModule;
import com.jhw.module.util.rest_config.services.RestConfigResourceService;

public class RestConfigSwingModule extends DefaultAbstractSwingMainModule {

    private final RestConfigModuleNavigator navigator = new RestConfigModuleNavigator();

    private RestConfigSwingModule() {
    }

    public static RestConfigSwingModule init() {
        System.out.println("Iniciando 'Configuracion REST'");
        try {
            RestConfigResourceService.init();
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
        return new RestConfigSwingModule();
    }

    @Override
    public void register(AbstractSwingApplication app) {
    }

    @Override
    public void navigateTo(String string, Object... o) {
        navigator.navigateTo(string, o);
    }

}
