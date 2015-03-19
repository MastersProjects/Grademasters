package test.labor;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class Speichern extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected JPanel panel = new JPanel(new GridLayout(3,1));
	
	final JTextField field1 = new JTextField(32);
	final JTextField field2 = new JTextField(32);
	
	protected JButton button = new JButton ("OK");
	
	public Speichern() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setName("GradeMasters");
		
		panel.add(field1);
		panel.add(field2);
		panel.add(button);
		this.add(panel);

		button.addActionListener (new SpeichernListener (field1, field2));
	    
	   
	}

	public static void main(String[] args) {
		Speichern gui = new Speichern();
		gui.setSize(760, 500);
		gui.setVisible(true);

	}

}
