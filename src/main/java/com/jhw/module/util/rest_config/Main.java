/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.util.rest_config;

import com.jhw.module.util.rest_config.services.RESTHandler;
import java.util.Scanner;

/**
 *
 * @author Jesus Hernandez Barrios (jhernandezb96@gmail.com)
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        System.out.println(RESTHandler.login("admin", "admin"));

        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            System.out.println("");
            String endpoint = in.next();
            if (endpoint.equals("break")) {
                break;
            } else if (endpoint.equals("token")) {
                System.out.println(RESTHandler.OAuth2RestTemplate().getAccessToken());
                continue;
            }
            System.out.println(RESTHandler.OAuth2RestTemplate().getForObject("http://localhost:8080/test/" + endpoint, String.class));
            System.out.println("");
        }

    }

}
