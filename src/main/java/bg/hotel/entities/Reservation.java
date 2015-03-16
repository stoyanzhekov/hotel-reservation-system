package bg.hotel.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.inject.Named;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="reservation")
@Named
public class Reservation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", nullable=false)
	private Long id;
	
	@OneToMany(mappedBy="reservation", cascade=CascadeType.ALL)
	private List<ReservationDetails> reservationDetails;
	
	@Column(name="created_at")
	private Date createdAt;
	
	@OneToOne(mappedBy="reservetion")
	private Payment payment;
	
	@ManyToOne(cascade={CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(nullable=false, name = "customer_id")
	private Customer customer;
	
	public Reservation(){}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<ReservationDetails> getReservationDetails() {
		return reservationDetails;
	}

	public void setReservationDetails(List<ReservationDetails> reservationDetails) {
		this.reservationDetails = reservationDetails;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result
				+ ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((payment == null) ? 0 : payment.hashCode());
		result = prime
				* result
				+ ((reservationDetails == null) ? 0 : reservationDetails
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
		Reservation other = (Reservation) obj;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (payment == null) {
			if (other.payment != null)
				return false;
		} else if (!payment.equals(other.payment))
			return false;
		if (reservationDetails == null) {
			if (other.reservationDetails != null)
				return false;
		} else if (!reservationDetails.equals(other.reservationDetails))
			return false;
		return true;
	}
}
