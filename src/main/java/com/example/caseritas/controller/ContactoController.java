package com.example.caseritas.controller;


import com.example.caseritas.bl.ContactoBl;
import com.example.caseritas.bl.LugarBl;
import com.example.caseritas.domain.ContactoEntity;
import com.example.caseritas.domain.LugarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
public class ContactoController {

    ContactoBl contactoBl;

    @Autowired
    public ContactoController(ContactoBl contactoBl ) {
        this.contactoBl = contactoBl;
    }


    @RequestMapping(value = "/contactanos/guardar", method = RequestMethod.POST)
    public ResponseEntity loginDoc(@RequestBody ContactoEntity contactoEntity, BindingResult bindingResult){
        contactoBl.save_contact(contactoEntity);
        return new ResponseEntity(new ContactoController.Mensaje("Bien"), HttpStatus.ACCEPTED);
    }

    public static class Mensaje{
        public String mensaje;
        public Mensaje(String mensaje){
            this.mensaje = mensaje;
        }
    }
}
