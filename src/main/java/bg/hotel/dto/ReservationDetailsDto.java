package bg.hotel.dto;

import java.io.Serializable;
import java.util.Date;

import bg.hotel.entities.RoomType;

public class ReservationDetailsDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String firstName;
	private String lastName;
	
	private Integer roomCount;

	private String streetName;
	private String streetNumber;
	private Integer postCode;
	private Integer floor;
	private String entrance;
	private Integer roomNumber;

	private Boolean bathtub;
	private Boolean airConditioning;
	private Boolean kitchen;
	private Boolean laundry;
	private Boolean tv;
	private Boolean terrace;
	
	private Date checkIn;
	private Date checkOut;
	
	private RoomType roomType;
	
	public ReservationDetailsDto(){}
	
	public Integer getRoomCount() {
		return roomCount;
	}
	
	public void setRoomCount(Integer roomCount) {
		this.roomCount = roomCount;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getStreetName() {
		return streetName;
	}
	
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	public String getStreetNumber() {
		return streetNumber;
	}
	
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	
	public Integer getPostCode() {
		return postCode;
	}
	
	public void setPostCode(Integer postCode) {
		this.postCode = postCode;
	}
	
	public Integer getFloor() {
		return floor;
	}
	
	public void setFloor(Integer floor) {
		this.floor = floor;
	}
	
	public String getEntrance() {
		return entrance;
	}
	
	public void setEntrance(String entrance) {
		this.entrance = entrance;
	}
	
	public Integer getRoomNumber() {
		return roomNumber;
	}
	
	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	public Boolean getBathtub() {
		return bathtub;
	}
	
	public void setBathtub(Boolean bathtub) {
		this.bathtub = bathtub;
	}
	
	public Boolean getAirConditioning() {
		return airConditioning;
	}
	
	public void setAirConditioning(Boolean airConditioning) {
		this.airConditioning = airConditioning;
	}
	
	public Boolean getKitchen() {
		return kitchen;
	}
	
	public void setKitchen(Boolean kitchen) {
		this.kitchen = kitchen;
	}
	
	public Boolean getLaundry() {
		return laundry;
	}
	
	public void setLaundry(Boolean laundry) {
		this.laundry = laundry;
	}
	
	public Boolean getTv() {
		return tv;
	}
	
	public void setTv(Boolean tv) {
		this.tv = tv;
	}
	
	public Boolean getTerrace() {
		return terrace;
	}
	
	public void setTerrace(Boolean terrace) {
		this.terrace = terrace;
	}
	
	public Date getCheckIn() {
		return checkIn;
	}
	
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	
	public Date getCheckOut() {
		return checkOut;
	}
	
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	
	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((airConditioning == null) ? 0 : airConditioning.hashCode());
		result = prime * result + ((bathtub == null) ? 0 : bathtub.hashCode());
		result = prime * result + ((checkIn == null) ? 0 : checkIn.hashCode());
		result = prime * result
				+ ((checkOut == null) ? 0 : checkOut.hashCode());
		result = prime * result
				+ ((entrance == null) ? 0 : entrance.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((floor == null) ? 0 : floor.hashCode());
		result = prime * result + ((kitchen == null) ? 0 : kitchen.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((laundry == null) ? 0 : laundry.hashCode());
		result = prime * result
				+ ((postCode == null) ? 0 : postCode.hashCode());
		result = prime * result
				+ ((roomCount == null) ? 0 : roomCount.hashCode());
		result = prime * result
				+ ((roomNumber == null) ? 0 : roomNumber.hashCode());
		result = prime * result
				+ ((roomType == null) ? 0 : roomType.hashCode());
		result = prime * result
				+ ((streetName == null) ? 0 : streetName.hashCode());
		result = prime * result
				+ ((streetNumber == null) ? 0 : streetNumber.hashCode());
		result = prime * result + ((terrace == null) ? 0 : terrace.hashCode());
		result = prime * result + ((tv == null) ? 0 : tv.hashCode());
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
		ReservationDetailsDto other = (ReservationDetailsDto) obj;
		if (airConditioning == null) {
			if (other.airConditioning != null)
				return false;
		} else if (!airConditioning.equals(other.airConditioning))
			return false;
		if (bathtub == null) {
			if (other.bathtub != null)
				return false;
		} else if (!bathtub.equals(other.bathtub))
			return false;
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
		if (entrance == null) {
			if (other.entrance != null)
				return false;
		} else if (!entrance.equals(other.entrance))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (floor == null) {
			if (other.floor != null)
				return false;
		} else if (!floor.equals(other.floor))
			return false;
		if (kitchen == null) {
			if (other.kitchen != null)
				return false;
		} else if (!kitchen.equals(other.kitchen))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (laundry == null) {
			if (other.laundry != null)
				return false;
		} else if (!laundry.equals(other.laundry))
			return false;
		if (postCode == null) {
			if (other.postCode != null)
				return false;
		} else if (!postCode.equals(other.postCode))
			return false;
		if (roomCount == null) {
			if (other.roomCount != null)
				return false;
		} else if (!roomCount.equals(other.roomCount))
			return false;
		if (roomNumber == null) {
			if (other.roomNumber != null)
				return false;
		} else if (!roomNumber.equals(other.roomNumber))
			return false;
		if (roomType != other.roomType)
			return false;
		if (streetName == null) {
			if (other.streetName != null)
				return false;
		} else if (!streetName.equals(other.streetName))
			return false;
		if (streetNumber == null) {
			if (other.streetNumber != null)
				return false;
		} else if (!streetNumber.equals(other.streetNumber))
			return false;
		if (terrace == null) {
			if (other.terrace != null)
				return false;
		} else if (!terrace.equals(other.terrace))
			return false;
		if (tv == null) {
			if (other.tv != null)
				return false;
		} else if (!tv.equals(other.tv))
			return false;
		return true;
	}
}
