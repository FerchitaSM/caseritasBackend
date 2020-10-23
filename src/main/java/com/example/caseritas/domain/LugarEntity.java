package com.example.caseritas.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "lugar", schema = "caseritas", catalog = "")
public class LugarEntity {
    private int idLugar;
    private int idTipoTurismo;
    private String nombre;
    private String descripcion;
    private String ubicacion;
    private double latitud;
    private double longitud;
    private int numero;

    @Basic
    @Id
    @Column(name = "id_lugar")
    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    @Basic
    @Column(name = "id_tipo_turismo")
    public int getIdTipoTurismo() {
        return idTipoTurismo;
    }

    public void setIdTipoTurismo(int idTipoTurismo) {
        this.idTipoTurismo = idTipoTurismo;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "ubicacion")
    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Basic
    @Column(name = "latitud")
    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    @Basic
    @Column(name = "longitud")
    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    @Basic
    @Column(name = "numero")
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LugarEntity that = (LugarEntity) o;
        return idLugar == that.idLugar &&
                idTipoTurismo == that.idTipoTurismo &&
                Double.compare(that.latitud, latitud) == 0 &&
                Double.compare(that.longitud, longitud) == 0 &&
                numero == that.numero &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(descripcion, that.descripcion) &&
                Objects.equals(ubicacion, that.ubicacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLugar, idTipoTurismo, nombre, descripcion, ubicacion, latitud, longitud, numero);
    }
}
