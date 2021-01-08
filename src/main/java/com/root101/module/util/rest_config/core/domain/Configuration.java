/*
 * Copyright 2021 Root101 (jhernandezb96@gmail.com, +53-5-426-8660).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Or read it directly from LICENCE.txt file at the root of this project.
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.root101.module.util.rest_config.core.domain;

import com.root101.utils.clean.EntityDomainObjectValidated;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Root101 (jhernandezb96@gmail.com, +53-5-426-8660)
 * @author JesusHdezWaterloo@Github
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
