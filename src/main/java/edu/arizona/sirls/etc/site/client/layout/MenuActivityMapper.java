package edu.arizona.sirls.etc.site.client.layout;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.inject.Inject;

import edu.arizona.sirls.etc.site.client.etcsite.menu.MenuActivity;
import edu.arizona.sirls.etc.site.client.etcsite.menu.MenuPlace;
import edu.arizona.sirls.etc.site.client.etcsite.menu.StartMenuActivity;
import edu.arizona.sirls.etc.site.client.etcsite.menu.StartMenuPlace;

public class MenuActivityMapper implements ActivityMapper {
	
	private MenuActivity menuActivity;
	private StartMenuActivity startMenuActivity;
	private Activity currentActivity;

	@Inject
	public MenuActivityMapper(MenuActivity menuActivity, StartMenuActivity startMenuActivity) {
		this.menuActivity = menuActivity;
		this.startMenuActivity = startMenuActivity;
	}
	
	@Override
	public Activity getActivity(Place place) {
		if(currentActivity == null)
			currentActivity = startMenuActivity;
		
		if(place instanceof MenuPlace)
			currentActivity = menuActivity;
		
		if(place instanceof StartMenuPlace)
			currentActivity = startMenuActivity;
		
		return currentActivity;
	}

}
