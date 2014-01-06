package edu.arizona.biosemantics.etcsite.client.layout;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;

import edu.arizona.biosemantics.etcsite.client.etcsite.top.LoggedInActivity;
import edu.arizona.biosemantics.etcsite.client.etcsite.top.LoggedInPlace;
import edu.arizona.biosemantics.etcsite.client.etcsite.top.LoggedOutActivity;
import edu.arizona.biosemantics.etcsite.client.etcsite.top.LoggedOutPlace;

public class TopActivityMapper implements ActivityMapper {

	private LoggedOutActivity loggedOutActivity;
	private LoggedInActivity loggedInActivity;
	private Activity currentActivity;

	@Inject
	public TopActivityMapper(LoggedInActivity loggedInActivity, LoggedOutActivity loggedOutActivity) {
		this.loggedInActivity = loggedInActivity;
		this.loggedOutActivity = loggedOutActivity;
	}
	
	@Override
	public Activity getActivity(Place place) {
		if(currentActivity == null)
			currentActivity = loggedOutActivity;
		
		if(place instanceof LoggedInPlace)
			currentActivity = loggedInActivity;
		
		if(place instanceof LoggedOutPlace) 
			currentActivity = loggedOutActivity;
		
		return currentActivity;
	}
}
