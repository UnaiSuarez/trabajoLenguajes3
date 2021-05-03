package com.sergiojavierre.LecturaXML.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;
@JacksonXmlRootElement(localName = "data")
public class Data {
    @JacksonXmlElementWrapper(localName = "jugadores")
    @JacksonXmlProperty(localName = "jugador")
    List<Jugador> jugadores;

    public Data(){}

    public Data(List<Jugador> jugadores) {
        if(jugadores != null) {
            this.jugadores = jugadores;
        }
        else this.jugadores = new ArrayList<>();
    }

    public List<Jugador> getUsers() {
        return jugadores;
    }

    public void setUsers(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }
}
