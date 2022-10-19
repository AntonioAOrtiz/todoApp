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
	
	@Test
	void NoteDeleteTest()
	{
		Note note1 = new Note(1, "reunión", "reunion de trabajo", LocalDate.now(), LocalDate.parse("2022-12-12"), LocalDate.parse("2022-12-13"), "link","Germán" ,Priority.MEDIUM);
		notedata.create(note1);
		notedata.delete(note1);
		
		assertTrue(!notedata.getNotes().contains(note1));
	}
	
	
	@Test
	void NoteReadSuccesfulTest() {
		Note note1 = new Note(1, "reunión", "reunion de trabajo", LocalDate.now(), LocalDate.parse("2022-12-12"), LocalDate.parse("2022-12-13"), "link","Germán" ,Priority.MEDIUM);
		
		
		notedata.create(note1);
		
		Note note2 = notedata.read(note1.getId());
		
		assertTrue(note1 == note2);
		
		
		
	}
	
	@Test
	void NoteReadFailedTest() {
		
		Note note = notedata.read(-1);
		
		assertTrue(note == null);
	}
	
	@Test
	void test1() {
		
		Note note1 = new Note(1, "reunión", "reunion de trabajo", LocalDate.now(), LocalDate.parse("2022-12-12"), LocalDate.parse("2022-12-13"), "link","Germán" ,Priority.MEDIUM);
		
		
		notedata.create(note1);
		notedata.create(note1);
	}
	
	@Test
	void estimatedCannotBeSmallerthanCreation(){
		
		Note note1 = new Note(1, "reunión", "reunion de trabajo", LocalDate.now(), LocalDate.parse("2022-12-12"), LocalDate.parse("2022-12-13"), "link","Germán" ,Priority.MEDIUM);
		
		LocalDate data = LocalDate.from(note1.getEstimatedCompletion());
		
		note1.setEstimatedCompletion(LocalDate.parse("2022-03-10"));
		
		assertTrue(data.isEqual(note1.getEstimatedCompletion()));
		
		
	}
	
	@Test
	void estimatedCannotBeSmallerthanCreation2(){
		
		Note note1 = new Note(1, "reunión", "reunion de trabajo", LocalDate.now(), LocalDate.parse("2022-12-12"), LocalDate.parse("2022-12-13"), "link","Germán" ,Priority.MEDIUM);
		
		LocalDate data = LocalDate.from(note1.getEstimatedCompletion());
		
		note1.setEstimatedCompletion(LocalDate.parse("2022-12-14"));
		
		assertTrue(!data.isEqual(note1.getEstimatedCompletion()));
	}
	
	@Test
	void isNoteCompleted()
	{
		Note note = new Note(1, "reunión", "reunion de trabajo", LocalDate.now(), LocalDate.parse("2022-12-12"), LocalDate.parse("2022-12-12"), "link","Germán" ,Priority.MEDIUM);
		assertTrue(NoteData.isCompleted(note));
	}
	
	@Test
	void isNoteCompletedShoulReturnFalse()
	{
		Note note = new Note(1, "reunión", "reunion de trabajo", LocalDate.now(), LocalDate.parse("2022-12-12"), null, "link","Germán" ,Priority.MEDIUM);
		assertTrue(!NoteData.isCompleted(note));
	}
	
	@Test
	void isNoteCurrent()
	{
		Note note = new Note(1, "reunión", "reunion de trabajo", LocalDate.parse("2022-08-12"), LocalDate.parse("2022-12-12"), null, "link","Germán" ,Priority.MEDIUM);
		assertTrue(NoteData.isCurrent(note));
	}
	
	@Test
	void isNoteCurrentShouldReturnFalse()
	{
		Note note = new Note(1, "reunión", "reunion de trabajo", LocalDate.now(), LocalDate.parse("2022-12-12"), null, "link","Germán" ,Priority.MEDIUM);
		assertTrue(!NoteData.isCurrent(note));
	}
	
	@Test
	void isNoteFuture()
	{
		Note note = new Note(1, "reunión", "reunion de trabajo", LocalDate.parse("2022-11-12"), LocalDate.parse("2022-12-12"), null, "link","Germán" ,Priority.MEDIUM);
		assertTrue(NoteData.isFuture(note));
	}
	
	@Test
	void isNoteFutureShouldReturnFalse()
	{
		Note note = new Note(1, "reunión", "reunion de trabajo", LocalDate.parse("2022-09-12"), LocalDate.parse("2022-12-12"), null, "link","Germán" ,Priority.MEDIUM);
		assertTrue(!NoteData.isFuture(note));
	}
	
	
	@Test
	void priorityTest() {
		Note note = new Note(1, "reunión", "reunion de trabajo", LocalDate.parse("2022-09-12"), LocalDate.parse("2022-12-12"), null, "link","Germán" ,Priority.MEDIUM);
		Priority priority = note.getPriority();
		
		note.setPriority(Priority.HIGH);
		
		Note note2 = notedata.read(1);
		
		System.out.println(priority.toString());
		System.out.println(note.getPriority().toString());
	
		
		assertTrue(priority != note.getPriority());
		
		
	}
	
	
	

}
