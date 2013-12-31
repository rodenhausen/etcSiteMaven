package edu.arizona.sirls.etc.site.client.content.semanticMarkup;

import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

import edu.arizona.sirls.etc.site.client.content.fileManager.FileManagerPlace;
import edu.arizona.sirls.etc.site.shared.db.Task;

public class SemanticMarkupInputPlace extends SemanticMarkupPlace {
	
	public SemanticMarkupInputPlace() {
		super(null);
	}

	public static class Tokenizer implements PlaceTokenizer<SemanticMarkupInputPlace> {

		@Override
		public SemanticMarkupInputPlace getPlace(String token) {
			return new SemanticMarkupInputPlace();
		}

		@Override
		public String getToken(SemanticMarkupInputPlace place) {
			return "";
		}

	}
	
}
