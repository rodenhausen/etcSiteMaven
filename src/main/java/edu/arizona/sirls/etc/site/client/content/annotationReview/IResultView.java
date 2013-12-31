package edu.arizona.sirls.etc.site.client.content.annotationReview;

import java.util.List;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;

import edu.arizona.sirls.etc.site.shared.file.search.SearchResult;

public interface IResultView extends IsWidget {
	
	  public interface Presenter {
		void onTargetClicked(String target);
	  }
	  
	  void setPresenter(Presenter presenter);
	  void setResult(List<SearchResult> result);
	  Widget asWidget();

}
