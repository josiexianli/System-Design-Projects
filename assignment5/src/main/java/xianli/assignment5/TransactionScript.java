package xianli.assignment5;

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
	
	public void setAccountGateway(AccountGateway accountGateway) {
		this.accountGateway = accountGateway;
	}

	public void setAccountFinder(AccountFinder accountFinder) {
		this.accountFinder = accountFinder;
	}

	public void setReservationGateway(ReservationGateway reservationGateway) {
		this.reservationGateway = reservationGateway;
	}

	public void setReservationFinder(ReservationFinder reservationFinder) {
		this.reservationFinder = reservationFinder;
	}

	public void setItemGateway(ItemGateway itemGateway) {
		this.itemGateway = itemGateway;
	}

	public void setItemFinder(ItemFinder itemFinder) {
		this.itemFinder = itemFinder;
	}

	public void setNotificationEngine(NotificationEngine notificationEngine) {
		this.notificationEngine = notificationEngine;
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
    	List<AccountDAO> accounts = accountFinder.findAccount(username);
    	return accounts != null;
    } 
    
    public boolean returnItem(String itemName, int currentUserId) {
    	boolean result = false;
    	List<ItemDAO> items = itemFinder.findItem(itemName, currentUserId);
    	for (ItemDAO item : items) {
    		if (item.isReserved()) {
    			List<ReservationDAO> reservations = reservationFinder.findReservation(1, 1);
    			if (reservations != null) {
    				for (ReservationDAO r : reservations) {
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
