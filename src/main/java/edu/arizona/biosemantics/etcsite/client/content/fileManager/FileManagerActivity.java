package edu.arizona.biosemantics.etcsite.client.content.fileManager;

import com.google.gwt.activity.shared.MyActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;

import edu.arizona.biosemantics.etcsite.client.common.files.IManagableFileTreeView;
import edu.arizona.biosemantics.etcsite.client.content.annotationReview.AnnotationReviewPlace;
import edu.arizona.biosemantics.etcsite.client.content.fileManager.IFileManagerView.Presenter;
import edu.arizona.biosemantics.etcsite.shared.file.FileFilter;

public class FileManagerActivity implements MyActivity, Presenter {

	private PlaceController placeController;
	private IFileManagerView fileManagerView;
	private IManagableFileTreeView.Presenter managableFileTreePresenter;
	
	@Inject
	public FileManagerActivity(PlaceController placeController, 
			IFileManagerView fileManagerView, 
			IManagableFileTreeView.Presenter managableFileTreePresenter) {
		super();
		this.placeController = placeController;
		this.fileManagerView = fileManagerView;
		fileManagerView.setPresenter(this);
		this.managableFileTreePresenter = managableFileTreePresenter;
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		panel.setWidget(fileManagerView);
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

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onAnnotationReview() {
		placeController.goTo(new AnnotationReviewPlace());
	}

	@Override
	public IsWidget getView() {
		return fileManagerView;
	}

}
