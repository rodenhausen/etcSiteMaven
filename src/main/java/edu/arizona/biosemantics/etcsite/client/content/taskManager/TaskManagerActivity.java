package edu.arizona.biosemantics.etcsite.client.content.taskManager;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.activity.shared.MyAbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

public class TaskManagerActivity extends MyAbstractActivity implements ITaskManagerView.Presenter {

	private ITaskManagerView taskManagerView;
	private PlaceController placeController;

	@Inject
	public TaskManagerActivity(ITaskManagerView taskManagerView, PlaceController placeController) {
		this.placeController = placeController;
		this.taskManagerView = taskManagerView;
	}
	
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		taskManagerView.setPresenter(this);
		panel.setWidget(taskManagerView.asWidget());
		//TODO: taskManagerView.setTaskData();
	}

	@Override
	public void onShare(TaskData taskData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onDelete(TaskData taskData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRewind(TaskData taskData) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onResume(TaskData taskData) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
