package xianli.assignment4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReservationGateway {
	SessionFactory factory;
	Session session;
	
	public ReservationGateway() {
		factory = new Configuration()
				  .configure("hibernate.cfg.xml")
				  .addAnnotatedClass(Reservation.class)
				  .buildSessionFactory();
		session = factory.getCurrentSession();
	}
	
	public void updateReservationRecord(int reservationId) {
		try {
			session.beginTransaction();
			Reservation oldReservation = session.get(Reservation.class, reservationId);
			oldReservation.setFilled(true);
			session.getTransaction().commit();
			System.out.println("Reservation updated successfully");
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
