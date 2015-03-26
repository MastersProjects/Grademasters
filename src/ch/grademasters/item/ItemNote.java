package ch.grademasters.item;

public class ItemNote {
	//Instanzvariablen
		private int id;
	    private String pruefung;
	    private float note;
	    private float gewichtung;
	    private String fach;
	    

	    /**
	     * Konstruktor fuer Item
	     * @param id
	     * @param description 
	     * 
	     */
	    public ItemNote(int id, String pruefung, float note, float gewichtung, String fach) {
	       this.setId(id);
	       this.setPruefung(pruefung);
	       this.setNote(note);
	       this.setGewichtung(gewichtung);
	       this.setFach(fach);	        
	        
	    }


		public int getId() {
			return id;
		}


		public String getPruefung() {
			return pruefung;
		}


		public float getNote() {
			return note;
		}


		public float getGewichtung() {
			return gewichtung;
		}


		public String getFach() {
			return fach;
		}


		public void setId(int id) {
			this.id = id;
		}


		public void setPruefung(String pruefung) {
			this.pruefung = pruefung;
		}


		public void setNote(float note) {
			this.note = note;
		}


		public void setGewichtung(float gewichtung) {
			this.gewichtung = gewichtung;
		}


		public void setFach(String fach) {
			this.fach = fach;
		}

	    // Setter & Getter



}
