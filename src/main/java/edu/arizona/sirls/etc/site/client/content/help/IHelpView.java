package edu.arizona.sirls.etc.site.client.content.help;

import com.google.gwt.user.client.ui.IsWidget;

public interface IHelpView extends IsWidget {

	public interface Presenter {
		
	}

	void setPresenter(Presenter presenter);
	
}
