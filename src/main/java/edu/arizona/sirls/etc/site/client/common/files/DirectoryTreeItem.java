package edu.arizona.sirls.etc.site.client.common.files;

import edu.arizona.sirls.etc.site.shared.file.FileInfo;

public class DirectoryTreeItem extends FileImageLabelTreeItem {

	private String folderImage = "images/Folder.gif";
	
	public DirectoryTreeItem(String label, FileInfo fileInfo) {
		super(fileInfo);
		FileImageLabel fileComposite = new FileImageLabel(this, folderImage, "19px", "20px", label);
		super.setFileImageLabel(fileComposite);
	}
}
