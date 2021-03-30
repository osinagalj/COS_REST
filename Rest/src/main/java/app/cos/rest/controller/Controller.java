package app.cos.rest.controller;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import app.cos.rest.dto.request.CowAlertDTO_request;
import app.cos.rest.dto.request.CowBcsDTO_request;
import app.cos.rest.dto.request.CowDTO_request;
import app.cos.rest.dto.request.HerdAlertDTO_request;
import app.cos.rest.dto.request.HerdDTO_request;
import app.cos.rest.dto.response.CowAlertDTO_response;
import app.cos.rest.dto.response.CowBcsDTO_response;
import app.cos.rest.dto.response.CowDTO_response;
import app.cos.rest.dto.response.CowExtraDTO_response;
import app.cos.rest.dto.response.HerdAlertDTO_response;
import app.cos.rest.dto.response.HerdDTO_response;
import app.cos.rest.dto.response.HerdExtraDTO_response;
import app.cos.rest.model.Cow;
import app.cos.rest.model.CowAlert;
import app.cos.rest.model.CowBcs;
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
	@PostMapping(path = "cow")
	public ResponseEntity<Long> addCow(@RequestBody CowDTO_request cowDTO){
		Cow new_cow = modelMapper.map(cowDTO, Cow.class);
		new_cow.setHerd(restService.findHerdById(cowDTO.getHerd_id()));
		restService.register(new_cow);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(new_cow.getId())
				.toUri();

		return ResponseEntity.created(location).body(new_cow.getId());
	}	

	@PostMapping(path = "cowBcs")
	public ResponseEntity<Long> addCow(@RequestBody CowBcsDTO_request cowBcs){
		CowBcs new_cow = modelMapper.map(cowBcs, CowBcs.class);
		
		new_cow.setCow(restService.findById(cowBcs.getCow_id()));
		new_cow.setDate(new Date());
		restService.register(new_cow);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(new_cow.getId())
				.toUri();
				
		return ResponseEntity.created(location).body(new_cow.getId());
	}


	@PostMapping(path = "cowAlert")
	public ResponseEntity<Long> addHerd(@RequestBody CowAlertDTO_request cowAlertDTO){
		CowAlert newCowAlert = modelMapper.map(cowAlertDTO, CowAlert.class);
		newCowAlert.setCow(restService.findById(cowAlertDTO.getCow_id()));
		restService.register(newCowAlert);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newCowAlert.getId())
				.toUri();
		return ResponseEntity.created(location).body(newCowAlert.getId());
	}
	
	@PostMapping(path = "herd")
	public ResponseEntity<Long> addHerd(@RequestBody HerdDTO_request herdDTO){
		Herd new_herd = modelMapper.map(herdDTO, Herd.class);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(new_herd.getId())
				.toUri();
		
		restService.register(new_herd);

		return ResponseEntity.created(location).body(new_herd.getId());
	}
	

	
	@PostMapping(path = "herdAlert")
	public ResponseEntity<Long> addHerd(@RequestBody HerdAlertDTO_request herdAlertDTO){
		HerdAlert newHerdAlert = modelMapper.map(herdAlertDTO, HerdAlert.class);
		newHerdAlert.setHerd(restService.findHerdById(herdAlertDTO.getHerd_id()));
		restService.register(newHerdAlert);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newHerdAlert.getId())
				.toUri();
		return ResponseEntity.created(location).body(newHerdAlert.getId());
	}

	//ASOCIA UN COW A UN HERD that already exists
	//http://localhost:8080/api/associate_cow?herd=1&cow=1
	@PostMapping(path = "associate_cow")
	public ResponseEntity<CowDTO_response> registerCowToHerd(@RequestParam(value = "herd")int id_herd, @RequestParam(value = "cow")int id_cow ){
		Herd herd = restService.findHerdById(id_herd);
		Cow cow = restService.findById(id_cow);
		cow.setHerd(herd);
		restService.register(cow);
		CowDTO_response cow_response = modelMapper.map(cow, CowDTO_response.class);
		cow_response.setHerd_id(herd.getId());
		return ResponseEntity.ok(cow_response);
	}
	
	
	//-----------------------------------------------------------------------------------//
	//-------------------------------- GET ---------------------------------------------//
	//-----------------------------------------------------------------------------------//
	

	@GetMapping(path = "cows")
	public ResponseEntity<List<CowDTO_response>> getCows(){
		List<CowDTO_response> cows = new ArrayList<CowDTO_response>();
		for(Cow cow : restService.getAllCows()) {
			CowDTO_response new_cow =  modelMapper.map(cow, CowDTO_response.class);
			new_cow.setHerd_id(cow.getHerd().getId());
			cows.add(new_cow);
		}
		return ResponseEntity.ok(cows);
	}
	

	@GetMapping(path = "cows/{id}")
	public ResponseEntity<CowDTO_response> getCow(@PathVariable(value = "id") int id){
		Cow cow = restService.findById(id);
		CowDTO_response new_cow = modelMapper.map(cow, CowDTO_response.class);
		new_cow.setHerd_id(cow.getHerd().getId());
		return ResponseEntity.ok(new_cow);
	}
	
	@GetMapping(path = "herds")
	public ResponseEntity<List<HerdDTO_response>> getHerds(){
		List<HerdDTO_response> herds = new ArrayList<HerdDTO_response>();
		for(Herd herd: restService.getAllHerds()) {
			HerdDTO_response new_herd = new HerdDTO_response();
			new_herd.setId(herd.getId());
			new_herd.setLocation(herd.getLocation());
			List<CowDTO_response> cows = new ArrayList<CowDTO_response>();
			for(Cow cow : restService.getCowsByHerd(herd)) {
				CowDTO_response new_cow = modelMapper.map(cow, CowDTO_response.class);
				new_cow.setHerd_id(herd.getId());
				cows.add(new_cow);
			}
			
			new_herd.setCows(cows);
			herds.add(new_herd);
		}
		return ResponseEntity.ok(herds);
	}
	
	

	
	
	@GetMapping(path = "herds/{id}")
	public ResponseEntity<HerdDTO_response> getHerd(@PathVariable(value = "id") int id){
		Herd herd = restService.findHerdById(id);	
		HerdDTO_response new_herd = new HerdDTO_response();
		new_herd.setId(herd.getId());
		new_herd.setLocation(herd.getLocation());
		List<CowDTO_response> cows = new ArrayList<CowDTO_response>();
		for(Cow cow : restService.getCowsByHerd(herd)) {
			CowDTO_response new_cow = modelMapper.map(cow, CowDTO_response.class);
			new_cow.setHerd_id(herd.getId());
			cows.add(new_cow);
		}
		new_herd.setCows(cows);
	
		return ResponseEntity.ok(new_herd);
	}
	

	
	
	@GetMapping(path = "cowAlerts")
	public ResponseEntity<List<CowAlertDTO_response>> getCowAlerts(){
		List<CowAlertDTO_response> alerts = new ArrayList<CowAlertDTO_response>();
		for(CowAlert cowAlert: restService.getAllCowAlerts()) {
			CowAlertDTO_response newCowAlert = modelMapper.map(cowAlert, CowAlertDTO_response.class);
			newCowAlert.setId_cow(cowAlert.getCow().getId());
			alerts.add(newCowAlert);
		}
		return ResponseEntity.ok(alerts);
	}
	
	@GetMapping(path = "herdAlerts")
	public ResponseEntity<List<HerdAlertDTO_response>> getHerdAlerts(){
		List<HerdAlertDTO_response> alerts = new ArrayList<HerdAlertDTO_response>();
		for(HerdAlert cowAlert: restService.getAllHerdAlerts()) {
			HerdAlertDTO_response newHerdAlert = modelMapper.map(cowAlert, HerdAlertDTO_response.class);
			newHerdAlert.setId_herd(cowAlert.getHerd().getId());
			alerts.add(newHerdAlert);
		}
		return ResponseEntity.ok(alerts);
	}
	
	@GetMapping(path = "cowsBcs")
	public ResponseEntity<List<CowBcsDTO_response>> getAllCowBcs(){
		List<CowBcsDTO_response> alerts = new ArrayList<CowBcsDTO_response>();
		for(CowBcs cowBcs: restService.getAllCowBcs()) {
			CowBcsDTO_response newCowBcs = modelMapper.map(cowBcs, CowBcsDTO_response.class);
			newCowBcs.setCow_id(cowBcs.getCow().getId());
			alerts.add(newCowBcs);
		}
		return ResponseEntity.ok(alerts);
	}
	
	
	//---------------------- Extras ---------------------------------------------//
	@GetMapping(path = "cows/extra")
	public ResponseEntity<List<CowExtraDTO_response>> getCowsExtra(){
		List<CowExtraDTO_response> cows = new ArrayList<CowExtraDTO_response>();
		for(CowExtra cow : restService.getAllCowsExtra()) {		 
			cows.add(modelMapper.map(cow, CowExtraDTO_response.class));
		}
		
		return ResponseEntity.ok(cows);
	}

	
	/*Fetch cows extra by cow id*/
	@GetMapping(path = "cows/extra/{id}")
	public ResponseEntity<CowExtraDTO_response> getCowsExtra(@PathVariable(value = "id") int id){
		CowExtra cow = restService.getCowExtraById(id);
		return ResponseEntity.ok(modelMapper.map(cow, CowExtraDTO_response.class));
	}
	
	
	@GetMapping(path = "herds/extra/{id}")
	public ResponseEntity<HerdExtraDTO_response> getHerdExtra(@PathVariable(value = "id") int id){
		HerdExtra herd = restService.getHerdExtraById(id);
		return ResponseEntity.ok(modelMapper.map(herd, HerdExtraDTO_response.class));
	}
	
	@GetMapping(path = "herds/extra")
	public ResponseEntity<List<HerdExtraDTO_response>> getAllHerdExtra(){
		List<HerdExtraDTO_response> herds = new ArrayList<HerdExtraDTO_response>();
		for(HerdExtra herd : restService.getAllHerdExtra())
			herds.add(modelMapper.map(herd, HerdExtraDTO_response.class));
				
		return ResponseEntity.ok(herds);
	}
	

	


}