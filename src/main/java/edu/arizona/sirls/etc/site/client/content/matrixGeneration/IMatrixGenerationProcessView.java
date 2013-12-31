package edu.arizona.sirls.etc.site.client.content.matrixGeneration;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

import edu.arizona.sirls.etc.site.shared.db.Task;

public interface IMatrixGenerationProcessView extends IsWidget {

	public interface Presenter {
		void onNext();
		void onTaskManager();
		IMatrixGenerationProcessView getView();
		void setTask(Task task);
	}
	  
	void setPresenter(Presenter presenter);
	Widget asWidget();
	void setNonResumable();
	void setResumable();
	
}
