package edu.arizona.sirls.etc.site.client.content.annotationReview;

import java.util.List;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import com.google.web.bindery.event.shared.EventBus;

import edu.arizona.sirls.etc.site.client.common.Authentication;
import edu.arizona.sirls.etc.site.client.common.files.FileImageLabelTreeItem;
import edu.arizona.sirls.etc.site.client.common.files.FileTreePresenter;
import edu.arizona.sirls.etc.site.client.common.files.IFileTreeView;
import edu.arizona.sirls.etc.site.client.common.files.ISelectableFileTreeView;
import edu.arizona.sirls.etc.site.client.common.files.SelectableFileTreePresenter.ISelectListener;
import edu.arizona.sirls.etc.site.shared.file.search.Search;
import edu.arizona.sirls.etc.site.shared.file.search.SearchResult;
import edu.arizona.sirls.etc.site.shared.rpc.AuthenticationToken;
import edu.arizona.sirls.etc.site.shared.rpc.IFileSearchServiceAsync;
import edu.arizona.sirls.etc.site.shared.rpc.IFileServiceAsync;
import edu.arizona.sirls.etc.site.shared.rpc.RPCCallback;
import edu.arizona.sirls.etc.site.shared.file.FileFilter;

public class SearchPresenter implements ISearchView.Presenter {

	private ISearchView view;
	private Search search;
	private IFileSearchServiceAsync fileSearchService;
	private IFileServiceAsync fileService;
	protected String input;
	private EventBus eventBus;
	private ISelectableFileTreeView.Presenter selectableFileTreePresenter;
	private IFileTreeView.Presenter fileTreePresenter;

	@Inject
	public SearchPresenter(@Named("AnnotationReview")EventBus eventBus, ISearchView view, IFileServiceAsync fileService, IFileSearchServiceAsync fileSearchService, 
			ISelectableFileTreeView.Presenter selectableFileTreePresenter, @Named("Selectable")IFileTreeView.Presenter fileTreePresenter) {
		this.eventBus = eventBus;
		this.view = view;
		view.setPresenter(this);
		this.fileService = fileService;
		this.fileSearchService = fileSearchService;
		this.fileTreePresenter = fileTreePresenter;
		this.selectableFileTreePresenter = selectableFileTreePresenter;
		view.setPresenter(this);
		view.setEnabled(false);
	}

	@Override
	public void onSearchButtonClicked(Search search) {
		this.search = search;
		if(search != null) {
			fileSearchService.search(Authentication.getInstance().getToken(), input, search,
					new RPCCallback<List<SearchResult>>() {
				@Override
				public void onResult(List<SearchResult> result) {
					eventBus.fireEvent(new SearchResultEvent(result));
				}
			});
		}
	}

	@Override
	public void onInputButtonClicked() {
		selectableFileTreePresenter.show("Select File", FileFilter.DIRECTORY, new ISelectListener() {
			@Override
			public void onSelect() {
				FileImageLabelTreeItem selection = fileTreePresenter.getSelectedItem();
				if(selection != null) {
					SearchPresenter.this.input = selection.getFileInfo().getFilePath();
					SearchPresenter.this.view.setInput(selection.getFileInfo().getFilePath());
					SearchPresenter.this.view.setEnabled(true);
				}
			}
		});
	}

}
