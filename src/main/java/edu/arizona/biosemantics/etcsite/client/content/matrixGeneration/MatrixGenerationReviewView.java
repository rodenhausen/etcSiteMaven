package edu.arizona.biosemantics.etcsite.client.content.matrixGeneration;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import edu.arizona.biosemantics.etcsite.client.content.matrixGeneration.review.ViewImpl;

public class MatrixGenerationReviewView extends Composite implements IMatrixGenerationReviewView {

	private static ReviewMatrixGenerationViewUiBinder uiBinder = GWT.create(ReviewMatrixGenerationViewUiBinder.class);

	interface ReviewMatrixGenerationViewUiBinder extends UiBinder<Widget, MatrixGenerationReviewView> {
	}

	private Presenter presenter;

	@UiField(provided = true)
	ViewImpl view;
	
	@Inject
	public MatrixGenerationReviewView(ViewImpl view) {
		super();
		this.view = view;
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	@UiHandler("nextButton")
	public void onNext(ClickEvent event) {
		presenter.onNext();
	}
	

}
