package bg.hotel.services.impl;

import bg.hotel.entities.ReservationDetails;
import bg.hotel.entities.Room;
import bg.hotel.repositories.RoomRepository;
import bg.hotel.services.ReceptionService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

@Named(value="receptionService")
@Transactional(value=TxType.SUPPORTS)
public class ReceptionServiceImpl implements ReceptionService{

    @Inject
    private RoomRepository roomRepository;

    @Override
    public List<Room> fetchAllRooms() {
        return getDummyData();
        //return roomRepository.findAll();
    }

    public List<Room> getDummyData() {
        List<Room> roomList = new ArrayList<>();
        for (int i = 1; i < 9; i++) {
            roomList.add(getRoom(i));
        }
        return roomList;
    }

    public Room getRoom(int roomNumber) {
        Room room = new Room();
        room.setNumber(roomNumber);
        room.setReservationDetail(getReservationDetails());
        return room;
    }

    public List<ReservationDetails> getReservationDetails() {
        List<ReservationDetails> reservationDetails = new ArrayList<>();

        ReservationDetails rd = new ReservationDetails();

        Calendar calFrom = Calendar.getInstance();
        Random randomGenerator = new Random();
        Integer numberFrom = randomGenerator.nextInt(29);
        Integer numberTo = randomGenerator.nextInt(29);
        if (numberFrom > numberTo) {
            Integer random;
            random = numberFrom;
            numberFrom = numberTo;
            numberTo = random;
        }
        calFrom.add(Calendar.DATE, numberFrom);

        Calendar calTo = Calendar.getInstance();
        calTo.add(Calendar.DATE, numberTo);

        rd.setCheckIn(calFrom.getTime());
        rd.setCheckOut(calTo.getTime());

        reservationDetails.add(rd);

        return reservationDetails;
    }
}
