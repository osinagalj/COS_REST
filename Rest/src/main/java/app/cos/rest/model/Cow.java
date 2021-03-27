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
@Table(name = "cow")  //se le podria poner otro nombre a la tabla de esta forma
public class Cow {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne //El Many hace referencia a Cow y el One a Herd
	@JoinColumn(name = "herd_Id", referencedColumnName = "id" )
	private Herd herd;	

	
	@Column(name = "eletronic_id", nullable = false)
	private int eletronic_id;
	
	
	@Column(name = "born_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date born_date;
	
	@Column(name = "last_due_date", nullable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date last_due_date;
	
	@Column(name = "deliveries", nullable = false)
	private int deliveries;
	
	@Column(name = "weigth", nullable = false)
	private float weigth;
	

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	
}
