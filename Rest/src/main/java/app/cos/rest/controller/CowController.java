package app.cos.rest.controller;

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

import app.cos.rest.model.Cow;
import app.cos.rest.service.CowService;


@RestController
public class CowController {
	
	@Autowired
	CowService cowService;

	@PostMapping(path = "/api/cows")
	public ResponseEntity<Cow> registerPersona(@RequestBody Cow cow){
		Cow newCow = cowService.register(cow);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newCow.getId())
				.toUri();
		return ResponseEntity.created(location).body(newCow);
	}	

	@GetMapping(path = "/api/cows")
	public ResponseEntity<List<Cow>> getCows( ){
		List<Cow> list = cowService.getAllCows();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping(path = "/api/cows/{id}/")
	public ResponseEntity<Cow> getPersona(@PathVariable(value = "id") int id){
		Cow p = cowService.findById(id);		
		return ResponseEntity.ok(p);
	}
}