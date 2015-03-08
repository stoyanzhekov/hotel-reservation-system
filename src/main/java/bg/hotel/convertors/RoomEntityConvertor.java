package bg.hotel.convertors;

import bg.hotel.dto.RoomDto;
import bg.hotel.entities.Extras;
import bg.hotel.entities.Room;

public class RoomEntityConvertor {

	
	private RoomEntityConvertor(){}
	
	public static Room roomConvertor(RoomDto roomDto){
		Room room = new Room();
		room.setId(roomDto.getId());
		room.setNumber(roomDto.getNumber());
		room.setFloor(roomDto.getFloor());
		if((roomDto.getAirConditioning() != null && roomDto.getAirConditioning()) || 
				(roomDto.getBathtub() != null && roomDto.getBathtub()) || 
				(roomDto.getKitchen() != null && roomDto.getKitchen()) || 
				(roomDto.getLaundry() != null && roomDto.getLaundry()) || 
				(roomDto.getTerrace() != null && roomDto.getTerrace()) || 
				(roomDto.getTv() != null && roomDto.getTv())
				){
			Extras ext = new Extras();
			if(roomDto.getAirConditioning() != null && roomDto.getAirConditioning()) ext.setAirConditioning(roomDto.getAirConditioning());
			if(roomDto.getBathtub() != null && roomDto.getBathtub()) ext.setBathtub(roomDto.getBathtub());
			if(roomDto.getKitchen() != null && roomDto.getKitchen()) ext.setKitchen(roomDto.getKitchen());
			if(roomDto.getTerrace() != null && roomDto.getTerrace()) ext.setTerrace(roomDto.getTerrace());
			if(roomDto.getLaundry() != null && roomDto.getLaundry()) ext.setLaundry(roomDto.getLaundry());
			if(roomDto.getTv() != null && roomDto.getTv()) ext.setTv(roomDto.getTv());
			ext.setRoom(room);
			room.setExtras(ext);
		}
		room.setRoomType(roomDto.getRoomType());
		
		return room;
	}
}
