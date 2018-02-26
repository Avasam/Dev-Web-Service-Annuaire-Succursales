/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviceannuaire.models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Avasam
 */
public class SuccursaleDao {
    
    protected Connection cnx;
    
    public SuccursaleDao(Connection cnx) {
        this.cnx = cnx;
    }
    
    public List<Succursale> findAll() {
        List<Succursale> liste = new LinkedList();
        
        try
        {
           Statement stm = cnx.createStatement();
           ResultSet r = stm.executeQuery("SELECT * FROM Succursales");
           while(r.next())
           {
                Succursale s = new Succursale();
                s.setNoEntrepriseQuebec(r.getInt("NOENTREPRISEQUEBEC"));
                s.setNom(r.getString("NOM"));
                s.setLattitude(r.getFloat("LATTITUDE"));
                s.setLongitude(r.getFloat("LONGITUDE"));
                s.setDescription(r.getString("DESCRIPTION"));
                liste.add(s);
           }
           r.close();
           stm.close();
        }
        catch(SQLException exp)
        {
        
        }
        return liste;
    }
    public List<Succursale> findByDistance(int Distance) {
        List<Succursale> liste = new LinkedList();
        
        /*try
        {
           Statement stm = cnx.createStatement();
           ResultSet r = stm.executeQuery("SELECT * FROM Succursales");
           while(r.next())
           {
                Succursale s = new Succursale();
                s.setNoEntrepriseQuebec(r.getInt("NOENTREPRISEQUEBEC"));
                s.setNom(r.getString("NOM"));
                s.setLattitude(r.getFloat("LATTITUDE"));
                s.setLongitude(r.getFloat("LONGITUDE"));
                s.setDescription(r.getString("DESCRIPTION"));
                liste.add(s);
           }
           r.close();
           stm.close();
        }
        catch(SQLException exp)
        {
        
        }*/
        return liste;
    }

}
