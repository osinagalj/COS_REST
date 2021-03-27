package app.cos.rest.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.hibernate.annotations.Check;

@Entity //
@Table
@Check(constraints = "bcs_threshold_min < bcs_threshold_max")
public class CowAlert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "cow_id", referencedColumnName = "id" )
	private Cow cow;	

	@Min(value=1)
	@Max(value=9)
	@Column(name = "bcs_threshold_min", nullable = false)
	private int bcs_threshold_min;
	
	@Min(value=1)
	@Max(value=9)
	@Column(name = "bcs_threshold_max", nullable = false)
	private int bcs_threshold_max;
	
	
	//-------------------------------------------------------------------------------------//
	//----------------------------- Getters && Setters ------------------------------------//
	//-------------------------------------------------------------------------------------//
	
	public int getBcs_threshold_min() {
		return bcs_threshold_min;
	}



	public void setBcs_threshold_min(int bcs_threshold_min) {
		this.bcs_threshold_min = bcs_threshold_min;
	}



	public int getBcs_threshold_max() {
		return bcs_threshold_max;
	}



	public void setBcs_threshold_max(int bcs_threshold_max) {
		this.bcs_threshold_max = bcs_threshold_max;
	}



	public int getId() {
		return id;
	}


	
	public Cow getCow() {
		return cow;
	}

	public void setCow(Cow cow) {
		this.cow = cow;
	}

	
}
