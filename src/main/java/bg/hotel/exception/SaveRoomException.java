package bg.hotel.exception;

public class SaveRoomException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public SaveRoomException(){
		super("Such a room already exist !!!");
	}

}
