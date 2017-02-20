package test;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

import game.Game;
import game.Item;
import game.Room;

public class FunctionalityTest {
	
	@Test 
	public void testRoomEvents(){
		Vector<Item> itemsToWin = new Vector<Item>();
		  Vector<Room> roomsList = new Vector<Room>();
		  Room house = new Room("house");
	      house.addExit("north", "store");
	      house.addExit("south", "mall");
	      house.addItem("plate");
	      house.addItem("knife");
	      house.addEvent("ah he's got a knife", house.getItem("knife"));
	      Game game = new Game(house,roomsList, itemsToWin);
	      game.get("knife");
	      game.useOn("knife");
	      house.eventAct(game.getPlayerItems());
	}
	
	@Test
	public void testExamineCommand(){
		Vector<Item> itemsToWin = new Vector<Item>();
		  Vector<Room> roomsList = new Vector<Room>();
		  Room house = new Room("house");
	      house.addExit("north", "store");
	      house.addExit("south", "mall");
	      house.addItem("plate");
	      house.addItem("knife");
	      Game game = new Game(house,roomsList, itemsToWin);
	      game.get("knife");
	      game.useOn("knife");
	      //System.out.print(game.examine("knife"));
	      assertEquals(game.examine("knife"),"knife item is true");
	}
	
	
	@Test
	public void testInventoryCommand(){
		Game hello = new Game("catHall", "light", "north", "hell");
		hello.get("light");
		assertEquals(hello.getPlayerItems().toString(),"[light]");
		
	}
	
	@Test
	public void testUseAndGetCommand(){
		  Vector<Item> itemsToWin = new Vector<Item>();
		  Vector<Room> roomsList = new Vector<Room>();
		  Room house = new Room("house");
	      house.addExit("north", "store");
	      house.addExit("south", "mall");
	      house.addItem("plate");
	      house.addItem("knife");
	      Game game = new Game(house,roomsList, itemsToWin);
	      game.get("knife");
	      game.useOn("knife");
	      assertTrue(game.getPlayerItem("knife").isOn());
	}


	@Test
	public void testGoCommands(){
		Vector<Item> itemsToWin = new Vector<Item>();
		  Vector<Room> roomsList = new Vector<Room>();
		  Room house = new Room("house");
	      house.addExit("north", "store");
	      house.addExit("south", "mall");
	      house.addItem("plate");
	      house.addItem("knife");
	      
	      Room store = new Room("store");
	      store.addExit("south", "house");
	      store.addItem("bread");
	      store.addItem("PB");
	      
	      roomsList.add(store);
	      roomsList.add(house);
	      
	      Game game = new Game(house,roomsList, itemsToWin);
	      game.go("store");
	      assertEquals(game.getCurrentRoom().getRoomName(),"store");
	}
	
	
	@Test
	public void testAddingandRemovingItems() {
		Room house = new Room("house");
	      house.addExit("north", "store");
	      house.addExit("south", "mall");
	      house.addItem("plate");
	      house.addItem("knife");
	      
	      //System.out.println(house.getItems().toString());
	      assertEquals(house.getItems().toString(),"[plate, knife]");
	}
	
	
	//Designed to specifically test the ability of the mapping hash set to 
	//prove that it can be searched then loaded (ie. setting the new state)
	@Test
	public void testExits(){
		Room house = new Room("house");
	      house.addExit("north", "store");
	      house.addExit("south", "mall");
	      house.addItem("plate");
	      house.addItem("knife");
	      
	      //System.out.println(house.getExits().toString());
	      assertEquals(house.getExits().toString(),"{south=mall, north=store}");
		
	}
	
	
}