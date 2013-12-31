package edu.arizona.sirls.etc.site.client.content.semanticMarkup;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

import edu.arizona.sirls.etc.site.client.common.Authentication;
import edu.arizona.sirls.etc.site.shared.db.Task;
import edu.arizona.sirls.etc.site.shared.rpc.ITaskServiceAsync;
import edu.arizona.sirls.etc.site.shared.rpc.RPCCallback;

public class SemanticMarkupPreprocessPlace extends SemanticMarkupPlace {

	public SemanticMarkupPreprocessPlace(Task task) {
		super(task);
	}
	
	public static class Tokenizer implements PlaceTokenizer<SemanticMarkupPreprocessPlace> {
				
		@Override
		public SemanticMarkupPreprocessPlace getPlace(String token) {
			Task task = new Task();
			try {
				int taskId = Integer.parseInt(token.split("task=")[1]);
				task.setId(taskId);
			} catch(Exception e) {
				return new SemanticMarkupPreprocessPlace(null);
			}
			return new SemanticMarkupPreprocessPlace(task);
		}

		@Override
		public String getToken(SemanticMarkupPreprocessPlace place) {
			return "task=" + place.getTask().getId();
		}

	}
	
}
