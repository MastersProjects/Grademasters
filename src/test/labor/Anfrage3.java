package test.labor;

import java.awt.*; 
import java.awt.event.*; 
import java.sql.*;

public class Anfrage3 extends Frame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	Label l = new Label("Note anzeigen"); 
      TextArea textAus = new TextArea("",10,60); // Zeilen, Spalten
      Button b = new Button("Suchen");
      public Anfrage3() {
    	  	
            setLayout(new FlowLayout()); // muss
            add(l);
            add(b); 
            b.addActionListener(this);
            add(textAus);
            setSize(500,300); 
            setVisible(true);
            addWindowListener(new FensterLauscher());
      }
      public void actionPerformed(ActionEvent e) {
         Connection con = null;
         try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/GRADEMASTERS","root","1234");
            Statement s= con.createStatement();
            ResultSet res= s.executeQuery("select * from pruefung where FACH_ID = '1'");
            String t; double p;
            while (res.next()) {
                  t=res.getString("Pruefung"); 
                  textAus.append(t+"\t");
                  
                  t=res.getString("Note"); 
                  textAus.append(t+"\t");
                  
                  p=res.getDouble("Gewichtung"); 
                  textAus.append(""+p+"\n");
            }
            res.close(); s.close(); con.close(); 
         }
         catch (Exception ex) { textAus.append(""+ex.getMessage());}
      }
      class FensterLauscher extends WindowAdapter {
            public void windowClosing(WindowEvent e) {
            	System.exit(0);
            }
      }

      public static void main(String[] args) {
            Anfrage3 anfrage3 = new Anfrage3();
            anfrage3.setLocationRelativeTo(null);
            
      }
}