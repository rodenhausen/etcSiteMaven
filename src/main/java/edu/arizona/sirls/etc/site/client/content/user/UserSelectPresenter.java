package edu.arizona.sirls.etc.site.client.content.user;

import java.util.Set;

import com.google.gwt.user.client.ui.TitleCloseDialogBox;
import com.google.inject.Inject;

import edu.arizona.sirls.etc.site.shared.db.ShortUser;

public class UserSelectPresenter implements UserSelectView.Presenter {

	private IUserSelectView view;
	private TitleCloseDialogBox dialogBox;
	private ISelectListener currentListener;

	@Inject
	public UserSelectPresenter(IUserSelectView view) {
		this.view = view;
		view.setPresenter(this);
		this.dialogBox = new TitleCloseDialogBox("File Content");
		this.dialogBox.setGlassEnabled(true);
		this.dialogBox.setWidget(view);
		this.dialogBox.setTitle("User Selection");
		this.dialogBox.center();
	}
	
	@Override
	public void show(ISelectListener listener) {
		this.currentListener = listener;
		dialogBox.center();	
	}

	@Override
	public void onSelect(Set<ShortUser> users) {
		currentListener.onSelect(users);
		dialogBox.hide();
	}
	
	public interface ISelectListener {
		void onSelect(Set<ShortUser> user);
	}

	public void setSelected(Set<ShortUser> result) {
		// TODO Auto-generated method stub
		
	}

}
