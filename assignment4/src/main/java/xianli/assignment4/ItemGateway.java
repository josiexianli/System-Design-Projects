package xianli.assignment4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//not necessary for this assignment since we are not updating Item records, only fetching
public class ItemGateway {
	SessionFactory factory;
	Session session;
	
	public ItemGateway() {
		factory = new Configuration()
				  .configure("hibernate.cfg.xml")
				  .addAnnotatedClass(Item.class)
				  .buildSessionFactory();
		session = factory.getCurrentSession();
	}
}
