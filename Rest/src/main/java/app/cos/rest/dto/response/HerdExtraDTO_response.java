package app.cos.rest.dto.response;

import java.util.ArrayList;
import java.util.List;

public class HerdExtraDTO_response {
	
	private long id;
	private String location;
	private float average_bcs;
	private List<CowExtraDTO_response> cows = new ArrayList<CowExtraDTO_response>();
	
	private int cow_amount = 0;
	private int total_bcs = 0;
	
	public HerdExtraDTO_response() {}
	
	public HerdExtraDTO_response(long id, String location) {
		this.id = id;
		this.location = location;
		this.average_bcs = 0f; 
	}
	
	public void addCow(CowExtraDTO_response cow) {
		cows.add(cow);
		this.cow_amount ++;
		this.total_bcs += cow.getCc();
		this.average_bcs = total_bcs/cow_amount;
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
	public List<CowExtraDTO_response> getCows() {
		return cows;
	}
	public void setCows(List<CowExtraDTO_response> cows) {
		this.cows = cows;
	}
}
