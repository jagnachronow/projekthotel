package hotel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class UserPanel extends JPanel {
	
	JComboBox miesiac;
	JComboBox dzien;
	JComboBox dzienL;
	JComboBox dzien30;
	JComboBox wyborRoku;
	JComboBox miesiacK;
	JComboBox dzienK;
	JComboBox dzienLK;
	JComboBox dzien30K;
	JComboBox wyborRokuK;
	JComboBox wyborTypu;
	JComboBox liczbaOsob;
	JComboBox czyWidok;
	JComboBox ifDisabled;
	JComboBox payMet;
	
	JLabel od;
	JLabel doo;
	
	JButton b1;
	JButton b2;
	JButton b3;
	
	AllListener listener = new AllListener();
	
	
	
	
	
	
	void addListeners(){
		
		miesiac.addActionListener(new CBRepController());
		miesiacK.addActionListener(new CBRepController());
		
		miesiac.addActionListener(listener);
		dzien.addActionListener(listener);
		dzienL.addActionListener(listener);
		dzien30.addActionListener(listener);
		wyborRoku.addActionListener(listener);
		miesiacK.addActionListener(listener);
		dzienK.addActionListener(listener);
		dzienLK.addActionListener(listener);
		dzien30K.addActionListener(listener);
		wyborRokuK.addActionListener(listener);
		
	}
	
	
	
	
	
	

	UserPanel(){
		
//		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(500, 500));
		
		
		setLayout(new GridBagLayout());
		GridBagConstraints cons = new GridBagConstraints();
		
		cons.insets = new Insets(0,-50,20,0);
		cons.gridx = 0;
		cons.gridy = 0;
		
		String[] typy = new String[3];
		typy[0] = "wybierz standard pokoju";
//		typy[1] = "bez znaczenia";
		typy[1] = "apartament";
		typy[2] = "klasa ekonomiczna";
		wyborTypu = new TextComboBox(typy, "standard");
		wyborTypu.addActionListener(listener);
		add(wyborTypu, cons);
		
		cons.insets = new Insets(0,-78,20,0);
		cons.gridx = 0;
		cons.gridy = 1;
		
		String [] osoby = new String [6];
		osoby [0] = "wybierz liczbe osob";
		for(int i = 0; i<5;i++){
			osoby[i+1] = ((Integer)(i+1)).toString();
		}
		liczbaOsob = new TextComboBox(osoby, "liczba osob");
		liczbaOsob.addActionListener(listener);
		add(liczbaOsob, cons);
		
		cons.insets = new Insets(0,-110,20,0);
		cons.gridx = 0;
		cons.gridy = 2;
		
		String[] widok = new String[4];
		widok[0] = "widok";
		widok[1] = "tak";
		widok[2] = "nie";
		widok[3]= "bez znaczenia";
		czyWidok = new TextComboBox(widok, "view");
		czyWidok.addActionListener(listener);
		add(czyWidok, cons);
		
		cons.insets = new Insets(0,0,40,0);
		cons.gridx = 0;
		cons.gridy = 3;
		
		String[] disabled = new String[3];
		disabled[0] = "ulatwienia dla niepelnosprawnych";
		disabled[1] = "tak";
		disabled[2] = "nie";
		ifDisabled = new TextComboBox(disabled, "disabled");
		ifDisabled.addActionListener(listener);
		add(ifDisabled, cons);	
		
		cons.insets = new Insets(0,-100,20,100);
	
		String [] miesiace = new String [13];
		miesiace [0] = "miesiac";
		for(int i = 0; i<12;i++){
			miesiace[i+1] = ((Integer)(i+1)).toString();
		}
		
		String[] dni = new String [32];
		dni [0] = "dzien";
		for(int i = 0; i<31;i++){
			dni[i+1] = ((Integer)(i+1)).toString();
		}
		
		String[] dniLuty = new String [29];
		dniLuty[0] = "dzien";
		for(int i = 0; i<28;i++){
			dniLuty[i+1] = ((Integer)(i+1)).toString();
		}
		
		String[] dni30 = new String[31];
		dni30[0] = "dzien";
		for(int i = 0; i<30;i++){
			dni30[i+1] = ((Integer)(i+1)).toString();
		}
		
		
		String[] rok = new String[4];
		rok[0] = "rok";
		rok[1] = "2016";
		rok[2] = "2017";		
		rok[3] = "2018";
		
		miesiac = new TextComboBox(miesiace, "p1");
		dzien = new TextComboBox(dni, "p2");
		dzienL = new TextComboBox(dniLuty,"p2");
		dzien30 = new TextComboBox(dni30, "p2");
		wyborRoku = new TextComboBox(rok, "p3");
		dzienL.setVisible(false);
		dzien30.setVisible(false);
		
		miesiacK = new TextComboBox(miesiace, "k1");
		dzienK = new TextComboBox(dni, "k2");
		dzienLK = new TextComboBox(dniLuty,"k2");
		dzien30K = new TextComboBox(dni30, "k2");
		wyborRokuK = new TextComboBox(rok, "k3");
		dzienLK.setVisible(false);
		dzien30K.setVisible(false);
		
		od = new JLabel("od");
		doo = new JLabel("do");
		
		addListeners();
	
		cons.insets = new Insets(0,-180,20,100);
		cons.gridx = 0;
		cons.gridy = 4;
		add(od, cons);
		
		cons.insets = new Insets(0,-220,20,220);
		cons.gridx++;
		add(wyborRoku, cons);
		

		cons.gridx++;
		add(miesiac, cons);
		
		cons.gridx++;
		add(dzien, cons); 
		add(dzienL, cons);
		add(dzien30, cons);
		
		
		cons.insets = new Insets(0,-180,20,100);
		cons.gridx = 0;
		cons.gridy = 5;
		
		add(doo, cons);
		
		cons.insets = new Insets(0,-220,20,220);
		cons.gridx++;
		add(wyborRokuK, cons);
		
		cons.gridx++;
		add(miesiacK, cons);
		
		cons.gridx++;
		add(dzienK, cons);
		add(dzienLK, cons);
		add(dzien30K, cons);
		
		String [] methods = new String [4];
		methods[0] = "wybierz metode platnosci";
		methods[1] = "przelew";
		methods[2] = "pay pal";
		methods[3] = "osobiscie";
		payMet = new TextComboBox(methods, "Payment Method");
		payMet.setVisible(false);
		
		b1 = new JButton("Availability check");
		b1.setPreferredSize(new Dimension(200,50));
		
		b2 = new JButton("Reserve");
		b2.setPreferredSize(new Dimension(250,50));
		b2.setVisible(false);
		
		b3 = new JButton("Cancel");
		b3.setPreferredSize(new Dimension(250,50));
		b3.setVisible(false);
		
		b2.addActionListener(listener);
		b1.addActionListener(listener);
		b3.addActionListener(listener);
		
		cons.insets = new Insets(20,-20,0,0);
		
		cons.gridy = 6;
		cons.gridx = 0;
		
		add(b1, cons);
		
		
		cons.insets = new Insets(0,0,0,0);
		cons.gridy = 3;
		cons.gridx = 0;
		add(b3,cons);
		
		cons.gridy = 3;
		cons.gridx = 1;
		add(payMet, cons);
		
		cons.gridy = 3;
		cons.gridx = 2;
		add(b2, cons);
		
		
		
		
	}
}
