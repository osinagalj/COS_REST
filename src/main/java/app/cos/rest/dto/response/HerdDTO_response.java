package app.cos.rest.dto.response;

import java.util.ArrayList;
import java.util.List;

public class HerdDTO_response {
	
	private long id;
	private String location;
	private float average_bcs = 0f;
	private List<CowDTO_response> cows = new ArrayList<CowDTO_response>();
	
	private int size = 0;
	private float total_bcs = 0f;
	
	public HerdDTO_response() {}
	
	public HerdDTO_response(long id, String location) {
		this.id = id;
		this.location = location;
	}
	
	public void add(CowDTO_response cow) {
		cows.add(cow);
		size++;
		total_bcs += cow.getCc();
		this.average_bcs = (float)total_bcs/size;
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
	public List<CowDTO_response> getCows() {
		return cows;
	}
	public void setCows(List<CowDTO_response> cows) {
		this.cows = cows;
	}
}
