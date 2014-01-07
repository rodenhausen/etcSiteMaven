package edu.arizona.biosemantics.etcsite.client.layout;

import com.google.gwt.user.client.ui.IsWidget;
import com.google.inject.Inject;

import edu.arizona.biosemantics.etcsite.client.content.home.IHomeContentView;
import edu.arizona.biosemantics.etcsite.client.menu.IMenuView;
import edu.arizona.biosemantics.etcsite.client.menu.IStartMenuView;
import edu.arizona.biosemantics.etcsite.client.top.ILoginTopView;
import edu.arizona.biosemantics.etcsite.client.top.ITopView;

public class EtcSitePresenter implements IEtcSiteView.Presenter, IMenuView.Presenter, IStartMenuView.Presenter, IHomeContentView.Presenter, ITopView.Presenter, ILoginTopView.Presenter {

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
		topView.setPresenter(this);
		this.loginTopView = loginTopView;
		loginTopView.setPresenter(this);
		this.menuView = menuView;
		menuView.setPresenter(this);
		this.startMenuView = startMenuView;
		startMenuView.setPresenter(this);
		this.startContentView = startContentView;
		startContentView.setPresenter(this);
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

	@Override
	public void onSemanticMarkup() {

	}

	@Override
	public void onMatrixGeneration() {
		
	}

	@Override
	public void onTreeGeneration() {
		
	}

	@Override
	public void onTaxonomyComparison() {
		
	}

	@Override
	public void onVisualization() {
		
	}
	
	@Override
	public void onPipeline() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onHelp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLogin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFileManager() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTaskManager() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onHome() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSettings() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLogout() {
		// TODO Auto-generated method stub
		
	}



}
