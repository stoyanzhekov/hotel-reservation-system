package bg.hotel.entities;

import java.io.Serializable;

public class Extras implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Boolean bathtub;
	private Boolean airConditioning;
	private Boolean kitchen;
	private Boolean laundry;
	private Boolean tv;
	private Boolean terrace;
	
	public Extras(){}

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
		result = prime * result + ((kitchen == null) ? 0 : kitchen.hashCode());
		result = prime * result + ((laundry == null) ? 0 : laundry.hashCode());
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
