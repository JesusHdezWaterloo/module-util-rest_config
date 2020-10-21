package com.jhw.module.util.rest_config.repo.repo_impl;

import com.clean.core.app.services.Notification;
import com.clean.core.app.services.NotificationsGeneralType;
import com.clean.core.domain.services.Resource;
import com.jhw.module.util.rest_config.core.domain.Configuration;
import javax.inject.Inject;
import com.jhw.utils.jackson.JACKSONRepoGeneral;
import com.jhw.module.util.rest_config.core.repo_def.RestConfigRepo;

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
        Notification.showConfirmDialog(NotificationsGeneralType.CONFIRM_INFO,
                Resource.getString("msg.mysql.error.read"));
    }
}
