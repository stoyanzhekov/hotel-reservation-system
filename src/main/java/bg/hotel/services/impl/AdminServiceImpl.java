package bg.hotel.services.impl;

import bg.hotel.entities.PricePeriod;
import bg.hotel.entities.Room;
import bg.hotel.exception.SavePricePeriodException;
import bg.hotel.exception.SaveRoomException;
import bg.hotel.repositories.PricePeriodRepository;
import bg.hotel.repositories.RoomRepository;
import bg.hotel.services.AdminService;
import bg.hotel.util.DateUtils;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.joda.time.Interval;

import java.util.List;

@Named(value="adminService")
@Transactional(value=TxType.SUPPORTS)
public class AdminServiceImpl implements AdminService{
	
	@Inject
	private RoomRepository roomRepository;
	
	@Inject
	private PricePeriodRepository pricePeriodRepository;
	
	@Override
	@Transactional(value=TxType.REQUIRED, rollbackOn={Exception.class})
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
	@Transactional(rollbackOn=Exception.class,  value=TxType.REQUIRED)
	public void deleteRoom(Room room){
		roomRepository.delete(room);
	}
	
	@Override
	public List<PricePeriod> fetchAllPricePeriods(){
		return pricePeriodRepository.findAll();
	}
	
	@Override
	@Transactional(rollbackOn={SavePricePeriodException.class, Exception.class},  value=TxType.REQUIRED)
	public PricePeriod savePricePeriod(PricePeriod pricePeriod) throws SavePricePeriodException{
		
		if(!DateUtils.isPeriodValid(pricePeriod.getFrom(), pricePeriod.getTo())){
			throw new SavePricePeriodException();
		}
        List<PricePeriod> pricePeriods = pricePeriodRepository.checkPricePeriod(pricePeriod.getRoom().getNumber());
        Interval new_, existing;
        for(PricePeriod p : pricePeriods){
        	new_ = new Interval(pricePeriod.getFrom().getTime(), pricePeriod.getTo().getTime());
        	existing = new Interval(p.getFrom().getTime(), p.getTo().getTime());
        	boolean overlap = new_.overlaps(existing);
        	boolean abuts = new_.abuts(existing);
        	if(overlap || abuts){
        		throw new SavePricePeriodException();
        	}
        }
		return pricePeriodRepository.save(pricePeriod);
	}

	@Override
	@Transactional(value=TxType.REQUIRED, rollbackOn={Exception.class})
	public void deletePricePeriod(PricePeriod pricePeriod) {
		pricePeriodRepository.delete(pricePeriod.getId());
	}

}
