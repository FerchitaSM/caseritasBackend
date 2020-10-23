package com.example.caseritas.bl;

import com.example.caseritas.dao.ContactoRepository;
import com.example.caseritas.dao.FotoRepository;
import com.example.caseritas.dao.LugarRepository;
import com.example.caseritas.domain.ContactoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


}
