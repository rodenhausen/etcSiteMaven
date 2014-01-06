package edu.arizona.biosemantics.etcsite.client.content.user;

import java.util.List;
import java.util.Set;

import com.google.gwt.user.client.ui.Widget;

import edu.arizona.biosemantics.etcsite.shared.db.ShortUser;

public interface IUsersView {

	public interface Presenter {
		
	}
	  
	void setUsers(List<ShortUser> users);
	void setPresenter(Presenter presenter);
	Widget asWidget();
	Set<ShortUser> getSelectedUsers();
	void setSelectedUsers(Set<ShortUser> selectedUsers);

}
