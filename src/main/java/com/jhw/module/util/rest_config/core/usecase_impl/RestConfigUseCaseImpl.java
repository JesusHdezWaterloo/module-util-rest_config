package com.jhw.module.util.rest_config.core.usecase_impl;

import com.clean.core.app.usecase.DefaultReadWriteUseCase;
import com.jhw.module.util.rest_config.core.domain.Configuration;
import com.jhw.module.util.rest_config.core.domain.ConnectionTarget;
import com.jhw.module.util.rest_config.core.module.RestConfigCoreModule;
import javax.inject.Inject;
import java.util.List;
import com.jhw.module.util.rest_config.core.repo_def.RestConfigRepo;
import com.jhw.module.util.rest_config.core.usecase_def.RestConfigUseCase;

public class RestConfigUseCaseImpl extends DefaultReadWriteUseCase<Configuration> implements RestConfigUseCase {

    /**
     * Instancia del repo para almacenar las cosas en memoria
     */
    private final RestConfigRepo repo = RestConfigCoreModule.getInstance().getImplementation(RestConfigRepo.class);

    /**
     * Constructor por defecto, usado par injectar.
     */
    @Inject
    public RestConfigUseCaseImpl() {
        super.setRepo(repo);
    }

    @Override
    public List<ConnectionTarget> conections() throws Exception {
        return read().getList();
    }

    @Override
    public ConnectionTarget actual() throws Exception {
        return read().actual();
    }

}
