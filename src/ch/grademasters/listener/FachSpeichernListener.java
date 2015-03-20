package ch.grademasters.listener;

import java.awt.event.ActionEvent;

import javax.swing.JTextField;

import ch.grademasters.model.Fach;

public class FachSpeichernListener {
	private JTextField fach;
	
	public FachSpeichernListener(JTextField fach){
		this.setFach(fach);
	}
	
	public void actionPerformed(ActionEvent e) {
		String fachName = this.getFach().getText();
		Fach fach = new Fach(fachName);
		
		//clear textfield
		this.getFach().setText("");
	}
	 
	public JTextField getFach() {
		return fach;
	}

	public void setFach(JTextField fach) {
		this.fach = fach;
	}
}
