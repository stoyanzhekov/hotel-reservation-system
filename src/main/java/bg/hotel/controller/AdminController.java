package bg.hotel.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import bg.hote.convertors.RoomEntityConvertor;
import bg.hote.dto.RoomDto;
import bg.hotel.services.AdminService;

@Scope
@Named(value="adminMB")
public class AdminController {

	@Inject
	private AdminService adminService;
	
	private RoomDto roomDto = new RoomDto();
	
	public void saveRoom() {
		adminService.save(RoomEntityConvertor.roomConvertor(roomDto));
	}

	public RoomDto getRoomDto() {
		return roomDto;
	}

	public void setRoomDto(RoomDto roomDto) {
		this.roomDto = roomDto;
	}
	
	private void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
