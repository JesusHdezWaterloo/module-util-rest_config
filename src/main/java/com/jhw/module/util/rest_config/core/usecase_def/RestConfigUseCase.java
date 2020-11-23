package com.jhw.module.util.rest_config.core.usecase_def;

import com.clean.core.app.usecase.ReadWriteUseCase;
import com.jhw.module.util.rest_config.core.domain.Configuration;
import com.jhw.module.util.rest_config.core.domain.ConnectionTarget;
import java.util.List;
import org.springframework.web.client.RestTemplate;

/**
 * Interfaz del caso de uso de la licencia para definir las principales
 * funcionalidades de la licencia
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface RestConfigUseCase extends ReadWriteUseCase<Configuration> {

    public List<ConnectionTarget> conections() throws Exception;

    public ConnectionTarget actual() throws Exception;

    public RestTemplate restTemplate() throws Exception;

    public boolean isConnected();

}
