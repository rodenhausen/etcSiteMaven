package edu.arizona.sirls.etc.site.client.common.files;

import com.google.gwt.user.client.ui.IsWidget;

import edu.arizona.sirls.etc.site.client.common.files.SelectableFileTreePresenter.ISelectListener;
import edu.arizona.sirls.etc.site.shared.file.FileFilter;

public interface ISelectableFileTreeView extends IsWidget {

	public interface Presenter {

		void onSelect();

		void onClose();

		ISelectableFileTreeView getView();

		void show(String title, FileFilter fileFilter,
				ISelectListener listener);
		
	}

	void setPresenter(Presenter presenter);
	
}
