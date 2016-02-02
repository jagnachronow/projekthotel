package hotel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;

public class CBRepController implements ActionListener {

	 UserPanel p;
	 
	@Override
	public void actionPerformed(ActionEvent e) {
		p = (UserPanel) ((JComboBox) e.getSource()).getParent();
		if (((TextComboBox) e.getSource()).getText().equals("p1")){
		if (((JComboBox) e.getSource()).getSelectedItem().equals("2")){
			p.dzien.setVisible(false);
			p.dzien30.setVisible(false);
			p.dzienL.setVisible(true);
			p.repaint();
		}
			else if (((JComboBox) e.getSource()).getSelectedItem().equals("1")||
					((JComboBox) e.getSource()).getSelectedItem().equals("3")||
					((JComboBox) e.getSource()).getSelectedItem().equals("5")||
					((JComboBox) e.getSource()).getSelectedItem().equals("7")||
					((JComboBox) e.getSource()).getSelectedItem().equals("8")||
					((JComboBox) e.getSource()).getSelectedItem().equals("10")||
					((JComboBox) e.getSource()).getSelectedItem().equals("12")){
				p.dzien.setVisible(true);
				p.dzien30.setVisible(false);
				p.dzienL.setVisible(false);
				p.repaint();
			}
			else if (((JComboBox) e.getSource()).getSelectedItem().equals("4")||
					((JComboBox) e.getSource()).getSelectedItem().equals("6")||
					((JComboBox) e.getSource()).getSelectedItem().equals("9")||
					((JComboBox) e.getSource()).getSelectedItem().equals("11")){
				p.dzien.setVisible(false);
				p.dzien30.setVisible(true);
				p.dzienL.setVisible(false);
				p.repaint();
			}
		}
		else if (((TextComboBox) e.getSource()).getText().equals("k1")) {
			if (((JComboBox) e.getSource()).getSelectedItem().equals("2")){
				p.dzienK.setVisible(false);
				p.dzien30K.setVisible(false);
				p.dzienLK.setVisible(true);
				p.repaint();
			}
				else if (((JComboBox) e.getSource()).getSelectedItem().equals("1")||
						((JComboBox) e.getSource()).getSelectedItem().equals("3")||
						((JComboBox) e.getSource()).getSelectedItem().equals("5")||
						((JComboBox) e.getSource()).getSelectedItem().equals("7")||
						((JComboBox) e.getSource()).getSelectedItem().equals("8")||
						((JComboBox) e.getSource()).getSelectedItem().equals("10")||
						((JComboBox) e.getSource()).getSelectedItem().equals("12")){
					p.dzienK.setVisible(true);
					p.dzien30K.setVisible(false);
					p.dzienLK.setVisible(false);
					p.repaint();
				}
				else if (((JComboBox) e.getSource()).getSelectedItem().equals("4")||
						((JComboBox) e.getSource()).getSelectedItem().equals("6")||
						((JComboBox) e.getSource()).getSelectedItem().equals("9")||
						((JComboBox) e.getSource()).getSelectedItem().equals("11")){
					p.dzienK.setVisible(false);
					p.dzien30K.setVisible(true);
					p.dzienLK.setVisible(false);
					p.repaint();
				}
		}
		}
		
	}