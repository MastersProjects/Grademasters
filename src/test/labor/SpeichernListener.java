
package test.labor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class SpeichernListener implements ActionListener{

	private JTextField field1;
	private JTextField field2;
	 
    public SpeichernListener (JTextField field1, JTextField field2) {
   
       this.field1 = field1;
       this.field2 = field2;
    }

    @Override
    public void actionPerformed (ActionEvent e)
    {
       System.out.println ("Pressed");
       System.out.println (field1.getText ());
       System.out.println (field2.getText ());
    }

}
