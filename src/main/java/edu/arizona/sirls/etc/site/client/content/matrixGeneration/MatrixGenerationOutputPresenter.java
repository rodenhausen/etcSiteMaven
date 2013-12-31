package edu.arizona.sirls.etc.site.client.content.matrixGeneration;

import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;

import edu.arizona.sirls.etc.site.client.common.Authentication;
import edu.arizona.sirls.etc.site.client.content.fileManager.FileManagerPlace;
import edu.arizona.sirls.etc.site.shared.db.MatrixGenerationConfiguration;
import edu.arizona.sirls.etc.site.shared.db.Task;
import edu.arizona.sirls.etc.site.shared.file.FilePathShortener;
import edu.arizona.sirls.etc.site.shared.rpc.IMatrixGenerationServiceAsync;
import edu.arizona.sirls.etc.site.shared.rpc.RPCCallback;
import edu.arizona.sirls.etc.site.shared.rpc.RPCResult;

public class MatrixGenerationOutputPresenter implements IMatrixGenerationOutputView.Presenter {

	private Task task;
	private IMatrixGenerationOutputView view;
	private PlaceController placeController;
	private IMatrixGenerationServiceAsync matrixGenerationService;
	private FilePathShortener filePathShortener;

	@Inject
	public MatrixGenerationOutputPresenter(IMatrixGenerationOutputView view, 
			PlaceController placeController, 
			IMatrixGenerationServiceAsync matrixGenerationService, 
			FilePathShortener filePathShortener) {
		this.view = view;
		view.setPresenter(this);
		this.placeController = placeController;
		this.matrixGenerationService = matrixGenerationService;
		this.filePathShortener = filePathShortener;
	}
	
	@Override
	public void onFileManager() {
		placeController.goTo(new FileManagerPlace());
	}

	@Override
	public IMatrixGenerationOutputView getView() {
		return view;
	}

	@Override
	public void setTask(Task task) {
		matrixGenerationService.output(Authentication.getInstance().getToken(), task, 
				new RPCCallback<Task>() {
			@Override
			public void onResult(Task result) {
				String output = ((MatrixGenerationConfiguration)result.getConfiguration()).getOutput();
				view.setOutput(filePathShortener.shortenOutput(output, result, Authentication.getInstance().getUsername()));
			}
		});
	}


}
