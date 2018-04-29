/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.serviceannuaire.ressources;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.serviceannuaire.models.Succursale;
import com.serviceannuaire.services.SuccursaleService;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * REST Web Service
 *
 * @author PadgetPi
 */
@Path("/api/annuaire/succursales")
public class AnnuaireRessource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AnnuaireRessource
     */
    public AnnuaireRessource() {
    }

    /**
     * Retrieves representation of an instance of com.serviceannuaire.ressources.AnnuaireRessource
     * @param distance
     * @param longitude
     * @param latitude
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSuccursales(int distance, float longitude, float latitude) {
        String listeSuccursale = new SuccursaleService().getParDistance(
                distance,
                longitude,
                latitude);
        return Response.ok(listeSuccursale).build();
    }

    /**
     * PUT method for updating or creating an instance of AnnuaireRessource
     * @param content representation for the resource
     * @return
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response putSuccursale(String content) {
        Succursale succursale;
        try {
            succursale = new Gson().fromJson(content, Succursale.class);
        } catch (JsonSyntaxException ex) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        if (new SuccursaleService().add(succursale)){
            return Response.status(Response.Status.NO_CONTENT).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    /**
     * DELETE method for deleting an instance of AnnuaireRessource
     * @param id
     * @return
     */
    @DELETE
    @Path("{id}")
    public Response deleteSuccursale(@PathParam("id")String id) {
        if (new SuccursaleService().remove(id)) {
            return Response.ok().build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
