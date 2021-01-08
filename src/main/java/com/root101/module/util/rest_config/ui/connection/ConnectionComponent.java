/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.module.util.rest_config.ui.connection;

import com.root101.module.util.rest_config.services.RESTHandler;
import com.root101.swing.material.components.container.panel.MaterialPanelBorder;
import com.root101.swing.material.components.container.panel._PanelGradient;
import com.root101.swing.material.components.labels.MaterialLabel;
import com.root101.swing.material.components.labels.MaterialLabelsFactory;
import com.root101.swing.material.injection.MaterialSwingInjector;
import com.root101.swing.material.standards.MaterialColors;
import com.root101.swing.material.standards.MaterialFontRoboto;
import com.root101.utils.interfaces.Update;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
 */
public class ConnectionComponent extends _PanelGradient implements Update {

    public static final String TEXT_CONNECTED = "CONECTADO";
    public static final String TEXT_NOT_CONNECTED = "SIN CONECCION";

    public static final Color COLOR_CONNECTED = MaterialColors.GREEN_900;
    public static final Color COLOR_NOT_CONNECTED = MaterialColors.RED_900;

    public static MaterialPanelBorder fromComponent() {
        return MaterialSwingInjector.getImplementation(ConnectionComponent.class);
    }

    private final Timer timer = new Timer((int) RESTHandler.pingEveryMillis(), (ActionEvent e) -> {
        update();
    });

    private boolean lastState = false;

    public ConnectionComponent() {
        initComponents();
        timer.start();
    }

    private void initComponents() {
        labelConnection = MaterialLabelsFactory.build();
        labelConnection.setHorizontalAlignment(SwingConstants.CENTER);
        labelConnection.setFont(MaterialFontRoboto.BOLD.deriveFont(12f));

        this.setToolTipText("Estado de la conección hacia el servidor");
        this.setLayout(new BorderLayout());
        this.setBackground(MaterialColors.TRANSPARENT);
        //this.setBorderThickness(2);

        this.add(labelConnection);
    }
    private MaterialLabel labelConnection;

    @Override
    public void update() {
        boolean actualState = RESTHandler.isConnected();

        if (actualState != lastState) {
            lastState = actualState;

            Color c = actualState ? COLOR_CONNECTED : COLOR_NOT_CONNECTED;
            labelConnection.setForeground(c);
            this.setBorderColor(c);

            labelConnection.setText(actualState ? TEXT_CONNECTED : TEXT_NOT_CONNECTED);
        }
    }

}
