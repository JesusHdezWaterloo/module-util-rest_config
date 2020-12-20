/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhw.module.util.rest_config;

import com.clean.core.app.services.AuthenticationHandler;
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
        Scanner in = new Scanner(System.in);
        System.out.println("GOGOGOGOGOGO");
        System.out.println((boolean) AuthenticationHandler.login(in.next(), in.next()));
        System.out.println("ENDPOINT GO");
        while (in.hasNext()) {
            System.out.println("");
            String endpoint = in.next();
            if (endpoint.equals("break")) {
                break;
            } else if (endpoint.equals("token")) {
                System.out.println(RESTHandler.OAuth2RestTemplate().getAccessToken());
                continue;
            }
            System.out.println(RESTHandler.OAuth2RestTemplate().getForObject("http://localhost:8080/" + endpoint, String.class));
            System.out.println("");
        }

    }

}
