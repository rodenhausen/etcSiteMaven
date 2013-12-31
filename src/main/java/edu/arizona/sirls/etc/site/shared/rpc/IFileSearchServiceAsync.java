package edu.arizona.sirls.etc.site.shared.rpc;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

import edu.arizona.sirls.etc.site.shared.file.search.Search;
import edu.arizona.sirls.etc.site.shared.file.search.SearchResult;

public interface IFileSearchServiceAsync {

	public void search(AuthenticationToken authenticationToken, String filePath, Search search, AsyncCallback<RPCResult<List<SearchResult>>> callback);

	public void getFileContentSearched(AuthenticationToken authenticationToken, String filePath, Search search, AsyncCallback<RPCResult<String>> callback);
	
}
