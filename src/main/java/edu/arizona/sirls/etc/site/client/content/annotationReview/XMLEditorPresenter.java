package edu.arizona.sirls.etc.site.client.content.annotationReview;

import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.google.web.bindery.event.shared.EventBus;

import edu.arizona.sirls.etc.site.shared.rpc.AuthenticationToken;
import edu.arizona.sirls.etc.site.shared.rpc.IFileAccessServiceAsync;
import edu.arizona.sirls.etc.site.shared.rpc.IFileFormatServiceAsync;
import edu.arizona.sirls.etc.site.shared.rpc.IFileSearchServiceAsync;
import edu.arizona.sirls.etc.site.shared.rpc.RPCResult;
import edu.arizona.sirls.etc.site.shared.file.FileTypeEnum;

public class XMLEditorPresenter implements IXMLEditorView.Presenter {

	private final IXMLEditorView view;
	private IFileAccessServiceAsync fileAccessService;
	private IFileFormatServiceAsync fileFormatService;
	private IFileSearchServiceAsync fileSearchService;
	private String target;
	private EventBus eventBus;
	
	@Inject
	public XMLEditorPresenter(@Named("AnnotationReview")EventBus eventBus, IXMLEditorView view, IFileAccessServiceAsync fileAccessService, IFileFormatServiceAsync fileFormatService, 
			IFileSearchServiceAsync fileSearchService) {
		this.eventBus = eventBus;
		this.view = view;
		view.setPresenter(this);
		this.fileAccessService = fileAccessService;
		this.fileFormatService = fileFormatService;
		this.fileSearchService = fileSearchService;
		
		this.setEnabled(false);		
		eventBus.addHandler(TargetEvent.TYPE, new TargetEventHandler() {
			@Override
			public void onTarget(TargetEvent targetEvent) {
				XMLEditorPresenter.this.setTarget(targetEvent.getTarget());
			}
		});
	}
	
	@Override
	public void onSaveButtonClicked() {
		fileFormatService.isValidMarkedupTaxonDescriptionContent(new AuthenticationToken("test", ""), view.getText(), new AsyncCallback<RPCResult<Boolean>>() {
			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}
			@Override
			public void onSuccess(RPCResult<Boolean> result) {
				if(result.isSucceeded()) {
					if(result.getData()) {
						fileAccessService.setFileContent(new AuthenticationToken("test", ""), target, view.getText(), new AsyncCallback<RPCResult<Void>>() {
							@Override
							public void onFailure(Throwable caught) {
								caught.printStackTrace();
							}
							@Override
							public void onSuccess(RPCResult<Void> result) {
								Window.alert("Saved successfully");
							}
						});
					} else {
						Window.alert("Invalid format. Can't save.");
					}
				}
			}
		});
	}

	@Override
	public void onValidateButtonClicked() {
		/*byte[] bytes = view.getText().getBytes();
	    StringBuilder sb = new StringBuilder();
	    for (byte b : bytes) {
	    	 sb.append(Integer.toHexString(b & 0xFF) + " ");
	    }
	    System.out.println(sb.toString());*/
		
		fileFormatService.isValidMarkedupTaxonDescriptionContent(new AuthenticationToken("test", ""), view.getText(), new AsyncCallback<RPCResult<Boolean>>() {
			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}
			@Override
			public void onSuccess(RPCResult<Boolean> result) {
				if(result.isSucceeded()) {
					if(result.getData())
						Window.alert("Valid format");
					else
						Window.alert("Invalid format");
				}
			}
		});
	}
	
	@Override
	public void setTarget(String target) {
		this.setEnabled(true);
		this.target = target;
		fileAccessService.getFileContentHighlighted(new AuthenticationToken("test", ""), target, FileTypeEnum.TAXON_DESCRIPTION, new AsyncCallback<RPCResult<String>>() {
			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
			}
			@Override
			public void onSuccess(RPCResult<String> result) {
				if(result.isSucceeded())
					view.setText(result.getData());
			}
		}); 
	}

	public void setEnabled(boolean value) {
		this.view.setEnabled(value);
	}
}
