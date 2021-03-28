package app.cos.rest.dto;

import java.util.Collections;
import java.util.List;

public class HerdDTO {

	private Long id;
	private String location;
	private List<CowDTO> cows;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public List<CowDTO> getCows() {
		return Collections.unmodifiableList(cows);
	}
	public void setCows(List<CowDTO> cows) {
		this.cows = cows;
	}

	
}
