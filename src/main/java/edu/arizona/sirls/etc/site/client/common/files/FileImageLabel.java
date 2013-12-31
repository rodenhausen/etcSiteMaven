package edu.arizona.sirls.etc.site.client.common.files;

import edu.arizona.sirls.etc.site.client.common.ImageLabel;
import edu.arizona.sirls.etc.site.shared.file.FileInfo;

public class FileImageLabel extends ImageLabel {
	
	private FileImageLabelTreeItem fileTreeItem;
	
	public FileImageLabel(FileImageLabelTreeItem fileTreeItem, String imageUri, String width,
			String height, String label) {
		super(imageUri, width, height, label);
		this.fileTreeItem = fileTreeItem;
	}

	public FileInfo getFileInfo() {
		return fileTreeItem.getFileInfo();
	}

	public FileImageLabelTreeItem getFileTreeItem() {
		return fileTreeItem;
	}
	
}
