package app.cos.rest.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.cos.rest.model.Cow;
import app.cos.rest.repository.CowRepository;

@Service
public class CowServiceImp implements CowService {
	
	@Autowired
	CowRepository cowRepository;

	
	@Override
	public Cow register(Cow cow) {
		return cowRepository.save(cow);
	}

	@Override
	public Cow findById(int id) {
		return cowRepository.findById(id);
	}
	
	public List<Cow> getAllCows(){
		List<Cow> cows = new ArrayList<Cow>();
		Iterator<Cow> it = cowRepository.findAll().iterator();
		while (it.hasNext()) {
			Cow cow = it.next();
			cows.add(cow);
		}
		return cows;
	}
}