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
    private long connectionPingEveryMillis = 1 * 1000;

    private String oauth2TokenURL = "http://localhost:8080/oauth/token";

    public Configuration() {
        list.add(new ConnectionTarget("localhost", 7777, 7780, "local", "", "develop rest server"));
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

    public String getOauth2TokenURL() {
        return oauth2TokenURL;
    }

    public void setOauth2TokenURL(String oauth2TokenURL) {
        this.oauth2TokenURL = oauth2TokenURL;
    }

    public long getConnectionPingEveryMillis() {
        return connectionPingEveryMillis;
    }

    public void setConnectionPingEveryMillis(long connectionPingEveryMillis) {
        this.connectionPingEveryMillis = connectionPingEveryMillis;
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
