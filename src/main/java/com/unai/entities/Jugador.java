package com.unai.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement(localName = "jugador")
public class Jugador {
    public static Integer nextId = 0;
    @JacksonXmlProperty(isAttribute = true)
    private int id;
    @JacksonXmlProperty(isAttribute = true)
    private String nombre;
    @JacksonXmlElementWrapper(localName = "componentes")
    @JacksonXmlProperty(localName = "componente")
    List<Componente> componentes = new ArrayList<>();
    @JacksonXmlElementWrapper(localName = "videojuegos")
    @JacksonXmlProperty(localName = "videojuego")
    List<Videojuegos> videojuegos = new ArrayList<>();

    public Jugador() {
    }

    public Jugador(String nombre) {
        this.id = nextId;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addComponente(Componente componente){
        if(this.componentes == null){
            this.componentes = new ArrayList<>();
        }
        componentes.add(componente);
    }

    public void addVideojuego(Videojuegos videojuego){
        if(this.videojuegos == null){
            this.videojuegos = new ArrayList<>();
        }
        videojuegos.add(videojuego);
    }

    public List<Componente> getComponentes() {
        return componentes;
    }

    public List<Videojuegos> getVideojuegos() {
        return videojuegos;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + nombre + '\'' +
                ", componentes=" + componentes +
                ", videojuegos=" + videojuegos +
                '}';
    }
}
