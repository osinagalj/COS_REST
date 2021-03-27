package app.cos.rest.dto;

import java.util.ArrayList;
import java.util.List;

public class HerdDTO {
	
	private long id;
	private String location;
	private float average_bcs;
	private List<CowDTO> cows = new ArrayList<CowDTO>();
	
	public HerdDTO() {}
	
	public HerdDTO(long id, String location) {
		this.id = id;
		this.location = location;
		this.average_bcs = 7.5f; //todo
	}
	
	public void addCow(CowDTO cow) {
		cows.add(cow);
		//calcualr nuevo promedio
	}
	//-------------------------------------------------------------------------------------//
	//----------------------------- Getters && Setters ------------------------------------//
	//-------------------------------------------------------------------------------------//
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public float getAverage_bcs() {
		return average_bcs;
	}
	public void setAverage_bcs(float average_bcs) {
		this.average_bcs = average_bcs;
	}
	public List<CowDTO> getCows() {
		return cows;
	}
	public void setCows(List<CowDTO> cows) {
		this.cows = cows;
	}
}
