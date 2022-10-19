package todoApp.com.example.todoApp;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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
	
	public Note read(int id) {
		
		try {
			return notes.stream().filter(note -> note.getId() == id).findFirst().get();
		}catch(NoSuchElementException e){
			return null;
		}
		
		
		
	}
}
