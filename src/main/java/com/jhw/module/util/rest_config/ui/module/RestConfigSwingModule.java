package com.jhw.module.util.rest_config.ui.module;

import com.clean.core.app.services.ExceptionHandler;
import com.clean.swing.app.AbstractSwingApplication;
import com.clean.swing.app.DefaultAbstractSwingMainModule;
import com.clean.swing.app.dashboard.DashBoardSimple;
import com.clean.swing.app.dashboard.DashboardConstants;
import com.jhw.module.util.rest_config.services.AuthenticationService;
import com.jhw.module.util.rest_config.services.RESTExceptionHandler;
import com.jhw.module.util.rest_config.services.RestConfigResourceService;
import com.jhw.module.util.rest_config.ui.connection.ConnectionComponent;

public class RestConfigSwingModule extends DefaultAbstractSwingMainModule {

    private final RestConfigModuleNavigator navigator = new RestConfigModuleNavigator();

    private RestConfigSwingModule() {
    }

    public static RestConfigSwingModule init() {
        System.out.println("Iniciando 'Configuracion REST'");
        RESTExceptionHandler.init();
        AuthenticationService.init();
        try {
            RestConfigResourceService.init();
        } catch (Exception e) {
            ExceptionHandler.handleException(e);
        }
        return new RestConfigSwingModule();
    }

    @Override
    public void register(AbstractSwingApplication app) {
        DashBoardSimple dash = app.rootView().dashboard();

        dash.addKeyValue(DashboardConstants.DOWN_ELEMENT, ConnectionComponent.fromComponent(), 0);
    }

    @Override
    public void navigateTo(String string, Object... o) {
        navigator.navigateTo(string, o);
    }

}
