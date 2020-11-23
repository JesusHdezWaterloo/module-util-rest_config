/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.util.rest_config.ui.connection;

import com.jhw.module.util.rest_config.services.RESTHandler;
import com.jhw.swing.material.components.container.panel.MaterialPanelBorder;
import com.jhw.swing.material.components.container.panel._MaterialPanelComponent;
import com.jhw.swing.material.components.container.panel._PanelGradient;
import com.jhw.swing.material.components.labels.MaterialLabel;
import com.jhw.swing.material.components.labels.MaterialLabelsFactory;
import com.jhw.swing.material.injection.MaterialSwingInjector;
import com.jhw.swing.material.standards.MaterialColors;
import com.jhw.swing.material.standards.MaterialFontRoboto;
import com.jhw.utils.interfaces.Update;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class ConnectionComponent extends _PanelGradient implements Update {

    public static final String TEXT_CONNECTED = "CONECTADO";
    public static final String TEXT_NOT_CONNECTED = "SIN CONECCION";

    public static final Color COLOR_CONNECTED = MaterialColors.GREENA_200;
    public static final Color COLOR_NOT_CONNECTED = MaterialColors.REDA_200;

    public static MaterialPanelBorder fromComponent() {
        return MaterialSwingInjector.getImplementation(ConnectionComponent.class);
    }

    private final Timer timer = new Timer((int) RESTHandler.pingEveryMillis(), (ActionEvent e) -> {
        update();
    });

    public ConnectionComponent() {
        initComponents();
        timer.start();
    }

    private void initComponents() {
        labelConnection = MaterialLabelsFactory.build();
        labelConnection.setHorizontalAlignment(SwingConstants.CENTER);
        labelConnection.setFont(MaterialFontRoboto.MEDIUM.deriveFont(10f));

        this.setLayout(new BorderLayout());

        this.add(labelConnection);
    }
    private MaterialLabel labelConnection;

    @Override
    public void update() {
        setBackground(RESTHandler.isConnected() ? COLOR_CONNECTED : COLOR_NOT_CONNECTED);
        labelConnection.setText(RESTHandler.isConnected() ? TEXT_CONNECTED : TEXT_NOT_CONNECTED);
    }

}
