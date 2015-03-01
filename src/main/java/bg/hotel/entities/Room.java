package bg.hotel.entities;

import java.io.Serializable;
import java.util.List;

public class Room implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer floor;
	private Integer number;
	private Hotel hotel;
	private Extras extras;
	private ReservationDetails reservationDetail;
	private List<PricePeriod> pricePeriods;
	
	public Room(){}

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

	public ReservationDetails getReservationDetail() {
		return reservationDetail;
	}

	public void setReservationDetail(ReservationDetails reservationDetail) {
		this.reservationDetail = reservationDetail;
	}

	public List<PricePeriod> getPricePeriods() {
		return pricePeriods;
	}

	public void setPricePeriods(List<PricePeriod> pricePeriods) {
		this.pricePeriods = pricePeriods;
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
				+ ((reservationDetail == null) ? 0 : reservationDetail
						.hashCode());
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
		if (reservationDetail == null) {
			if (other.reservationDetail != null)
				return false;
		} else if (!reservationDetail.equals(other.reservationDetail))
			return false;
		return true;
	}
	
}
