package app.cos.rest.controller;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import app.cos.rest.dto.CowDTO;
import app.cos.rest.dto.HerdDTO;
import app.cos.rest.model.Cow;
import app.cos.rest.model.CowAlert;
import app.cos.rest.model.Herd;
import app.cos.rest.model.HerdAlert;
import app.cos.rest.service.RestService;



@RestController
@RequestMapping("/api/v0/")
public class Controller {
	
	@Autowired
	RestService restService;
	
	
	//-----------------------------------------------------------------------------------//
	//-------------------------------- POST ---------------------------------------------//
	//-----------------------------------------------------------------------------------//
	@PostMapping(path = "cows")
	public ResponseEntity<Cow> addCow(@RequestBody Cow cow){
		Cow newCow = restService.register(cow);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newCow.getId())
				.toUri();
		return ResponseEntity.created(location).body(newCow);
	}	

	@PostMapping(path = "herd")
	public ResponseEntity<Herd> addHerd(@RequestBody Herd herd){
		Herd newHerd = restService.register(herd);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newHerd.getId())
				.toUri();
		return ResponseEntity.created(location).body(newHerd);
	}
	

	@PostMapping(path = "cowAlert")
	public ResponseEntity<CowAlert> addHerd(@RequestBody CowAlert cowAlert){
		CowAlert newCowAlert = restService.register(cowAlert);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newCowAlert.getId())
				.toUri();
		return ResponseEntity.created(location).body(newCowAlert);
	}

	//ASOCIA UN COW A UN HERD that already exists
	//http://localhost:8080/api/associate_cow?herd=1&cow=1
	@PostMapping(path = "associate_cow")
	public ResponseEntity<Herd> registerCowToHerd(@RequestParam(value = "herd")int id_herd, @RequestParam(value = "cow")int id_cow ){
		Herd herd = restService.findHerdById(id_herd);
		Cow cow = restService.findById(id_cow);
		cow.setHerd(herd);
		restService.register(cow);
		return ResponseEntity.ok(herd);
	}
	
	
	
	
	//-----------------------------------------------------------------------------------//
	//-------------------------------- GET ---------------------------------------------//
	//-----------------------------------------------------------------------------------//
	
	@GetMapping(path = "cows")
	public ResponseEntity<List<CowDTO>> getCows(){
		List<CowDTO> list = restService.getAllCowsDTO();
		return ResponseEntity.ok(list);
	}
		
	@GetMapping(path = "cows/{id}")
	public ResponseEntity<CowDTO> getCow(@PathVariable(value = "id") int id){
		CowDTO p = restService.findByIdCTO(id);		
		return ResponseEntity.ok(p);
	}
	
	@GetMapping(path = "herds")
	public ResponseEntity<List<HerdDTO>> getHerds(){
		return ResponseEntity.ok(restService.getAllHerds());
	}
	
	@GetMapping(path = "herds/{id}")
	public ResponseEntity<HerdDTO> getHerd(@PathVariable(value = "id") int id){
		HerdDTO p = restService.findHerdDTOById(id);		
		return ResponseEntity.ok(p);
	}
	
	@GetMapping(path = "cowAlerts")
	public ResponseEntity<List<CowAlert>> getCowAlerts(){
		List<CowAlert> p = restService.getAllCowAlerts();		
		return ResponseEntity.ok(p);
	}
	
	@GetMapping(path = "herdAlerts")
	public ResponseEntity<List<HerdAlert>> getHerdAlerts(){
		List<HerdAlert> p = restService.getAllHerdAlerts();		
		return ResponseEntity.ok(p);
	}
	

	
	//Para implementar paginacion se usan:
	//@GetMapping(path = "/api/cows?page=1&limit=50"), entonces devuelve de a 50 
	
	/*
	//para la paginacion
	@GetMapping(path = "/api/cows")
	public ResponseEntity<List<Cow>> getCows(@RequestParam(value = "page") int page , @RequestParam(value = "limit") int limit ){
		List<Cow> list = restService.getAllCows();
		return ResponseEntity.ok(list);
	}*/
}