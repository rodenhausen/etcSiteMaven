package edu.arizona.sirls.etc.site.client.common.files;

import gwtupload.client.IUploader;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

import edu.arizona.sirls.etc.site.shared.file.FileFilter;

public interface IManagableFileTreeView extends IsWidget {

	public interface Presenter {

		void onCreate();

		void onRename();

		void onDelete();

		void onDownload();

		IsWidget getView();
		
		void refresh(FileFilter fileFilter);

	}

	void setPresenter(Presenter presenter);

	IUploader getUploader();

	void setEnabledCreateDirectory(boolean value);

	void setEnabledRename(boolean value);

	void setEnabledDelete(boolean value);

	void setEnabledUpload(boolean value);

	void setStatusWidget(Widget widget);

	Button getAddButton();

}
