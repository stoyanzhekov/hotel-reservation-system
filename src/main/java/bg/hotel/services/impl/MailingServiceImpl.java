package bg.hotel.services.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import bg.hotel.services.MailingService;

@Named(value="mailingService")
public class MailingServiceImpl implements MailingService{

	@Inject
	private MailSender mailSender;
	
	@Override
	public void bookingConformation(String clientEmail, String msg) {
    	SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setFrom(FROM_EMAIL);
		simpleMailMessage.setTo(clientEmail);
		simpleMailMessage.setSubject(SUBJECT);
		simpleMailMessage.setText(msg);
		mailSender.send(simpleMailMessage);
	}

}
