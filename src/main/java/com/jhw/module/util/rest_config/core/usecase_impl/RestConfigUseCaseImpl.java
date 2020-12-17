package com.jhw.module.util.rest_config.core.usecase_impl;

import com.jhw.module.util.rest_config.core.utils.RestOperationsFactory;
import com.clean.core.app.usecase.DefaultReadWriteUseCase;
import com.jhw.module.util.rest_config.core.domain.Configuration;
import com.jhw.module.util.rest_config.core.domain.ConnectionTarget;
import com.jhw.module.util.rest_config.core.module.RestConfigCoreModule;
import java.util.List;
import com.jhw.module.util.rest_config.core.repo_def.RestConfigRepo;
import com.jhw.module.util.rest_config.core.usecase_def.RestConfigUseCase;
import com.jhw.module.util.rest_config.core.utils.OAuth2RestOperationsFactory;
import com.jhw.utils.others.Red;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.web.client.RestOperations;

public class RestConfigUseCaseImpl extends DefaultReadWriteUseCase<Configuration> implements RestConfigUseCase {

    /**
     * Instancia del repo para almacenar las cosas en memoria
     */
    private final RestConfigRepo repo = RestConfigCoreModule.getInstance().getImplementation(RestConfigRepo.class);

    private final RestOperations template;
    private OAuth2RestOperations oauth2Template;

    /**
     * Constructor por defecto, usado par injectar.
     */
    public RestConfigUseCaseImpl() {
        super.setRepo(repo);
        template = RestOperationsFactory.from(this).build();
        //oauth2Template = OAuth2RestOperationsFactory.from(this).build();
    }

    @Override
    public List<ConnectionTarget> conections() throws Exception {
        return read().getList();
    }

    @Override
    public ConnectionTarget actual() throws Exception {
        return read().actual();
    }

    @Override
    public RestOperations restTemplate() throws Exception {//TODO
        return template;
    }

    @Override
    public OAuth2RestOperations OAuth2RestTemplate() {
        return oauth2Template;
    }

    @Override
    public boolean isConnected() {
        try {
            return Red.isRunning(actual().getIp(), actual().getPortRest());
        } catch (Exception e) {
            return false;
        }
    }
}
