package ch.grademasters.listener;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonListener implements ActionListener  {
	
	private JButton button;
	private JPanel card;

	

	
	public ButtonListener(JPanel card) {
		
		
		this.setCard(card);
	}





	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Klasse hinzufügen")) {
			CardLayout cardLayout = (CardLayout) getCard().getLayout();
        	cardLayout.show(card, "Add Klasse Panel");
		}
		else if (e.getActionCommand().equals("Fach hinzufügen")) {
			CardLayout cardLayout = (CardLayout) getCard().getLayout();
        	cardLayout.show(card, "Add Fach Panel");
		}
		else if (e.getActionCommand().equals("Note hinzufügen")) {
			CardLayout cardLayout = (CardLayout) getCard().getLayout();
        	cardLayout.show(card, "Add Note Panel");
		}
		else if (e.getActionCommand().equals("Verlassen")) {
			CardLayout cardLayout = (CardLayout) getCard().getLayout();
        	cardLayout.show(card, "Start Panel");
		}
		
	}


	


	//Getter und Setter
	public JPanel getCard() {
		return card;
	}





	public void setCard(JPanel card) {
		this.card = card;
	}





	


	
}
