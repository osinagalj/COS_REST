package app.cos.rest.service;

import java.util.List; 

import app.cos.rest.dto.response.CowDTO_response;
import app.cos.rest.dto.response.HerdDTO_response;
import app.cos.rest.model.Cow;
import app.cos.rest.model.CowAlert;
import app.cos.rest.model.CowBcs;
import app.cos.rest.model.Herd;
import app.cos.rest.model.HerdAlert;

public interface RestService {
	
	//Cows
	Cow register(Cow cow);
	Cow findById(long id);
	List<Cow> getAllCows();
	List<Cow> getAllCows(Herd herd);
	

	//Herds
	Herd register(Herd herd);
	Herd findHerdById(long id);
	List<Herd> getAllHerds();
	

	//CowAlerts
	CowAlert register(CowAlert cowAlert);
	List<CowAlert> getAllCowAlerts();
	
	//HerdAlerts
	HerdAlert register(HerdAlert herdAlert);
	List<HerdAlert> getAllHerdAlerts();
	
	//CowBcs
	CowBcs register(CowBcs cowBcs);
	List<CowBcs> getAllCowBcs(long id);
	List<CowBcs> getAllCowBcs();
	CowBcs getLastBcs(long id);
	
}