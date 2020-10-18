/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.util.rest_config.core.domain;

import com.jhw.utils.clean.EntityDomainObjectValidated;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class ConnectionTarget extends EntityDomainObjectValidated {

    private String ip;
    private String port;
    private String name;
    private String description;

    public ConnectionTarget() {
    }

    public ConnectionTarget(String ip, String port, String name, String description) {
        this.ip = ip;
        this.port = port;
        this.name = name;
        this.description = description;
        validate();
    }

    public String url() {
        return "http://" + ip + ":" + port;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return url();
    }

}
