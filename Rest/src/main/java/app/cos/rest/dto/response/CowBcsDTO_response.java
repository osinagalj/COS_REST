package app.cos.rest.dto.response;

import java.util.Date;

public class CowBcsDTO_response {
	
	private Long id;
	private Long cow_id;
	private Date date;
	private int cc;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public Long getCow_id() {
		return cow_id;
	}
	public void setCow_id(Long cow_id) {
		this.cow_id = cow_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
}
