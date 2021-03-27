package app.cos.rest.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import app.cos.rest.dto.CowDTO;
import app.cos.rest.dto.HerdDTO;
import app.cos.rest.model.Cow;
import app.cos.rest.model.CowAlert;
import app.cos.rest.model.Herd;
import app.cos.rest.repository.CowAlertRepository;
import app.cos.rest.repository.CowRepository;
import app.cos.rest.repository.HerdRepository;

@Service
public class RestServiceImp implements RestService {
	
	@Autowired
	CowRepository cowRepository;
	
	@Autowired
	HerdRepository herdRepository;
	
	@Autowired
	CowAlertRepository cowAlertRepository;
	
	@Override
	public Cow register(Cow cow) {
		return cowRepository.save(cow);
	}
	
	@Override
	public Herd register(Herd herd) {
		return herdRepository.save(herd);
	}
	
	@Override
	public CowAlert register(CowAlert cowAlert) {
		return cowAlertRepository.save(cowAlert);
	}
	

	@Override
	public Cow findById(int id) {
		return cowRepository.findById(id);
	}
	
	@Override
	public List<Cow> getAllCows(){
		List<Cow> cows = new ArrayList<Cow>();
		Iterator<Cow> it = cowRepository.findAll().iterator();
		while (it.hasNext()) {
			Cow cow = it.next();
			cows.add(cow);
		}
		return cows;
	}
	
	@Override
	public CowDTO findByIdCTO(int id) {
		Cow cow = cowRepository.findById(id);
		Herd herd = herdRepository.findById(cow.getHerd().getId());
		int id_herd = 0;
		Date last_bcs = new Date();
		int cc = 0;
		
		if(herd != null)
			id_herd = (int) herd.getId();
		
		
		CowDTO new_cow = new CowDTO(
									cow.getId(),
									cow.getEletronic_id(),
									cow.getBorn_date(),
									cow.getLast_due_date(),
									cow.getDeliveries(),
									cow.getWeigth(),
									1,
									1, //id_cowBcs
									last_bcs, //date of cowBcs
									cc
		);
		
		return new_cow;
	}
	

	@Override
	public HerdDTO findHerdDTOById(int id) {
		Herd herd = herdRepository.findById(id);
		//Herd herd = herdRepository.findById(cow.getHerd().getId());
		
		HerdDTO new_herd = new HerdDTO(herd.getId(),herd.getLocation());
		
		for(Cow cow : cowRepository.findAllByherd(herd)) {
			CowDTO new_cow = new CowDTO(
					cow.getId(),
					cow.getEletronic_id(),
					cow.getBorn_date(),
					cow.getLast_due_date(),
					cow.getDeliveries(),
					cow.getWeigth(),
					herd.getId(),
					1, //id_cowBcs
					new Date(), //date of cowBcs
					1 //cc
			);
			new_herd.addCow(new_cow);
		}
			
		
		return new_herd;
	}
	
	@Override
	public Herd findHerdById(int id) {
		return herdRepository.findById(id);
		//Herd herd = herdRepository.findById(cow.getHerd().getId());
	}
	

	@Override
	public List<HerdDTO> getAllHerds(){
		
		List<HerdDTO> herds = new ArrayList<HerdDTO>();
		Iterator<Herd> it = herdRepository.findAll().iterator();
	
		while (it.hasNext()) {
			//Herd herd = it.next();
			HerdDTO h = findHerdDTOById((int)it.next().getId());
			herds.add(h);
		}
		return herds;
	
	}
	
	@Override
	public List<CowDTO> getAllCowsDTO(){
		
		List<CowDTO> cows_dto = new ArrayList<>();		
		for(Cow cow : cowRepository.findAll()) {
			cows_dto.add(findByIdCTO(cow.getId()));
		}
			
		return cows_dto;
	}
	
	@Override
	public List<CowAlert> getAllCowsAlert(){
		
		List<CowAlert> cows = new ArrayList<CowAlert>();
		Iterator<CowAlert> it = cowAlertRepository.findAll().iterator();
		while (it.hasNext()) {
			CowAlert cow = it.next();
			cows.add(cow);
		}
			
		return cows;
	}
	


	
	 
	
	

	
}