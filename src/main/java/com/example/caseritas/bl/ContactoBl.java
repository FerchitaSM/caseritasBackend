package com.example.caseritas.bl;

import com.example.caseritas.controller.ContactoController;
import com.example.caseritas.dao.ContactoRepository;
import com.example.caseritas.dao.FotoRepository;
import com.example.caseritas.dao.LugarRepository;
import com.example.caseritas.domain.ContactoEntity;
import com.example.caseritas.domain.LugarEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class ContactoBl {
    private ContactoRepository contactoRepository;
    Logger logger = Logger.getLogger("MyLog");

    @Autowired
    public ContactoBl(ContactoRepository contactoRepository) {
        this.contactoRepository = contactoRepository;
    }

    public void save_contact (ContactoEntity contactoEntity){
        System.out.println(contactoEntity.toString());
        contactoRepository.save(contactoEntity);
    }


    public List<ContactoEntity> list_contactanos() {
        List<ContactoEntity> list_contactanos = contactoRepository.findAll();
        return list_contactanos;
    }

    /*
    public ResponseEntity list_contactanos() {
        try{
            List<ContactoEntity> list_contactanos = contactoRepository.findAll();
            return new ResponseEntity(list_contactanos, HttpStatus.ACCEPTED);

        } catch (Exception e){
            return new ResponseEntity("Error "+e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

     */


    public ResponseEntity delete_contact (int id){
        try {
            ContactoEntity contactoEntity = contactoRepository.findByIdContacto(id);

            contactoRepository.delete(contactoEntity);
            return new ResponseEntity("Borrado", HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity("Error "+e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity put_contact (ContactoEntity newcontactoEntity){
        try{
            ContactoEntity contactoEntity = contactoRepository.findByIdContacto(newcontactoEntity.getIdContacto());

            contactoEntity.setNombre(newcontactoEntity.getNombre());
            contactoEntity.setEmail(newcontactoEntity.getEmail());
            contactoEntity.setTelefono(newcontactoEntity.getTelefono());
            contactoEntity.setAsunto(newcontactoEntity.getAsunto());
            contactoEntity.setMensaje(newcontactoEntity.getMensaje());

            contactoRepository.save(contactoEntity);
            return  new ResponseEntity("Actualizado", HttpStatus.ACCEPTED);

        }catch (Exception e){
            return new ResponseEntity("Error "+e.getMessage(), HttpStatus.BAD_REQUEST);

        }

    }

    public ResponseEntity patch_contact (int id, ContactoEntity newcontactoEntity){
        try {
            boolean datos_cambiados = false;
            ContactoEntity contactoEntity = contactoRepository.findByIdContacto(id);
            if (newcontactoEntity.getNombre() != null) {
                contactoEntity.setNombre(newcontactoEntity.getNombre());
                datos_cambiados = true;
            }
            if (newcontactoEntity.getEmail() != null) {
                contactoEntity.setEmail(newcontactoEntity.getEmail());
                datos_cambiados = true;
            }
            if (newcontactoEntity.getTelefono() != 0) {
                contactoEntity.setTelefono(newcontactoEntity.getTelefono());
                datos_cambiados = true;
            }
            if (newcontactoEntity.getAsunto() != null) {
                contactoEntity.setAsunto(newcontactoEntity.getAsunto());
                datos_cambiados = true;
            }
            if (newcontactoEntity.getMensaje() != null) {
                contactoEntity.setMensaje(newcontactoEntity.getMensaje());
                datos_cambiados = true;
            }
            if (datos_cambiados){
                contactoRepository.save(contactoEntity);
                return new ResponseEntity("Actualizado ", HttpStatus.ACCEPTED);
            }else{
                return new ResponseEntity("No se ha registrado ningun cambio ", HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return new ResponseEntity("Error "+e.getMessage(), HttpStatus.BAD_REQUEST);

        }
    }


}




