package edu.arizona.sirls.etc.site.client.etcsite.top;

import java.util.Map;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.google.web.bindery.event.shared.EventBus;

import edu.arizona.sirls.etc.site.client.common.Authentication;
import edu.arizona.sirls.etc.site.client.content.fileManager.FileManagerPlace;
import edu.arizona.sirls.etc.site.client.content.help.HelpPlace;
import edu.arizona.sirls.etc.site.client.content.home.HomePlace;
import edu.arizona.sirls.etc.site.client.content.settings.SettingsPlace;
import edu.arizona.sirls.etc.site.client.content.taskManager.ResumableTasksEvent;
import edu.arizona.sirls.etc.site.client.content.taskManager.TaskManagerPlace;
import edu.arizona.sirls.etc.site.client.etcsite.top.ITopView.Presenter;
import edu.arizona.sirls.etc.site.shared.db.Task;
import edu.arizona.sirls.etc.site.shared.rpc.ITaskServiceAsync;
import edu.arizona.sirls.etc.site.shared.rpc.RPCCallback;

public class LoggedInActivity implements Activity, Presenter {

	private PlaceController placeController;
	private ITopView topView;
	private Timer resumableTasksTimer;

	@Inject
	public LoggedInActivity(ITopView topView, PlaceController placeController, 
			final ITaskServiceAsync taskService, @Named("Tasks") final EventBus tasksBus) {
		this.topView = topView;
		this.placeController = placeController;
		this.resumableTasksTimer = new Timer() {
	        public void run() {
	        	taskService.getResumableTasks(Authentication.getInstance().getToken(), new RPCCallback<Map<Integer, Task>>() {
					@Override
					public void onResult(Map<Integer, Task> result) {
						tasksBus.fireEvent(new ResumableTasksEvent(result));
					}
	    		});
	        }
		};
	}
	
	@Override
	public void start(AcceptsOneWidget panel, com.google.gwt.event.shared.EventBus eventBus) {
		topView.setPresenter(this);
		panel.setWidget(topView.asWidget());
		this.resumableTasksTimer.scheduleRepeating(1000);
	}
	
	@Override
	public String mayStop() {
		return null;
	}

	@Override
	public void onCancel() {
		if(resumableTasksTimer != null)
			resumableTasksTimer.cancel();
	}

	@Override
	public void onStop() {
		if(resumableTasksTimer != null)
			resumableTasksTimer.cancel();
	}

	@Override
	public void onFileManager() {
		placeController.goTo(new FileManagerPlace());
	}

	@Override
	public void onTaskManager() {
		placeController.goTo(new TaskManagerPlace());
	}

	@Override
	public void onHome() {
		placeController.goTo(new HomePlace());
	}

	@Override
	public void onSettings() {
		placeController.goTo(new SettingsPlace());
	}

	@Override
	public void onHelp() {
		placeController.goTo(new HelpPlace());
	}

	@Override
	public void onLogout() {
		Authentication.getInstance().destroy();
		placeController.goTo(new LoggedOutPlace());
	}
}
