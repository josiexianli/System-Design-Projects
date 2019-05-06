package xianli.assignment4;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AccountFinder {
	SessionFactory factory;
	Session session;
	
	public AccountFinder() {
		factory = new Configuration()
				  .configure("hibernate.cfg.xml")
				  .addAnnotatedClass(Account.class)
				  .buildSessionFactory();
		session = factory.getCurrentSession();
	}
	
	List<Account> findAllAccounts() {
		try {
			session.beginTransaction();
			
			List<Account> accounts = session.createQuery("from Account").getResultList();
			
			session.getTransaction().commit();
			return accounts;
		}
		finally {
			session.close();
			factory.close();
		}
	}
	
	public List<Account> findAccount(String userName) {
		try {
			session.beginTransaction();
			
			@SuppressWarnings("unchecked")
			List<Account> accounts = session.createQuery("from Account where user_name = (:userName)").setParameter("userName", userName).getResultList();
			
			session.getTransaction().commit();
			return accounts;
		}
		finally {
			session.close();
			factory.close();
		}
	}
}
