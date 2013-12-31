package edu.arizona.sirls.etc.site.shared.rpc;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.arizona.sirls.etc.site.shared.db.Task;
import edu.arizona.sirls.etc.site.shared.rpc.matrixGeneration.Matrix;
import edu.arizona.sirls.etc.site.shared.rpc.matrixGeneration.TaskStageEnum;
import edu.arizona.sirls.etc.site.shared.rpc.semanticMarkup.LearnInvocation;
import edu.arizona.sirls.etc.site.shared.rpc.semanticMarkup.ParseInvocation;
import edu.arizona.sirls.etc.site.shared.rpc.semanticMarkup.PreprocessedDescription;

@RemoteServiceRelativePath("matrixGeneration")
public interface IMatrixGenerationService extends RemoteService {

	public RPCResult<Task> start(AuthenticationToken authenticationToken, String taskName, String input);
	
	public RPCResult<Task> process(AuthenticationToken authenticationToken, Task task);
	
	public RPCResult<Matrix> review(AuthenticationToken authenticationToken, Task task);
	
	public RPCResult<Task> completeReview(AuthenticationToken authenticationToken, Task task);
	
	public RPCResult<Task> output(AuthenticationToken authenticationToken, Task task);

	public RPCResult<Task> getLatestResumable(AuthenticationToken authenticationToken);
	
	public RPCResult<Void> cancel(AuthenticationToken authenticationToken, Task task);

	public RPCResult<Void> save(AuthenticationToken authenticationToken, Matrix matrix, Task task);
	
	public RPCResult<Task> goToTaskStage(AuthenticationToken authenticationToken, Task task, TaskStageEnum review);

}
