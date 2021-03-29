package app.cos.rest.dto.response;

public class CowAlertDTO_response {

	private Long id;
	private int id_cow;	
	private int bcs_threshold_min;
	private int bcs_threshold_max;
	
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
}
