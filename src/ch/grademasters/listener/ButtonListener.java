package ch.grademasters.listener;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * @description Button Listener fuer wechseln der verschiedenen Cards
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * ButtonListener.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */
 
public class ButtonListener implements ActionListener {

	private JPanel cards;

	public ButtonListener(JPanel cards) {

		this.setCard(cards);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Klasse hinzufügen")) {
			CardLayout cardLayout = (CardLayout) getCard().getLayout();
			cardLayout.show(cards, "Add Klasse Card");
		}
		else if (e.getActionCommand().equals("Fach hinzufügen")) {
			CardLayout cardLayout = (CardLayout) getCard().getLayout();
			cardLayout.show(cards, "Add Fach Card");
		}
		else if (e.getActionCommand().equals("Note hinzufügen")) {
			CardLayout cardLayout = (CardLayout) getCard().getLayout();
			cardLayout.show(cards, "Add Note Card");
		}
		else if (e.getActionCommand().equals("Verlassen")) {
			CardLayout cardLayout = (CardLayout) getCard().getLayout();
			cardLayout.show(cards, "Start Card");
		}

	}

	// Getter und Setter
	public JPanel getCard() {
		return cards;
	}

	public void setCard(JPanel cards) {
		this.cards = cards;
	}

}
