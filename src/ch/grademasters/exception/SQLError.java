package ch.grademasters.exception;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.grademasters.view.GradeMastersView;

/**
 * @description Exceptionklasse wenn keine VErbindung zur Datenbank besteht.
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * SQLException.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class SQLError extends JDialog {

	private static final long serialVersionUID = 1L;
	
	protected JPanel error = new JPanel(new CardLayout());
	protected JPanel errorCard = new JPanel(new FlowLayout());
	
	/*
	 * Button
	 */
	private final Icon errorImg = GradeMastersView.loadIcon("cancel.png");
	protected final JLabel errorImgButton = new JLabel(errorImg);
	protected final JButton ok = new JButton("Ok");
	
	/*
	 * JLabel
	 */
	protected JLabel sqlErrorLabel = new JLabel("Keine Verbindung zur Datenbank");
	
	public SQLError(){
			
		setSize(220,135);
		setVisible(true);
		setResizable(false);

		errorCard.add(errorImgButton, BorderLayout.NORTH);
		errorCard.add(sqlErrorLabel, BorderLayout.CENTER);
		errorCard.add(ok, BorderLayout.SOUTH);
		
		error.add(errorCard);
		
		this.add(error);

	}

	
}
