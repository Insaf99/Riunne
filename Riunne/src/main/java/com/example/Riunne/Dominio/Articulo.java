package com.example.Riunne.Dominio;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
@Entity
@Table(name="articulo")
public class Articulo implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_articulo;
    @NotEmpty
    private String nombre;
    @NotEmpty
    @DateTimeFormat
    private String fecha;
    @NotEmpty
    private int autor;
    private String cita;

    public Articulo() {
    }

    public Articulo(Long id_articulo, String nombre, String fecha, int autor) {
        this.id_articulo = id_articulo;
        this.nombre = nombre;
        this.fecha = fecha;
        this.autor = autor;
        this.cita = autor + " " + nombre + " " + fecha;
    }

    public Long getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(Long id_articulo) {
        this.id_articulo = id_articulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getAutor() {
        return autor;
    }

    public void setAutor(int autor) {
        this.autor = autor;
    }

    public String getCita() {
        return cita;
    }

    public void setCita(String cita) {
        this.cita = getAutor()+" "+getNombre()+" "+getFecha();
    }
}
