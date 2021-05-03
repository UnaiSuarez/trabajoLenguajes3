package com.sergiojavierre.LecturaXML;

import com.sergiojavierre.LecturaXML.dao.DAOFactory;
import com.sergiojavierre.LecturaXML.entities.Jugador;
import com.sergiojavierre.LecturaXML.entities.Videojuegos;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LecturaXmlApplication {

	public static void main(String[] args) {

		//SpringApplication.run(LecturaXmlApplication.class, args);


		DAOFactory.getInstance().getDaoUsers().add(new Jugador("unai"));

	}

}
