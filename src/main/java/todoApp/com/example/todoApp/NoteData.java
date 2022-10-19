package todoApp.com.example.todoApp;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class NoteData {
	private List<Note> notes;
	
	public NoteData()
	{
		notes = new ArrayList<Note>();
	}
	
	public void create(Note note) {
		Optional<Note> opt = notes.stream().filter(note2 -> note2.getId() == note.getId()).findFirst();
		if(opt.isEmpty()){
			notes.add(note);
		}
		else {
			int index = notes.indexOf(opt.get());
			notes.set(index, note);
		}
	}
	
	public void update(Note note) {
		create(note);
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
