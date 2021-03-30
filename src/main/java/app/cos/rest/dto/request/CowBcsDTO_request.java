package app.cos.rest.dto.request;



public class CowBcsDTO_request {
	
	private Long cow_id;
	private int cc;

	//-------------------------------------------------------------------------------------//
	//----------------------------- Getters && Setters ------------------------------------//
	//-------------------------------------------------------------------------------------//
	
	public Long getCow_id() {
		return cow_id;
	}

	public void setCow_id(Long cow_id) {
		this.cow_id = cow_id;
	}

	public int getCc() {
		return cc;
	}

	public void setCc(int cc) {
		this.cc = cc;
	}
	
}
