package com.jhw.module.util.rest_config.core.domain;

import com.jhw.utils.clean.EntityDomainObjectValidated;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class Configuration extends EntityDomainObjectValidated {

    private List<ConnectionTarget> list = new ArrayList<>();
    private int actualConfig = 0;
    private long connectTimeOutMillis = 3 * 1000;
    private long readTimeOutMillis = 3 * 1000;

    public Configuration() {
        list.add(new ConnectionTarget("localhost", "8080", "local", "develop rest server"));
    }

    public Duration connectTimeOut() {
        return Duration.ofMillis(connectTimeOutMillis);
    }

    public Duration readTimeOut() {
        return Duration.ofMillis(readTimeOutMillis);
    }

    public ConnectionTarget actual() {
        ConnectionTarget actual = list.get(actualConfig);
        actual.validate();
        return actual;
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

    public long getConnectTimeOutMillis() {
        return connectTimeOutMillis;
    }

    public void setConnectTimeOutMillis(long connectTimeOutMillis) {
        this.connectTimeOutMillis = connectTimeOutMillis;
    }

    public long getReadTimeOutMillis() {
        return readTimeOutMillis;
    }

    public void setReadTimeOutMillis(long readTimeOutMillis) {
        this.readTimeOutMillis = readTimeOutMillis;
    }

}
