package com.example.caseritas.bl;

import com.example.caseritas.dao.FotoRepository;
import com.example.caseritas.dao.LugarRepository;
import com.example.caseritas.domain.FotoEntity;
import com.example.caseritas.domain.LugarEntity;
import com.example.caseritas.dto.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


import java.util.logging.Logger;

@Service
public class LugarBl {

    private LugarRepository lugarRepository;
    private FotoRepository fotoRepository;
    Logger logger = Logger.getLogger("MyLog");

    @Autowired
    public LugarBl(LugarRepository lugarRepository, FotoRepository fotoRepository) {
        this.lugarRepository = lugarRepository;
        this.fotoRepository = fotoRepository;
    }

    public List<LugarEntity> list_places_type(String tipo_turismo) {
        int id_tipo_turismo = lugarRepository.findIdByTipoTurismo(tipo_turismo);
        List<LugarEntity> listPlaces = lugarRepository.findAllByIdTipoTurismo(id_tipo_turismo);
        return listPlaces;

    }

    public Place place(int id_lugar) {
        LugarEntity lugar = lugarRepository.findByIdLugar(id_lugar);
        List<FotoEntity> listPhotos = fotoRepository.findAllByIdLugar(id_lugar);
        List<String> listPhotosString = new ArrayList<>();
        for (FotoEntity foto: listPhotos) {
            listPhotosString.add(foto.getFoto());
        }
        Place place = new Place(lugar.getNombre(), lugar.getDescripcion(),lugar.getUbicacion(),listPhotosString,lugar.getLatitud(),lugar.getLongitud(),lugar.getNumero());
        return place;
    }

    public List<LugarEntity> list_places() {
        List<LugarEntity> listPlaces = lugarRepository.findAll();
        return listPlaces;
    }

}
