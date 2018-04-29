/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviceannuaire.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return liste;
    }
    public Succursale findByNoEntrepriseQuebec(int noEntrQc) {
        try {
            PreparedStatement stm = cnx.prepareStatement("SELECT * FROM succursales WHERE noentreprisequebec = ? ");
            stm.setInt(1, noEntrQc);
            ResultSet r= stm.executeQuery();
            Succursale succ = new Succursale();
            while(r.next()){
                succ.setNoEntrepriseQuebec(r.getInt("NOENTREPRISEQUEBEC"));
                succ.setNom(r.getString("NOM"));
                succ.setLattitude(r.getFloat("LATTITUDE"));
                succ.setLongitude(r.getFloat("LONGITUDE"));
                succ.setDescription(r.getString("DESCRIPTION"));
            }
            if (succ.getNoEntrepriseQuebec() == 0){
                return null;
            }
            return succ;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public boolean CreateOrUpdtate(Succursale succursale) {
        try 
        {
            PreparedStatement prepStmt = cnx.prepareStatement("INSERT INTO succursales (`NOENTREPRISEQUEBEC` , `LATTITUDE` , `LONGITUDE`,`DESCRIPTION`) VALUES (?,?,?,?)");
            prepStmt.setInt(1,succursale.getNoEntrepriseQuebec());
            prepStmt.setFloat(2,succursale.getLattitude());
            prepStmt.setFloat(3,succursale.getLongitude());
            prepStmt.setString(4,succursale.getDescription());
            int succes = prepStmt.executeUpdate();
            if (succes>0)
            {
                prepStmt.close();
                return true;
            }
        }
        catch (SQLException e)
        {
             e.printStackTrace();
        }
        return false;

    }

    public boolean delete(int noEntrQc) {

        try {
            PreparedStatement stm = cnx.prepareStatement( "DELETE FROM Succursales WHERE NOENTREPRISEQUEBEC =?");
            stm.setInt(1, noEntrQc);
            return stm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }

}
