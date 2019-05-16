package xianli.assignment3;

public class ItemDAO {
	private int itemId;
	
	private boolean isReserved;
	
	private int actorId;
	
	private String itemName;
	
	public ItemDAO() {}
	
	public ItemDAO(boolean isReserved, int actorId, String itemName) {
		this.isReserved = isReserved;
		this.actorId = actorId;
		this.itemName = itemName;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public boolean isReserved() {
		return isReserved;
	}

	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}

	public int getActorId() {
		return actorId;
	}

	public void setActorId(int actorId) {
		this.actorId = actorId;
	}

	public String getName() {
		return itemName;
	}

	public void setName(String itemName) {
		this.itemName = itemName;
	}

	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", isReserved=" + isReserved + ", actorId=" + actorId + ", name=" + itemName
				+ "]";
	}
	
	
}
