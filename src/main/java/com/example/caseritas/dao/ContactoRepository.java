package com.example.caseritas.dao;

import com.example.caseritas.domain.ContactoEntity;
import com.example.caseritas.domain.FotoEntity;
import com.example.caseritas.domain.LugarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactoRepository extends JpaRepository<ContactoEntity,Integer> {
    ContactoEntity findByIdContacto(int id);

    List<ContactoEntity> findAll();


}