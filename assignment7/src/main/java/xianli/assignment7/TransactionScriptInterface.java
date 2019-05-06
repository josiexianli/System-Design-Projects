package xianli.assignment7;

public interface TransactionScriptInterface
{
	
	public void setAccountGateway(AccountGateway accountGateway);

	public void setAccountFinder(AccountFinder accountFinder);

	public void setReservationGateway(ReservationGateway reservationGateway);

	public void setReservationFinder(ReservationFinder reservationFinder);

	public void setItemGateway(ItemGateway itemGateway);

	public void setItemFinder(ItemFinder itemFinder);

	public void setNotificationEngine(NotificationEngine notificationEngine);
	
    public boolean createAccount(String username, String password, String email);
    
    void deleteAccount(String username);
    
    boolean hasDuplicates(String username);
    
    public boolean returnItem(String itemName, int currentUserId);
}
