package edu.arizona.sirls.etc.site.client.content.annotationReview;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

import edu.arizona.sirls.etc.site.client.content.settings.SettingsPlace;

public class AnnotationReviewPlace extends Place {

	public static class Tokenizer implements PlaceTokenizer<AnnotationReviewPlace> {

		@Override
		public AnnotationReviewPlace getPlace(String token) {
			return new AnnotationReviewPlace();
		}

		@Override
		public String getToken(AnnotationReviewPlace place) {
			return "";
		}

	}

}
