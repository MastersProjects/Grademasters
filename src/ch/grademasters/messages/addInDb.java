package ch.grademasters.messages;

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

public class addInDb extends JDialog {

	private static final long serialVersionUID = 1L;

	// JPanel
	protected JPanel success = new JPanel(new CardLayout());
	protected JPanel successCard = new JPanel(new FlowLayout());

	// Buttons
	protected final Icon addImg = GradeMastersView.loadIcon("vcard_add.png");
	protected final JLabel addImageButton = new JLabel(addImg);
	protected final JButton ok = new JButton("Ok");

	// JLabel
	protected JLabel successText = new JLabel(
			"Die Werte wurden erfolgreich gespeichert.");

	// Success Field
	public addInDb() {

		// Eigenschaften des Fesnters
		setSize(240, 150);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);

		// alles adden
		successCard.add(addImageButton, BorderLayout.NORTH);
		successCard.add(successText, BorderLayout.CENTER);
		successCard.add(ok);
		success.add(successCard);

		this.add(success);

		// ActionListener hinzufuegen
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// verstecken
				setVisible(false);
				// wegraumen
				dispose();
			}
		});

	}

}
