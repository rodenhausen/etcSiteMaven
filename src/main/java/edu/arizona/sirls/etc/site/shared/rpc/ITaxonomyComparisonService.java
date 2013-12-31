package edu.arizona.sirls.etc.site.shared.rpc;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.arizona.sirls.etc.site.shared.db.Task;
import edu.arizona.sirls.etc.site.shared.db.TaxonomyComparisonConfiguration;

@RemoteServiceRelativePath("taxonomyComparison")
public interface ITaxonomyComparisonService extends RemoteService  {
	
	public RPCResult<Task> getTaxonomyComparisonTask(AuthenticationToken authenticationToken, Task task);

}
