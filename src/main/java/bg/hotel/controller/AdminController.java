package bg.hotel.controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
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
//@Scope("request")
@RequestScoped
public class AdminController extends BaseController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private AdminService adminService;
	private Map<RoomType, RoomType> roomTypes;

	public void saveRoom(Room room) throws SaveRoomException {
		try {
			room = adminService.saveRoom(room);
			addMessage(FacesMessage.SEVERITY_INFO, INFO_TITLE, ROOM_ADDING_SUCCESS_MSG);
		} catch (SaveRoomException e) {
			addMessage(FacesMessage.SEVERITY_WARN, WARN_TITLE, ROOM_ADDING_NOT_SUCCESS_MSG);
		}
	}

	public void savePricePeriod(PricePeriod pricePeriod) {
		try {
			adminService.savePricePeriod(pricePeriod);
			addMessage(FacesMessage.SEVERITY_INFO, INFO_TITLE, PRICE_PERIOD_ADDING_SUCCESS_MSG);
		} catch (SavePricePeriodException e) {
			addMessage(FacesMessage.SEVERITY_WARN, WARN_TITLE, PRICE_PERIOD_ADDING_NOT_SUCCESS_MSG);
		}
	} 
	
	public void deleteRoom(Room room){
		adminService.deleteRoom(room);
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
}
