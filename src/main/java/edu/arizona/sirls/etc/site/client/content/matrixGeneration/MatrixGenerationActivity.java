package edu.arizona.sirls.etc.site.client.content.matrixGeneration;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

import edu.arizona.sirls.etc.site.client.common.Authentication;
import edu.arizona.sirls.etc.site.client.content.matrixGeneration.IMatrixGenerationProcessView.Presenter;
import edu.arizona.sirls.etc.site.shared.db.Task;
import edu.arizona.sirls.etc.site.shared.rpc.ITaskServiceAsync;
import edu.arizona.sirls.etc.site.shared.rpc.RPCCallback;
import edu.arizona.sirls.etc.site.shared.rpc.TaskTypeEnum;
import edu.arizona.sirls.etc.site.shared.rpc.matrixGeneration.TaskStageEnum;

public class MatrixGenerationActivity extends AbstractActivity {

	private ITaskServiceAsync taskService;
	private MatrixGenerationPlace place;
	private IMatrixGenerationInputView.Presenter inputPresenter;
	private IMatrixGenerationProcessView.Presenter processPresenter;
	private IMatrixGenerationReviewView.Presenter reviewPresenter;
	private IMatrixGenerationOutputView.Presenter outputPresenter;

	@Inject
	public MatrixGenerationActivity(ITaskServiceAsync taskService, 
			IMatrixGenerationInputView.Presenter inputPresenter, 
			IMatrixGenerationProcessView.Presenter processPresenter,
			IMatrixGenerationReviewView.Presenter reviewPresenter,
			IMatrixGenerationOutputView.Presenter outputPresenter) {
		this.taskService = taskService;
		this.inputPresenter = inputPresenter;
		this.processPresenter = processPresenter;
		this.reviewPresenter = reviewPresenter;
		this.outputPresenter = outputPresenter;
	}
	
	@Override
	public void start(final AcceptsOneWidget panel, EventBus eventBus) {
		final Task task = place.getTask();
		if(task == null) 
			panel.setWidget(inputPresenter.getView());
		else 
			this.taskService.getTask(Authentication.getInstance().getToken(),
					 task, new RPCCallback<Task>() {
						@Override
						public void onResult(Task result) {
							if(result.getTaskType().getTaskTypeEnum().equals(TaskTypeEnum.MATRIX_GENERATION)) {
								switch(TaskStageEnum.valueOf(result.getTaskStage().getTaskStage())) {
								case INPUT:
									panel.setWidget(inputPresenter.getView());
									break;
								case OUTPUT:
									outputPresenter.setTask(task);
									panel.setWidget(outputPresenter.getView());
									break;
								case PROCESS:
									processPresenter.setTask(task);
									panel.setWidget(processPresenter.getView());
									break;
								case REVIEW:
									reviewPresenter.setTask(task);
									panel.setWidget(reviewPresenter.getView());
									break;
								default:
									panel.setWidget(inputPresenter.getView());
									break;
								}
							}
						}
			});
	}

	public void setPlace(MatrixGenerationPlace place) {
		this.place = place;
	}

}
