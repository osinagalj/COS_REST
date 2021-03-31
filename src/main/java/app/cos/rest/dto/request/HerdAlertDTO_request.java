package app.cos.rest.dto.request;

public class HerdAlertDTO_request {


	private Long herd_id;	
	private int bcs_threshold_min;
	private int bcs_threshold_max;
	
	//-------------------------------------------------------------------------------//
	//------------------------------ Getters && Setters -----------------------------//
	//-------------------------------------------------------------------------------//


	public Long getHerd_id() {
		return herd_id;
	}

	public void setHerd_id(Long herd_id) {
		this.herd_id = herd_id;
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
