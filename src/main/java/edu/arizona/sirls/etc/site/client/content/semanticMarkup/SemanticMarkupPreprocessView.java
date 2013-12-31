package edu.arizona.sirls.etc.site.client.content.semanticMarkup;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

import edu.arizona.sirls.etc.site.client.common.ChangeAwareRichTextArea;

public class SemanticMarkupPreprocessView extends Composite implements ISemanticMarkupPreprocessView {

	private static SemanticMarkupPreprocessViewUiBinder uiBinder = GWT
			.create(SemanticMarkupPreprocessViewUiBinder.class);

	interface SemanticMarkupPreprocessViewUiBinder extends
			UiBinder<Widget, SemanticMarkupPreprocessView> {
	}

	private Presenter presenter;
	
	@UiField
	Label descriptionIdLabel;
	
	@UiField
	HTML bracketCounts;
	
	@UiField
	ChangeAwareRichTextArea textArea;
	
	@UiField
	Button previousDescriptionButton;
	
	@UiField
	Button nextDescriptionButton;
	
	@UiField
	Button nextButton;

	public SemanticMarkupPreprocessView() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
	
	@UiHandler("textArea")
	public void onTextChange(ValueChangeEvent<String> event) {
		presenter.onValueChange();
	}
	
	@UiHandler("nextButton")
	public void onNext(ClickEvent event) {
		presenter.onNext();
	}
	
	
	@UiHandler("nextButton")
	public void onNextDescription(ClickEvent event) {
		presenter.onNextDescription();
	}
	
	@UiHandler("nextButton")
	public void onPreviousDescription(ClickEvent event) {
		presenter.onPreviousDescription();
	}

	@Override
	public String getText() {
		return textArea.getText();
	}

	@Override
	public void setBracketCounts(String html) {
		this.bracketCounts.setHTML(html);
	}

	@Override
	public void setDescriptionIDLabel(String text) {
		this.descriptionIdLabel.setText(text);
	}

	@Override
	public void setText(String text) {
		this.textArea.setText(text);
	}

	@Override
	public void setEnabledNextDescriptionButton(boolean value) {
		this.nextDescriptionButton.setEnabled(value);
	}

	@Override
	public void setEnabledPreviousDescriptionButton(boolean value) {
		this.previousDescriptionButton.setEnabled(value);
	}

}
