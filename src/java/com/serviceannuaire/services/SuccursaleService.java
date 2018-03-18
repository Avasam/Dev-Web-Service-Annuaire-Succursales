/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviceannuaire.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.serviceannuaire.models.Connexion;
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

    public static String getParDistance(
            int distance,
            float longitude,
            float latitude)
    {
        List<Succursale> listeFromBD = new LinkedList<>();
        List<Succursale> listeTrimmed = new LinkedList<>();
        Connection cnx = Connexion.getInstance();
        Gson gson = new GsonBuilder().create();

        try {
            SuccursaleDao dao = new SuccursaleDao(cnx);
            listeFromBD = dao.findAll();

            // Todo trim la liste recu de la BD en utilisant google, les corrds et distance
            listeTrimmed = listeFromBD;

            System.out.println("SUCCURSALES : " + gson.toJson(listeTrimmed));
        }
        catch (Exception ex) {
            Logger.getLogger(SuccursaleService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return gson.toJson(listeTrimmed);
    }

}
