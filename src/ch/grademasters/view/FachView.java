package ch.grademasters.view;

import java.awt.GridLayout;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;

public class FachView {

	// Toolbar
		protected final JToolBar klasseToolBar = new JToolBar();
		
		//Formular
		protected JPanel fachFormular = new JPanel(new GridLayout(1, 2));
		
		//TextField fuer erfassen der Faecher
		private JTextField FachName = new JTextField();
		private JList schuleName = new JList();
		
		public FachView() {

			klasseToolBar.setFloatable(false);

			// Buttons fuer Toolbar
			verlassen.setToolTipText("Achtung Informationen werden nicht gespeichert");
			klasseToolBar.add(verlassen);

			speichern.setToolTipText("Fach wird hinzugefuegt");
			klasseToolBar.add(speichern);
			
			fachName.setText("Fach Name");
			fachName.add(klasseFach);
	
}
