package com.example.caseritas.controller;


import com.example.caseritas.bl.ContactoBl;
import com.example.caseritas.bl.LugarBl;
import com.example.caseritas.domain.ContactoEntity;
import com.example.caseritas.domain.LugarEntity;
import com.example.caseritas.dto.Place;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
public class ContactoController {

    ContactoBl contactoBl;

    @Autowired
    public ContactoController(ContactoBl contactoBl ) {
        this.contactoBl = contactoBl;
    }


    @RequestMapping(value = "/contactanos/guardar", method = RequestMethod.POST)
    public ResponseEntity post(@RequestBody ContactoEntity contactoEntity, BindingResult bindingResult){
        contactoBl.save_contact(contactoEntity);
        return new ResponseEntity(new ContactoController.Mensaje("Guardado"), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/contactanos/listar", method = RequestMethod.GET)
    public ResponseEntity get(){
        List<ContactoEntity> list_contactanos= contactoBl.list_contactanos();
        return new ResponseEntity(list_contactanos, HttpStatus.ACCEPTED);
    }



    @RequestMapping(value = "/contactanos/borrar/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id")int id) {
        ResponseEntity responseEntity= contactoBl.delete_contact(id);
        return responseEntity;
    }

    @RequestMapping(value = "/contactanos/actualizar", method = RequestMethod.PUT)
    public ResponseEntity put(@RequestBody ContactoEntity contactoEntity, BindingResult bindingResult){
        ResponseEntity responseEntity= contactoBl.put_contact(contactoEntity);
        return responseEntity;
    }
    @RequestMapping(value = "/contactanos/actualizar/{id}", method = RequestMethod.PATCH)
    public ResponseEntity patch(@RequestBody ContactoEntity contactoEntity,@PathVariable("id")int id) {
        ResponseEntity responseEntity =contactoBl.patch_contact(id, contactoEntity);
        return responseEntity;
    }

    public static class Mensaje{
        public String mensaje;
        public Mensaje(String mensaje){
            this.mensaje = mensaje;
        }
    }
}
