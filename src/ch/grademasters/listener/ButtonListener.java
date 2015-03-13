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
		
		getStartPanel().setVisible(false);
		getAddKlassePanel().setVisible(false);
		getAddFachPanel().setVisible(false);
		getAddNotePanel().setVisible(false);
		
		if (e.getActionCommand().equals("Klasse hinzufügen")) {
			getAddKlassePanel().setVisible(true);
		}
		else if (e.getActionCommand().equals("Fach hinzufügen")){
			getAddFachPanel().setVisible(true);
		}
		else if (e.getActionCommand().equals("Note hinzufügen")){
			getAddNotePanel().setVisible(true);
		}
		else if (e.getActionCommand().equals("Verlassen")){
			getStartPanel().setVisible(true);
		}
		
	}


	//Getter und Setter
	
	/**
	 * @return StartPanel
	 */
	public JPanel getStartPanel() {
		return startPanel;
	}

	/**
	 * @return add Klasse Panel
	 */
	public JPanel getAddKlassePanel() {
		return addKlassePanel;
	}

	/**
	 * @return add Fach Panel
	 */
	public JPanel getAddFachPanel() {
		return addFachPanel;
	}

	/**
	 * @return add Note Panel
	 */
	public JPanel getAddNotePanel() {
		return addNotePanel;
	}

	/**
	 * 
	 * @param start Panel
	 */
	public void setStartPanel(JPanel startPanel) {
		this.startPanel = startPanel;
	}

	/**
	 * 
	 * @param add Klasse Panel
	 */
	public void setAddKlassePanel(JPanel addKlassePanel) {
		this.addKlassePanel = addKlassePanel;
	}

	/**
	 * 
	 * @param add Fach Panel
	 */
	public void setAddFachPanel(JPanel addFachPanel) {
		this.addFachPanel = addFachPanel;
	}

	/**
	 * 
	 * @param add Note Panel
	 */
	public void setAddNotePanel(JPanel addNotePanel) {
		this.addNotePanel = addNotePanel;
	}



	
}
