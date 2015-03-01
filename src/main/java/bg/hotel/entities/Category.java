package bg.hotel.entities;

public enum Category {
	ONE_STAR("*"),
	TWO_STAR("**"),
	THREE_STAR("***"),
	FOUR_STAR("****"),
	FIVE_STAR("*****");
	
	String category;
	
	Category(String category){
		this.category = category;
	}
	
	public String getCategory(){
		return category;
	}
}
