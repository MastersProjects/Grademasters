package ch.grademasters.listener;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonListener implements ActionListener  {
	
	private JPanel card;

	

	
	public ButtonListener(JPanel card) {
				
		this.setCard(card);
	}





	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Klasse hinzufügen")) {
			CardLayout cardLayout = (CardLayout) getCard().getLayout();
        	cardLayout.show(card, "Add Klasse Card");
		}
		else if (e.getActionCommand().equals("Fach hinzufügen")) {
			CardLayout cardLayout = (CardLayout) getCard().getLayout();
        	cardLayout.show(card, "Add Fach Card");
		}
		else if (e.getActionCommand().equals("Note hinzufügen")) {
			CardLayout cardLayout = (CardLayout) getCard().getLayout();
        	cardLayout.show(card, "Add Note Card");
		}
		else if (e.getActionCommand().equals("Verlassen")) {
			CardLayout cardLayout = (CardLayout) getCard().getLayout();
        	cardLayout.show(card, "Start Card");
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
