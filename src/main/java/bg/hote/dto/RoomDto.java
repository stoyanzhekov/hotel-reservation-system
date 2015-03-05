package bg.hote.dto;

import java.io.Serializable;

public class RoomDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//basic props
	private Integer floor;
	private Integer number;

	//extras
	private Boolean bathtub;
	private Boolean airConditioning;
	private Boolean kitchen;
	private Boolean laundry;
	private Boolean tv;
	private Boolean terrace;
	
	public RoomDto(){}

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
	public String toString() {
		return "RoomDto [floor=" + floor + ", number=" + number + ", bathtub="
				+ bathtub + ", airConditioning=" + airConditioning
				+ ", kitchen=" + kitchen + ", laundry=" + laundry + ", tv="
				+ tv + ", terrace=" + terrace + "]";
	}
	
}
