/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviceannuaire.models;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;

/**
 *
 * @author Le Paré
 */
public class GoogleMatrixRequest {
    private static final String API_KEY = "AIzaSyB0nAMYJDH6x5VoncfGxZpro42hHEZVd6o";
    private final OkHttpClient client = new OkHttpClient();
    private final String destination;
    private final String Origin;
    private String url_request;
    Request request;

    public GoogleMatrixRequest(String Origin,String destination) {
        this.destination = destination;
        this.Origin = Origin;
    }


    public String getAPI_KEY() {
        return API_KEY;
    }

    public String run() throws IOException {
        this.url_request = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="
                +this.Origin+"&destinations="
                +this.destination
                +"&mode=bicycling&language=fr-FR&key="
                +this.getAPI_KEY();
        request = new Request.Builder()
            .url(this.url_request)
            .build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
