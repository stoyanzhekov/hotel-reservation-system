package bg.hotel.repositories.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import bg.hotel.entities.Room;
import bg.hotel.repositories.RoomRepositoryCustom;

public class RoomRepositoryImpl implements RoomRepositoryCustom{
	
	@PersistenceContext
	private EntityManager em;
	@Override
	public List<Room> findAvailableRooms() {
		System.out.println("test");
		return null;
	}

}
