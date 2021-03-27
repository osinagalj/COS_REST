package app.cos.rest.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.cos.rest.dto.CowDTO;
import app.cos.rest.dto.HerdDTO;
import app.cos.rest.model.Cow;
import app.cos.rest.model.Herd;
import app.cos.rest.repository.CowRepository;
import app.cos.rest.repository.HerdRepository;

@Service
public class RestServiceImp implements RestService {
	
	@Autowired
	CowRepository cowRepository;
	
	@Autowired
	HerdRepository herdRepository;
	
	@Override
	public Cow register(Cow cow) {
		return cowRepository.save(cow);
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
	public CowDTO findById2(int id) {
		Cow cow = cowRepository.findById(id);
		//Herd herd = herdRepository.findById(cow.getHerd().getId());
		
		CowDTO new_cow = new CowDTO(
									cow.getId(),
									cow.getEletronic_id(),
									cow.getBorn_date(),
									cow.getLast_due_date(),
									cow.getDeliveries(),
									cow.getWeigth(),
									1,
									1, //id_cowBcs
									new Date(), //date of cowBcs
									1 //cc
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
	public Cow saveCow(Cow cow) {
		return cowRepository.save(cow);
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
	
	

	
}