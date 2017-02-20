package game;


public class Item {
	String itemName;
	boolean use=false;
	
	public Item(String itemName){
		this.itemName = itemName;
	}
	
	//TODO Will these functions be used? Can an item lose its ability to be used
	//turn off item
	public void useOff(){
		use = false;
	}
	//turn on item
	public void useOn(){
		use=true;
	}
	
	//default toString
	public String toString(){
		return itemName;
	}
	
	//boolean item on
	public boolean isOn(){
		return use;
	}

	//String getName
	public String getName() {
		return itemName;
	}
}
