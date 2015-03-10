package bg.hotel.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import bg.hotel.entities.Room;

public class ReceptionReportModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Room> rooms = new ArrayList<>();
	private List<String> days = new ArrayList<>();
	 
	public ReceptionReportModel(){}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}

	public List<String> getDays() {
		return days;
	}

	public void setDays(List<String> days) {
		this.days = days;
	}
}
