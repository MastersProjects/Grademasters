package test.labor;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
 



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.JSpinner.DateEditor;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
 
public class datumTest extends JFrame
{

	private static final long serialVersionUID = 1L;

	public datumTest()
	{
		final JLabel label = new JLabel();
		label.setText("Choose Date by selecting below.");
		 
		final JXDatePicker datePicker = new JXDatePicker(System.currentTimeMillis());
		datePicker.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setText(datePicker.getDate().toString());
			
	}
		}
	}
}
		
	public static void main(String[] args)
	{
		new datumTest();
 
	}
	
	}
