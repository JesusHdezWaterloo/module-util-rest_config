package com.jhw.module.util.rest_config.ui.module;

import com.root101.clean.core.app.services.ExceptionHandler;
import com.root101.clean.swing.app.AbstractSwingApplication;
import com.root101.clean.swing.app.DefaultAbstractSwingMainModule;
import com.root101.clean.swing.app.RootView;
import com.root101.clean.swing.app.dashboard.DashBoardSimple;
import com.root101.clean.swing.app.dashboard.DashboardConstants;
import com.jhw.module.util.rest_config.services.RESTExceptionHandler;
import com.jhw.module.util.rest_config.services.RestConfigResourceServiceImplementation;
import com.jhw.module.util.rest_config.ui.connection.ConnectionComponent;
import com.root101.swing.material.standards.MaterialIcons;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class RestConfigSwingModule extends DefaultAbstractSwingMainModule {

    private final RestConfigModuleNavigator navigator = new RestConfigModuleNavigator();

    private RestConfigSwingModule() {
    }

    public static RestConfigSwingModule init() {
        System.out.println("Iniciando 'Configuracion REST'");
        RESTExceptionHandler.init();
        try {
            RestConfigResourceServiceImplementation.init();
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
