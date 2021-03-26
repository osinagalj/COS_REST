package app.cos.rest.service;

import java.util.ArrayList; 
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.cos.rest.model.Persona;
import app.cos.rest.repository.PersonaRepository;

@Service
public class PersonaServiceImp implements PersonaService {
	
	@Autowired
	PersonaRepository pr;

	
	@Override
	public Persona register(Persona p) {
		return pr.save(p);
	}

	@Override
	public Persona findByName(String name) {
		return pr.findByName(name);
	}
	
	public List<Persona> getAllPersonas(){
		List<Persona> personas = new ArrayList<Persona>();
		Iterator<Persona> it = pr.findAll().iterator();
		while (it.hasNext()) {
			Persona persona = it.next();
			personas.add(persona);
		}
		return personas;
	}

}
