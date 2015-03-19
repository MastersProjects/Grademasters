package ch.grademasters.exception;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import ch.grademasters.view.GradeMastersView;

/**
 * @description Exceptionklasse wenn keine VErbindung zur Datenbank besteht.
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * UserError.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */

public class UserSucess extends JDialog {

	private static final long serialVersionUID = 1L;
	
	protected JPanel error = new JPanel(new CardLayout());
	protected JPanel errorCard = new JPanel(new FlowLayout());
	
	/*
	 * Button
	 */
	private final Icon userAddImg = GradeMastersView.loadIcon("vcard_add.png");
	protected final JLabel userAddImageButton = new JLabel(userAddImg);
	protected final JButton ok = new JButton("Ok");
	
	/*
	 * JLabel
	 */
	protected JLabel sucessText = new JLabel("Sie wurden erfolgreich registriert!");
	
	public UserSucess(){
			
		setSize(250,150);
		setVisible(true);
		setResizable(false);

		errorCard.add(userAddImageButton, BorderLayout.NORTH);
		errorCard.add(sucessText, BorderLayout.CENTER);
		errorCard.add(ok, BorderLayout.SOUTH);
		
		error.add(errorCard);
		
		this.add(error);
		
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});

	}
	
	

	
}
