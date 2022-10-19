package todoApp.com.example.todoApp;

import java.util.ArrayList;
import java.util.List;

public class NoteData {
	private List<Note> notes;
	
	public NoteData()
	{
		notes = new ArrayList<Note>();
	}
	
	public void create(Note note) {
		notes.add(note);
	}
	
	public void update(Note note) {
		
	}
	
	public void delete(Note note) {
		notes.remove(note);
	}
	
	public List<Note> getNotes()
	{
		return notes;
	}
}
