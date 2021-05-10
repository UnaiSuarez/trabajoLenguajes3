package com.unai.controllers;

import com.unai.dao.DAOFactory;
import com.unai.entities.Componente;
import com.unai.entities.Jugador;
import com.unai.entities.Videojuegos;
import jdk.dynalink.linker.LinkerServices;

import java.util.List;
import java.util.Scanner;

public class JugadoresControllesrTerminal {
    Scanner scanner = new Scanner(System.in);
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

    public void insertarElemento(String nombre){
        Jugador jugador = new Jugador(nombre);
        DAOFactory.getInstance().getDaoUsers().add(jugador);
        System.out.println("jugador guardado");
    }

    public void insertarAtributo(){
        List<Jugador> jugadores = DAOFactory.getInstance().getDaoUsers().getAll();
        int i = 1;
        for (Jugador jugador : jugadores){
            System.out.println(i+") "+jugador.getNombre());
            i++;
        }
        System.out.print("Elige un jugador: ");
        String opcionJugador = scanner.nextLine();
        int opcionJugadorInt = Integer.parseInt(opcionJugador);
        System.out.print("Elige un videojuego: ");
        String opcionVideojuego = scanner.nextLine();
        Videojuegos videojuego = new Videojuegos(opcionVideojuego);
        DAOFactory.getInstance().getDaoUsers().addVideojuego(opcionJugadorInt,videojuego);
        System.out.println("Atributo guardado");
    }

    public void actualizarAtributo() {
        List<Jugador> jugadores = DAOFactory.getInstance().getDaoUsers().getAll();
        for (int i = 0; i < jugadores.size(); i++) {
            List<Videojuegos> videojuegos = jugadores.get(i).getVideojuegos();
            for (int j = 0; j < videojuegos.size(); j++) {
                if (videojuegos.get(j).getNombre().contains("cod")) {
                    videojuegos.get(j).setNombre("call of duty");
                }
            }
        }
        DAOFactory.getInstance().getDaoUsers().save(jugadores);
        System.out.println("guardado");
    }

    public void añadirAtributoCondicion(){
        List<Jugador> jugadores = DAOFactory.getInstance().getDaoUsers().getAll();
        for (int i = 0; i < jugadores.size(); i++) {
            List<Videojuegos> videojuegos = jugadores.get(i).getVideojuegos();
            for (int j = 0; j < videojuegos.size(); j++) {
                if (videojuegos.get(j).getNombre().contains("cyber")) {
                    jugadores.get(i).addComponente(new Componente(5));
                }
            }
        }
        DAOFactory.getInstance().getDaoUsers().save(jugadores);
        System.out.println("guardado");
    }

    public void eliminarElementos(){
        List<Jugador> jugadores = DAOFactory.getInstance().getDaoUsers().getAll();
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getNombre().equals("unai")){
                jugadores.remove(i);
            }
        }
        DAOFactory.getInstance().getDaoUsers().save(jugadores);
        System.out.println("Guardado");
    }

    public void eliminarElementoAtributo(){
        List<Jugador> jugadores = DAOFactory.getInstance().getDaoUsers().getAll();
        for (int i = 0; i < jugadores.size(); i++) {
            List<Videojuegos> videojuegos = jugadores.get(i).getVideojuegos();
            for (int j = 0; j < videojuegos.size(); j++) {
                if (videojuegos.get(j).getNombre().contains("cyber")) {
                    jugadores.remove(i);
                }
            }
        }
        DAOFactory.getInstance().getDaoUsers().save(jugadores);
        System.out.println("guardado");
    }
}
