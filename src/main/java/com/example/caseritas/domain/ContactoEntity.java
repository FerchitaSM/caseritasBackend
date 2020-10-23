package com.example.caseritas.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "contacto", schema = "caseritas", catalog = "")
public class ContactoEntity {
    private int idContacto;
    private String nombre;
    private String email;
    private int telefono;
    private String asunto;
    private String mensaje;

    @Id
    @Column(name = "id_contacto")
    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
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
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "telefono")
    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Basic
    @Column(name = "asunto")
    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    @Basic
    @Column(name = "mensaje")
    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactoEntity that = (ContactoEntity) o;
        return idContacto == that.idContacto &&
                telefono == that.telefono &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(email, that.email) &&
                Objects.equals(asunto, that.asunto) &&
                Objects.equals(mensaje, that.mensaje);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idContacto, nombre, email, telefono, asunto, mensaje);
    }
}
