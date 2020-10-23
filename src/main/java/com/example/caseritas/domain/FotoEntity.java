package com.example.caseritas.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "foto", schema = "caseritas", catalog = "")
public class FotoEntity {
    private int idFoto;
    private String foto;
    private int idLugar;

    @Basic
    @Id
    @Column(name = "id_foto")
    public int getIdFoto() {
        return idFoto;
    }

    public void setIdFoto(int idFoto) {
        this.idFoto = idFoto;
    }

    @Basic
    @Column(name = "foto")
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Basic
    @Column(name = "id_lugar")
    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FotoEntity that = (FotoEntity) o;
        return idFoto == that.idFoto &&
                idLugar == that.idLugar &&
                Objects.equals(foto, that.foto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFoto, foto, idLugar);
    }
}
