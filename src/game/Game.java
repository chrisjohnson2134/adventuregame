package game;

import java.util.Scanner;
import java.util.Vector;

public class Game {
	public Vector<Item> itemsList = new Vector<Item>();
	public Vector<Room> roomsList = new Vector<Room>();
	public Room currentRoom = new Room();
	public Vector<Item> winningItems = new Vector<Item>();
	public String winningMessage;

	public Game(String roomName, String item, String direct, String dest) {
		roomsList.add(new Room(roomName));
		roomsList.firstElement().addItem(item);
		roomsList.firstElement().addExit(direct, dest);
		currentRoom = roomsList.firstElement();
	}

	public Game(Room startingRoom, Vector<Room> roomsList, Vector<Item> winningItems) {
		currentRoom = startingRoom;
		this.roomsList = roomsList;
		this.winningItems = winningItems;
	}

	public Game(Room startingRoom, Vector<Room> roomsList, Vector<Item> winningItems, String winningMessage) {
		this.currentRoom = startingRoom;
		this.roomsList = roomsList;
		this.winningItems = winningItems;
		this.winningMessage = winningMessage;
	}

	// default constructor
	public Game() {
	}

	// start up sequence for the game
	public void start() {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String in; // TODO why create a null string?

		while (gameWon() == false) {
			getCurrentRoom().eventAct(getPlayerItems());
			System.out.print("input command: ");
			in = input.nextLine();
			System.out.println(submitCommand(in) + "\n");
		}

		System.out.println(winningMessage);
	}

	// command string parser
	public String submitCommand(String input) {
		try {
			if (input.split(" ").length < 3)
				switch (input.split(" ")[0]) {
				case "use":
					return "player used " + useOn(input.split(" ")[1]);
				case "go":
					return "player went to the " + go(input.split(" ")[1]);
				case "get":
					return "player got: " + get(input.split(" ")[1]);
				case "examine":
					return "player examined" + examine(input.split(" ")[1]);
				case "inventory":
					return "players inventory: " + getPlayerItems().toString();
				case "room":
					return getRoomItems();
				case "exits":
					return "places you can go from the " + currentRoom.getRoomName() + " " + getRoomExits();
				default:
					return "command not valid";
				}

			return "invalid command";

		} catch (Exception e) {
			return "invalid command";
		}

	}

	// determines if the player has won the game
	public boolean gameWon() {
		int count = 0;
		for (Item a : itemsList) {
			if (a.isOn() && winningItems.contains(a))
				count++;
		}

		if (count == winningItems.size())
			return true;

		return false;
	}

	// examine command
	public String examine(String item) {
		for (Item curr : itemsList) {
			if (curr.getName().equals(item))
				return item + " item is " + curr.isOn();
		}
		return "item not found";
	}

	// get Command
	public String get(String msg) {
		for (Item curr : currentRoom.getItems()) {
			if (curr.getName().equals(msg) && !itemsList.contains(curr)) {
				itemsList.add(curr);
				return curr.getName();
			}
		}
		return "item not found.";
	}

	public String getRoomExits() {
		return currentRoom.getExits().toString();

	}

	// go command
	public String go(String msg) {
		if (currentRoom.getExits().containsValue(msg)) {
			setCurrentRoom(msg);
			return msg;
		}

		return "room not found. try entering the room name.";
	}

	// turn on a item
	public String useOn(String msg) {
		for (Item item : itemsList) {
			if (item.getName().equals(msg)) {
				item.useOn();
				return msg;
			}
		}
		return "item not found";
	}

	// turn off a item
	public String useOff(String msg) {
		for (Item item : itemsList) {
			if (item.getName().equals(msg)) {
				item.useOff();
				return null;
			}
		}
		return "item not found";
	}

	// return current room
	public Room getCurrentRoom() {
		return currentRoom;
	}

	// return player item list
	public Vector<Item> getPlayerItems() {
		return itemsList;
	}

	// return a player item
	public Item getPlayerItem(String item) {
		for (Item curr : itemsList) {
			if (curr.getName().equals(item)) {
				return curr;
			}
		}
		return null;
	}

	// print the items in a room
	public String getRoomItems() {
		return currentRoom.getItems().toString();
	}

	// Set room
	public void setCurrentRoom(String room) {
		for (Room curr : roomsList) {
			if (curr.getRoomName().equals(room)) {
				currentRoom = curr;
				return;
			}
		}
	}
	
	

	

}
