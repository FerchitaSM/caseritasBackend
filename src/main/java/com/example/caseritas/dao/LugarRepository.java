package com.example.caseritas.dao;

import com.example.caseritas.domain.LugarEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LugarRepository extends JpaRepository<LugarEntity,Integer> {
    List<LugarEntity> findAllByIdTipoTurismo(int id_tipo_turismo);
    LugarEntity findByIdLugar(int id_lugar);
    List<LugarEntity> findAll();


    @Query(value = "SELECT id_tipo_turismo FROM tipo_turismo  WHERE tipo_turismo = ?1", nativeQuery = true)
    int findIdByTipoTurismo (String tipo_turismo);


}

/*

    @Query(
            value = "SELECT * FROM lugar p WHERE p.id_doctor = ?1",
            nativeQuery = true)
    List<String> findFirstNameByIdDoctor(int id);

 */
