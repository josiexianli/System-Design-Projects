package xianli.assignment4;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReservationFinder {
	SessionFactory factory;
	Session session;
	
	public ReservationFinder() {
		factory = new Configuration()
				  .configure("hibernate.cfg.xml")
				  .addAnnotatedClass(Reservation.class)
				  .buildSessionFactory();
		session = factory.getCurrentSession();
	}
	
	public List<Reservation> findReservation(int itemId, int actorId) {
		try {
			session.beginTransaction();
			
			List<Reservation> reservations = session.createQuery("from Reservation r where r.itemId = :itemId and r.actorId = :actorId").setParameter("itemId", itemId).setParameter("actorId", actorId).getResultList();
			
			session.getTransaction().commit();
			return reservations;
		}
		finally {
			session.close();
			factory.close();
		}
	}
	
	List<Reservation> findAllReservations() {
		try {
			session.beginTransaction();
			
			List<Reservation> reservations = session.createQuery("from Reservation").getResultList();
			
			session.getTransaction().commit();
			return reservations;
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
