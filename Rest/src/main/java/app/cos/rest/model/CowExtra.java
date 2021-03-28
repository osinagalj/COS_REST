package app.cos.rest.model;

import java.util.Date;

public class CowExtra {

	private long id;
	private long eletronic_id;
	private Date born_date;
	private Date last_due_date = null;
	private int deliveries;
	private Float weigth;
	private long id_herd;	
	private Date bcs_date = null;
	private float cc;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getEletronic_id() {
		return eletronic_id;
	}
	public void setEletronic_id(long eletronic_id) {
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
	public Float getWeigth() {
		return weigth;
	}
	public void setWeigth(Float weigth) {
		this.weigth = weigth;
	}
	public long getId_herd() {
		return id_herd;
	}
	public void setId_herd(long id_herd) {
		this.id_herd = id_herd;
	}
	public Date getBcs_date() {
		return bcs_date;
	}
	public void setBcs_date(Date bcs_date) {
		this.bcs_date = bcs_date;
	}
	public float getCc() {
		return cc;
	}
	public void setCc(float cc) {
		this.cc = cc;
	}

	
}
