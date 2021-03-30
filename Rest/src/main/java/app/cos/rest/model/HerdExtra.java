package app.cos.rest.model;

import java.util.ArrayList;
import java.util.List;

public class HerdExtra {
	
	private long id;
	private String location;
	private float average_bcs;
	private List<CowExtra> cows = new ArrayList<CowExtra>();
	
	
	public HerdExtra() {}
	
	public HerdExtra(long id, String location,List<CowExtra> cows) {
		this.id = id;
		this.location = location;
		this.cows = cows;
		this.average_bcs = calculateAverage(cows);

	}
	
	private float calculateAverage(List<CowExtra> cows) {
		int total = 0;
		int size = 0;
		for(CowExtra cow: cows) {
			total += cow.getCc();
			size++;
		}
		if(size>0)
			return (float)total/size; 
		return 0f;
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
	public List<CowExtra> getCows() {
		return cows;
	}
	public void setCows(List<CowExtra> cows) {
		this.cows = cows;
	}
}
