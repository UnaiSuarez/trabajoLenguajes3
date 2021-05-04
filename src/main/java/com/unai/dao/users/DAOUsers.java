package com.unai.dao.users;

import com.unai.entities.Componente;
import com.unai.entities.Jugador;
import com.unai.entities.Videojuegos;

import java.util.List;

public interface DAOUsers {

    public Integer add(Jugador user);
    public List<Jugador> getAll();
    public Jugador search(Integer id);
    public void addVideojuego(Integer id, Videojuegos videojuegos);
    public void addComponente(Integer id, Componente componente);

}
