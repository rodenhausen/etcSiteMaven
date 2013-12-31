package edu.arizona.sirls.etc.site.client.content.matrixGeneration;

import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

import edu.arizona.sirls.etc.site.client.content.semanticMarkup.SemanticMarkupLearnPlace;
import edu.arizona.sirls.etc.site.shared.db.Task;

public class MatrixGenerationOutputPlace extends MatrixGenerationPlace {

	public MatrixGenerationOutputPlace(Task task) {
		super(task);
	}
	
	public static class Tokenizer implements PlaceTokenizer<MatrixGenerationOutputPlace> {

		@Override
		public MatrixGenerationOutputPlace getPlace(String token) {
			Task task = new Task();
			try {
				int taskId = Integer.parseInt(token.split("task=")[1]);
				task.setId(taskId);
			} catch(Exception e) {
				return new MatrixGenerationOutputPlace(null);
			}
			return new MatrixGenerationOutputPlace(task);
		}

		@Override
		public String getToken(MatrixGenerationOutputPlace place) {
			return "task=" + place.getTask().getId();
		}

	}

}
