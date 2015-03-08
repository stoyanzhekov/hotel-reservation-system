package bg.hotel.services.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;


import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import bg.hotel.entities.PricePeriod;
import bg.hotel.entities.Room;
import bg.hotel.exception.SavePricePeriodException;
import bg.hotel.exception.SaveRoomException;
import bg.hotel.repositories.PricePeriodRepository;
import bg.hotel.repositories.RoomRepository;
import bg.hotel.services.AdminService;

@Named(value="adminService")
@Transactional(value=TxType.SUPPORTS)
public class AdminServiceImpl implements AdminService{
	
	@Inject
	private RoomRepository roomRepository;
	
	@Inject
	private PricePeriodRepository pricePeriodRepository;
	
	@Override
	@Transactional(value=TxType.REQUIRED)
	public Room save(Room room) throws SaveRoomException {
		List<Room> persons = roomRepository.findByNumber(room.getNumber());
		if(persons.size() > 0){
			throw new SaveRoomException();
		}
		return roomRepository.saveAndFlush(room);
	}

	@Override
	public List<Room> fetchAllRooms() {
		return roomRepository.findAll();
	}

	@Override
	public Room findById(Long id) {
		return roomRepository.findById(id);
	}
	
	@Override
	public List<PricePeriod> fetchAllPricePeriods(){
		return pricePeriodRepository.findAll();
	}
	
	@Override
	public PricePeriod save(PricePeriod pricePeriod) throws SavePricePeriodException{
		if(pricePeriod.getTo().before(pricePeriod.getFrom()) || 
				pricePeriodRepository.findByFromAndTo(pricePeriod.getFrom(), pricePeriod.getTo()).size() > 0){
			throw new SavePricePeriodException();
			
		}
		return pricePeriodRepository.saveAndFlush(pricePeriod);
	}

}
