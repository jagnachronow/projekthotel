package hotel;

import java.awt.Dimension;

import javax.swing.JComboBox;

public class TextComboBox extends JComboBox{

	private String text;
	private int id;
	
	
	TextComboBox(Object [] obj, String text){
		super(obj);
		this.text = text;
	}
	
	TextComboBox(Object [] obj, String text, int id){
		super(obj);
		this.text = text;
		this.id = id;
	}
	
	public String getText(){
		return text;
	}
	
	public int getId(){
		return id;
	}

	
}
