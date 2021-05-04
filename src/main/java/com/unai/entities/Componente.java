package com.unai.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "componente")
public class Componente {
    @JacksonXmlProperty(isAttribute = true)
    private int id;

    public Componente() {
    }

    public Componente(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Componente{" +
                "id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }
}
