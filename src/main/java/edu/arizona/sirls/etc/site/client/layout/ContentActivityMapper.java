package edu.arizona.sirls.etc.site.client.layout;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;

import edu.arizona.sirls.etc.site.client.content.annotationReview.AnnotationReviewActivity;
import edu.arizona.sirls.etc.site.client.content.annotationReview.AnnotationReviewPlace;
import edu.arizona.sirls.etc.site.client.content.fileManager.FileManagerActivity;
import edu.arizona.sirls.etc.site.client.content.fileManager.FileManagerPlace;
import edu.arizona.sirls.etc.site.client.content.help.HelpActivity;
import edu.arizona.sirls.etc.site.client.content.help.HelpPlace;
import edu.arizona.sirls.etc.site.client.content.home.HomeActivity;
import edu.arizona.sirls.etc.site.client.content.home.HomePlace;
import edu.arizona.sirls.etc.site.client.content.matrixGeneration.MatrixGenerationActivity;
import edu.arizona.sirls.etc.site.client.content.matrixGeneration.MatrixGenerationPlace;
import edu.arizona.sirls.etc.site.client.content.semanticMarkup.SemanticMarkupInputPlace;
import edu.arizona.sirls.etc.site.client.content.semanticMarkup.SemanticMarkupActivity;
import edu.arizona.sirls.etc.site.client.content.semanticMarkup.SemanticMarkupPlace;
import edu.arizona.sirls.etc.site.client.content.settings.SettingsActivity;
import edu.arizona.sirls.etc.site.client.content.settings.SettingsPlace;
import edu.arizona.sirls.etc.site.client.content.taskManager.TaskManagerActivity;
import edu.arizona.sirls.etc.site.client.content.taskManager.TaskManagerPlace;
import edu.arizona.sirls.etc.site.client.etcsite.top.LoggedOutPlace;

public class ContentActivityMapper implements ActivityMapper {

	private HelpActivity helpActivity;
	private HomeActivity homeActivity;
	private SettingsActivity settingsActivity;
	private TaskManagerActivity taskManagerActivity;
	private FileManagerActivity fileManagerActivity;
	private SemanticMarkupActivity semanticMarkupActivity;
	private MatrixGenerationActivity matrixGenerationActivity;
	private AnnotationReviewActivity annotationReviewActivity;
	
	private Activity currentActivity;

	@Inject
	public ContentActivityMapper(HelpActivity helpActivity, HomeActivity homeActivity, SettingsActivity settingsActivity, TaskManagerActivity taskManagerActivity,
			FileManagerActivity fileManagerActivity, SemanticMarkupActivity semanticMarkupActivity, MatrixGenerationActivity matrixGenerationActivity, 
			AnnotationReviewActivity annotationReviewActivity) {
		super();
		this.helpActivity = helpActivity;
		this.homeActivity = homeActivity;
		this.settingsActivity = settingsActivity;
		this.taskManagerActivity = taskManagerActivity;
		this.fileManagerActivity = fileManagerActivity;
		this.semanticMarkupActivity = semanticMarkupActivity;
		this.matrixGenerationActivity = matrixGenerationActivity;
		this.annotationReviewActivity = annotationReviewActivity;
	}

	@Override
	public Activity getActivity(Place place) {
		if(currentActivity == null)
			currentActivity = homeActivity;
		
		if(place instanceof HomePlace) 
			currentActivity = homeActivity;
		if(place instanceof SettingsPlace)
			currentActivity = settingsActivity;
		if(place instanceof HelpPlace)
			currentActivity = helpActivity;
		if(place instanceof LoggedOutPlace)
			currentActivity = homeActivity;
		if(place instanceof TaskManagerPlace)
			currentActivity = taskManagerActivity;
		if(place instanceof FileManagerPlace)
			currentActivity = fileManagerActivity;
		if(place instanceof SemanticMarkupPlace) {
			semanticMarkupActivity.setPlace((SemanticMarkupPlace)place);
			currentActivity = semanticMarkupActivity;
		}
		if(place instanceof MatrixGenerationPlace) {
			matrixGenerationActivity.setPlace((MatrixGenerationPlace)place);
			currentActivity = matrixGenerationActivity;
		}
		if(place instanceof AnnotationReviewPlace)
			currentActivity = annotationReviewActivity;
		
		return currentActivity;
	}

}
