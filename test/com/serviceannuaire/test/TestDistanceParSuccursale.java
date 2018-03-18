package com.serviceannuaire.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.serviceannuaire.models.GoogleMatrixRequest;
import com.serviceannuaire.models.Connexion;
import com.serviceannuaire.models.Succursale;
import com.serviceannuaire.models.SuccursaleDao;
import com.serviceannuaire.services.SuccursaleService;
import java.io.IOException;
import java.sql.Connection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Le Paré
 */
public class TestDistanceParSuccursale {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
         List<Succursale> liste = new LinkedList<>();
         Connection cnx = Connexion.getInstance();
            Gson gson = new GsonBuilder().create();
            Gson Matrix;
            String origin ;
            String destination;
            GoogleMatrixRequest request;
            String response;
        try{
            SuccursaleDao dao = new SuccursaleDao(cnx);
            liste = dao.findAll();
            for (Succursale Succ : liste) {
                origin = Float.toString(Succ.getLattitude())+","+Float.toString(Succ.getLongitude());
                destination = "45.5411394,-73.5765389";
                request = new GoogleMatrixRequest(origin,destination);
                response = request.run();
                System.out.println(response);
                   /* 
                    FRANCIS : COURT test pour aller chercher la distance dans la chaine JSON 
                              Le seul problème est que pour l'instant, la chaine retourne pas celle 
                              demandeé, donc il y est impossible de trouver la distance car elle n'est pas la (Voir Photo que je t'ai envoyé)
                              
                    JsonElement jelement = new JsonParser().parse(response);
                    JsonObject  jobject = jelement.getAsJsonObject();
                    jobject = jobject.getAsJsonObject("rows");
                    JsonArray jarray = jobject.getAsJsonArray("elements");
                    jobject = jarray.get(0).getAsJsonObject();
                    String result = jobject.get("distance").getAsString();
                    System.out.println(result);
                */
                    
                }
                
                
            }
            
        catch (IOException ex) {
            Logger.getLogger(SuccursaleService.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}
