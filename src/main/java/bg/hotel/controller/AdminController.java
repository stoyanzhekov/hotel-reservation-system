package bg.hotel.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import bg.hotel.entities.PricePeriod;
import bg.hotel.entities.Room;
import bg.hotel.entities.RoomType;
import bg.hotel.exception.SavePricePeriodException;
import bg.hotel.exception.SaveRoomException;
import bg.hotel.services.AdminService;

@Named(value = "adminMB")
@Scope("request")
public class AdminController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String ROOM_ADDING_SUCCESS_MSG = "Room has been successfully added.";
	private static final String ROOM_ADDING_NOT_SUCCESS_MSG = "Room with such number on this floor already exist.";
	private static final String PRICE_PERIOD_ADDING_NOT_SUCCESS_MSG = "Price period for this room already exist or date to is before from.";
	private static final String PRICE_PERIOD_ADDING_SUCCESS_MSG = "Price period has been successfully added.";
	@SuppressWarnings("unused")
	private static final String EMPTY_ROOM_LIST = "There are not added any rooms.";
	private static final String INFO_TITLE = "Info";
	@SuppressWarnings("unused")
	private static final String ERROR_TITLE = "Error";
	private static final String WARN_TITLE = "Warn";

	@Inject
	private AdminService adminService;
	private Map<RoomType, RoomType> roomTypes;

	public void saveRoom(Room room) throws SaveRoomException {
		try {
			room = adminService.save(room);
			addMessage(FacesMessage.SEVERITY_INFO, INFO_TITLE, ROOM_ADDING_SUCCESS_MSG);
		} catch (SaveRoomException e) {
			addMessage(FacesMessage.SEVERITY_WARN, WARN_TITLE, ROOM_ADDING_NOT_SUCCESS_MSG);
		}
	}

	public void savePricePeriod(PricePeriod pricePeriod) {
		try {
			adminService.save(pricePeriod);
			addMessage(FacesMessage.SEVERITY_INFO, INFO_TITLE, PRICE_PERIOD_ADDING_SUCCESS_MSG);
		} catch (SavePricePeriodException e) {
			addMessage(FacesMessage.SEVERITY_WARN, WARN_TITLE, PRICE_PERIOD_ADDING_NOT_SUCCESS_MSG);
		}
	} 
	
	public void deletePricePeriod(PricePeriod pricePeriod){
		adminService.deletePricePeriod(pricePeriod);
	}

	public List<PricePeriod> getPricePeriods() {
		return adminService.fetchAllPricePeriods();
	}

	public List<Room> getRooms() {
		return adminService.fetchAllRooms();
	}

	public Map<RoomType, RoomType> getRoomTypes() {
		if (roomTypes == null) {
			roomTypes = new HashMap<>();
			for (RoomType rt : RoomType.values()) {
				roomTypes.put(rt, rt);
			}
		}
		return roomTypes;
	}

	private void addMessage(Severity severity, String summary, String details) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, summary, details));
	}
}
