package com.root101.module.util.rest_config.repo.repo_impl;

import com.root101.clean.core.app.services.NotificationHandler;
import com.root101.clean.core.app.services.NotificationsGeneralType;
import com.root101.clean.core.domain.services.ResourceHandler;
import com.root101.module.util.rest_config.core.domain.Configuration;
import javax.inject.Inject;
import com.root101.repo.json.JACKSONRepoGeneral;
import com.root101.module.util.rest_config.core.repo_def.RestConfigRepo;

/**
 * Implementacion de la Interfaz {@code LicenceRepo} para manejar el
 * comportamiento de las definiciones de su interfaz
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class RestConfigRepoImpl extends JACKSONRepoGeneral<Configuration> implements RestConfigRepo {

    /**
     * Constructor por defecto, usado par injectar.
     */
    @Inject
    public RestConfigRepoImpl() {
        super("rest_config.json", Configuration.class);
    }

    @Override
    protected void onReadError(Exception e) {
        NotificationHandler.showConfirmDialog(NotificationsGeneralType.CONFIRM_INFO,
                ResourceHandler.getString("msg.mysql.error.read"));
    }
}
