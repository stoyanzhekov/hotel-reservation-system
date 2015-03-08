package bg.hotel.entities;

import java.io.Serializable;
import java.util.List;

import javax.inject.Named;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.context.annotation.Scope;

@Entity
@Table(name="room")
@Named
@Scope("request")
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
	
	@OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="extras_id")
	private Extras extras = new Extras();
	
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
		result = prime * result + ((floor == null) ? 0 : floor.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
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
		if (floor == null) {
			if (other.floor != null)
				return false;
		} else if (!floor.equals(other.floor))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (roomType != other.roomType)
			return false;
		return true;
	}
	
}
