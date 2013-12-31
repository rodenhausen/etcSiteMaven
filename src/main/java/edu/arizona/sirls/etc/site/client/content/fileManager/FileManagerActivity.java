package edu.arizona.sirls.etc.site.client.content.fileManager;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

import edu.arizona.sirls.etc.site.client.common.files.IManagableFileTreeView;
import edu.arizona.sirls.etc.site.client.content.fileManager.IFileManagerView.Presenter;
import edu.arizona.sirls.etc.site.shared.file.FileFilter;

public class FileManagerActivity implements Activity, Presenter {

	private PlaceController placeController;
	private IManagableFileTreeView.Presenter managableFileTreePresenter;
	
	@Inject
	public FileManagerActivity(PlaceController placeController, 
			IManagableFileTreeView.Presenter managableFileTreePresenter) {
		super();
		this.placeController = placeController;
		this.managableFileTreePresenter = managableFileTreePresenter;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		panel.setWidget(managableFileTreePresenter.getView());
		managableFileTreePresenter.refresh(FileFilter.ALL);
	}

	@Override
	public String mayStop() {
		return null;
	}

	@Override
	public void onCancel() { }

	@Override
	public void onStop() { }
	
}
