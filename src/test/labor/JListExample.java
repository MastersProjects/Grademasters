package test.labor;

/*
Java Swing, 2nd Edition
By Marc Loy, Robert Eckstein, Dave Wood, James Elliott, Brian Cole
ISBN: 0-596-00408-7
Publisher: O'Reilly 
*/

//JListExample.java
//An example of JList with a DefaultListModel that we build up at runtime.
//

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.util.Vector;

public class JListExample extends JPanel {
   
   private JList list;
   
   private JTextField selected = new JTextField("Blank");

   private Vector<String> data = new Vector<String>();
   
   public JListExample() {
       setLayout(new BorderLayout());
       list = new JList();
	JPanel lowerArea = new JPanel( new BorderLayout() );
	JPanel buttonBox = new JPanel( new FlowLayout() );
       JScrollPane pane = new JScrollPane(list);
       JButton addButton = new JButton("Add Element");
       JButton removeButton = new JButton("Remove Element");

	selected.setEnabled(false);
       for (int i = 0; i < 15; i++){
           data.add("Element " + i);
       }
	list.setListData(data);
	list.addListSelectionListener( new ListSelectionListener() {
	    public void valueChanged(ListSelectionEvent e){
		int sel = list.getSelectedIndex();
               if( sel != -1 ){
		    selected.setEnabled(false);
		    selected.setText( data.get(sel) );
		    selected.setEnabled(true);
		}
	    }
	} );
	selected.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               String edit = selected.getText();
		int sel = list.getSelectedIndex();
               if( sel != -1 ){
		    data.remove( sel );
		    data.add( sel, edit );
                   list.setListData(data);
                   list.setSelectedIndex( sel );

               }
           }
       });

       addButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
		int sel = list.getSelectedIndex();
		if( sel != -1 ){
                   data.add( data.get( sel ) + "." + data.size());
		    list.setListData(data);
		    list.setSelectedIndex( sel );
		    
		}
           }
       });
       removeButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               if (data.size() > 0){
                   int sel = list.getSelectedIndex();
		    if( sel != -1 ){
                       data.remove( sel );
		    	list.setListData(data);
			if( sel >= data.size() ){
			    list.setSelectedIndex( sel - 1 );
			} else {
			    list.setSelectedIndex( sel );
			} 

		    }
		}
           }
       });
       
	buttonBox.add(addButton);
	buttonBox.add(removeButton);
       lowerArea.add(buttonBox, BorderLayout.SOUTH);
       lowerArea.add(selected, BorderLayout.NORTH);
       add(pane, BorderLayout.CENTER);
       add(lowerArea, BorderLayout.SOUTH);
/*
       add(buttonBox, BorderLayout.SOUTH);
       add(pane, BorderLayout.NORTH);
       add(addButton, BorderLayout.WEST);
       add(removeButton, BorderLayout.EAST);
*/
   }
   
   public static void main(String s[]) {
       JFrame frame = new JFrame("List Model Example");
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setContentPane(new JListExample());
       frame.setSize(360, 500);
       frame.setLocation(100, 100);
       frame.setVisible(true);
   }
}
