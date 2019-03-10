package xianli.assignment3;

public class ReturnItemService {
	DAL dataLayer;
	public ReturnItemService() {
		dataLayer = new DAL();
	};
	
	public void returnItem (int itemId, int actorId, String email) {
		dataLayer.returnItem(itemId, actorId, email);
	}
}
