package hotel;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class AllListener implements ActionListener {

	private String std = "wybierz standard pokoju";
	private String person = "wybierz liczbe osob";
	private String ifView = "widok";
	private String ifDisabled = "ulatwienia dla niepelnosprawnych";
	Integer year1;
	Integer month1;
	Integer day1;
	Integer year2;
	Integer month2;
	Integer day2;
	ArrayList <Calendar> toReserve = new ArrayList <Calendar>();
	
	boolean ifFound = false;
	int roomId = 0;
	
	Hotel hotel = new Hotel();

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		
		
	// odczyt danych z panelu	
		
		if (e.getSource().getClass().getName().equals("hotel.TextComboBox")){
			
			if (((TextComboBox) e.getSource()).getText() == "standard"){
				std = (String) ((JComboBox)e.getSource()).getSelectedItem();
				System.out.println(std);
			}
			else if (((TextComboBox) e.getSource()).getText() == "liczba osob"){
				person = (String) ((JComboBox)e.getSource()).getSelectedItem();
				System.out.println(person);
			}
			else if (((TextComboBox) e.getSource()).getText() == "view"){
			ifView = (String) ((JComboBox)e.getSource()).getSelectedItem();
			System.out.println(ifView);
			}
			else if (((TextComboBox) e.getSource()).getText() == "disabled"){
			ifDisabled = (String) ((JComboBox)e.getSource()).getSelectedItem();
			System.out.println(ifDisabled);
			}	
			else if (((TextComboBox) e.getSource()).getText() == "p1"){
				month1 = Integer.valueOf((String) ((JComboBox) e.getSource()).getSelectedItem());
				System.out.println(month1);
			}
			else if (((TextComboBox) e.getSource()).getText() == "p2"){
				day1 = Integer.valueOf((String) ((JComboBox) e.getSource()).getSelectedItem());
				System.out.println(day1);
			}
			else if (((TextComboBox) e.getSource()).getText() == "p3"){
				year1 = Integer.valueOf((String) ((JComboBox) e.getSource()).getSelectedItem());
				System.out.println(year1);
			}
			else if (((TextComboBox) e.getSource()).getText() == "k1"){
				month2 = Integer.valueOf((String) ((JComboBox) e.getSource()).getSelectedItem());
				System.out.println(month2);
			}
			else if (((TextComboBox) e.getSource()).getText() == "k2"){
				day2 = Integer.valueOf((String) ((JComboBox) e.getSource()).getSelectedItem());
				System.out.println(day2);
			}
			else if (((TextComboBox) e.getSource()).getText() == "k3"){
				year2 = Integer.valueOf((String) ((JComboBox) e.getSource()).getSelectedItem());
				System.out.println(year2);
			}
		}
			
	// koniec odczytu danych z panelu	
		
		
		
		
		else if (e.getSource().getClass().getName().equals("javax.swing.JButton")) {
			// dla przycisku "Availablility check"
				if (((JButton) e.getSource()).getText() == "Availability check"){
					
					
					for (int k = 0; k < toReserve.size();k++){
						System.out.println("toReserve" + toReserve.get(k));
		
					}
					for (int k = 0; k < hotel.listaPokoi.get(roomId).zajete.size();k++){
						System.out.println("lista w pokoju " + hotel.listaPokoi.get(roomId).zajete.get(k));
					}
					
					
					
					
					
					if (std.equals("wybierz standard pokoju") ||
						person.equals("wybierz liczbe osob") ||
						ifView.equals("widok") || 
						ifDisabled.equals("ulatwienia dla niepelnosprawnych")){
						JOptionPane.showMessageDialog(null, "Przed rezerwacja musisz wybrac pokoj");
						
					}
					else if ((int)year2<(int)year1 || ((int)year2 == (int)year1 && (int)month2<(int)month1) ||
						((int)year2==(int)year1 && (int)month2==(int)month1 && (int)day2<=(int)day1)){
						JOptionPane.showMessageDialog(null, "Bledny termin");
					}
					else {
					
						Date cal1 = new Date(year1,month1,day1);
						Date cal2 = new Date(year2, month2, day2);
					
						long beg = cal1.getTime();
						long end = cal2.getTime();
						long bor = end - beg;
					
						System.out.println("data poczatkowa to"+day1+"."+month1+"."+year1);
						System.out.println("data koncowa to"+day2+"."+month2+"."+year2);
						System.out.println("chcecie wynajac na "+bor+" milisekund");
					
						for (long i = 0; i <bor;i+=86400000){
							Calendar calendar = Calendar.getInstance();
							calendar.setTimeInMillis(i+beg);
							calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR)-1900);
//							System.out.println(calendar);
							toReserve.add(calendar);
						}
//					funkcja jednostkowa
//					for (int j = 0; j < ifReserved.size();j++){
//					System.out.println(((Calendar) ifReserved.get(j)).get(Calendar.YEAR)+
//							"."+((Calendar) ifReserved.get(j)).get(Calendar.MONTH)+
//							"."+((Calendar) ifReserved.get(j)).get(Calendar.DATE));
//					}
												
					
			
						for (int i = 0; i <hotel.listaPokoi.size(); i++){
							
							
//							for(int h = 0; h<hotel.listaPokoi.get(i).zajete.size(); h++){
//								System.out.println(hotel.listaPokoi.get(i).zajete.get(h));
//							}
							
							
							
							
							ifFound = false;
							
							if (hotel.listaPokoi.get(i).getStd().equals(std) 
									&& hotel.listaPokoi.get(i).getLiczbaOsob().equals(person) 
									&& ((hotel.listaPokoi.get(i).getWidok().equals(ifView) || (ifView.equals("bez znaczenia"))))
									&& hotel.listaPokoi.get(i).getNiepelnosprawni().equals(ifDisabled)){ // szuka pokoju spelniajacego warunki
					
								ifFound = true;
								
					
								for(int j = 0; j < toReserve.size(); j++){
									for (int k = 0; k < hotel.listaPokoi.get(i).zajete.size();k++){
										if (toReserve.get(j).equals(hotel.listaPokoi.get(i).zajete.get(k))){
											ifFound = false;
										}			
								}
							}
							}
								
								
								if (ifFound == true){
									roomId = i;
									break;
								}
								
						}
						//mamy indeks wlasciwego pokoju
						
						if (ifFound == true){
								
									JOptionPane.showMessageDialog(null, "W wybranym terminie pokoj jest dostepny");
									resMenu(e);
							
									
								}
					else{
						
						JOptionPane.showMessageDialog(null, "Wybrany pokoj nie jest dostepny w podanym terminie");
						toReserve = new ArrayList <Calendar>();
					}
					}
				}
				// koniec akcji dla przycisku "Availability check"
				
				
				
	
				else if (((JButton) e.getSource()).getText() == "Reserve"){
					
					mainMenu(e);
					
					for (int k = 0; k < toReserve.size();k++){
						hotel.listaPokoi.get(roomId).zajete.add(toReserve.get(k));
		
					}
//					for (int h = 0;h<toReserve.size();h++){
//						toReserve.remove(h);
//					}
					toReserve = new ArrayList <Calendar>();
					
//					for (int k = 0; k < toReserve.size();k++){
//						System.out.println("toReserve" + toReserve.get(k));
//		
//					}
//					for (int k = 0; k < hotel.listaPokoi.get(roomId).zajete.size();k++){
//						System.out.println("lista w pokoju " + hotel.listaPokoi.get(roomId).zajete.get(k));
//					}
					
					
					
				JOptionPane.showMessageDialog(null, "Zarezerwowano w terminie od " + new Date(year1-1900,month1-1,day1) + " do " +
						new Date(year2-1900,month2-1,day2));
				
				
		}
				else if (((JButton) e.getSource()).getText() == "Cancel"){
			
					mainMenu(e);
					toReserve = new ArrayList <Calendar>();
//					for (int k = 0; k < toReserve.size();k++){
//						System.out.println("toReserve" + toReserve.get(k));
//		
//					}
//					for (int k = 0; k < hotel.listaPokoi.get(roomId).zajete.size();k++){
//						System.out.println("lista w pokoju " + hotel.listaPokoi.get(roomId).zajete.get(k));
//					}
				}
	}
}
	
	
	
	
	
	
	
	
private void mainMenu(ActionEvent e){
	
	((UserPanel)((Component) e.getSource()).getParent()).miesiac.setVisible(true);
	((UserPanel)((Component) e.getSource()).getParent()).dzien.setVisible(true);
	((UserPanel)((Component) e.getSource()).getParent()).dzienL.setVisible(false);
	((UserPanel)((Component) e.getSource()).getParent()).dzien30.setVisible(false);
	((UserPanel)((Component) e.getSource()).getParent()).wyborRoku.setVisible(true);
	((UserPanel)((Component) e.getSource()).getParent()).miesiacK.setVisible(true);
	((UserPanel)((Component) e.getSource()).getParent()).dzienK.setVisible(true);
	((UserPanel)((Component) e.getSource()).getParent()).dzienLK.setVisible(false);
	((UserPanel)((Component) e.getSource()).getParent()).dzien30K.setVisible(false);
	((UserPanel)((Component) e.getSource()).getParent()).wyborRokuK.setVisible(true);
	((UserPanel)((Component) e.getSource()).getParent()).b1.setVisible(true);
	((UserPanel)((Component) e.getSource()).getParent()).wyborTypu.setVisible(true);
	((UserPanel)((Component) e.getSource()).getParent()).liczbaOsob.setVisible(true);
	((UserPanel)((Component) e.getSource()).getParent()).czyWidok.setVisible(true);
	((UserPanel)((Component) e.getSource()).getParent()).ifDisabled.setVisible(true);
	((UserPanel)((Component) e.getSource()).getParent()).od.setVisible(true);
	((UserPanel)((Component) e.getSource()).getParent()).doo.setVisible(true);
	((UserPanel)((Component) e.getSource()).getParent()).b3.setVisible(false);
	((UserPanel)((Component) e.getSource()).getParent()).b2.setVisible(false);
	((UserPanel)((Component) e.getSource()).getParent()).payMet.setVisible(false);
	((UserPanel)((Component) e.getSource()).getParent()).repaint();
	
}
	
	
private void resMenu(ActionEvent e){
	
	((UserPanel)((Component) e.getSource()).getParent()).miesiac.setVisible(false);
	((UserPanel)((Component) e.getSource()).getParent()).dzien.setVisible(false);
	((UserPanel)((Component) e.getSource()).getParent()).dzienL.setVisible(false);
	((UserPanel)((Component) e.getSource()).getParent()).dzien30.setVisible(false);
	((UserPanel)((Component) e.getSource()).getParent()).wyborRoku.setVisible(false);
	((UserPanel)((Component) e.getSource()).getParent()).miesiacK.setVisible(false);
	((UserPanel)((Component) e.getSource()).getParent()).dzienK.setVisible(false);
	((UserPanel)((Component) e.getSource()).getParent()).dzienLK.setVisible(false);
	((UserPanel)((Component) e.getSource()).getParent()).dzien30K.setVisible(false);
	((UserPanel)((Component) e.getSource()).getParent()).wyborRokuK.setVisible(false);
	((UserPanel)((Component) e.getSource()).getParent()).b1.setVisible(false);
	((UserPanel)((Component) e.getSource()).getParent()).wyborTypu.setVisible(false);
	((UserPanel)((Component) e.getSource()).getParent()).liczbaOsob.setVisible(false);
	((UserPanel)((Component) e.getSource()).getParent()).czyWidok.setVisible(false);
	((UserPanel)((Component) e.getSource()).getParent()).ifDisabled.setVisible(false);
	((UserPanel)((Component) e.getSource()).getParent()).od.setVisible(false);
	((UserPanel)((Component) e.getSource()).getParent()).doo.setVisible(false);
	((UserPanel)((Component) e.getSource()).getParent()).b3.setVisible(true);
	((UserPanel)((Component) e.getSource()).getParent()).b2.setVisible(true);
	((UserPanel)((Component) e.getSource()).getParent()).payMet.setVisible(true);
	
	((UserPanel)((Component) e.getSource()).getParent()).repaint();
}



	
	
	
}