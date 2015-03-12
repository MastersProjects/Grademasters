package ch.grademasters.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonListener implements ActionListener  {
	
	private JPanel startPanel;
	private JPanel addKlassePanel;
	private JPanel addFachPanel;
	private JPanel addNotePanel;
	

	public ButtonListener(JPanel startPanel, JPanel addKlassePanel, JPanel addFachPanel, JPanel addNotePanel) {
	    
		this.setStartPanel(startPanel);
		this.setAddKlassePanel(addKlassePanel);
		this.setAddFachPanel(addFachPanel);
		this.setAddNotePanel(addNotePanel);
		
	 }

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Klasse hinzufügen")) {
			getAddKlassePanel().setVisible(true);
			getStartPanel().setVisible(false);
			getAddFachPanel().setVisible(false);
			getAddNotePanel().setVisible(false);
		}
		
	}


	public JPanel getStartPanel() {
		return startPanel;
	}


	public JPanel getAddKlassePanel() {
		return addKlassePanel;
	}


	public JPanel getAddFachPanel() {
		return addFachPanel;
	}


	public JPanel getAddNotePanel() {
		return addNotePanel;
	}


	public void setStartPanel(JPanel startPanel) {
		this.startPanel = startPanel;
	}


	public void setAddKlassePanel(JPanel addKlassePanel) {
		this.addKlassePanel = addKlassePanel;
	}


	public void setAddFachPanel(JPanel addFachPanel) {
		this.addFachPanel = addFachPanel;
	}


	public void setAddNotePanel(JPanel addNotePanel) {
		this.addNotePanel = addNotePanel;
	}



	
}
