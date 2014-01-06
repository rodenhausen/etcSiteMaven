package edu.arizona.biosemantics.etcsite.client.content.matrixGeneration;

import com.google.gwt.place.shared.PlaceTokenizer;

public class MatrixGenerationInputPlace extends MatrixGenerationPlace {

	//needed becuase per default the name is used, which causes a name clash with 
	//InputPlace of semanticMarkup's
	public static class Tokenizer implements PlaceTokenizer<MatrixGenerationInputPlace> {

		@Override
		public MatrixGenerationInputPlace getPlace(String token) {
			return new MatrixGenerationInputPlace();
		}

		@Override
		public String getToken(MatrixGenerationInputPlace place) {
			return "";
		}

	}

	public MatrixGenerationInputPlace() {
		super(null);
	}

}
