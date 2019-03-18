package xianli.assignment4;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AccountGateway {
	SessionFactory factory;
	Session session;
	
	public AccountGateway() {
		factory = new Configuration()
				  .configure("hibernate.cfg.xml")
				  .addAnnotatedClass(Account.class)
				  .buildSessionFactory();
		session = factory.getCurrentSession();
	}
	
	public void insertAccount(String username, String password, String email) {
		try {
			Account acc = new Account(username, password, email);
			session.beginTransaction();
			session.save(acc);
			session.getTransaction().commit();
			System.out.println("Account updated successfully， saved accountID = " + acc.getAccountId());
		}
		finally {
			session.close();
			factory.close();
		}
	}
	
	public void deleteAccount(String username) {
		try {
			session.beginTransaction();
			session.createQuery("delete from Account where user_name = :username").setParameter("username", username).executeUpdate();
			System.out.println("Account deleted successfully， saved username = " + username);
		}
		finally {
			session.close();
			factory.close();
		}
	}
	
	
}
