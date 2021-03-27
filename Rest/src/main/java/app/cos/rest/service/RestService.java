package app.cos.rest.service;

import java.util.List;

import app.cos.rest.dto.CowDTO;
import app.cos.rest.dto.HerdDTO;
import app.cos.rest.model.Cow;
import app.cos.rest.model.CowAlert;
import app.cos.rest.model.Herd;
import app.cos.rest.model.HerdAlert;


public interface RestService {
	
	//Cows
	Cow register(Cow cow);
	Cow findById(long id);
	List<Cow> getAllCows();
	List<CowDTO> getAllCowsDTO();
	CowDTO findByIdCTO(long id);
	
	//Herds
	Herd register(Herd herd);
	Herd findHerdById(int id);
	HerdDTO findHerdDTOById(int id);
	List<HerdDTO> getAllHerds();
	

	//CowAlerts
	CowAlert register(CowAlert cowAlert);
	List<CowAlert> getAllCowAlerts();
	
	//HerdAlerts
	HerdAlert register(HerdAlert herdAlert);
	List<HerdAlert> getAllHerdAlerts();
	
}