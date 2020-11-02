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

    @NotEmpty(message = "#msg.module.util.rest_config.validation.connection_target_port_rest_empty#")
    private String portRest;

    @NotEmpty(message = "#msg.module.util.rest_config.validation.connection_target_port_apache_empty#")
    private String portApache;

    @NotEmpty(message = "#msg.module.util.rest_config.validation.connection_target_name_empty#")
    private String name;

    private String contextPath;

    private String description;

    public ConnectionTarget() {
    }

    public ConnectionTarget(String ip, String portRest, String portApache, String name, String contextPath, String description) {
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

    public String getPortRest() {
        return portRest;
    }

    public void setPortRest(String portRest) {
        this.portRest = portRest;
    }

    public String getPortApache() {
        return portApache;
    }

    public void setPortApache(String portApache) {
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
