package edu.arizona.biosemantics.etcsite.client.content.fileManager;

import com.google.gwt.user.client.ui.IsWidget;

public interface IFileManagerView extends IsWidget {

	public interface Presenter {

	}

	void setPresenter(Presenter presenter);
	
}
