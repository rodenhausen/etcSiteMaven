package edu.arizona.sirls.etc.site.client.content.matrixGeneration.review;

import com.google.gwt.dom.client.NativeEvent;

public interface ClickHandler {
	
	public void onClick(com.google.gwt.cell.client.Cell.Context context, NativeEvent event);

	public void onDoubleClick(com.google.gwt.cell.client.Cell.Context context, NativeEvent event);

	public void onContext(com.google.gwt.cell.client.Cell.Context context, NativeEvent event);
	
}
