package ch.grademasters.listener;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import ch.grademasters.abfrage.Abfrage_User;

/**
 * @description Button Listener fuer wechseln der verschiedenen Cards
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin ButtonListener.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */
 
public class CardButtonListener implements ActionListener {

	private JPanel cards;

	public CardButtonListener(JPanel cards) {

		this.setCard(cards);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Klasse hinzuf�gen")) {
			CardLayout cardLayout = (CardLayout) getCard().getLayout();
			cardLayout.show(cards, "Add Klasse Card");
		}
		else if (e.getActionCommand().equals("Fach hinzuf�gen")) {
			CardLayout cardLayout = (CardLayout) getCard().getLayout();
			cardLayout.show(cards, "Add Fach Card");
		}
		else if (e.getActionCommand().equals("Note hinzuf�gen")) {
			CardLayout cardLayout = (CardLayout) getCard().getLayout();
			cardLayout.show(cards, "Add Note Card");
		}
		else if (e.getActionCommand().equals("Diagramm erstellen")) {
			CardLayout cardLayout = (CardLayout) getCard().getLayout();
			cardLayout.show(cards, "Add Diagramm Card");
		}
		else if (e.getActionCommand().equals("Verlassen")) {
			Abfrage_User.getGradeMastersView().dispose();			
			Abfrage_User.creatGradeMastersView();
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
