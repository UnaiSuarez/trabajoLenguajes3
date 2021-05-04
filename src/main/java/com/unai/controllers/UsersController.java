package com.unai.controllers;

import com.unai.dao.DAOFactory;
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


/*
    @GetMapping("/addUser")
    public String addUser(Model model, @RequestParam String email, @RequestParam String password){
        User user = new User(email,password);
        DAOFactory.getInstance().getDaoUsers().add(user);
        //aquí crearemos la vista que queramos para el usuario añadido correctamente
        return "users";
    }

    @GetMapping("/addBookToUser")
    public String addBookToUser(Model model, @RequestParam Integer id, @RequestParam String title){
        DAOFactory.getInstance().getDaoUsers().add(id,new Book(title));
        //lo mismo para el libro añadido
        return "users";
    }

 */

}
