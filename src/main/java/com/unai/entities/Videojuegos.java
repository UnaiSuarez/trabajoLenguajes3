package com.unai.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "videojuego")
public class Videojuegos {
    @JacksonXmlProperty(isAttribute = true)
    private String nombre;

    public Videojuegos() {
    }

    public Videojuegos(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Videojuegos{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}
