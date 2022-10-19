package todoApp.com.example.todoApp;

import java.time.LocalDate;
import java.util.List;

public class Note {
	private int id;
	private String description;
	private String text;
	private LocalDate dateCreation;
	private LocalDate estimatedCompletion;
	private LocalDate dateCompletion;
	private String link;
	private String mentions;
	private Priority priority;
	
	public Note(int id, String description, String text, LocalDate dateCreation, LocalDate estimatedCompletion,
			LocalDate dateCompletion, String link, String mentions, Priority priority) {
		super();
		this.id = id;
		this.description = description;
		this.text = text;
		this.dateCreation = dateCreation;
		this.estimatedCompletion = estimatedCompletion;
		this.dateCompletion = dateCompletion;
		this.link = link;
		this.mentions = mentions;
		this.priority = priority;
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDate getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDate dateCreation) {
		this.dateCreation = dateCreation;
	}

	public LocalDate getEstimatedCompletion() {
		return estimatedCompletion;
	}

	public void setEstimatedCompletion(LocalDate estimatedCompletion) {
		if(estimatedCompletion.isAfter(dateCreation)) {
			this.estimatedCompletion = estimatedCompletion;
		}
	}

	public LocalDate getDateCompletion() {
		return dateCompletion;
	}

	public void setDateCompletion(LocalDate dateCompletion) {
		this.dateCompletion = dateCompletion;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getMentions() {
		return mentions;
	}

	public void setMentions( String mentions) {
		this.mentions = mentions;
	}

	public Priority getPriority() {
		return priority;
	}

	public void setPriority(Priority priority) {
		this.priority = priority;
	}
	
	
	
	
	
}

