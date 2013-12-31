package edu.arizona.sirls.etc.site.client.content.matrixGeneration;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

import edu.arizona.sirls.etc.site.client.common.ImageLabel;
import edu.arizona.sirls.etc.site.shared.rpc.matrixGeneration.TaskStageEnum;

public class SubMenu extends Composite {

	private static SubmenuUiBinder uiBinder = GWT.create(SubmenuUiBinder.class);

	interface SubmenuUiBinder extends UiBinder<Widget, SubMenu> {
	}
	
	@UiField
	ImageLabel input;
	
	@UiField
	ImageLabel process;
	
	@UiField
	ImageLabel review;
	
	@UiField
	ImageLabel output;

	public SubMenu() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setStep(TaskStageEnum taskStage) {
		switch(taskStage) {
		case INPUT:
			input.setImage("images/Enumeration_1.gif");
			break;
		case PROCESS:
			process.setImage("images/Enumeration_2.gif");
			break;
		case REVIEW:
			review.setImage("images/Enumeration_3.gif");
			break;
		case OUTPUT:
			output.setImage("images/Enumeration_4.gif");
			break;
		default:
			input.setImage("images/Enumeration_1.gif");
		}
	}

}
