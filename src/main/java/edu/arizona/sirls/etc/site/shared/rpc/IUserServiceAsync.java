package edu.arizona.sirls.etc.site.shared.rpc;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.arizona.sirls.etc.site.shared.db.ShortUser;

public interface IUserServiceAsync {

	public void getUsers(AuthenticationToken authenticationToken, boolean includeSelf, AsyncCallback<RPCResult<List<ShortUser>>> callback);
	
}
