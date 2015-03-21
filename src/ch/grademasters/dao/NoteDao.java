package ch.grademasters.dao;

import java.sql.SQLException;

public interface NoteDao {
	
	public abstract void addNote(int note, float gewichtung, int fach_ID, String benennung) throws SQLException;
}
