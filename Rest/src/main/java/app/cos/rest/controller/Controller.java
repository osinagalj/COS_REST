package app.cos.rest.controller;

import java.net.URI;
import java.util.ArrayList;

import java.util.List;

import org.modelmapper.ModelMapper;
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

import app.cos.rest.dto.CowAlertDTO;
import app.cos.rest.dto.CowDTO;
import app.cos.rest.dto.CowExtraDTO;
import app.cos.rest.dto.HerdAlertDTO;
import app.cos.rest.dto.HerdDTO;
import app.cos.rest.dto.HerdExtraDTO;
import app.cos.rest.model.Cow;
import app.cos.rest.model.CowAlert;

import app.cos.rest.model.CowExtra;
import app.cos.rest.model.Herd;
import app.cos.rest.model.HerdAlert;
import app.cos.rest.model.HerdExtra;
import app.cos.rest.service.RestService;



@RestController
@RequestMapping("/api/v0/")
public class Controller {
	
	ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	RestService restService;
	

	//-----------------------------------------------------------------------------------//
	//-------------------------------- POST ---------------------------------------------//
	//-----------------------------------------------------------------------------------//
	@PostMapping(path = "cows")
	public ResponseEntity<Cow> addCow(@RequestBody CowDTO cowDTO){
		Cow new_cow = modelMapper.map(cowDTO, Cow.class);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(new_cow.getId())
				.toUri();
		return ResponseEntity.created(location).body(restService.register(new_cow));
	}	

	@PostMapping(path = "herd")
	public ResponseEntity<Herd> addHerd(@RequestBody HerdDTO herdDTO){
		Herd new_herd = modelMapper.map(herdDTO, Herd.class);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(new_herd.getId())
				.toUri();
		return ResponseEntity.created(location).body(restService.register(new_herd));
	}
	

	@PostMapping(path = "cowAlert")
	public ResponseEntity<CowAlert> addHerd(@RequestBody CowAlertDTO cowAlertDTO){
		CowAlert newCowAlert = modelMapper.map(cowAlertDTO, CowAlert.class);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newCowAlert.getId())
				.toUri();
		return ResponseEntity.created(location).body(restService.register(newCowAlert));
	}
	
	@PostMapping(path = "herdAlert")
	public ResponseEntity<HerdAlert> addHerd(@RequestBody HerdAlertDTO herdAlertDTO){
		HerdAlert newHerdAlert = modelMapper.map(herdAlertDTO, HerdAlert.class);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newHerdAlert.getId())
				.toUri();
		return ResponseEntity.created(location).body(restService.register(newHerdAlert));
	}

	//ASOCIA UN COW A UN HERD that already exists
	//http://localhost:8080/api/associate_cow?herd=1&cow=1
	@PostMapping(path = "associate_cow")
	public ResponseEntity<Long> registerCowToHerd(@RequestParam(value = "herd")int id_herd, @RequestParam(value = "cow")int id_cow ){
		Herd herd = restService.findHerdById(id_herd);
		Cow cow = restService.findById(id_cow);
		cow.setHerd(herd);
		restService.register(cow);
		return ResponseEntity.ok(cow.getId());
	}
	
	
	//-----------------------------------------------------------------------------------//
	//-------------------------------- GET ---------------------------------------------//
	//-----------------------------------------------------------------------------------//
	

	@GetMapping(path = "cows")
	public ResponseEntity<List<CowDTO>> getCows(){
		List<CowDTO> cows = new ArrayList<CowDTO>();
		for(Cow cow : restService.getAllCows()) {
			cows.add(modelMapper.map(cow, CowDTO.class));
		}
		return ResponseEntity.ok(cows);
	}
	
	@GetMapping(path = "cows/extra")
	public ResponseEntity<List<CowExtraDTO>> getCowsExtra(){
		List<CowExtraDTO> cows = new ArrayList<CowExtraDTO>();
		for(CowExtra cow : restService.getAllCowsExtra()) {		 
			cows.add(modelMapper.map(cow, CowExtraDTO.class));
		}
		
		return ResponseEntity.ok(cows);
	}
	
	/*Fetch cows extra by cow id*/
	@GetMapping(path = "cows/extra/{id}")
	public ResponseEntity<CowExtraDTO> getCowsExtra(@PathVariable(value = "id") int id){
		CowExtra cow = restService.getCowExtraById(id);
		return ResponseEntity.ok(modelMapper.map(cow, CowExtraDTO.class));
	}
		
	@GetMapping(path = "cows/{id}")
	public ResponseEntity<CowDTO> getCow(@PathVariable(value = "id") int id){
		Cow cow = restService.findById(id);
		return ResponseEntity.ok(modelMapper.map(cow, CowDTO.class));
	}
	
	@GetMapping(path = "herds")
	public ResponseEntity<List<HerdDTO>> getHerds(){
		List<HerdDTO> herds = new ArrayList<HerdDTO>();
		for(Herd herd: restService.getAllHerds()) {
			HerdDTO new_herd = new HerdDTO();
			new_herd.setId(herd.getId());
			new_herd.setLocation(herd.getLocation());
			List<CowDTO> cows = new ArrayList<CowDTO>();
			for(Cow cow : restService.getCowsByHerd(herd))
				cows.add(modelMapper.map(cow, CowDTO.class)); 
			
			new_herd.setCows(cows);
			herds.add(new_herd);
		}
		return ResponseEntity.ok(herds);
	}
	
	@GetMapping(path = "herds/{id}")
	public ResponseEntity<HerdDTO> getHerd(@PathVariable(value = "id") int id){
		Herd herd = restService.findHerdById(id);	
		HerdDTO new_herd = new HerdDTO();
		new_herd.setId(herd.getId());
		new_herd.setLocation(herd.getLocation());
		List<CowDTO> cows = new ArrayList<CowDTO>();
		for(Cow cow : restService.getCowsByHerd(herd))
			cows.add(modelMapper.map(cow, CowDTO.class)); 
		new_herd.setCows(cows);
	
		return ResponseEntity.ok(new_herd);
	}
	
	@GetMapping(path = "herds/extra/{id}")
	public ResponseEntity<HerdExtraDTO> getHerdExtra(@PathVariable(value = "id") int id){
		HerdExtra herd = restService.getHerdExtraById(id);
		return ResponseEntity.ok(modelMapper.map(herd, HerdExtraDTO.class));
	}
	
	@GetMapping(path = "herds/extra")
	public ResponseEntity<List<HerdExtraDTO>> getAllHerdExtra(){
		List<HerdExtraDTO> herds = new ArrayList<HerdExtraDTO>();
		for(HerdExtra herd : restService.getAllHerdExtra())
			herds.add(modelMapper.map(herd, HerdExtraDTO.class));
				
		return ResponseEntity.ok(herds);
	}
	
	@GetMapping(path = "cowAlerts")
	public ResponseEntity<List<CowAlertDTO>> getCowAlerts(){
		List<CowAlertDTO> alerts = new ArrayList<CowAlertDTO>();
		for(CowAlert cowAlert: restService.getAllCowAlerts()) {
			alerts.add(modelMapper.map(cowAlert, CowAlertDTO.class));
		}
		return ResponseEntity.ok(alerts);
	}
	
	@GetMapping(path = "herdAlerts")
	public ResponseEntity<List<HerdAlertDTO>> getHerdAlerts(){
		List<HerdAlertDTO> alerts = new ArrayList<HerdAlertDTO>();
		for(HerdAlert cowAlert: restService.getAllHerdAlerts()) {
			alerts.add(modelMapper.map(cowAlert, HerdAlertDTO.class));
		}
		return ResponseEntity.ok(alerts);
	}
	
	

	


}