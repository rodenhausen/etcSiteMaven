package edu.arizona.sirls.etc.site.client;

import com.google.gwt.inject.client.GinModules;
import com.google.gwt.inject.client.Ginjector;

import edu.arizona.sirls.etc.site.shared.rpc.ISetupServiceAsync;

@GinModules(ClientModule.class)
public interface ClientGinjector extends Ginjector {

	RootLayoutPanelDecorator getRootLayoutPanelDecorator();

	ISetupServiceAsync getSetupService();
	
}