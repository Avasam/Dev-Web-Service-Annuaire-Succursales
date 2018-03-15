package com.serviceannuaire.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.serviceannuaire.models.GoogleMatrixRequest;
import com.serviceannuaire.models.Connexion;
import com.serviceannuaire.models.Succursale;
import com.serviceannuaire.models.SuccursaleDao;
import java.io.IOException;
import java.sql.Connection;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Le Paré
 */
public class TestDao {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        GoogleMatrixRequest request;
        String Origin = "Vancouver+BC%7CSeattle";
        String Destination = "San+Francisco%7CVictoria+BC";
        request = new GoogleMatrixRequest(Origin,Destination);
        
        String response = request.run();
        System.out.println(response);
       
    }
    
}
