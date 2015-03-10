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
import bg.hotel.util.DateUtils;

@Named(value="adminService")
@Transactional(value=TxType.SUPPORTS)
public class AdminServiceImpl implements AdminService{
	
	@Inject
	private RoomRepository roomRepository;
	
	@Inject
	private PricePeriodRepository pricePeriodRepository;
	
	@Override
	@Transactional(value=TxType.REQUIRED)
	public Room saveRoom(Room room) throws SaveRoomException {
		List<Room> rooms = roomRepository.findByNumber(room.getNumber());
		if(rooms.size() > 0){
			throw new SaveRoomException();
		}
		return roomRepository.save(room);
	}

	@Override
	public List<Room> fetchAllRooms() {
		return roomRepository.findAll();
	}

	@Override
	public Room findRoomById(Long id) {
		return roomRepository.findById(id);
	}
	
	@Override
	public void deleteRoom(Room room){
		roomRepository.delete(room);
	}
	
	@Override
	public List<PricePeriod> fetchAllPricePeriods(){
		return pricePeriodRepository.findAll();
	}
	
	@Override
	@Transactional(value=TxType.REQUIRED)
	public PricePeriod savePricePeriod(PricePeriod pricePeriod) throws SavePricePeriodException{
		
		if(!DateUtils.isPeriodValid(pricePeriod.getFrom(), pricePeriod.getTo())){
			throw new SavePricePeriodException();
		}
		List<PricePeriod> allPricePeriods = pricePeriodRepository.findAllByRoomNumber(pricePeriod.getRoom().getNumber());
		//TODO: INCORRECT CONDITION
		long count = allPricePeriods.stream().filter(p->{
			if((pricePeriod.getFrom().after(p.getFrom()) && pricePeriod.getFrom().before(p.getTo())) ||
					(pricePeriod.getFrom().equals(p.getFrom()) || pricePeriod.getFrom().equals(p.getTo())) ||
					(pricePeriod.getTo().equals(p.getFrom()) || pricePeriod.getTo().equals(p.getTo())) ||
					(pricePeriod.getTo().after(p.getFrom()) || pricePeriod.getFrom().before(p.getTo()))
					){
				return false;
			}
			
			return false;
		}).count();
		if(count > 0){
			throw new SavePricePeriodException();
		}
		return pricePeriodRepository.save(pricePeriod);
	}

	@Override
	@Transactional(value=TxType.REQUIRED)
	public void deletePricePeriod(PricePeriod pricePeriod) {
		pricePeriodRepository.delete(pricePeriod.getId());
	}

}
