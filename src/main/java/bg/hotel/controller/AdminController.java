package bg.hotel.controller;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import bg.hote.dto.RoomDto;

@Scope
@Named(value="adminMB")
public class AdminController {

	private RoomDto room = new RoomDto();
	
	public void saveRoom() {
		System.out.println(room);
	}

	public RoomDto getRoom() {
		return room;
	}

	public void setRoom(RoomDto room) {
		this.room = room;
	}
	
}
