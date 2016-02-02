package hotel;

import java.awt.List;
import java.util.ArrayList;

public class Hotel {
	
	ArrayList<Room> listaPokoi = new ArrayList <Room>();
	
	Hotel(){
		
		Room r1 = new Room("apartament", "3", "tak", "nie");
		Room r2 = new Room("klasa ekonomiczna", "2", "nie", "nie");
		Room r3 = new Room("klasa ekonomiczna", "3", "tak", "nie");
		Room r4 = new Room("klasa ekonomiczna", "1", "tak", "nie");
		Room r5 = new Room("apartament", "1", "tak", "tak");
		Room r6 = new Room("apartament", "2", "tak", "nie");
		Room r7 = new Room("klasa ekonomiczna", "5", "tak", "nie");
		Room r8 = new Room("apartament", "4", "tak", "nie");
		Room r9 = new Room("klasa ekonomiczna", "4", "nie", "nie");
		Room r10 = new Room("apartament", "1", "tak", "nie");
		listaPokoi.add(r1);
		listaPokoi.add(r2);
		listaPokoi.add(r3);
		listaPokoi.add(r4);
		listaPokoi.add(r5);
		listaPokoi.add(r6);
		listaPokoi.add(r7);
		listaPokoi.add(r8);
		listaPokoi.add(r9);
		listaPokoi.add(r10);
	}
	
	

}
