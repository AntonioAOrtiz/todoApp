package todoApp.com.example.todoApp;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

class NoteTests {

	NoteData notedata = new NoteData();
	@Test
	void NoteCreatetest() {
		
		Note note1 = new Note(1, "reunión", "reunion de trabajo", LocalDate.now(), LocalDate.parse("2022-12-12"), LocalDate.parse("2022-12-13"), "link","Germán" ,Priority.MEDIUM);
		
		notedata.create(note1);
		
		
		
		assertTrue(notedata.getNotes().contains(note1));
		
		
	}
	
	

}
