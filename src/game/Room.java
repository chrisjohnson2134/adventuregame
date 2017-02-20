package game;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class Room {
	
	String roomName;
	Vector<Item> itemList = new Vector<Item>();
	Vector<Event> eventsList = new Vector<Event>();
	
	Map<String, String> exits = new HashMap<String, String>();
	
	
	//constructors
	public Room(){	
	}
	
	//room name with items
	public Room(String roomName,Vector<Item> itemList){
		this.itemList = itemList;
		this.roomName = roomName;
	}
	
	//minium info needed constructor
	public Room(String roomName) {
		this.roomName = roomName;
	}
	
	
	//Item Actions
	public void addItem(String item){
		itemList.add(new Item(item));
	}
	
	public void removeItem(String item){
		for(Item curr : itemList){
			if(curr.getName().equals(item)){
				itemList.remove(curr);
				return;
			}
		}
	}
	
	public Item getItem(String item){
		for(Item curr : itemList){
			if(curr.toString().equals(item)){
				return curr;
			}
		}
		return null;
	}
	
	public Vector<Item> getItems(){
		return itemList;
	}

	
	//Exit functions
	public void addExit(String dir,String place){
		exits.put(dir, place);
	}
	
	public Map<String, String> getExits(){
		return exits;
	}
	
	
	
	
	//get room name
	public String getRoomName(){
		return roomName;
	}
	
	//toString
    public String toString(){
		      return roomName + " State and contains" + itemList.toString() ;
	}

    
    
    
    
    //add Events and descriptions
	public void addEvent(String string, Item item) {
		eventsList.add(new Event(string,item));
	}
	
	public void addRoomDescp(String descp){
		eventsList.add(new Event(descp));
	}
	
	public void addToggleEvent(String before, String after, Item item) {
		eventsList.add(new Event(before,after,item));
	}
	
	public void eventAct(Vector<Item> list){
		for(Event e : eventsList){
			if(list.contains(e.getItem())){
				if(e.itemState()){
					System.out.println(e.getAfter());
				}
				else 
					System.out.println(e.getDescp());
			}
			if(e.eventState() && !list.contains(e.getItem())){
				System.out.println(e.getDescp());
			}
		}
	}

	
	
    
    

	
}
