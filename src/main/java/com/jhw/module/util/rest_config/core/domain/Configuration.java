package com.jhw.module.util.rest_config.core.domain;

import com.jhw.utils.clean.EntityDomainObjectValidated;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class Configuration extends EntityDomainObjectValidated {

    private List<ConnectionTarget> list = new ArrayList<>();
    private int actualConfig = 0;

    public Configuration() {
        list.add(new ConnectionTarget("localhost", "8080", "local", "develop rest server"));
    }

    public ConnectionTarget actual() {
        return list.get(actualConfig);
    }

    public List<ConnectionTarget> getList() {
        return list;
    }

    public void setList(List<ConnectionTarget> list) {
        this.list = list;
    }

    public int getActualConfig() {
        return actualConfig;
    }

    public void setActualConfig(int actualConfig) {
        this.actualConfig = actualConfig;
    }

}
