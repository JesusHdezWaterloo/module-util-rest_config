package com.jhw.module.util.rest_config.core.repo_def;

import com.clean.core.app.repo.ReadWriteRepository;
import com.jhw.module.util.rest_config.core.domain.Configuration;

/**
 * Interfaz de Repo para definir el trabajo de almacenamiento de la configuracion.
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public interface RestConfigRepo extends ReadWriteRepository<Configuration> {

}
