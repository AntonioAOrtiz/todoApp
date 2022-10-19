package todoApp.com.example.todoApp;

import java.time.LocalDate;
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
	
	public static boolean isCompleted(Note note)
	{
		return note.getDateCompletion() != null;
	}
	
	public static boolean isFuture(Note note)
	{
		return note.getDateCreation().isAfter(LocalDate.now());
	}
	
	public static boolean isCurrent(Note note)
	{
		return note.getDateCreation().isBefore(LocalDate.now()) && !isCompleted(note);
	}
	
	public void displayNotes()
	{
		List<Note> completed = notes.stream().filter(note -> isCompleted(note)).toList();
		List<Note> current = notes.stream().filter(note -> isCurrent(note)).toList();
		List<Note> future = notes.stream().filter(note -> isFuture(note)).toList();
		System.out.println("COMPLETED");
		for(Note note : completed) System.out.println(note);
		System.out.println("CURRENT");
		for(Note note : current) System.out.println(note);
		System.out.println("FUTURE ");
		for(Note note : future) System.out.println(note);
	}
	
	
}
