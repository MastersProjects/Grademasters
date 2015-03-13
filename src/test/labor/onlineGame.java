package test.labor;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;  // Packages used in this program imported    

public class onlineGame extends JFrame implements ActionListener
{

    JPanel cards;
    JButton button1, button2, button3;

    public onlineGame() //This is the CONSTRUCTOR method
    {
        //The entry point into your program
        setLayout(new FlowLayout()); //Use this for now.
        setSize(810, 510); //Set the size of the JFrame
        setTitle("Generic Card Game"); //Put Title on top of JFrame
        setBackground(Color.yellow);
        setResizable(false);

        button1 = new JButton("THIS IS BUTTON 1");
        button2 = new JButton("THIS IS BUTTON 2");
        button3 = new JButton("THIS IS BUTTON 3");

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);    
        

        //Create the cards

        JPanel card1 = new JPanel();
        card1.add(button1);

        JPanel card2 = new JPanel();
        card2.add(button2);

        JPanel card3 = new JPanel();
        card3.add(button3);

        //Create the panel that contains the "cards".

        cards = new JPanel(new CardLayout());

        cards.add(card1, "Card 1");
        cards.add(card2, "Card 2");
        cards.add(card3, "Card 3");

        getContentPane().add(cards); 
        setVisible(true); //Make JFrame visible
    }

    public void actionPerformed(ActionEvent e)
    {    
        if (e.getSource() == button1){    
        	CardLayout cardLayout = (CardLayout) cards.getLayout();
        	cardLayout.show(cards, "Card 3");
        }
    }
    public static void main(String args[])
    {    
        new onlineGame(); // This calls the constructor and runs it    
    }
}
