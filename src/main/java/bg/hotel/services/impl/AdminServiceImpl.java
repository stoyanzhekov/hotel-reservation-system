package bg.hotel.services.impl;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import bg.hotel.entities.Room;
import bg.hotel.repositories.RoomRepository;
import bg.hotel.services.AdminService;

@Named
@Transactional(readOnly=true)
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private RoomRepository roomRepository;
	
	@Override
	@Transactional(readOnly=false)
	public void save(Room room) {
		roomRepository.saveAndFlush(room);
	}

}
