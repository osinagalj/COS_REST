package app.cos.rest.service;

import java.util.List;

import app.cos.rest.dto.CowDTO;
import app.cos.rest.dto.HerdDTO;
import app.cos.rest.model.Cow;
import app.cos.rest.model.Herd;


public interface RestService {
	Cow register(Cow cow);
	Cow findById(int id);
	List<Cow> getAllCows();
	
	List<HerdDTO> getAllHerds();
	
	CowDTO findById2(int id);
	
	Herd findHerdById(int id);
	HerdDTO findHerdDTOById(int id);
	Cow saveCow(Cow cow);
	
}