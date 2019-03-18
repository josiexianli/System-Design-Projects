package xianli.assignment4;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reservations")
public class Reservation {
	@Id
	@Column(name="reservation_Id")
	private int reservationId;
	
	@Column(name="actorId")
	private int actorId;
	
	@Column(name="itemId")
	private int itemId;
	
	@Column(name="isFilled")
	private boolean isFilled;
	
	public Reservation() {}
	
	public Reservation(int actorId, int itemId, boolean isFilled) {
		super();
		this.actorId = actorId;
		this.itemId = itemId;
		this.isFilled = isFilled;
	}

	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", actorId=" + actorId + ", itemId=" + itemId
				+ ", isFilled=" + isFilled + "]";
	}

	public int getReservationId() {
		return reservationId;
	}

	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public boolean isFilled() {
		return isFilled;
	}

	public void setFilled(boolean isFilled) {
		this.isFilled = isFilled;
	}
}
