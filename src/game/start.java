package game;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class start {
	
	 Vector<Item> itemsList = new Vector<Item>();
	 static Vector<Room> roomsList = new Vector<Room>();
	 static Room currentRoom = new Room();
	 static Vector<Item> winningItems = new Vector<Item>();
	 static String winningMessage;

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		String in; 
		
		System.out.print("enter the name of the game file you would like to play: ");
		in = input.nextLine();
		
		fileRead(in);
		
		 Game game = new Game(currentRoom,roomsList,winningItems,winningMessage);
		 game.start();

	}
	
	
	//setup up game parser
	public static void fileRead(String fileName) {

		Room aRoom = new Room("");
		String temp1, temp2;
		File in_file = new File(fileName);
		try {
			Scanner s = new Scanner(in_file);
			while (s.hasNextLine()) {
				String line = s.nextLine();
				String[] str = line.split(" ");

				switch (str[0]) {
				case "new":
					if (str.length == 3) {
						if (str[2].equals("start")) {
							aRoom = new Room(str[1]);
							roomsList.add(aRoom);
							currentRoom = aRoom;
						}
						if (str[2].equals("new")) {
							aRoom = new Room(str[1]);
							roomsList.add(aRoom);
						}
					}
					break;
				case "item":
					aRoom.addItem(str[1]);
					break;
				case "exit":
					aRoom.addExit(str[1], str[2]);
					break;
				case "description":
					temp1 = s.nextLine();
					aRoom.addRoomDescp(temp1);
					break;
				case "toggle":
					temp1 = s.nextLine();
					temp2 = s.nextLine();
					aRoom.addToggleEvent(temp1, temp2, aRoom.getItem(str[1]));
					break;
				case "event":
					temp1 = s.nextLine();
					aRoom.addEvent(temp1, aRoom.getItem(str[1]));
					break;
				case "win":
					winningItems.add(aRoom.getItem(str[1]));
					break;
				case "super":
					if (str[1].equals("win")) {
						winningMessage = s.nextLine();
					}
				}

			}

			try {

			} finally {
				if (s != null) {
					s.close();
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("Could not find file");
		}
	}

}
