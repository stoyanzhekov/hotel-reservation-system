package bg.hotel.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="room")
public class Room implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false)
	private Long id;
	
	@Column(name="floor", nullable=false)
	private Integer floor;
	
	@Column(name="number", nullable=false)
	private Integer number;
	
	@ManyToOne
	@JoinColumn(nullable=false, name = "hotel_id")
	private Hotel hotel;
	
	@OneToOne
    @JoinColumn(name="extras_id", nullable=false)
	private Extras extras;
	
	@OneToMany(mappedBy="room")
	private List<ReservationDetails> reservationDetails;
	
	@OneToMany(mappedBy="room")
	private List<PricePeriod> pricePeriods;
	
	@Enumerated(EnumType.STRING)
	private RoomType roomType;
	
	public Room(){}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Integer getFloor() {
		return floor;
	}

	public void setFloor(Integer floor) {
		this.floor = floor;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Extras getExtras() {
		return extras;
	}

	public void setExtras(Extras extras) {
		this.extras = extras;
	}

	public List<PricePeriod> getPricePeriods() {
		return pricePeriods;
	}

	public void setPricePeriods(List<PricePeriod> pricePeriods) {
		this.pricePeriods = pricePeriods;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	public List<ReservationDetails> getReservationDetail() {
		return reservationDetails;
	}

	public void setReservationDetail(List<ReservationDetails> reservationDetails) {
		this.reservationDetails = reservationDetails;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((extras == null) ? 0 : extras.hashCode());
		result = prime * result + ((floor == null) ? 0 : floor.hashCode());
		result = prime * result + ((hotel == null) ? 0 : hotel.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result
				+ ((pricePeriods == null) ? 0 : pricePeriods.hashCode());
		result = prime
				* result
				+ ((reservationDetails == null) ? 0 : reservationDetails
						.hashCode());
		result = prime * result
				+ ((roomType == null) ? 0 : roomType.hashCode());
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
		Room other = (Room) obj;
		if (extras == null) {
			if (other.extras != null)
				return false;
		} else if (!extras.equals(other.extras))
			return false;
		if (floor == null) {
			if (other.floor != null)
				return false;
		} else if (!floor.equals(other.floor))
			return false;
		if (hotel == null) {
			if (other.hotel != null)
				return false;
		} else if (!hotel.equals(other.hotel))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (pricePeriods == null) {
			if (other.pricePeriods != null)
				return false;
		} else if (!pricePeriods.equals(other.pricePeriods))
			return false;
		if (reservationDetails == null) {
			if (other.reservationDetails != null)
				return false;
		} else if (!reservationDetails.equals(other.reservationDetails))
			return false;
		if (roomType != other.roomType)
			return false;
		return true;
	}
	
}
