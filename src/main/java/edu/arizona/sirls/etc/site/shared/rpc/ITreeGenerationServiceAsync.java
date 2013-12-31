package edu.arizona.sirls.etc.site.shared.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.arizona.sirls.etc.site.shared.db.Task;

public interface ITreeGenerationServiceAsync {

	public void getTreeGenerationTask(AuthenticationToken authenticationToken, Task task, AsyncCallback<RPCResult<Task>> asyncCallback);

}
