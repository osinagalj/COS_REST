package app.cos.rest.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import app.cos.rest.model.Herd;


@Entity //
@Table
public class Cow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne //The Many refers to Cow and the One to Herd
	@JoinColumn(name = "herd_id", referencedColumnName = "id" )
	private Herd herd;	

	@Column(name = "eletronic_id", nullable = false)
	private int eletronic_id;
	
	
	@Column(name = "born_date", nullable = false)
	private Date born_date;
	
	@Column(name = "last_due_date", nullable = true)
	private Date last_due_date;
	
	@Column(name = "deliveries", nullable = false)
	private int deliveries;
	
	@Column(name = "weigth", nullable = false)
	private float weigth;
	

	
	//-------------------------------------------------------------------------------------//
	//----------------------------- Getters && Setters ------------------------------------//
	//-------------------------------------------------------------------------------------//
	
	public Long getId() {
		return id;
	}

	public int getEletronic_id() {
		return eletronic_id;
	}
	public void setEletronic_id(int eletronic_id) {
		this.eletronic_id = eletronic_id;
	}
	public Date getBorn_date() {
		return born_date;
	}
	public void setBorn_date(Date born_date) {
		this.born_date = born_date;
	}
	public Date getLast_due_date() {
		return last_due_date;
	}
	public void setLast_due_date(Date last_due_date) {
		this.last_due_date = last_due_date;
	}
	public int getDeliveries() {
		return deliveries;
	}
	public void setDeliveries(int deliveries) {
		this.deliveries = deliveries;
	}
	public float getWeigth() {
		return weigth;
	}
	public void setWeigth(float weigth) {
		this.weigth = weigth;
	}
	public Herd getHerd() {
		return herd;
	}
	public void setHerd(Herd herd) {
		this.herd = herd;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((herd == null) ? 0 : herd.hashCode());		
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cow other = (Cow) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
