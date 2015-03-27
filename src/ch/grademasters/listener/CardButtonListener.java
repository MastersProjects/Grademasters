package ch.grademasters.listener;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import ch.grademasters.abfrage.Abfrage_User;
import ch.grademasters.diagramm.CreateDiagramm;
import ch.grademasters.messages.CreateZeugnis;

/**
 * @description Button Listener fuer wechseln der verschiedenen Cards
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin ButtonListener.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */
 
public class CardButtonListener implements ActionListener {

	private JPanel cards;

	/**
	 * Konstruktor fuer die Klasse CardButtonListener
	 * @param cards
	 */
	public CardButtonListener(JPanel cards) { 

		this.setCard(cards);
	}

	public void actionPerformed(ActionEvent e) {
		//Setzt Klasse hinzufuegen auf visable wenn Button gedrueckt wird
		if (e.getActionCommand().equals("Klasse hinzufügen")) {
			CardLayout cardLayout = (CardLayout) getCard().getLayout();
			cardLayout.show(cards, "Add Klasse Card");
		}
		//Setzt Fach hinzufuegen auf visable wenn Button gedrueckt wird
		else if (e.getActionCommand().equals("Fach hinzufügen")) {
			CardLayout cardLayout = (CardLayout) getCard().getLayout();
			cardLayout.show(cards, "Add Fach Card");
		}
		//Setzt Note hinzufuegen auf visable wenn Button gedrueckt wird
		else if (e.getActionCommand().equals("Note hinzufügen")) {
			CardLayout cardLayout = (CardLayout) getCard().getLayout();
			cardLayout.show(cards, "Add Note Card");
		}
		//Erstellt ein neues Fenster mit dem Diagramm
		else if (e.getActionCommand().equals("Diagramm erstellen")) {
			new CreateDiagramm("Diagramm");
		}
		//Erstellt ein neues Fenster fuer den Export des Zeugnisses
		else if (e.getActionCommand().equals("Zeugnis erstellen")) {
			new CreateZeugnis();
		}
		//Verlassen Button fuer alle Fesnter kehrt zu Start Card zurueck
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
