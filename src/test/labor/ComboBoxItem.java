package test.labor;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

public class ComboBoxItem extends JFrame implements ActionListener
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public ComboBoxItem()
    {
        Vector<Item> model = new Vector<Item>();
        model.addElement( new Item(1, "car" ) );
        model.addElement( new Item(2, "plane" ) );
        model.addElement( new Item(3, "train" ) );
        model.addElement( new Item(4, "boat" ) );

        JComboBox<Item> comboBox;

        //  Easiest approach is to just override toString() method
        //  of the Item class

        comboBox = new JComboBox<Item>( model );
        comboBox.setEnabled(true);
        comboBox.addActionListener( this );
        getContentPane().add(comboBox, BorderLayout.NORTH );

        //  Most flexible approach is to create a custom render
        //  to diplay the Item data

        comboBox = new JComboBox<Item>( model );
        comboBox.setEnabled(true);
        comboBox.setRenderer( new ItemRenderer() );
        comboBox.addActionListener( this );
        getContentPane().add(comboBox, BorderLayout.SOUTH );
    }

    public void actionPerformed(ActionEvent e)
    {
        JComboBox<?> comboBox = (JComboBox<?>)e.getSource();
        Item item = (Item)comboBox.getSelectedItem();
        System.out.println( item.getId() + " : " + item.getDescription() );
    }

    @SuppressWarnings("serial")
	class ItemRenderer extends BasicComboBoxRenderer
    {
        public Component getListCellRendererComponent(
            @SuppressWarnings("rawtypes") JList list, Object value, int index,
            boolean isSelected, boolean cellHasFocus)
        {
            super.getListCellRendererComponent(list, value, index,
                isSelected, cellHasFocus);

            if (value != null)
            {
                Item item = (Item)value;
                setText( item.getDescription().toUpperCase() );
            }

            if (index == -1)
            {
                Item item = (Item)value;
                setText( "" + item.getId() );
            }


            return this;
        }
    }

    class Item
    {
        private int id;
        private String description;

        public Item(int id, String description)
        {
            this.id = id;
            this.description = description;
        }

        public int getId()
        {
            return id;
        }

        public String getDescription()
        {
            return description;
        }

        public String toString()
        {
            return description;
        }
    }

    public static void main(String[] args)
    {
        JFrame frame = new ComboBoxItem();
        frame.setDefaultCloseOperation( EXIT_ON_CLOSE );
        frame.pack();
        frame.setVisible( true );
     }

}
