package edu.arizona.sirls.etc.site.client.content.matrixGeneration;

import com.google.gwt.place.shared.PlaceTokenizer;
import com.google.gwt.place.shared.Prefix;

import edu.arizona.sirls.etc.site.shared.db.Task;

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
