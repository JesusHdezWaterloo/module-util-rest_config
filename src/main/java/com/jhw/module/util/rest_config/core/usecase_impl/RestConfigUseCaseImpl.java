package com.jhw.module.util.rest_config.core.usecase_impl;

import com.clean.core.app.usecase.DefaultReadWriteUseCase;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jhw.module.util.rest_config.core.domain.Configuration;
import com.jhw.module.util.rest_config.core.domain.ConnectionTarget;
import com.jhw.module.util.rest_config.core.module.RestConfigCoreModule;
import javax.inject.Inject;
import java.util.List;
import com.jhw.module.util.rest_config.core.repo_def.RestConfigRepo;
import com.jhw.module.util.rest_config.core.usecase_def.RestConfigUseCase;
import com.jhw.utils.jackson.JACKSON;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class RestConfigUseCaseImpl extends DefaultReadWriteUseCase<Configuration> implements RestConfigUseCase {

    /**
     * Instancia del repo para almacenar las cosas en memoria
     */
    private final RestConfigRepo repo = RestConfigCoreModule.getInstance().getImplementation(RestConfigRepo.class);

    private final RestTemplate template;

    /**
     * Constructor por defecto, usado par injectar.
     */
    @Inject
    public RestConfigUseCaseImpl() {
        super.setRepo(repo);
        template = initRestTemplate();
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
    public RestTemplate restTemplate() throws Exception {//TODO
        return template;
    }

    private RestTemplate initRestTemplate() {
        ObjectMapper om = new ObjectMapper();
        JACKSON.configureObjectMapper(om);

        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        messageConverter.setPrettyPrint(true);
        messageConverter.setObjectMapper(om);

        RestTemplate rt = new RestTemplate();
        rt.getMessageConverters().removeIf(m -> m.getClass().isAssignableFrom(MappingJackson2HttpMessageConverter.class));
        rt.getMessageConverters().add(messageConverter);

        return rt;
    }
    /*@Override
    public RestTemplate restTemplate() throws Exception {//TODO
        return new RestTemplate();
    }*/
}
