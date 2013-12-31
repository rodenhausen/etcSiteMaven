package edu.arizona.sirls.etc.site.client.content.annotationReview;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.inject.Inject;

import edu.arizona.sirls.etc.site.shared.rpc.IFileAccessServiceAsync;
import edu.arizona.sirls.etc.site.shared.rpc.IFileFormatServiceAsync;
import edu.arizona.sirls.etc.site.shared.rpc.IFileSearchServiceAsync;
 
public class AnnotationReviewView extends Composite implements IAnnotationReviewView {
 
    private static AnnotationReviewViewUiBinder uiBinder = GWT.create(AnnotationReviewViewUiBinder.class);

	@UiTemplate("AnnotationReviewView.ui.xml")
	interface AnnotationReviewViewUiBinder extends UiBinder<Widget, AnnotationReviewView> {
	}
	
    @UiField(provided=true)
    ISearchView search;
    @UiField(provided=true)
    IResultView result;    
    @UiField(provided=true)
    IXMLEditorView xmlEditor;
    
	private Presenter presenter;

	@Inject
    public AnnotationReviewView(ISearchView search, IResultView result, IXMLEditorView xmlEditor,
    		IFileAccessServiceAsync fileAccessService, IFileFormatServiceAsync fileFormatService, IFileSearchServiceAsync fileSearchService) {
    	this.search = search;
        this.result = result;
        this.xmlEditor = xmlEditor;
    	initWidget(uiBinder.createAndBindUi(this));
    }

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
}