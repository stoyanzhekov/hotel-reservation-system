package bg.hotel.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservation_details")
public class ReservationDetails implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(nullable=false, name = "room_id")
	private Room room;
	
	@ManyToOne
	@JoinColumn(nullable=false, name = "reservation_id")
	private Reservation reservation;
	
	@Column(name="check_in", nullable=false)
	private LocalDate checkIn;
	
	@Column(name="check_out", nullable=false)
	private LocalDate checkOut;
	
	@Column(name="is_canceled")
	private Boolean isCanceled;
	
	public ReservationDetails(){}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public Boolean getIsCanceled() {
		return isCanceled;
	}

	public void setIsCanceled(Boolean isCanceled) {
		this.isCanceled = isCanceled;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((checkIn == null) ? 0 : checkIn.hashCode());
		result = prime * result
				+ ((checkOut == null) ? 0 : checkOut.hashCode());
		result = prime * result
				+ ((isCanceled == null) ? 0 : isCanceled.hashCode());
		result = prime * result
				+ ((reservation == null) ? 0 : reservation.hashCode());
		result = prime * result + ((room == null) ? 0 : room.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ReservationDetails other = (ReservationDetails) obj;
		if (checkIn == null) {
			if (other.checkIn != null)
				return false;
		} else if (!checkIn.equals(other.checkIn))
			return false;
		if (checkOut == null) {
			if (other.checkOut != null)
				return false;
		} else if (!checkOut.equals(other.checkOut))
			return false;
		if (isCanceled == null) {
			if (other.isCanceled != null)
				return false;
		} else if (!isCanceled.equals(other.isCanceled))
			return false;
		if (reservation == null) {
			if (other.reservation != null)
				return false;
		} else if (!reservation.equals(other.reservation))
			return false;
		if (room == null) {
			if (other.room != null)
				return false;
		} else if (!room.equals(other.room))
			return false;
		return true;
	}

}