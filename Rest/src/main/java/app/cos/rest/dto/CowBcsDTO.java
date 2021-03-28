package app.cos.rest.dto;

import java.util.Date;

public class CowBcsDTO {
	
	private Long id;
	private int id_cow;
	private Date date;
	private int cc;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getId_cow() {
		return id_cow;
	}
	public void setId_cow(int id_cow) {
		this.id_cow = id_cow;
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
