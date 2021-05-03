package com.sergiojavierre.LecturaXML.dao.users;

import com.sergiojavierre.LecturaXML.entities.Componente;
import com.sergiojavierre.LecturaXML.entities.Jugador;
import com.sergiojavierre.LecturaXML.entities.Videojuegos;

import java.util.List;

public interface DAOUsers {

    public Integer add(Jugador user);
    public List<Jugador> getAll();
    public Jugador search(Integer id);
    public void addVideojuego(Integer id, Videojuegos videojuegos);
    public void addComponente(Integer id, Componente componente);

}
