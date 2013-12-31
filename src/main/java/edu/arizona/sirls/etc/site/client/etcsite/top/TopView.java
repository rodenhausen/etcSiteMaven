package edu.arizona.sirls.etc.site.client.etcsite.top;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

import edu.arizona.sirls.etc.site.client.common.ImageLabel;

public class TopView extends Composite implements ITopView {

	private static TopViewUiBinder uiBinder = GWT.create(TopViewUiBinder.class);

	interface TopViewUiBinder extends UiBinder<Widget, TopView> {
	}

	private Presenter presenter;

	@UiField
	Button logoutButton;
	
	@UiField
	ImageLabel home;
	
	@UiField
	ImageLabel taskManager;
	
	@UiField
	ImageLabel fileManager;
	
	@UiField
	ImageLabel settings;
	
	@UiField
	ImageLabel help;
	
	public TopView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
	
	@UiHandler("help")
	public void onHelp(ClickEvent event) {
		presenter.onHelp();
	}
	
	@UiHandler("taskManager")
	public void onTaskManager(ClickEvent event) {
		presenter.onTaskManager();
	}
	
	@UiHandler("fileManager")
	public void onFileManager(ClickEvent event) {
		presenter.onFileManager();
	}
	
	@UiHandler("settings")
	public void onSettings(ClickEvent event) {
		presenter.onSettings();
	}
	
	@UiHandler("home")
	public void onHome(ClickEvent event) {
		presenter.onHome();
	}
	
	@UiHandler("logoutButton")
	public void onLogout(ClickEvent event) {
		presenter.onLogout();
	}

}
