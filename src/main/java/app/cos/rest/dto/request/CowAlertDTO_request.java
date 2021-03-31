package app.cos.rest.dto.request;

public class CowAlertDTO_request {

	private Long cow_id;	
	private int bcs_threshold_min;
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
	public Long getCow_id() {
		return cow_id;
	}

	public void setCow_id(Long cow_id) {
		this.cow_id = cow_id;
	}




}
