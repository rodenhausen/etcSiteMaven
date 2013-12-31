package edu.arizona.sirls.etc.site.client.content.semanticMarkup;

import com.google.gwt.user.client.ui.IsWidget;

import edu.arizona.sirls.etc.site.shared.db.Task;

public interface ISemanticMarkupParseView extends IsWidget {

	public interface Presenter {

		void setTask(Task task);

		IsWidget getView();

		void onTaskManager();

		void onNext();
		
	}
	
	void setPresenter(Presenter presenter);

	void setNonResumable();

	void setResumable();
}
