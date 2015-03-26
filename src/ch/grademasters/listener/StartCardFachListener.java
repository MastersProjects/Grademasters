package ch.grademasters.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import ch.grademasters.item.Item;

public class StartCardFachListener implements ListSelectionListener {

	
	
	public StartCardFachListener() {
		
	}
	

	@Override
	public void valueChanged(ListSelectionEvent e) {
		ListSelectionModel lsm = (ListSelectionModel)e.getSource();
		int item = lsm.getSelectionMode();
		System.out.println(item);
		
		
	}


}
