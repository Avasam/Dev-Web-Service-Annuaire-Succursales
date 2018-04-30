/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviceannuaire.models;

/**
 *
 * @author Avasam
 */
public class Succursale {
    private int NoEntrepriseQuebec;
    private String Nom;
    private String Description;
    private double Longitude;
    private double Lattitude;

    public Succursale() {
    }

    public Succursale(
            int NoEntrepriseQuebec,
            String Nom,
            String Description,
            double Longitude,
            double Lattitude
    ) {
        this.NoEntrepriseQuebec = NoEntrepriseQuebec;
        this.Nom = Nom;
        this.Description = Description;
        this.Longitude = Longitude;
        this.Lattitude = Lattitude;
    }

    public int getNoEntrepriseQuebec() {
        return NoEntrepriseQuebec;
    }

    public String getNom() {
        return Nom;
    }

    public String getDescription() {
        return Description;
    }

    public double getLongitude() {
        return Longitude;
    }

    public double getLattitude() {
        return Lattitude;
    }

    public void setNoEntrepriseQuebec(int NoEntrepriseQuebec) {
        this.NoEntrepriseQuebec = NoEntrepriseQuebec;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setLongitude(double Longitude) {
        this.Longitude = Longitude;
    }

    public void setLattitude(double Lattitude) {
        this.Lattitude = Lattitude;
    }

}
