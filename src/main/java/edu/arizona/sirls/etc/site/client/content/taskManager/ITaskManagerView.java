package edu.arizona.sirls.etc.site.client.content.taskManager;

import java.util.List;

import com.google.gwt.user.client.ui.Widget;

public interface ITaskManagerView {

	public interface Presenter {
		void onShare(TaskData taskData);
		void onDelete(TaskData taskData);
		void onRewind(TaskData taskData);
		void onResume(TaskData taskData);
	}
	  
	void setPresenter(Presenter presenter);
	Widget asWidget();
	void setTaskData(List<TaskData> taskData);
	void updateTaskData(TaskData taskData);
	void removeTaskData(TaskData taskData);
	void addTaskData(TaskData taskData);
	TaskData getSelectedTaskData();
	void resetSelection();
	
}
