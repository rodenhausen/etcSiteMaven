package edu.arizona.sirls.etc.site.client.content.semanticMarkup;

import com.google.gwt.user.client.ui.IsWidget;

import edu.arizona.sirls.etc.site.shared.db.Task;

public interface ISemanticMarkupOutputView extends IsWidget {

	public interface Presenter {

		void setTask(Task task);

		IsWidget getView();

		void onFileManager();
		
	}
	
	void setPresenter(Presenter presenter);

	void setOutput(String output);
	
}
