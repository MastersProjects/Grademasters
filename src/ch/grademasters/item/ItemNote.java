package ch.grademasters.item;

public class ItemNote {
	//Instanzvariablen
		private int id;
	    private String description;

	    /**
	     * Konstruktor fuer Item
	     * @param id
	     * @param description
	     */
	    public ItemNote(int id, String pruefung, float note, float gewichtung, String fach) {
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
