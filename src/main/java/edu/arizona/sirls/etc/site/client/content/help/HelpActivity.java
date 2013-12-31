package edu.arizona.sirls.etc.site.client.content.help;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.inject.Inject;

import edu.arizona.sirls.etc.site.client.content.help.IHelpView.Presenter;
import edu.arizona.sirls.etc.site.client.etcsite.top.ILoginTopView;
import edu.arizona.sirls.etc.site.shared.rpc.IAuthenticationServiceAsync;

public class HelpActivity extends AbstractActivity implements Presenter {

	private IHelpView helpView;
	private PlaceController placeController;

	@Inject
	public HelpActivity(IHelpView helpView, PlaceController placeController) {
		this.placeController = placeController;
		this.helpView = helpView;
	}
	
	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		helpView.setPresenter(this);
		panel.setWidget(helpView.asWidget());
	}

}
