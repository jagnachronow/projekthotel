package hotel;

import java.util.ArrayList;
import java.util.Calendar;

public class Room {
	
	String std;
	String liczbaOsob;
	String widok;
	String niepelnosprawni;
	ArrayList <Calendar> zajete = new ArrayList <Calendar>();
	
	public void setStd(String std){
		this.std = std;
	}
	
	public String getStd(){
		return std;
	}
	

	public void setLiczbaOsob(Integer liczbaOsob){
		this.liczbaOsob = liczbaOsob.toString();
	}
	
	
	public String getLiczbaOsob(){
		return liczbaOsob;
	}

	
	public String getWidok(){
		return widok;
	}
	
	public String getNiepelnosprawni(){
		return niepelnosprawni;
	}
	

	Room(String typ, String liczbaOsob, String widok, String niepelnosprawni){
		this.std = typ;
		this.liczbaOsob = liczbaOsob;
		this.widok = widok;
		this.niepelnosprawni = niepelnosprawni;
	}
}
