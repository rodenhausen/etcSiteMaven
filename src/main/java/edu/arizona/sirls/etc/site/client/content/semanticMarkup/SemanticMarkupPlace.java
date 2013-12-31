package edu.arizona.sirls.etc.site.client.content.semanticMarkup;

import com.google.gwt.place.shared.Place;

import edu.arizona.sirls.etc.site.shared.db.Task;

public class SemanticMarkupPlace extends Place {

	private Task task;
	
	public SemanticMarkupPlace(Task task) {
		this.task = task;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}
	
}
