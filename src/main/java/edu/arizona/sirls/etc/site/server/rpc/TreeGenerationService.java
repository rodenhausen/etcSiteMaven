package edu.arizona.sirls.etc.site.server.rpc;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

import edu.arizona.sirls.etc.site.shared.db.Task;
import edu.arizona.sirls.etc.site.shared.db.TreeGenerationConfiguration;
import edu.arizona.sirls.etc.site.shared.rpc.AuthenticationResult;
import edu.arizona.sirls.etc.site.shared.rpc.AuthenticationToken;
import edu.arizona.sirls.etc.site.shared.rpc.IAuthenticationService;
import edu.arizona.sirls.etc.site.shared.rpc.ITreeGenerationService;
import edu.arizona.sirls.etc.site.shared.rpc.RPCResult;

public class TreeGenerationService extends RemoteServiceServlet implements ITreeGenerationService {
	
	@Override
	public RPCResult<Task> getTreeGenerationTask(AuthenticationToken authenticationToken, Task task) {
		
		return null;
	}

}
