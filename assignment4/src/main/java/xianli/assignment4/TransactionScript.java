package xianli.assignment4;

import java.util.List;

public class TransactionScript 
{
	AccountGateway accountGateway;
	AccountFinder accountFinder;
	ReservationGateway reservationGateway;
	ReservationFinder reservationFinder; 
	ItemGateway itemGateway;
	ItemFinder itemFinder;

	NotificationEngine notificationEngine;
	
    public TransactionScript() {
    	accountGateway = new AccountGateway();
    	accountFinder = new AccountFinder();
    	reservationGateway = new ReservationGateway();
    	reservationFinder = new ReservationFinder();
    	itemGateway = new ItemGateway();
    	itemFinder = new ItemFinder();
    	notificationEngine = new NotificationEngine();
    }
    
    public boolean createAccount(String username, String password, String email) {
    	if (!hasDuplicates(username)) {
    		accountGateway.insertAccount(username, password, email);
    		return true;
    	} else {
    		
    		System.out.println("Account already exists");
    		return false;
    	}
    }
    
    void deleteAccount(String username) {
    	accountGateway.deleteAccount(username);
    }
    
    boolean hasDuplicates(String username) {
    	List<Account> accounts = accountFinder.findAccount(username);
    	return accounts != null;
    } 
    
    public boolean returnItem(String itemName, int currentUserId) {
    	boolean result = false;
    	List<Item> items = itemFinder.findItem(itemName, currentUserId);
    	for (Item item : items) {
    		if (item.isReserved()) {
    			List<Reservation> reservations = reservationFinder.findReservation(item.getItemId(), item.getActorId());
    			if (reservations != null) {
    				for (Reservation r : reservations) {
    					reservationGateway.updateReservationRecord(r.getReservationId());
    					notificationEngine.sendEmail(r.getActorId());
    					result = true;
    				}
    			} else {
    				System.out.println("Item " + item.getName() + "has not been reserved");
    				continue;
    			}
    		}
    	}
    	return result;
    }
}
