package edu.arizona.sirls.etc.site.client.content.semanticMarkup;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

import edu.arizona.sirls.etc.site.client.common.Authentication;
import edu.arizona.sirls.etc.site.client.content.semanticMarkup.ISemanticMarkupInputView.Presenter;
import edu.arizona.sirls.etc.site.shared.db.Task;
import edu.arizona.sirls.etc.site.shared.rpc.ITaskServiceAsync;
import edu.arizona.sirls.etc.site.shared.rpc.RPCCallback;
import edu.arizona.sirls.etc.site.shared.rpc.TaskTypeEnum;
import edu.arizona.sirls.etc.site.shared.rpc.semanticMarkup.TaskStageEnum;

public class SemanticMarkupActivity extends AbstractActivity {

	private ITaskServiceAsync taskService;
	private SemanticMarkupPlace place;
	private ISemanticMarkupInputView.Presenter inputPresenter;
	private ISemanticMarkupPreprocessView.Presenter preprocessPresenter;
	private ISemanticMarkupLearnView.Presenter learnPresenter;
	private ISemanticMarkupReviewView.Presenter reviewPresenter;
	private ISemanticMarkupParseView.Presenter parsePresenter;
	private ISemanticMarkupOutputView.Presenter outputPresenter;

	@Inject
	public SemanticMarkupActivity(
			ITaskServiceAsync taskService,
			Presenter inputPresenter,
			ISemanticMarkupPreprocessView.Presenter preprocessPresenter,
			ISemanticMarkupLearnView.Presenter learnPresenter,
			ISemanticMarkupReviewView.Presenter reviewPresenter,
			ISemanticMarkupParseView.Presenter parsePresenter,
			ISemanticMarkupOutputView.Presenter outputPresenter) {
		super();
		this.taskService = taskService;
		this.inputPresenter = inputPresenter;
		this.preprocessPresenter = preprocessPresenter;
		this.learnPresenter = learnPresenter;
		this.reviewPresenter = reviewPresenter;
		this.parsePresenter = parsePresenter;
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
							if(result.getTaskType().getTaskTypeEnum().equals(TaskTypeEnum.SEMANTIC_MARKUP)) {
								switch(TaskStageEnum.valueOf(result.getTaskStage().getTaskStage())) {
								case INPUT:
									panel.setWidget(inputPresenter.getView());
									break;
								case OUTPUT:
									outputPresenter.setTask(task);
									panel.setWidget(outputPresenter.getView());
									break;
								case PREPROCESS_TEXT:
									preprocessPresenter.setTask(task);
									panel.setWidget(preprocessPresenter.getView());
									break;
								case LEARN_TERMS:
									learnPresenter.setTask(task);
									panel.setWidget(learnPresenter.getView());
									break;
								case REVIEW_TERMS:
									reviewPresenter.setTask(task);
									panel.setWidget(reviewPresenter.getView());
									break;
								case PARSE_TEXT:
									parsePresenter.setTask(task);
									panel.setWidget(parsePresenter.getView());
									break;
								default:
									panel.setWidget(inputPresenter.getView());
									break;
								}
							}
						}
			});
	}

	public void setPlace(SemanticMarkupPlace place) {
		this.place = place;
	}

}
