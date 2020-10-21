/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.util.rest_config.core.domain;

import com.jhw.module.util.rest_config.core.utils.Ipv4;
import com.jhw.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.NotEmpty;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class ConnectionTarget extends EntityDomainObjectValidated {

    @Ipv4(message = "#msg.module.util.rest_config.validation.connection_target_ip_ipv4#")
    private String ip;

    @NotEmpty(message = "#msg.module.util.rest_config.validation.connection_target_port_empty#")
    private String port;

    @NotEmpty(message = "#msg.module.util.rest_config.validation.connection_target_name_empty#")
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
