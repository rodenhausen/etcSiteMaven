package edu.arizona.sirls.etc.site.shared.rpc;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.arizona.sirls.etc.site.shared.db.Task;
import edu.arizona.sirls.etc.site.shared.db.TaxonomyComparisonConfiguration;

public interface ITaxonomyComparisonServiceAsync {

	public void getTaxonomyComparisonTask(AuthenticationToken authenticationToken, Task task, AsyncCallback<RPCResult<Task>> asyncCallback);

}
