package edu.arizona.sirls.etc.site.shared.rpc;

import java.io.IOException;
import java.sql.SQLException;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import edu.arizona.sirls.etc.site.shared.file.FilePermissionType;

@RemoteServiceRelativePath("filePermission")
public interface IFilePermissionService extends RemoteService {

	public RPCResult<Boolean> hasReadPermission(AuthenticationToken authenticationToken, String filePath);
	
	public RPCResult<Boolean> hasWritePermission(AuthenticationToken authenticationToken, String filePath);
	
	public RPCResult<FilePermissionType> getPermissionType(AuthenticationToken authenticationToken, String filePath);
	
	public RPCResult<Boolean> isSharedFilePath(String username, String filePath);

	public RPCResult<Boolean> isOwnedFilePath(String username, String filePath);
}
