/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.util.rest_config.core.domain;

import com.jhw.module.util.rest_config.core.utils.Ipv4;
import com.jhw.utils.clean.EntityDomainObjectValidated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class ConnectionTarget extends EntityDomainObjectValidated {

    @Ipv4(message = "#msg.module.util.rest_config.validation.connection_target_ip_ipv4#")
    private String ip;

    @Positive(message = "#msg.module.util.rest_config.validation.connection_target_port_rest_empty#")
    private int portRest;

    @Positive(message = "#msg.module.util.rest_config.validation.connection_target_port_apache_empty#")
    private int portApache;

    @NotEmpty(message = "#msg.module.util.rest_config.validation.connection_target_name_empty#")
    private String name;

    private String contextPath;

    private String description;

    public ConnectionTarget() {
    }

    public ConnectionTarget(String ip, int portRest, int portApache, String name, String contextPath, String description) {
        this.ip = ip;
        this.portRest = portRest;
        this.portApache = portApache;
        this.name = name;
        this.contextPath = contextPath;
        this.description = description;
        validate();
    }

    public String urlREST() {
        return "http://" + clearURL(ip + ":" + portRest + contextPath);
    }

    public String urlApache() {
        return "http://" + clearURL(ip + ":" + portApache /*+ "/" + contextPath + "/"*/);
    }

    private String clearURL(String url) {
        return url.trim().replace("//", "/");
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPortRest() {
        return portRest;
    }

    public void setPortRest(int portRest) {
        this.portRest = portRest;
    }

    public int getPortApache() {
        return portApache;
    }

    public void setPortApache(int portApache) {
        this.portApache = portApache;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContextPath() {
        return contextPath;
    }

    public void setContextPath(String contextPath) {
        this.contextPath = contextPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return urlREST();
    }

}
