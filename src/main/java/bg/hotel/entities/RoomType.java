package bg.hotel.entities;

public enum RoomType {

	SINGLE("Single"),
	DOUBLE("Double"),
	APP("APP");
	
	private String label;
	
	RoomType(String label){
		this.label = label;
	}
	
	public String getLabel(){
		return label;
	}
}
