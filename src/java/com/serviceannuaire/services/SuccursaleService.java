/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviceannuaire.services;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.serviceannuaire.models.Connexion;
import com.serviceannuaire.models.GoogleMatrixRequest;
import com.serviceannuaire.models.Succursale;
import com.serviceannuaire.models.SuccursaleDao;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Avasam
 */
public class SuccursaleService {
    public GoogleMatrixRequest request;
    public String response;

    public String getParDistance(
            int distance,
            float longitude, 
            float latittude)
    {
        List<Succursale> liste = new LinkedList<>();
        Connection cnx = Connexion.getInstance();
        Gson gson = new GsonBuilder().create();
        Gson Matrix;
        String origin ;
        String destination;
        try{
            SuccursaleDao dao = new SuccursaleDao(cnx);
            liste = dao.findAll();
            for (Succursale Succ : liste) {
                origin = Float.toString(Succ.getLattitude())+","+Float.toString(Succ.getLongitude());
                destination = Float.toString(latittude)+","+Float.toString(longitude);
                request = new GoogleMatrixRequest(origin,destination);
                response = this.request.run();
                JsonParser parser = new JsonParser();
                JsonObject o = parser.parse(response).getAsJsonObject();
                Float dist = o.get("Distance").getAsFloat();
            }
            
            
            System.out.println(response);
            System.out.println("SUCCURSALES : " + gson.toJson(liste));
       }
        catch (IOException ex) {
            Logger.getLogger(SuccursaleService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return gson.toJson(liste);
    }

}
