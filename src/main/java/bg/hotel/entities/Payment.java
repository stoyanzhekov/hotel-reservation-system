package bg.hotel.entities;

import java.io.Serializable;
import java.math.BigDecimal;

public class Payment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private BigDecimal amount;
	private Reservation reservetion;
	
	public Payment(){}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Reservation getReservetion() {
		return reservetion;
	}

	public void setReservetion(Reservation reservetion) {
		this.reservetion = reservetion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result
				+ ((reservetion == null) ? 0 : reservetion.hashCode());
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
		Payment other = (Payment) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (reservetion == null) {
			if (other.reservetion != null)
				return false;
		} else if (!reservetion.equals(other.reservetion))
			return false;
		return true;
	}
	
}
