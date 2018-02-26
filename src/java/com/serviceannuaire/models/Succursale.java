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
    private float Longitude;
    private float Lattitude;

    public Succursale(
            int NoEntrepriseQuebec,
            String Nom,
            String Description,
            float Longitude,
            float Lattitude
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

    public float getLongitude() {
        return Longitude;
    }

    public float getLattitude() {
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

    public void setLongitude(float Longitude) {
        this.Longitude = Longitude;
    }

    public void setLattitude(float Lattitude) {
        this.Lattitude = Lattitude;
    }

}
