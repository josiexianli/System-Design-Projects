package xianli.assignment4;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ItemFinder {
	SessionFactory factory;
	Session session;
	
	public ItemFinder() {
		factory = new Configuration()
				  .configure("hibernate.cfg.xml")
				  .addAnnotatedClass(Item.class)
				  .buildSessionFactory();
		session = factory.getCurrentSession();
	}
	
	List<Item> findAllItems() {
		try {
			session.beginTransaction();
			
			List<Item> items = session.createQuery("from Item").getResultList();
			
			session.getTransaction().commit();
			return items;
		}
		finally {
			session.close();
			factory.close();
		}
	}
	
	public List<Item> findItem(String itemName, int actorId) {
		try {
			session.beginTransaction();
			
			List<Item> items = session.createQuery("from Item i where i.itemName = :itemName and i.actorId = :actorId").setParameter("itemName", itemName).setParameter("actorId", actorId).getResultList();
			
			session.getTransaction().commit();
			return items;
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
