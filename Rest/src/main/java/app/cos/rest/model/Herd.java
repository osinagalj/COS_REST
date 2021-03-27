package app.cos.rest.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;

@Entity //
@Table
public class Herd {
	
	@Id
	@Min(value = 1)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "location", nullable = false)
	private String location;
	
	//The list of cows is implemented on the cow side with the ManyToOne
	
	public long getId() {
		return id;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}


}
