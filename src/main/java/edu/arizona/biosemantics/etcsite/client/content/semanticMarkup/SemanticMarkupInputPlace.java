package edu.arizona.biosemantics.etcsite.client.content.semanticMarkup;

import com.google.gwt.place.shared.PlaceTokenizer;

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
