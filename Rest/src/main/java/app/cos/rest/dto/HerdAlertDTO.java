package app.cos.rest.dto;

public class HerdAlertDTO {

	private Long id;
	private Long id_herd;	
	private int bcs_threshold_min;
	private int bcs_threshold_max;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getId_herd() {
		return id_herd;
	}
	public void setId_herd(Long id_herd) {
		this.id_herd = id_herd;
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
