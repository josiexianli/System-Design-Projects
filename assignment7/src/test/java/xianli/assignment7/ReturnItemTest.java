package xianli.assignment7;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

import java.util.List;

public class ReturnItemTest {

	@Test
	public void testReturnItem() {
		ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");
		TransactionScript script = (TransactionScript) context.getBean("transactionBean");
		boolean result = script.returnItem("textbook", 1);
		//make sure item is returned
		assertTrue(result);
		
		//make sure reservation is updated
		ReservationFinder reservationFinder = (ReservationFinder) context.getBean("reservationFinderBean");
		List<ReservationDAO> reservations = reservationFinder.findReservation(1, 1);
		assertEquals(reservations.get(0).getActorId(), 1); 
		assertEquals(reservations.get(0).getItemId(), 1); 
		assertEquals(reservations.get(0).isFilled(), true); 
	}
}
