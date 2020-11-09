package com.example.caseritas.bl;

import com.example.caseritas.dao.ContactoRepository;
import com.example.caseritas.dao.FotoRepository;
import com.example.caseritas.dao.LugarRepository;
import com.example.caseritas.domain.ContactoEntity;
import com.example.caseritas.domain.LugarEntity;
import org.springframework.beans.factory.annotation.Autowired;
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


    public void delete_contact (int id){
        ContactoEntity contactoEntity = contactoRepository.findByIdContacto(id);
        contactoRepository.delete(contactoEntity);
    }

    public void put_contact (ContactoEntity newcontactoEntity){
        ContactoEntity contactoEntity = contactoRepository.findByIdContacto(newcontactoEntity.getIdContacto());

        contactoEntity.setNombre(newcontactoEntity.getNombre());
        contactoEntity.setEmail(newcontactoEntity.getEmail());
        contactoEntity.setTelefono(newcontactoEntity.getTelefono());
        contactoEntity.setAsunto(newcontactoEntity.getAsunto());
        contactoEntity.setMensaje(newcontactoEntity.getMensaje());

        contactoRepository.save(contactoEntity);
    }

    public void patch_contact (int id, ContactoEntity newcontactoEntity){
        ContactoEntity contactoEntity = contactoRepository.findByIdContacto(id);
        if (newcontactoEntity.getNombre() != null) {
            contactoEntity.setNombre(newcontactoEntity.getNombre());
        }
        if (newcontactoEntity.getEmail() != null) {
            contactoEntity.setEmail(newcontactoEntity.getEmail());
        }
        if (newcontactoEntity.getTelefono() != 0) {
            contactoEntity.setTelefono(newcontactoEntity.getTelefono());
        }
        if (newcontactoEntity.getAsunto() != null) {
            contactoEntity.setAsunto(newcontactoEntity.getAsunto());
        }
        if (newcontactoEntity.getMensaje() != null) {
            contactoEntity.setMensaje(newcontactoEntity.getMensaje());
        }
        contactoRepository.save(contactoEntity);
    }


}




