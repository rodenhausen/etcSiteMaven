package edu.arizona.sirls.etc.site.client.content.semanticMarkup;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

import edu.arizona.sirls.etc.site.shared.db.Task;

public class SemanticMarkupOutputPlace extends SemanticMarkupPlace {


	public SemanticMarkupOutputPlace(Task task) {
		super(task);
	}

	public static class Tokenizer implements PlaceTokenizer<SemanticMarkupOutputPlace> {

		@Override
		public SemanticMarkupOutputPlace getPlace(String token) {
			Task task = new Task();
			try {
				int taskId = Integer.parseInt(token.split("task=")[1]);
				task.setId(taskId);
			} catch(Exception e) {
				return new SemanticMarkupOutputPlace(null);
			}
			return new SemanticMarkupOutputPlace(task);
		}

		@Override
		public String getToken(SemanticMarkupOutputPlace place) {
			return "task=" + place.getTask().getId();
		}

	}

}
