package com.unai.dao.users;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.unai.entities.Componente;
import com.unai.entities.Jugador;
import com.unai.entities.Data;
import com.unai.entities.Videojuegos;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DAOUsersXML implements DAOUsers{

    private final String file = "jugadores.xml";

    @Override
    public Integer add(Jugador jugador) {
        List<Jugador>jugadores = getAll();
        int lastId = jugadores.get(jugadores.size()-1).getId(); // tomo el último
        jugador.setId(lastId + 1);
        jugadores.add(jugador);
        save(jugadores);
        return Jugador.nextId;
    }
    @Override
    public void save(List<Jugador> jugadores){
        Data dataContainer = new Data(jugadores);
        XmlMapper xmlMapper = new XmlMapper();
        try {
            xmlMapper.writeValue(new File(file), dataContainer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Jugador> getAll() {
        Data data = new Data(null);
        XmlMapper xmlMapper = new XmlMapper();
        try {
            String xml = new String(Files.readAllBytes(Path.of(file)));
            data = xmlMapper.readValue(xml, Data.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data.getJugadores();
    }

    @Override
    public Jugador search(Integer id) {
        List<Jugador> jugadores = getAll();
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getId() == id){
                Jugador poisibleJugador = jugadores.get(i);
                return poisibleJugador;
            }
            else {
                return null;
            }
        }
        return null;
    }

    @Override
    public void addVideojuego(Integer id, Videojuegos videojuegos) {
        List<Jugador> jugadores = getAll();
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getId() == id) {
                jugadores.get(i).addVideojuego(videojuegos);
            }
            save(jugadores);
        }
    }

    @Override
    public void addComponente(Integer id, Componente componente) {
        List<Jugador> jugadores = getAll();
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getId() == id) {
                jugadores.get(i).addComponente(componente);
            }
            save(jugadores);
        }
    }
}
