package edu.arizona.sirls.etc.site.client.content.semanticMarkup;

import com.google.gwt.user.client.ui.IsWidget;

import edu.arizona.sirls.etc.site.shared.db.Task;

public interface ISemanticMarkupPreprocessView extends IsWidget {

	public interface Presenter {

		void setTask(Task task);

		IsWidget getView();

		void onNext();

		void onNextDescription();

		void onPreviousDescription();

		void onValueChange();
		
	}
	
	void setPresenter(Presenter presenter);

	String getText();

	void setBracketCounts(String bracketHTML);

	void setDescriptionIDLabel(String text);

	void setText(String text);

	void setEnabledNextDescriptionButton(boolean value);
	
	void setEnabledPreviousDescriptionButton(boolean value);
	
}
