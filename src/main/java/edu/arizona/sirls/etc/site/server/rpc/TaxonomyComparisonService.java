package edu.arizona.sirls.etc.site.server.rpc;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.arizona.sirls.etc.site.shared.db.Task;
import edu.arizona.sirls.etc.site.shared.db.TaxonomyComparisonConfiguration;
import edu.arizona.sirls.etc.site.shared.rpc.AuthenticationResult;
import edu.arizona.sirls.etc.site.shared.rpc.AuthenticationToken;
import edu.arizona.sirls.etc.site.shared.rpc.IAuthenticationService;
import edu.arizona.sirls.etc.site.shared.rpc.ITaxonomyComparisonService;
import edu.arizona.sirls.etc.site.shared.rpc.RPCResult;

public class TaxonomyComparisonService extends RemoteServiceServlet implements ITaxonomyComparisonService {
	
	@Override
	public RPCResult<Task> getTaxonomyComparisonTask(AuthenticationToken authenticationToken, Task task) {
		
		return null;
	}

}
