package edu.arizona.sirls.etc.site.client.content.user;

import java.util.List;

import com.google.inject.Inject;

import edu.arizona.sirls.etc.site.client.common.Authentication;
import edu.arizona.sirls.etc.site.shared.db.ShortUser;
import edu.arizona.sirls.etc.site.shared.rpc.IUserServiceAsync;
import edu.arizona.sirls.etc.site.shared.rpc.RPCCallback;

public class UsersPresenter implements UsersView.Presenter {

	private IUsersView view;
	private IUserServiceAsync userService;

	@Inject
	public UsersPresenter(IUsersView view, IUserServiceAsync userService) {
		this.view = view;
		view.setPresenter(this);
		this.userService = userService;
		this.refresh();
	}
	
	public void refresh() {
		userService.getUsers(Authentication.getInstance().getToken(), false, new RPCCallback<List<ShortUser>>() {
			@Override
			public void onResult(List<ShortUser> result) {
				view.setUsers(result);
			}
		});
	}

}
