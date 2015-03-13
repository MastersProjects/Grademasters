package ch.grademasters.abfrage;

import java.awt.*; 
import java.awt.event.*; 
import java.sql.*;

public class Anfrage3 extends Frame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	Label l = new Label("Suchen in DB weine"); 
      TextArea textAus = new TextArea("",10,60); // Zeilen, Spalten
      Button b = new Button("Los!");
      public Anfrage3() {
            setLayout(new FlowLayout()); // muss
            add(l);
            add(b); b.addActionListener(this);
            add(textAus);
            setSize(500,300); setVisible(true);
            addWindowListener(new FensterLauscher());
      }
      public void actionPerformed(ActionEvent e) {
         Connection con = null;
         try {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            con=java.sql.DriverManager.getConnection
("jdbc:odbc:weine","","");
            Statement s= con.createStatement();
            ResultSet res= s.executeQuery("select * from rotweine where Preis > 30");
            String t; double p;
            while (res.next()) {
                  t=res.getString("Name"); textAus.append(t+"\t");
                  t=res.getString("Anbaugebiet"); textAus.append(t+"\t");
                  p=res.getDouble("Preis"); textAus.append(""+p+"\n");
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
            new Anfrage3();
      }
}