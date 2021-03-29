package app.cos.rest.dto.request;

import java.util.Date;

public class CowDTO_request {


	private Long herd_id;	
	private int eletronic_id;
	private Date born_date;
	private Date last_due_date;
	private int deliveries;
	private float weigth;
	
	public Long getHerd_id() {
		return herd_id;
	}
	public void setHerd_id(Long herd_id) {
		this.herd_id = herd_id;
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
}