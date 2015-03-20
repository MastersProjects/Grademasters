package ch.grademasters.dao;

/**
 * @description Wird bennoetigt fuer die Map der Combobox
 * @author Luca Marti, Chiramet Phong Penglerd, Elia Perenzin 
 * @file Item.java
 * Copyright Berufsbildungscenter GradeMasters 2015
 */
public class Item {
	//Instanzvariablen
	private int id;
    private String description;

    /**
     * Konstruktor fuer Item
     * @param id
     * @param description
     */
    public Item(int id, String description)
    {
        this.id = id;
        this.description = description;
    }

    // Setter & Getter
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
