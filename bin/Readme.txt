Adventure game framework 
Written by Chris Johnson 
Class CS290

1.)The framework supports specific Commands only unless modifications are made.
	-use       : will activate an item
	-go        : will change rooms
	-get       : will pick up a item
	-examine   : will examine item on player
	-inventory : will show the human inventory 
	-exits     : will show the room exits
	-room      : will show items in the room
	
	
2.)The text file should be in this format
new house start //makes house the starting location for the game
item knife      //adds a knife to the house
item plate
exit south mall //adds a exit to the house {direction,name}
exit north store
description 	//adds a description from the description given from the line below
I need to eat
toggle knife    //toggles the event if the player has a knife  and is on or off
he doesn't have a knife  //player doesn't have a knife in his inventory or the knife is off
he does have a knife     //player does have a knife and the knife is used
win knife                //adds the knife to the items you need to win
win plate
new store new   //makes a new room that is a store but it's not the starting room
item PB
item bread
win PB
win bread
exit south house
super win           //description for when you have won the game
you've won the game of sandwich

-This program sequentially reads in a #room followed by a description
--new operation is followed by #room and "start" if it's the starting room and "new" if it's just another room

--item operation adds a #item to the current room your setting up

--exit operation specifies the direction and name of the room the room can lead to

--win operation takes a item from that room and adds it to the items to win

--toggle operation will toggle the the operation between an on and off state
----toggle takes an item from a a room and two lines beneath the command the first is the item off event and the second is the item on event

--descritpion command adds a description to the room with the description given from the line beneath it

--event command adds a event when a player uses an item in his inventory for the current room 

--super win command adds the description from the line beneath for when the player wins the game