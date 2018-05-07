package com.succursaleAnnuaire.succursaleAnnuaire.web.controller;

import com.succursaleAnnuaire.succursaleAnnuaire.models.Succursale;
import com.succursaleAnnuaire.succursaleAnnuaire.services.SuccursaleService;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/api/succursales")
public class AnnuaireController {

    /**
     * Retrieves representation of an instance of com.serviceannuaire.ressources.AnnuaireController
     * @param distance
     * @param longitude
     * @param latitude
     * @return an instance of java.lang.String
     */    
    @GetMapping()
    public List getSuccursales(Integer distance, Float longitude, Float latitude) {
        if (distance == null && longitude==null && latitude==null) 
            return new SuccursaleService().getAll();
        if ((distance != null && longitude != null && latitude != null))
            return new SuccursaleService().getParDistance(distance, longitude, latitude);
        return new LinkedList<>();
    }
    @GetMapping("{id}")
    public Succursale getSuccursales(@PathVariable(value = "id") int id) {
        return new SuccursaleService().getByNoEntreprise(id);
    }

    /**
     * PUT method for updating or creating an instance of AnnuaireController
     * @param succursale
     * @return
     */
    @PutMapping()
    public boolean putSuccursale(@RequestBody Succursale succursale) {
        return new SuccursaleService().add(succursale);
    }

    /**
     * DELETE method for deleting an instance of AnnuaireController
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public boolean deleteSuccursale(@PathVariable(value = "id") String id) {
        return new SuccursaleService().remove(id);
    }
    
}
