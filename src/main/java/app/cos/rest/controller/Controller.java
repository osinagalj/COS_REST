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

import app.cos.rest.dto.response.HerdAlertDTO_response;
import app.cos.rest.dto.response.HerdDTO_response;
import app.cos.rest.model.Cow;
import app.cos.rest.model.CowAlert;
import app.cos.rest.model.CowBcs;
import app.cos.rest.model.Herd;
import app.cos.rest.model.HerdAlert;
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

	
	//-----------------------------------------------------------------------------------//
	//-------------------------------- GET ----------------------------------------------//
	//-----------------------------------------------------------------------------------//
		
	@GetMapping(path = "cows")
	public ResponseEntity<List<CowDTO_response>> getCows(){
		List<CowDTO_response> cows = new ArrayList<CowDTO_response>();
		for(Cow cow : restService.getAllCows()) {
			cows.add(this.getCowResponse(cow));
		}
		
		return ResponseEntity.ok(cows);
	}

	/*Fetch cows with last bcs by cow id */
	@GetMapping(path = "cows/{id}")
	public ResponseEntity<CowDTO_response> getCowsById(@PathVariable(value = "id") int id){
		Cow cow = restService.findById(id);	
		return ResponseEntity.ok(this.getCowResponse(cow));
	}
	
	/*Fetch herds with average bcs*/
	@GetMapping(path = "herds")
	public ResponseEntity<List<HerdDTO_response>> getHerds(){
		List<HerdDTO_response> herds = new ArrayList<HerdDTO_response>();
		for(Herd herd : restService.getAllHerds())
			herds.add(this.getHerdResponse(herd));
				
		return ResponseEntity.ok(herds);
	}
	
	/*Fetch herds with average bcs by herd id*/
	@GetMapping(path = "herds/{id}")
	public ResponseEntity<HerdDTO_response> getHerdById(@PathVariable(value = "id") int id){
		Herd herd = restService.findHerdById(id);
		return ResponseEntity.ok(this.getHerdResponse(herd));
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
	

	//-----------------------------------------------------------------------------------//
	//-------------------------------- private Methods  --------------------------------//
	//-----------------------------------------------------------------------------------//
	
	private CowDTO_response getCowResponse(Cow cow) {
		CowDTO_response new_cow = modelMapper.map(cow, CowDTO_response.class);
		new_cow.setHerd(cow.getHerd().getLocation());
		CowBcs cowBcs = restService.getLastBcs(cow.getId());
		
		if(cowBcs != null) {
			new_cow.setBcs_date(cowBcs.getDate());
			new_cow.setCc(cowBcs.getCc());
		}
		return new_cow;
	}
	
	private HerdDTO_response getHerdResponse(Herd herd) {
		HerdDTO_response new_herd = new HerdDTO_response(herd.getId(),herd.getLocation());
		for(Cow cow : restService.getAllCows(herd)) {
			CowDTO_response c = getCowResponse(cow);
			new_herd.add(c);
		}
		return new_herd;
	}
	
	


}