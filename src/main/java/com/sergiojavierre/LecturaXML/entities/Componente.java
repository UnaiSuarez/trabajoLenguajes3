package com.sergiojavierre.LecturaXML.entities;

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
}
