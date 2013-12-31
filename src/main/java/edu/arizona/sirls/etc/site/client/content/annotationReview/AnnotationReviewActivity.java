package edu.arizona.sirls.etc.site.client.content.annotationReview;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class AnnotationReviewActivity extends AbstractActivity {

	private PlaceController placeController;
	private IAnnotationReviewView.Presenter annotationReviewPresenter;

	@Inject
	public AnnotationReviewActivity(PlaceController placeController, IAnnotationReviewView.Presenter annotationReviewPresenter) {
		super();
		this.placeController = placeController;
		this.annotationReviewPresenter = annotationReviewPresenter;
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		panel.setWidget(annotationReviewPresenter.getView());
	}
}
