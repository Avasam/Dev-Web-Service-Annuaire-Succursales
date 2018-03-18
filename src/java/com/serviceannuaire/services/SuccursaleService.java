/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviceannuaire.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.serviceannuaire.models.Connexion;
import com.serviceannuaire.models.GoogleMatrixRequest;
import com.serviceannuaire.models.Succursale;
import com.serviceannuaire.models.SuccursaleDao;
import java.io.IOException;
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
    public GoogleMatrixRequest gMatrixRequest;
    public String gMatrixResponse;

    public String getParDistance(
            int distance,
            float longitude,
            float latittude)
    {
        List<Succursale> listeTrimmed = new LinkedList<>();
        Connection cnx = Connexion.getInstance();
        Gson gson = new GsonBuilder().create();
        String origin ;
        String destination;
        try{
            SuccursaleDao dao = new SuccursaleDao(cnx);
            List<Succursale> listeFromBD = dao.findAll();
            for (Succursale succursale : listeFromBD) {
                origin = Float.toString(succursale.getLattitude())+","+Float.toString(succursale.getLongitude());
                destination = Float.toString(latittude)+","+Float.toString(longitude);
                gMatrixRequest = new GoogleMatrixRequest(origin,destination);
                gMatrixResponse = this.gMatrixRequest.run();
                JsonParser parser = new JsonParser();
                JsonObject o = parser.parse(gMatrixResponse).getAsJsonObject();
                Float distanceRecue = o.get("Distance").getAsFloat();
                if (distanceRecue <= distance) {
                    listeTrimmed.add(succursale);
                }
            }

            System.out.println(gMatrixResponse);
            System.out.println("SUCCURSALES : " + gson.toJson(listeFromBD));
        }
        catch (IOException ex) {
            Logger.getLogger(SuccursaleService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return gson.toJson(listeTrimmed);
    }
}
