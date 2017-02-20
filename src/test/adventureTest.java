package test;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

import game.Game;
import game.Item;
import game.Room;

public class adventureTest {

	
	//This is great now write actual unit test
	@Test
	public void test() {
		Vector<Item> itemsToWin = new Vector<Item>();
		  Vector<Room> roomsList = new Vector<Room>();
		  
		  
		  
	      Room house = new Room("house");
	      house.addExit("north", "store");
	      house.addExit("south", "mall");
	      house.addItem("plate");
	      house.addItem("knife");
	      house.addRoomDescp("man I'm really hungry.\nI should get some bread,PB,knife, and a plate.");
	     
	      Room store = new Room("store");
	      store.addExit("south", "house");
	      store.addItem("bread");
	      store.addItem("PB");
	      store.addToggleEvent("theirs a creepy guy","the kife scared em off",house.getItem("knife"));
	      
	      Room mall = new Room("mall");
	      mall.addExit("north", "house");
	      mall.addItem("hat");
	      mall.addEvent("cool hat",mall.getItem("hat"));
	      
	      roomsList.add(store);
	      roomsList.add(mall);
	      roomsList.add(house);
	      
	      
	      itemsToWin.add(house.getItem("plate"));
	      itemsToWin.add(house.getItem("knife"));
	      itemsToWin.add(store.getItem("bread"));
	      itemsToWin.add(store.getItem("PB"));
	      
	      
	      Game game = new Game(house,roomsList, itemsToWin);
	      
	      game.submitCommand("get plate");
	      game.submitCommand("get knife");
	      game.submitCommand("go store");
	      game.submitCommand("get bread");
	      game.submitCommand("get PB");
	      game.submitCommand("go house");
	      game.submitCommand("use knife");
	      game.submitCommand("use plate");
	      game.submitCommand("use bread");
	      game.submitCommand("use PB");
	      
	      
	      assertTrue(game.gameWon());
	      
	}

}
