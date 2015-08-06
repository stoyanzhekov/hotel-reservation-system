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
	private String email;
	
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
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

}
