package com.example.caseritas.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tipo_turismo", schema = "caseritas", catalog = "")
public class TipoTurismoEntity {
    private int idTipoTurismo;
    private String tipoTurismo;

    @Basic
    @Id
    @Column(name = "id_tipo_turismo")
    public int getIdTipoTurismo() {
        return idTipoTurismo;
    }

    public void setIdTipoTurismo(int idTipoTurismo) {
        this.idTipoTurismo = idTipoTurismo;
    }

    @Basic
    @Column(name = "tipo_turismo")
    public String getTipoTurismo() {
        return tipoTurismo;
    }

    public void setTipoTurismo(String tipoTurismo) {
        this.tipoTurismo = tipoTurismo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoTurismoEntity that = (TipoTurismoEntity) o;
        return idTipoTurismo == that.idTipoTurismo &&
                Objects.equals(tipoTurismo, that.tipoTurismo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTipoTurismo, tipoTurismo);
    }
}
