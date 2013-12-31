package edu.arizona.sirls.etc.site.client.content.semanticMarkup;

import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.TitleCloseDialogBox;
import com.google.inject.Inject;
import com.google.inject.name.Named;

import edu.arizona.sirls.etc.site.client.common.Authentication;
import edu.arizona.sirls.etc.site.client.common.IMessageView;
import edu.arizona.sirls.etc.site.client.common.files.FileImageLabelTreeItem;
import edu.arizona.sirls.etc.site.client.common.files.IFileTreeView;
import edu.arizona.sirls.etc.site.client.common.files.IManagableFileTreeView;
import edu.arizona.sirls.etc.site.client.common.files.IManagableFileTreeView.Presenter;
import edu.arizona.sirls.etc.site.client.common.files.SelectableFileTreePresenter.ISelectListener;
import edu.arizona.sirls.etc.site.client.common.files.ISelectableFileTreeView;
import edu.arizona.sirls.etc.site.client.content.fileManager.IFileManagerView;
import edu.arizona.sirls.etc.site.client.content.matrixGeneration.MatrixGenerationProcessPlace;
import edu.arizona.sirls.etc.site.shared.db.Task;
import edu.arizona.sirls.etc.site.shared.file.FileFilter;
import edu.arizona.sirls.etc.site.shared.file.FilePathShortener;
import edu.arizona.sirls.etc.site.shared.rpc.ISemanticMarkupServiceAsync;
import edu.arizona.sirls.etc.site.shared.rpc.RPCCallback;

public class SemanticMarkupInputPresenter implements ISemanticMarkupInputView.Presenter {

	private ISemanticMarkupInputView view;
	private PlaceController placeController;
	private ISemanticMarkupServiceAsync semanticMarkupService;
	private Presenter managableFileTreePresenter;
	private edu.arizona.sirls.etc.site.client.common.files.ISelectableFileTreeView.Presenter selectableFileTreePresenter;
	private edu.arizona.sirls.etc.site.client.common.files.IFileTreeView.Presenter fileTreePresenter;
	private edu.arizona.sirls.etc.site.client.common.IMessageView.Presenter messagePresenter;
	private FilePathShortener filePathShortener;
	private TitleCloseDialogBox dialogBox;
	private String inputFile;

	@Inject
	public SemanticMarkupInputPresenter(ISemanticMarkupInputView view, PlaceController 
			placeController, ISemanticMarkupServiceAsync semanticMarkupService, 
			IFileManagerView fileManagerView, 
			IManagableFileTreeView.Presenter managableFileTreePresenter,
			ISelectableFileTreeView.Presenter selectableFileTreePresenter,
			@Named("Selectable")IFileTreeView.Presenter fileTreePresenter,
			IMessageView.Presenter messagePresenter, 
			FilePathShortener filePathShortener) {
		this.view = view;
		view.setPresenter(this);
		this.placeController = placeController;
		this.semanticMarkupService = semanticMarkupService;
		
		this.managableFileTreePresenter = managableFileTreePresenter;
		this.selectableFileTreePresenter = selectableFileTreePresenter;
		this.fileTreePresenter = fileTreePresenter;
		this.messagePresenter = messagePresenter;
		this.filePathShortener = filePathShortener;
		
		this.dialogBox = new TitleCloseDialogBox(false, "File Manager");
		dialogBox.setWidget(fileManagerView);
		dialogBox.setGlassEnabled(true);
	}
	
	@Override
	public IsWidget getView() {
		return view;
	}

	@Override
	public void onNext() {
		semanticMarkupService.start(Authentication.getInstance().getToken(), 
				view.getTaskName(), inputFile, view.getGlossaryName(), new RPCCallback<Task>() {
					@Override
					public void onResult(Task result) {
						placeController.goTo(new SemanticMarkupPreprocessPlace(result));
					}
		});
	}

	@Override
	public void onInput() {
		selectableFileTreePresenter.show("Select input", FileFilter.DIRECTORY, new ISelectListener() {
			@Override
			public void onSelect() {
				FileImageLabelTreeItem selection = fileTreePresenter.getSelectedItem();
				if (selection != null) {
					inputFile = selection.getFileInfo().getFilePath();
					String shortendPath = filePathShortener.shorten(selection.getFileInfo(), Authentication.getInstance().getUsername());
					view.setInput(shortendPath);
					view.setEnabledNext(true);			
					if(!selection.getFileInfo().getOwner().equals(Authentication.getInstance().getUsername())) {
						messagePresenter.showMessage("Shared input", "The selected input is not owned. To start the task the files will be copied to your own space.");
						dialogBox.hide();
					} else {
						dialogBox.hide();
					}
				}
			}
		});
	}

	@Override
	public void onFileManager() {
 		dialogBox.show();
 		managableFileTreePresenter.refresh(FileFilter.ALL);
	}

}
