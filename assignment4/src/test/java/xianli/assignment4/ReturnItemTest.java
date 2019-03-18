package xianli.assignment4;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;

public class ReturnItemTest {

	@Test
	public void testReturnItem() {
		TransactionScript script = new TransactionScript();
		boolean result = script.returnItem("textbook", 1);
		//make sure item is returned
		assertTrue(result);
		
		//make sure reservation is updated
		ReservationFinder reservationFinder = new ReservationFinder();
		List<Reservation> reservations = reservationFinder.findReservation(1, 1);
		assertEquals(reservations.get(0).getActorId(), 1); 
		assertEquals(reservations.get(0).getItemId(), 1); 
		assertEquals(reservations.get(0).isFilled(), true); 
	}
}
