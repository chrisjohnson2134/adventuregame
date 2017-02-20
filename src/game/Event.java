package game;


public class Event {
	Item item;
	String descp;
	String after;
	boolean on;
	
	public Event(String descp,Item item){
		this.item = item;
		this.descp = descp;
	}
	
	public Event(String descp) {
		this.descp = descp;
		on = true;
	}

	public Event(String before, String after, Item item) {
		this.descp = before;
		this.after = after;
		this.on = true;
		this.item = item;
	}

	public Item getItem(){
		return item;
	}
	
	public String getDescp(){
		return descp;
	}
	
	public String getAfter(){
		return after;
	}
	
	public boolean itemState(){
		return item.isOn();
	}
	
	public boolean eventState(){
		return on;
	}
	
}
