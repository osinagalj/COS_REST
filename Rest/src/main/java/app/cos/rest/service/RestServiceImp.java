package app.cos.rest.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.cos.rest.model.Cow;
import app.cos.rest.model.CowAlert;
import app.cos.rest.model.CowBcs;
import app.cos.rest.model.CowExtra;
import app.cos.rest.model.Herd;
import app.cos.rest.model.HerdAlert;
import app.cos.rest.model.HerdExtra;
import app.cos.rest.repository.CowAlertRepository;
import app.cos.rest.repository.CowBcsRepository;
import app.cos.rest.repository.CowRepository;
import app.cos.rest.repository.HerdAlertRepository;
import app.cos.rest.repository.HerdRepository;

@Service
public class RestServiceImp implements RestService {
	
	@Autowired
	CowRepository cowRepository;
	
	@Autowired
	HerdRepository herdRepository;
	
	@Autowired
	CowAlertRepository cowAlertRepository;
	
	@Autowired
	HerdAlertRepository herdAlertRepository;
	
	@Autowired
	CowBcsRepository cowBcsRepository;
	
	
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
	public HerdAlert register(HerdAlert herdAlert) {
		return herdAlertRepository.save(herdAlert); 
	}
	
	@Override
	public CowBcs register(CowBcs cowBcs) {
		return cowBcsRepository.save(cowBcs); 
	}
	

	@Override
	public Cow findById(long id) {
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
	public Herd findHerdById(long id) {
		return herdRepository.findById(id);
	}
	

	@Override
	public List<Herd> getAllHerds(){
		List<Herd> herds = new ArrayList<Herd>();
		Iterator<Herd> it = herdRepository.findAll().iterator();
		while (it.hasNext()) {
			Herd herd = it.next();
			herds.add(herd);
		}
		return herds;
	}
	
	
	@Override
	public List<CowAlert> getAllCowAlerts(){
		List<CowAlert> cows = new ArrayList<CowAlert>();
		Iterator<CowAlert> it = cowAlertRepository.findAll().iterator();
		while (it.hasNext()) {
			CowAlert cow = it.next();
			cows.add(cow);
		}
		return cows;
	}
	
		
	@Override
	public List<HerdAlert> getAllHerdAlerts(){
		List<HerdAlert> herdAlerts = new ArrayList<HerdAlert>();
		Iterator<HerdAlert> it = herdAlertRepository.findAll().iterator();
		while (it.hasNext()) {
			HerdAlert herdAlert = it.next();
			herdAlerts.add(herdAlert);
		}
			
		return herdAlerts;
	}
	

	/*Fetch all cowBcs for a particular cow*/
	@Override
	public List<CowBcs> getAllCowBcs(long id_cow){
		List<CowBcs> cows = new ArrayList<CowBcs>();
		Iterator<CowBcs> it = cowBcsRepository.findAll().iterator();
		while (it.hasNext()) {
			CowBcs cow = it.next();
			if(cow.getCow().getId() == id_cow)
				cows.add(cow);
		}
		return cows;
	}
	
	/*Fetch all cowBcs for a particular cow*/
	@Override
	public CowBcs getLastBcs(long id_cow){
		List<CowBcs> cows = new ArrayList<CowBcs>();
		Iterator<CowBcs> it = cowBcsRepository.findAll().iterator();
		while (it.hasNext()) {
			CowBcs cow = it.next();
			if(cow.getCow().getId() == id_cow)
				cows.add(cow);
		}
		Collections.sort(cows);
		Collections.reverse(cows);
		if(cows.isEmpty())
			return null;
		else
			return cows.get(0);
	}
	
	

	/*Fetch all cowBcs for a particular cow*/
	@Override
	public List<CowBcs> getAllCowBcs(){
		List<CowBcs> cows = new ArrayList<CowBcs>();
		Iterator<CowBcs> it = cowBcsRepository.findAll().iterator();
		while (it.hasNext()) {
			CowBcs cow = it.next();
		
			cows.add(cow);
		}
		return cows;
	}
	

	/*Fetch all Cows for a particular Herd*/
	@Override
	public List<Cow> getCowsByHerd(Herd herd){
		return cowRepository.findAllByherd(herd);
	}
	
	
	

	/*Fetch all Cows for a particular Herd*/
	@Override
	public CowExtra getCowExtraById(long id) {
		
		Cow cow = cowRepository.findById(id);
		Date last_bcs = null;
		int cc = 0;
		
		List<CowBcs> list = getAllCowBcs(cow.getId());
		if(list.size() > 0 ) {
			Collections.sort(list);
			Collections.reverse(list);
			CowBcs cowBcs = list.get(0);
			last_bcs = cowBcs.getDate();
			cc = cowBcs.getCc();
		}
		
		CowExtra new_cow = new CowExtra();
			new_cow.setId(cow.getId());
			new_cow.setEletronic_id(cow.getEletronic_id());
			new_cow.setId_herd(cow.getHerd().getId());
			new_cow.setBorn_date(cow.getBorn_date());
			new_cow.setDeliveries(cow.getDeliveries());
			new_cow.setLast_due_date(cow.getLast_due_date());
			new_cow.setWeigth(cow.getWeigth());
			
			new_cow.setBcs_date(last_bcs);
			new_cow.setCc(cc);
		return new_cow;
	}
	
	/*Fetch all Cows for a particular Herd*/
	@Override
	public List<CowExtra> getAllCowsExtra(){
		List<CowExtra> cows = new ArrayList<CowExtra>();
		Iterator<Cow> it = cowRepository.findAll().iterator();
		while (it.hasNext()) {
			Cow cow = it.next();
			CowExtra new_cow = getCowExtraById(cow.getId());
			cows.add(new_cow);
		}
		return cows;
	}
	
	/*Fetch all Cows for a particular Herd*/
	@Override
	public List<CowExtra> getAllCowsExtra(long id_herd){
		List<CowExtra> cows = new ArrayList<CowExtra>();
		Iterator<Cow> it = cowRepository.findAll().iterator();
		while (it.hasNext()) {
			Cow cow = it.next();
			if(cow.getHerd().getId() == id_herd) {
				CowExtra new_cow = getCowExtraById(cow.getId());
				cows.add(new_cow);
			}
		}
		return cows;
	}
	
	/*Fetch all Cows for a particular Herd*/
	@Override
	public List<HerdExtra> getAllHerdExtra(){
		
		List<HerdExtra> herds = new ArrayList<HerdExtra>();
		for(Herd herd : herdRepository.findAll()) {
			herds.add(getHerdExtraById(herd.getId()));
		}

		return herds;
	}
	 
	/*Fetch all Cows for a particular Herd*/
	@Override
	public HerdExtra getHerdExtraById(long id) {
		Herd herd = herdRepository.findById(id);
		HerdExtra new_herd = new HerdExtra(herd.getId(),
				herd.getLocation(),
				getAllCowsExtra(herd.getId())
				);
		return new_herd;
	}
	
	
	

	
}