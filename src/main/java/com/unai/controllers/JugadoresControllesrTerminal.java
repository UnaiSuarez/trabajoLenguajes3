package com.unai.controllers;

import com.unai.dao.DAOFactory;
import com.unai.entities.Jugador;
import com.unai.entities.Videojuegos;
import jdk.dynalink.linker.LinkerServices;

import java.util.List;

public class JugadoresControllesrTerminal {
    public void muestraDosJugadores(){
        System.out.println(DAOFactory.getInstance().getDaoUsers().getAll().get(0));
        System.out.println(DAOFactory.getInstance().getDaoUsers().getAll().get(1));
    }
    public void jugadoresDosJuegos(){
        List<Jugador> jugadores = DAOFactory.getInstance().getDaoUsers().getAll();
        for (int i = 0; i < jugadores.size(); i++) {
            List<Videojuegos> videojuegos = jugadores.get(i).getVideojuegos();
            if (videojuegos.size() >= 2){
                System.out.println(jugadores.get(i));
            }
        }
    }

    public void juegoCyber(){
        List<Jugador> jugadores = DAOFactory.getInstance().getDaoUsers().getAll();
        for (int i = 0; i < jugadores.size(); i++) {
            List<Videojuegos> videojuegos = jugadores.get(i).getVideojuegos();
            for (int j = 0; j < videojuegos.size(); j++) {
                if (videojuegos.get(j).getNombre().contains("cyber")){
                    System.out.println(jugadores.get(i));
                }
            }
        }
    }

    public void jugadorUnai(){
        List<Jugador> jugadores = DAOFactory.getInstance().getDaoUsers().getAll();
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getNombre().equals("unai")){
                System.out.println(jugadores.get(i));
            }
        }
    }
}
