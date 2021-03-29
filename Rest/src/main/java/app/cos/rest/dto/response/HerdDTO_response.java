package app.cos.rest.dto.response;

import java.util.Collections;
import java.util.List;

public class HerdDTO_response {

	private Long id;
	private String location;
	private List<CowDTO_response> cows;
	
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
	public List<CowDTO_response> getCows() {
		return Collections.unmodifiableList(cows);
	}
	public void setCows(List<CowDTO_response> cows) {
		this.cows = cows;
	}

	
}
