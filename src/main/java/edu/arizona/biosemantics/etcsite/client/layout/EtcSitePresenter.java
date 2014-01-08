package edu.arizona.biosemantics.etcsite.client.layout;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;

import edu.arizona.biosemantics.etcsite.client.content.home.IHomeContentView;
import edu.arizona.biosemantics.etcsite.client.menu.IMenuView;
import edu.arizona.biosemantics.etcsite.client.menu.IStartMenuView;
import edu.arizona.biosemantics.etcsite.client.top.ILoginTopView;
import edu.arizona.biosemantics.etcsite.client.top.ITopView;

public class EtcSitePresenter implements IEtcSiteView.Presenter {

	private IEtcSiteView view;
	private IMenuView menuView;
	private IStartMenuView startMenuView;
	private IHomeContentView startContentView;
	private ITopView topView;
	private ILoginTopView loginTopView;
	
	@Inject
	public EtcSitePresenter(IEtcSiteView view, ITopView topView, ILoginTopView loginTopView, IMenuView menuView, IStartMenuView startMenuView, IHomeContentView startContentView) {
		this.view = view;
		view.setPresenter(this);
		this.topView = topView;
		this.loginTopView = loginTopView;
		this.menuView = menuView;
		this.startMenuView = startMenuView;
		this.startContentView = startContentView;
	}
	
	@Override
	public void setLoggedIn() {
		view.setTop(topView);
	}
	
	@Override
	public void setLoggedOut() {
		view.setTop(loginTopView);
	}
	
	@Override
	public void setStart() {
		view.setMenu(startMenuView);
		view.setContent(startContentView);
	}
	
	@Override
	public void setContent(IsWidget content) {
		view.setMenu(menuView);
		menuView.initNativeJavascriptAnimations();
		view.setContent(content);
	}

}
