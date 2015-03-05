package bg.hotel.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="extras")
public class Extras implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false)
	private Long id;

	@Column(name="bathhub")
	private Boolean bathtub;
	
	@Column(name="air_conditioning")
	private Boolean airConditioning;
	
	@Column(name="kitchen")
	private Boolean kitchen;
	
	@Column(name="laundry")
	private Boolean laundry;
	
	@Column(name="tv")
	private Boolean tv;
	
	@Column(name="terrace")
	private Boolean terrace;
	
	@OneToOne(mappedBy="extras")
	private Room room;
	
	public Extras(){}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
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
	
	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((airConditioning == null) ? 0 : airConditioning.hashCode());
		result = prime * result + ((bathtub == null) ? 0 : bathtub.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((kitchen == null) ? 0 : kitchen.hashCode());
		result = prime * result + ((laundry == null) ? 0 : laundry.hashCode());
		result = prime * result + ((room == null) ? 0 : room.hashCode());
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
		Extras other = (Extras) obj;
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
		if (room == null) {
			if (other.room != null)
				return false;
		} else if (!room.equals(other.room))
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
