package app.cos.rest.controller;

import app.cos.rest.service.PersonaService;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



import app.cos.rest.model.Persona;

@RestController
public class PersonaController {
	
	@Autowired
	PersonaService ps;

	@PostMapping(path = "/api/personas")
	public ResponseEntity<Persona> registerPersona(@RequestBody Persona p){
		Persona newP = ps.register(p);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newP.getId())
				.toUri();
		return ResponseEntity.created(location).body(newP);
	}	

	@GetMapping(path = "/api/personas")
	public ResponseEntity<List<Persona>> getPersonas( ){
		List<Persona> list = ps.getAllPersonas();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(path = "/api/personas/{name}/")
	public ResponseEntity<Persona> getPersona(@PathVariable(value = "name") String name){
		Persona p = ps.findByName(name);		
		return ResponseEntity.ok(p);
	}


}
