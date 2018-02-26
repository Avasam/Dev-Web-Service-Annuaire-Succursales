package com.serviceannuaire.test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.serviceannuaire.models.Connexion;
import com.serviceannuaire.models.Succursale;
import com.serviceannuaire.models.SuccursaleDao;
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
    public static void main(String[] args) {
        Connection cnx;
        cnx = Connexion.getInstance();
        SuccursaleDao dao = new SuccursaleDao(cnx);
        List<Succursale> liste = new LinkedList();
        liste = dao.findAll();       
        System.out.println(liste.get(0).getNom());
       
    }
    
}
