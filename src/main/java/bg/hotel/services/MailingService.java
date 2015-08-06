package bg.hotel.services;

public interface MailingService {

	String FROM_EMAIL = "yanica.chechkova@gmail.com";
	String SUBJECT = "Conformation";
	
	void bookingConformation(String clientEmail, String msg);
}
