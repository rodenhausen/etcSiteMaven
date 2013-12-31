package edu.arizona.sirls.etc.site.client.content.home;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

import edu.arizona.sirls.etc.site.client.content.annotationReview.AnnotationReviewPlace;
import edu.arizona.sirls.etc.site.client.content.matrixGeneration.MatrixGenerationInputPlace;
import edu.arizona.sirls.etc.site.client.content.matrixGeneration.MatrixGenerationPlace;
import edu.arizona.sirls.etc.site.client.content.pipeline.PipelinePlace;
import edu.arizona.sirls.etc.site.client.content.semanticMarkup.SemanticMarkupInputPlace;
import edu.arizona.sirls.etc.site.client.content.taxonomyComparison.TaxonomyComparisonPlace;
import edu.arizona.sirls.etc.site.client.content.treeGeneration.TreeGenerationPlace;
import edu.arizona.sirls.etc.site.client.content.visualization.VisualizationPlace;
import edu.arizona.sirls.etc.site.client.etcsite.menu.IStartMenuView;

public class HomeActivity extends AbstractActivity implements IStartMenuView.Presenter, IHomeContentView.Presenter {

    private PlaceController placeController;
	private IHomeContentView homeContentView;

	@Inject
	public HomeActivity(IHomeContentView homeContentView, PlaceController placeController) {
		this.homeContentView = homeContentView;
    	this.placeController = placeController;
    }

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		homeContentView.setPresenter(this);
		panel.setWidget(homeContentView.asWidget());
	}

	@Override
	public void onMatrixGeneration() {
		placeController.goTo(new MatrixGenerationInputPlace());
	}

	@Override
	public void onSemanticMarkup() {
		placeController.goTo(new SemanticMarkupInputPlace());
	}

	@Override
	public void onTaxonomyComparison() {
		placeController.goTo(new TaxonomyComparisonPlace());
	}

	@Override
	public void onVisualization() {
		placeController.goTo(new VisualizationPlace());
	}

	@Override
	public void onPipeline() {
		placeController.goTo(new PipelinePlace());
	}

	@Override
	public void onTreeGeneration() {
		placeController.goTo(new TreeGenerationPlace());
	}
}
