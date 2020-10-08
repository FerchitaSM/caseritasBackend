package com.example.caseritas.controller;


import com.example.caseritas.bl.LugarBl;
import com.example.caseritas.domain.FotoEntity;
import com.example.caseritas.domain.LugarEntity;
import com.example.caseritas.dto.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping({"/caseritas"})
public class LugarController {

    LugarBl lugarBl;

    @Autowired
    public LugarController(LugarBl lugarBl ) {
        this.lugarBl = lugarBl;
    }

    @RequestMapping("/listPlaces")
    public List<LugarEntity> list_places() {
        List<LugarEntity> list_places= lugarBl.list_places();
        return list_places;
    }

    //me pasas el nombre del tipo de turismo en minusculas osea "gastronomico""cultural""aventura""naturaleza"""octurno""comunitario"............
    // te devuelvo un LugarEntity
    @GetMapping(path = {"/listPlacesType/{name}"})
    public List<LugarEntity> list_places_type(@PathVariable("name")String tipo_turismo) {
        //Recupera los datos de los lugares por el tipo de turismo con el id ""
        List<LugarEntity> list_places= lugarBl.list_places_type(tipo_turismo);
        return list_places;
    }

    //ne pasas el id del lugar
    //Te devuelvo un place
    @GetMapping(path = {"/placeId/{id}"})
    public Place place(@PathVariable("id")int id_lugar) {
        //Recupera los datos del lugar con el id ""
        Place place= lugarBl.place(id_lugar);
        return place;
    }


}




