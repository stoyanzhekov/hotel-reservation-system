package bg.hotel.controller;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class BaseController {
	

	public static final String INCORRECT_REPORTED_DATES_INPUT = "Date 'From' is after Date 'To'. Please correct!";
	public static final String RESERVATION_SUCCEED = "Reservation is successfully done.";
	public static final String RESERVATION_NOT_SUCCEED = "There is not available rooms for this period";
	public static final String ROOM_ADDING_SUCCESS_MSG = "Room has been successfully added.";
	public static final String ROOM_ADDING_NOT_SUCCESS_MSG = "Room with such number on this floor already exist.";
	public static final String PRICE_PERIOD_ADDING_NOT_SUCCESS_MSG = "Price period for this room already exist or date to is before from.";
	public static final String PRICE_PERIOD_ADDING_SUCCESS_MSG = "Price period has been successfully added.";
	@SuppressWarnings("unused")
	public static final String EMPTY_ROOM_LIST = "There are not added any rooms.";
	public static final String INFO_TITLE = "Info";
	@SuppressWarnings("unused")
	public static final String ERROR_TITLE = "Error";
	public static final String WARN_TITLE = "Warn";

	public void addMessage(Severity severity, String summary, String details) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, details));
	}
}
