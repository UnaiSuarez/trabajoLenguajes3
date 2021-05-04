package com.unai;

import com.unai.controllers.Menu;
import com.unai.dao.DAOFactory;
import com.unai.entities.Jugador;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.menu();
    }
}
