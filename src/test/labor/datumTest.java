package test.labor;

import java.awt.FlowLayout;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

import ch.grademasters.messages.CreateZeugnis;

public class datumTest extends JFrame {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public datumTest () {
    setSize(200, 100);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    setLayout(new FlowLayout(FlowLayout.LEFT, 4, 4));

    add(new JLabel("Datum: "));
    Date today = new Date();
    JSpinner datum = new JSpinner(new SpinnerDateModel(today, null, null, Calendar.MONTH));
    JSpinner.DateEditor datumformatiert = new JSpinner.DateEditor(datum, "dd/MM/yyyy");
    datum.setEditor(datumformatiert); //hbvjdasbfbsibf 
    add(datum);

    setVisible(true);
  }

  public static void main(String args[]) {
//    ArrayList<?> zeugnis = GMController.getInstance().getNotenUndFach();
//    System.out.println(zeugnis); 
//    new CreateDiagramm("Test");
	  new CreateZeugnis();
  }
}