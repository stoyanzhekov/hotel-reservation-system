package bg.hotel.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import bg.hotel.entities.RoomType;

public class RoomDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//basic props
	private Long id;
	private Integer floor;
	private Integer number;

	//extras
	private Boolean bathtub;
	private Boolean airConditioning;
	private Boolean kitchen;
	private Boolean laundry;
	private Boolean tv;
	private Boolean terrace;
	private RoomType roomType;
	private Map<RoomType, RoomType> roomTypes;
	
	public RoomDto(){
		roomTypes = new HashMap<>();
		 for (RoomType rt : RoomType.values()) {
			 roomTypes.put(rt, rt);
		 }
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Map<RoomType, RoomType> getRoomTypes() {
		return roomTypes;
	}
	
	public void setRoomTypes(Map<RoomType, RoomType> roomTypes) {
		this.roomTypes = roomTypes;
	}

	public RoomType getRoomType() {
		return roomType;
	}
	
	public void setRoomType(RoomType roomType) {
		this.roomType = roomType;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((airConditioning == null) ? 0 : airConditioning.hashCode());
		result = prime * result + ((bathtub == null) ? 0 : bathtub.hashCode());
		result = prime * result + ((floor == null) ? 0 : floor.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((kitchen == null) ? 0 : kitchen.hashCode());
		result = prime * result + ((laundry == null) ? 0 : laundry.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result
				+ ((roomType == null) ? 0 : roomType.hashCode());
		result = prime * result
				+ ((roomTypes == null) ? 0 : roomTypes.hashCode());
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
		RoomDto other = (RoomDto) obj;
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
		if (floor == null) {
			if (other.floor != null)
				return false;
		} else if (!floor.equals(other.floor))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (kitchen == null) {
			if (other.kitchen != null)
				return false;
		} else if (!kitchen.equals(other.kitchen))
			return false;
		if (laundry == null) {
			if (other.laundry != null)
				return false;
		} else if (!laundry.equals(other.laundry))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (roomType != other.roomType)
			return false;
		if (roomTypes == null) {
			if (other.roomTypes != null)
				return false;
		} else if (!roomTypes.equals(other.roomTypes))
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

	@Override
	public String toString() {
		return "RoomDto [floor=" + floor + ", number=" + number + ", bathtub="
				+ bathtub + ", airConditioning=" + airConditioning
				+ ", kitchen=" + kitchen + ", laundry=" + laundry + ", tv="
				+ tv + ", terrace=" + terrace + "]";
	}
	
}
