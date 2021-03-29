package app.cos.rest.service;

import java.util.List;

import app.cos.rest.dto.response.CowExtraDTO_response;
import app.cos.rest.dto.response.HerdExtraDTO_response;
import app.cos.rest.model.Cow;
import app.cos.rest.model.CowAlert;
import app.cos.rest.model.CowBcs;
import app.cos.rest.model.CowExtra;
import app.cos.rest.model.Herd;
import app.cos.rest.model.HerdAlert;
import app.cos.rest.model.HerdExtra;


public interface RestService {
	
	//Cows
	Cow register(Cow cow);
	Cow findById(long id);
	List<Cow> getCowsByHerd(Herd herd);
	List<Cow> getAllCows();
	
	//CowExtra
	CowExtra getCowExtraById(long id);
	List<CowExtra> getAllCowsExtra(long id_herd);
	List<CowExtra> getAllCowsExtra(); 
	
	//HerdExtra
	HerdExtra getHerdExtraById(long id);
	List<HerdExtra> getAllHerdExtra();
	
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
	
}