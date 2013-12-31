package edu.arizona.sirls.etc.site.client.content.semanticMarkup;

import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.google.web.bindery.event.shared.EventBus;

import edu.arizona.sirls.etc.site.client.common.Authentication;
import edu.arizona.sirls.etc.site.client.content.matrixGeneration.IMatrixGenerationProcessView;
import edu.arizona.sirls.etc.site.client.content.matrixGeneration.MatrixGenerationProcessPresenter;
import edu.arizona.sirls.etc.site.client.content.matrixGeneration.MatrixGenerationReviewPlace;
import edu.arizona.sirls.etc.site.client.content.taskManager.ResumableTasksEvent;
import edu.arizona.sirls.etc.site.client.content.taskManager.ResumableTasksEventHandler;
import edu.arizona.sirls.etc.site.client.content.taskManager.TaskManagerPlace;
import edu.arizona.sirls.etc.site.shared.db.Task;
import edu.arizona.sirls.etc.site.shared.rpc.IMatrixGenerationServiceAsync;
import edu.arizona.sirls.etc.site.shared.rpc.ISemanticMarkupServiceAsync;
import edu.arizona.sirls.etc.site.shared.rpc.RPCCallback;
import edu.arizona.sirls.etc.site.shared.rpc.semanticMarkup.LearnInvocation;

public class SemanticMarkupLearnPresenter implements ISemanticMarkupLearnView.Presenter {

	private ISemanticMarkupLearnView view;
	private ISemanticMarkupServiceAsync semanticMarkupService;
	private Task task;
	private PlaceController placeController;
	
	@Inject
	public SemanticMarkupLearnPresenter(final ISemanticMarkupLearnView view, 
			ISemanticMarkupServiceAsync semanticMarkupService, 
			PlaceController placeController, 
			@Named("Tasks") final EventBus tasksBus) {
		super();
		this.view = view;
		view.setPresenter(this);
		this.semanticMarkupService = semanticMarkupService;
		this.placeController = placeController;
		
		tasksBus.addHandler(ResumableTasksEvent.TYPE, new ResumableTasksEventHandler() {	
			@Override
			public void onResumableTaskEvent(ResumableTasksEvent resumableTasksEvent) {
				if(task != null && resumableTasksEvent.getTasks().containsKey(task.getId())) {
					view.setResumable();
				} else {
					view.setNonResumable();
				}
			}
		});
	}

	@Override
	public void onNext() {
		placeController.goTo(new SemanticMarkupReviewPlace(task));
	}

	@Override
	public void onTaskManager() {
		placeController.goTo(new TaskManagerPlace());
	}

	@Override
	public ISemanticMarkupLearnView getView() {
		return view;
	}

	@Override
	public void setTask(Task task) {
		this.task = task;
		semanticMarkupService.learn(Authentication.getInstance().getToken(), 
			task, new RPCCallback<LearnInvocation>() {
			@Override
			public void onResult(LearnInvocation result) {
				//MatrixGenerationProcessPresenter.this.task = result;
			}
		});
	}
}
