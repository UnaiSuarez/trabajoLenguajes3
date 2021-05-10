package com.unai.controllers;

import com.unai.dao.DAOFactory;
import com.unai.entities.Componente;
import com.unai.entities.Jugador;
import com.unai.entities.Videojuegos;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UsersController {

    @GetMapping("/muestraDosJugadores")
    public String readUsers(Model model){
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(DAOFactory.getInstance().getDaoUsers().getAll().get(0));
        jugadores.add(DAOFactory.getInstance().getDaoUsers().getAll().get(1));
        model.addAttribute("jugadores", jugadores);
        return "jugadores";
    }

    @GetMapping("/jugadoresDosJuegos")
    public String readUser(Model model){
        List<Jugador> jugadores = DAOFactory.getInstance().getDaoUsers().getAll();
        List<Jugador> jugadoraPasar = new ArrayList<>();
        for (int i = 0; i < jugadores.size(); i++) {
            List<Videojuegos> videojuegos = jugadores.get(i).getVideojuegos();
            if (videojuegos.size() >= 2){
                jugadoraPasar.add(jugadores.get(i));
            }
        }
        model.addAttribute("jugadores", jugadoraPasar);
        return "jugadores";
    }
    @GetMapping("/juegoCyber")
    public String juegoCyber(Model model){
        List<Jugador> jugadores = DAOFactory.getInstance().getDaoUsers().getAll();
        List<Jugador> jugadoraPasar = new ArrayList<>();
        for (int i = 0; i < jugadores.size(); i++) {
            List<Videojuegos> videojuegos = jugadores.get(i).getVideojuegos();
            for (int j = 0; j < videojuegos.size(); j++) {
                if (videojuegos.get(j).getNombre().contains("cyber")){
                    jugadoraPasar.add(jugadores.get(i));
                }
            }
        }
        model.addAttribute("jugadores", jugadoraPasar);
        return "jugadores";
    }
    @GetMapping("/jugadorUnai")
    public String jugadorUnai(Model model){
        List<Jugador> jugadores = DAOFactory.getInstance().getDaoUsers().getAll();
        List<Jugador> jugadoraPasar = new ArrayList<>();
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getNombre().equals("unai")){
                jugadoraPasar.add(jugadores.get(i));
            }
        }
        model.addAttribute("jugadores",jugadoraPasar);
        return "jugadores";
    }

    @GetMapping("/addUser")
    public String addUser(Model model, @RequestParam String nombre){
        Jugador jugador = new Jugador(nombre);
        DAOFactory.getInstance().getDaoUsers().add(jugador);
        return "users";
    }

    @GetMapping("/addAtributo")
    public String addAtributo(Model model, @RequestParam String jugadorId, String videojuego){
        List<Jugador> jugadores = DAOFactory.getInstance().getDaoUsers().getAll();
        Videojuegos videojuegos = new Videojuegos(videojuego);
        int idJugador = Integer.parseInt(jugadorId);
        DAOFactory.getInstance().getDaoUsers().addVideojuego(idJugador,videojuegos);
        return "users";
    }

    @GetMapping("/actualizarAtributo")
    public String actualizarAtributo(Model model){
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
        return "users";
    }

    @GetMapping("/añadirAtributoCondicion")
    public String añadirAtributoCondicion(Model model){
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
        return "users";
    }

    @GetMapping("/eliminarElementos")
    public String eliminarElementos(Model model){
        List<Jugador> jugadores = DAOFactory.getInstance().getDaoUsers().getAll();
        for (int i = 0; i < jugadores.size(); i++) {
            if (jugadores.get(i).getNombre().equals("pepe")){
                jugadores.remove(i);
            }
        }
        DAOFactory.getInstance().getDaoUsers().save(jugadores);
        return "users";
    }

    @GetMapping("/eliminarElementoAtributo")
    public String eliminarElementoAtributo(Model model){
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
        return "users";
    }

}
