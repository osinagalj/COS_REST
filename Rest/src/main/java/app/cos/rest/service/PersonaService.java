package app.cos.rest.service;

import java.util.List;

import app.cos.rest.model.Persona;

public interface PersonaService {
	Persona register(Persona p);
	Persona findByName(String name);
	List<Persona> getAllPersonas();

}
