package edu.arizona.sirls.etc.site.client.layout;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.IsWidget;

public interface IEtcSiteView extends IsWidget {

	public interface Presenter {
		void setStart();
		void setContent(IsWidget content);
		void setLoggedIn();
		void setLoggedOut();
	}

	void setTop(IsWidget content);	
	void setMenu(IsWidget menu);
	void setContent(IsWidget content);
	void setPresenter(Presenter presenter);
	AcceptsOneWidget getContentContainer();
	AcceptsOneWidget getMenuContainer();
	AcceptsOneWidget getTopContainer();
	
}
