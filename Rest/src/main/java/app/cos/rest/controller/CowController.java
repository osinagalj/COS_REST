package app.cos.rest.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;



import app.cos.rest.dto.CowDTO;
import app.cos.rest.dto.HerdDTO;
import app.cos.rest.model.Cow;
import app.cos.rest.model.Herd;
import app.cos.rest.service.RestService;



@RestController
public class CowController {
	
	@Autowired
	RestService restService;

	@PostMapping(path = "/api/cows")
	public ResponseEntity<Cow> addCow(@RequestBody Cow cow){
		Cow newCow = restService.register(cow);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newCow.getId())
				.toUri();
		return ResponseEntity.created(location).body(newCow);
	}	

	//ASOCIA UN COW A UN HERD ya existentes
	//http://localhost:8080/api/herd?herd=1&cow=1
	@PostMapping(path = "/api/herd")
	public ResponseEntity<Herd> registerCowToHerd(@RequestParam(value = "herd")int id_herd, @RequestParam(value = "cow")int id_cow ){
		Herd herd = restService.findHerdById(id_herd);
		Cow cow = restService.findById(id_cow);
		cow.setHerd(herd);
		restService.saveCow(cow);
		return ResponseEntity.ok(herd);
	}
	
	
	
	@GetMapping(path = "/api/cows")
	public ResponseEntity<List<Cow>> getCows( ){
		List<Cow> list = restService.getAllCows();
		return ResponseEntity.ok(list);
	}
	

	
	@GetMapping(path = "/api/cows/{id}/")
	public ResponseEntity<Cow> getCow(@PathVariable(value = "id") int id){
		Cow p = restService.findById(id);		
		return ResponseEntity.ok(p);
	}
	
	@GetMapping(path = "/api/{id}")
	public ResponseEntity<CowDTO> getCowDTO(@PathVariable(value = "id") int id){
		CowDTO p = restService.findById2(id);		
		return ResponseEntity.ok(p);
	}
	
	
	@GetMapping(path = "/api/herds/{id}")
	public ResponseEntity<HerdDTO> getHerdDTO(@PathVariable(value = "id") int id){
		HerdDTO p = restService.findHerdDTOById(id);		
		return ResponseEntity.ok(p);
	}
	
	@GetMapping(path = "/api/herds")
	public ResponseEntity<List<HerdDTO>> getAllHerdDTO(){
		return ResponseEntity.ok(restService.getAllHerds());
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