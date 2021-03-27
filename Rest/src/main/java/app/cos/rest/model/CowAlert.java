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

@Entity //
@Table(name = "cowAlert")  //se le podria poner otro nombre a la tabla de esta forma
public class CowAlert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "animal_Id", referencedColumnName = "id" )
	private Cow cow;	


	@Min(value=1)
	@Max(value=9)
	@Column(name = "bcs_threshold", nullable = false)
	private int bcs_threshold;
	
	public int getId() {
		return id;
	}

	public int getBcs_threshold() {
		return bcs_threshold;
	}
	
	public void setBcs_threshold(int bcs_threshold) {
		this.bcs_threshold = bcs_threshold;
	}
	
	public Cow getCow() {
		return cow;
	}

	public void setCow(Cow cow) {
		this.cow = cow;
	}

	
}
