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

    public boolean remove(String id)
    {
        Connection connection = Connexion.getInstance();
        boolean succes = false;
        try{
            int idInt = Integer.parseInt(id);
            SuccursaleDao dao = new SuccursaleDao(connection);
            succes = dao.delete(idInt);

            System.out.println("REMOVE SUCCURSALE ID" + id + ": " + succes);
        }
        catch (Exception ex) {
            Logger.getLogger(SuccursaleService.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        return succes;
    }

    public boolean add(Succursale succursale)
    {
        Connection connection = Connexion.getInstance();
        boolean succes = false;
        try{
            SuccursaleDao dao = new SuccursaleDao(connection);
            succes = dao.createOrUpdtate(succursale);

            System.out.println("CREATE OR UPDATE SUCCURSALE " + succursale.toString());
        }
        catch (Exception ex) {
            Logger.getLogger(SuccursaleService.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        return succes;
    }

    public String getParDistance(
            int distance,
            float longitude,
            float latittude)
    {
        List<Succursale> listeTrimmed = new LinkedList<>();
        Connection connection = Connexion.getInstance();
        Gson gson = new GsonBuilder().create();
        try{
            SuccursaleDao dao = new SuccursaleDao(connection);
            List<Succursale> listeFromBD = dao.findAll();
            for (Succursale succursale : listeFromBD) {
                double distanceCalculee = distance(
                        succursale.getLattitude(),
                        latittude,
                        succursale.getLongitude(),
                        longitude);
                if (distanceCalculee <= distance) {
                    listeTrimmed.add(succursale);
                }
            }

            System.out.println("SUCCURSALES : " + gson.toJson(listeFromBD));
        }
        catch (Exception ex) {
            Logger.getLogger(SuccursaleService.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        }

        return gson.toJson(listeTrimmed);
    }

    /**
     * Calculate distance between two points in latitude and longitude taking
     * into account height difference.If you are not interested in height
     * difference pass 0.0.Uses Haversine method as its base.lat1, lon1 Start
     * point lat2, lon2 End point el1 Start altitude in meters el2 End altitude
     * in meters
     * @param lat1
     * @param lat2
     * @param lon1
     * @param lon2
     * @param el1
     * @param el2
     * @return
     * @returns Distance in Meters
     */
    public static double distance(double lat1, double lat2, double lon1,
            double lon2, double el1, double el2) {

        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = el1 - el2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }
    public static double distance(double lat1, double lat2, double lon1, double lon2) {
        return distance(lat1, lat2, lon1, lon2, 0, 0);
    }
}
