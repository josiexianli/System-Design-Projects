package xianli.assignment4;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="items")
public class Item {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="itemId")
	private int itemId;
	
	@Column(name="isReserved")
	private boolean isReserved;
	
	@Column(name="actorId")
	private int actorId;
	
	@Column(name="itemName")
	private String itemName;
	
	public Item() {}
	
	public Item(boolean isReserved, int actorId, String itemName) {
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
