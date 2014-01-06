package edu.arizona.biosemantics.etcsite.client.content.fileManager;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import edu.arizona.biosemantics.etcsite.client.common.files.IManagableFileTreeView;

public class FileManagerView extends Composite implements IFileManagerView {

	private static FileManagerViewUiBinder uiBinder = GWT.create(FileManagerViewUiBinder.class);

	interface FileManagerViewUiBinder extends UiBinder<Widget, FileManagerView> {
	}

	private Presenter presenter;
	
	@UiField(provided = true)
	IManagableFileTreeView managableFileTreeView;
	
	@Inject
	public FileManagerView(IManagableFileTreeView managableFileTreeView) {
		this.managableFileTreeView = managableFileTreeView;
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

}
