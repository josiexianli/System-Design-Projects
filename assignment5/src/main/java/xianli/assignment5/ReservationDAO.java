package xianli.assignment5;


public class ReservationDAO {
	private int reservationId;
	
	private int actorId;
	
	private int itemId;
	
	private boolean isFilled;
	
	public ReservationDAO() {}
	
	public ReservationDAO(int actorId, int itemId, boolean isFilled) {
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
