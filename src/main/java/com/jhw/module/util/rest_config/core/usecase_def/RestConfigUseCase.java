package com.jhw.module.util.rest_config.core.usecase_def;

import com.clean.core.app.usecase.ReadWriteUseCase;
import com.jhw.module.util.rest_config.core.domain.Configuration;
import com.jhw.module.util.rest_config.core.domain.ConnectionTarget;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.web.client.RestOperations;

/**
 * Interfaz del caso de uso de la licencia para definir las principales
 * funcionalidades de la licencia
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface RestConfigUseCase extends ReadWriteUseCase<Configuration> {

    public default boolean login(String user, String pass) {
        return login(user, pass, new HashMap<>());
    }

    public boolean login(String user, String pass, Map<String, Object> args);

    public List<ConnectionTarget> conections() throws Exception;

    public ConnectionTarget actual() throws Exception;

    public RestOperations restTemplate() throws Exception;

    public OAuth2RestOperations OAuth2RestTemplate() throws Exception;

    public boolean isConnected();

}
