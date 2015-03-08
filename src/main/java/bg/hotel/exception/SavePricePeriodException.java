package bg.hotel.exception;

public class SavePricePeriodException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SavePricePeriodException(){
		super("Such a price period for this room exist already exist !!!");
	}

}
