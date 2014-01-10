package edu.arizona.biosemantics.etcsite.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.activity.shared.MyActivityManager;
import com.google.gwt.activity.shared.MyActivityMapper;
import com.google.gwt.inject.client.AbstractGinModule;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

import edu.arizona.biosemantics.etcsite.client.common.IMessageConfirmView;
import edu.arizona.biosemantics.etcsite.client.common.IMessageView;
import edu.arizona.biosemantics.etcsite.client.common.ITextInputView;
import edu.arizona.biosemantics.etcsite.client.common.MessageConfirmPresenter;
import edu.arizona.biosemantics.etcsite.client.common.MessageConfirmView;
import edu.arizona.biosemantics.etcsite.client.common.MessagePresenter;
import edu.arizona.biosemantics.etcsite.client.common.MessageView;
import edu.arizona.biosemantics.etcsite.client.common.TextInputPresenter;
import edu.arizona.biosemantics.etcsite.client.common.TextInputView;
import edu.arizona.biosemantics.etcsite.client.common.files.DnDFileTreePresenter;
import edu.arizona.biosemantics.etcsite.client.common.files.FileContentPresenter;
import edu.arizona.biosemantics.etcsite.client.common.files.FileContentView;
import edu.arizona.biosemantics.etcsite.client.common.files.FileTreePresenter;
import edu.arizona.biosemantics.etcsite.client.common.files.FileTreeView;
import edu.arizona.biosemantics.etcsite.client.common.files.IFileContentView;
import edu.arizona.biosemantics.etcsite.client.common.files.IFileTreeView;
import edu.arizona.biosemantics.etcsite.client.common.files.IManagableFileTreeView;
import edu.arizona.biosemantics.etcsite.client.common.files.ISavableFileTreeView;
import edu.arizona.biosemantics.etcsite.client.common.files.ISelectableFileTreeView;
import edu.arizona.biosemantics.etcsite.client.common.files.ManagableFileTreePresenter;
import edu.arizona.biosemantics.etcsite.client.common.files.ManagableFileTreeView;
import edu.arizona.biosemantics.etcsite.client.common.files.SavableFileTreePresenter;
import edu.arizona.biosemantics.etcsite.client.common.files.SavableFileTreeView;
import edu.arizona.biosemantics.etcsite.client.common.files.SelectableFileTreePresenter;
import edu.arizona.biosemantics.etcsite.client.common.files.SelectableFileTreeView;
import edu.arizona.biosemantics.etcsite.client.content.annotationReview.AnnotationReviewPresenter;
import edu.arizona.biosemantics.etcsite.client.content.annotationReview.AnnotationReviewView;
import edu.arizona.biosemantics.etcsite.client.content.annotationReview.IAnnotationReviewView;
import edu.arizona.biosemantics.etcsite.client.content.annotationReview.IResultView;
import edu.arizona.biosemantics.etcsite.client.content.annotationReview.ISearchView;
import edu.arizona.biosemantics.etcsite.client.content.annotationReview.IXMLEditorView;
import edu.arizona.biosemantics.etcsite.client.content.annotationReview.ResultPresenter;
import edu.arizona.biosemantics.etcsite.client.content.annotationReview.ResultView;
import edu.arizona.biosemantics.etcsite.client.content.annotationReview.SearchPresenter;
import edu.arizona.biosemantics.etcsite.client.content.annotationReview.SearchView;
import edu.arizona.biosemantics.etcsite.client.content.annotationReview.XMLEditorPresenter;
import edu.arizona.biosemantics.etcsite.client.content.annotationReview.XMLEditorView;
import edu.arizona.biosemantics.etcsite.client.content.fileManager.FileManagerDialogPresenter;
import edu.arizona.biosemantics.etcsite.client.content.fileManager.FileManagerDialogView;
import edu.arizona.biosemantics.etcsite.client.content.fileManager.FileManagerView;
import edu.arizona.biosemantics.etcsite.client.content.fileManager.IFileManagerDialogView;
import edu.arizona.biosemantics.etcsite.client.content.fileManager.IFileManagerView;
import edu.arizona.biosemantics.etcsite.client.content.help.HelpView;
import edu.arizona.biosemantics.etcsite.client.content.help.IHelpView;
import edu.arizona.biosemantics.etcsite.client.content.home.HomeContentView;
import edu.arizona.biosemantics.etcsite.client.content.home.IHomeContentView;
import edu.arizona.biosemantics.etcsite.client.content.matrixGeneration.IMatrixGenerationInputView;
import edu.arizona.biosemantics.etcsite.client.content.matrixGeneration.IMatrixGenerationOutputView;
import edu.arizona.biosemantics.etcsite.client.content.matrixGeneration.IMatrixGenerationProcessView;
import edu.arizona.biosemantics.etcsite.client.content.matrixGeneration.IMatrixGenerationReviewView;
import edu.arizona.biosemantics.etcsite.client.content.matrixGeneration.MatrixGenerationInputPresenter;
import edu.arizona.biosemantics.etcsite.client.content.matrixGeneration.MatrixGenerationInputView;
import edu.arizona.biosemantics.etcsite.client.content.matrixGeneration.MatrixGenerationOutputPresenter;
import edu.arizona.biosemantics.etcsite.client.content.matrixGeneration.MatrixGenerationOutputView;
import edu.arizona.biosemantics.etcsite.client.content.matrixGeneration.MatrixGenerationProcessPresenter;
import edu.arizona.biosemantics.etcsite.client.content.matrixGeneration.MatrixGenerationProcessView;
import edu.arizona.biosemantics.etcsite.client.content.matrixGeneration.MatrixGenerationReviewPresenter;
import edu.arizona.biosemantics.etcsite.client.content.matrixGeneration.MatrixGenerationReviewView;
import edu.arizona.biosemantics.etcsite.client.content.matrixGeneration.review.IReviewView;
import edu.arizona.biosemantics.etcsite.client.content.matrixGeneration.review.ReviewPresenter;
import edu.arizona.biosemantics.etcsite.client.content.matrixGeneration.review.ReviewView;
import edu.arizona.biosemantics.etcsite.client.content.semanticMarkup.ISemanticMarkupInputView;
import edu.arizona.biosemantics.etcsite.client.content.semanticMarkup.ISemanticMarkupLearnView;
import edu.arizona.biosemantics.etcsite.client.content.semanticMarkup.ISemanticMarkupOutputView;
import edu.arizona.biosemantics.etcsite.client.content.semanticMarkup.ISemanticMarkupParseView;
import edu.arizona.biosemantics.etcsite.client.content.semanticMarkup.ISemanticMarkupPreprocessView;
import edu.arizona.biosemantics.etcsite.client.content.semanticMarkup.ISemanticMarkupReviewView;
import edu.arizona.biosemantics.etcsite.client.content.semanticMarkup.SemanticMarkupInputPresenter;
import edu.arizona.biosemantics.etcsite.client.content.semanticMarkup.SemanticMarkupInputView;
import edu.arizona.biosemantics.etcsite.client.content.semanticMarkup.SemanticMarkupLearnPresenter;
import edu.arizona.biosemantics.etcsite.client.content.semanticMarkup.SemanticMarkupLearnView;
import edu.arizona.biosemantics.etcsite.client.content.semanticMarkup.SemanticMarkupOutputPresenter;
import edu.arizona.biosemantics.etcsite.client.content.semanticMarkup.SemanticMarkupOutputView;
import edu.arizona.biosemantics.etcsite.client.content.semanticMarkup.SemanticMarkupParsePresenter;
import edu.arizona.biosemantics.etcsite.client.content.semanticMarkup.SemanticMarkupParseView;
import edu.arizona.biosemantics.etcsite.client.content.semanticMarkup.SemanticMarkupPreprocessPresenter;
import edu.arizona.biosemantics.etcsite.client.content.semanticMarkup.SemanticMarkupPreprocessView;
import edu.arizona.biosemantics.etcsite.client.content.semanticMarkup.SemanticMarkupReviewPresenter;
import edu.arizona.biosemantics.etcsite.client.content.semanticMarkup.SemanticMarkupReviewView;
import edu.arizona.biosemantics.etcsite.client.content.settings.ISettingsView;
import edu.arizona.biosemantics.etcsite.client.content.settings.SettingsView;
import edu.arizona.biosemantics.etcsite.client.content.taskManager.ITaskManagerView;
import edu.arizona.biosemantics.etcsite.client.content.taskManager.TaskManagerPresenter;
import edu.arizona.biosemantics.etcsite.client.content.taskManager.TaskManagerView;
import edu.arizona.biosemantics.etcsite.client.content.user.IUserSelectView;
import edu.arizona.biosemantics.etcsite.client.content.user.IUsersView;
import edu.arizona.biosemantics.etcsite.client.content.user.UserSelectPresenter;
import edu.arizona.biosemantics.etcsite.client.content.user.UserSelectView;
import edu.arizona.biosemantics.etcsite.client.content.user.UsersPresenter;
import edu.arizona.biosemantics.etcsite.client.content.user.UsersView;
import edu.arizona.biosemantics.etcsite.client.layout.ContentActivityManagerProvider;
import edu.arizona.biosemantics.etcsite.client.layout.ContentActivityMapper;
import edu.arizona.biosemantics.etcsite.client.layout.EtcSitePresenter;
import edu.arizona.biosemantics.etcsite.client.layout.EtcSiteView;
import edu.arizona.biosemantics.etcsite.client.layout.IEtcSiteView;
import edu.arizona.biosemantics.etcsite.client.layout.MenuActivityManagerProvider;
import edu.arizona.biosemantics.etcsite.client.layout.MenuActivityMapper;
import edu.arizona.biosemantics.etcsite.client.layout.MyPlaceHistoryMapper;
import edu.arizona.biosemantics.etcsite.client.layout.PlaceControllerProvider;
import edu.arizona.biosemantics.etcsite.client.layout.PlaceHistoryHandlerProvider;
import edu.arizona.biosemantics.etcsite.client.layout.TopActivityManagerProvider;
import edu.arizona.biosemantics.etcsite.client.layout.TopActivityMapper;
import edu.arizona.biosemantics.etcsite.client.menu.IMenuView;
import edu.arizona.biosemantics.etcsite.client.menu.IStartMenuView;
import edu.arizona.biosemantics.etcsite.client.menu.MenuView;
import edu.arizona.biosemantics.etcsite.client.menu.StartMenuView;
import edu.arizona.biosemantics.etcsite.client.top.ILoginTopView;
import edu.arizona.biosemantics.etcsite.client.top.ITopView;
import edu.arizona.biosemantics.etcsite.client.top.LoggedOutPlace;
import edu.arizona.biosemantics.etcsite.client.top.LoginTopView;
import edu.arizona.biosemantics.etcsite.client.top.TopView;
import edu.arizona.biosemantics.etcsite.shared.file.FilePathShortener;
import edu.arizona.biosemantics.etcsite.shared.rpc.IAuthenticationServiceAsync;
import edu.arizona.biosemantics.etcsite.shared.rpc.IFileAccessServiceAsync;
import edu.arizona.biosemantics.etcsite.shared.rpc.IFileFormatServiceAsync;
import edu.arizona.biosemantics.etcsite.shared.rpc.IFilePermissionServiceAsync;
import edu.arizona.biosemantics.etcsite.shared.rpc.IFileSearchServiceAsync;
import edu.arizona.biosemantics.etcsite.shared.rpc.IFileServiceAsync;
import edu.arizona.biosemantics.etcsite.shared.rpc.IMatrixGenerationServiceAsync;
import edu.arizona.biosemantics.etcsite.shared.rpc.ISemanticMarkupServiceAsync;
import edu.arizona.biosemantics.etcsite.shared.rpc.ISetupServiceAsync;
import edu.arizona.biosemantics.etcsite.shared.rpc.ITaskServiceAsync;
import edu.arizona.biosemantics.etcsite.shared.rpc.ITaxonomyComparisonServiceAsync;
import edu.arizona.biosemantics.etcsite.shared.rpc.ITreeGenerationServiceAsync;
import edu.arizona.biosemantics.etcsite.shared.rpc.IUserServiceAsync;
import edu.arizona.biosemantics.etcsite.shared.rpc.IVisualizationServiceAsync;

public class ClientModule extends AbstractGinModule {
	
	protected void configure() {		
		//views, presenter
		bind(IEtcSiteView.class).to(EtcSiteView.class).in(Singleton.class);
		bind(IEtcSiteView.Presenter.class).to(EtcSitePresenter.class).in(Singleton.class);
		bind(ITopView.class).to(TopView.class).in(Singleton.class);
		bind(ILoginTopView.class).to(LoginTopView.class).in(Singleton.class);
		bind(IMenuView.class).to(MenuView.class).in(Singleton.class);
		bind(IStartMenuView.class).to(StartMenuView.class).in(Singleton.class);
		bind(IHomeContentView.class).to(HomeContentView.class).in(Singleton.class);
		bind(IHelpView.class).to(HelpView.class).in(Singleton.class);
		bind(ISettingsView.class).to(SettingsView.class).in(Singleton.class);
		bind(ITaskManagerView.class).to(TaskManagerView.class).in(Singleton.class);
		bind(ITaskManagerView.Presenter.class).to(TaskManagerPresenter.class).in(Singleton.class);
		bind(IFileManagerView.class).to(FileManagerView.class).in(Singleton.class);
		
		
		bind(IFileManagerDialogView.class).to(FileManagerDialogView.class);
		bind(IFileManagerDialogView.Presenter.class).to(FileManagerDialogPresenter.class).in(Singleton.class);
		
		bind(IUsersView.class).to(UsersView.class).in(Singleton.class);
		bind(IUsersView.Presenter.class).to(UsersPresenter.class).in(Singleton.class);
		bind(IUserSelectView.class).to(UserSelectView.class).in(Singleton.class);
		bind(IUserSelectView.Presenter.class).to(UserSelectPresenter.class).in(Singleton.class);
		
		//FileTreeView may not be singleton as it is a child for e.g. SelectableFileTreeView and
		//MangabableFileTreeView. As a widget can only have one parent at a time it can't be a singleton,
		//or has to be added to the parent view explicitly every time before the parent is rendered.
		//bind(FileTreeView.class).in(Singleton.class);
		bind(IFileTreeView.Presenter.class).annotatedWith(Names.named("Managable")).to(DnDFileTreePresenter.class);
		bind(IFileTreeView.Presenter.class).annotatedWith(Names.named("Selectable")).to(FileTreePresenter.class);
		bind(IFileTreeView.Presenter.class).annotatedWith(Names.named("Savable")).to(FileTreePresenter.class);
		bind(IFileTreeView.class).to(FileTreeView.class);
		bind(IManagableFileTreeView.Presenter.class).annotatedWith(Names.named("Dialog")).to(ManagableFileTreePresenter.class).in(Singleton.class);
		bind(IManagableFileTreeView.Presenter.class).annotatedWith(Names.named("FileManager")).to(ManagableFileTreePresenter.class).in(Singleton.class);
		bind(IManagableFileTreeView.class).to(ManagableFileTreeView.class);
		bind(IFileContentView.class).to(FileContentView.class).in(Singleton.class);
		bind(IFileContentView.Presenter.class).to(FileContentPresenter.class).in(Singleton.class);
		bind(ISelectableFileTreeView.class).to(SelectableFileTreeView.class).in(Singleton.class);
		bind(ISelectableFileTreeView.Presenter.class).to(SelectableFileTreePresenter.class).in(Singleton.class);
		bind(ISavableFileTreeView.class).to(SavableFileTreeView.class).in(Singleton.class);
		bind(ISavableFileTreeView.Presenter.class).to(SavableFileTreePresenter.class).in(Singleton.class);
		
		bind(ITextInputView.class).to(TextInputView.class).in(Singleton.class);
		bind(ITextInputView.Presenter.class).to(TextInputPresenter.class).in(Singleton.class);
		bind(IMessageView.class).to(MessageView.class).in(Singleton.class);
		bind(IMessageView.Presenter.class).to(MessagePresenter.class).in(Singleton.class);
		bind(IMessageConfirmView.class).to(MessageConfirmView.class).in(Singleton.class);
		bind(IMessageConfirmView.Presenter.class).to(MessageConfirmPresenter.class).in(Singleton.class);
		
		bind(IAnnotationReviewView.class).to(AnnotationReviewView.class).in(Singleton.class);
		bind(IAnnotationReviewView.Presenter.class).to(AnnotationReviewPresenter.class).in(Singleton.class);
		bind(ISearchView.class).to(SearchView.class).in(Singleton.class);
		bind(ISearchView.Presenter.class).to(SearchPresenter.class).in(Singleton.class);
		bind(IResultView.class).to(ResultView.class).in(Singleton.class);
		bind(IResultView.Presenter.class).to(ResultPresenter.class).in(Singleton.class);
		bind(IXMLEditorView.class).to(XMLEditorView.class).in(Singleton.class);
		bind(IXMLEditorView.Presenter.class).to(XMLEditorPresenter.class).in(Singleton.class);
		
		bind(IMatrixGenerationInputView.class).to(MatrixGenerationInputView.class);
		bind(IMatrixGenerationInputView.Presenter.class).to(MatrixGenerationInputPresenter.class);
		bind(IMatrixGenerationProcessView.class).to(MatrixGenerationProcessView.class);
		bind(IMatrixGenerationProcessView.Presenter.class).to(MatrixGenerationProcessPresenter.class);
		bind(IMatrixGenerationReviewView.class).to(MatrixGenerationReviewView.class);
		bind(IMatrixGenerationReviewView.Presenter.class).to(MatrixGenerationReviewPresenter.class);
		bind(IReviewView.class).to(ReviewView.class).in(Singleton.class);
		bind(IReviewView.Presenter.class).to(ReviewPresenter.class).in(Singleton.class);
		bind(IMatrixGenerationOutputView.class).to(MatrixGenerationOutputView.class);
		bind(IMatrixGenerationOutputView.Presenter.class).to(MatrixGenerationOutputPresenter.class);
		
		bind(ISemanticMarkupInputView.class).to(SemanticMarkupInputView.class);
		bind(ISemanticMarkupInputView.Presenter.class).to(SemanticMarkupInputPresenter.class);
		bind(ISemanticMarkupPreprocessView.class).to(SemanticMarkupPreprocessView.class);
		bind(ISemanticMarkupPreprocessView.Presenter.class).to(SemanticMarkupPreprocessPresenter.class);
		bind(ISemanticMarkupLearnView.class).to(SemanticMarkupLearnView.class);
		bind(ISemanticMarkupLearnView.Presenter.class).to(SemanticMarkupLearnPresenter.class);
		bind(ISemanticMarkupReviewView.class).to(SemanticMarkupReviewView.class);
		bind(ISemanticMarkupReviewView.Presenter.class).to(SemanticMarkupReviewPresenter.class);
		bind(ISemanticMarkupParseView.class).to(SemanticMarkupParseView.class);
		bind(ISemanticMarkupParseView.Presenter.class).to(SemanticMarkupParsePresenter.class);
		bind(ISemanticMarkupOutputView.class).to(SemanticMarkupOutputView.class);
		bind(ISemanticMarkupOutputView.Presenter.class).to(SemanticMarkupOutputPresenter.class);
		
		//activites, places, eventbus
		bind(EventBus.class).annotatedWith(Names.named("ActivitiesBus")).to(SimpleEventBus.class).in(Singleton.class);
		bind(PlaceController.class).toProvider(PlaceControllerProvider.class).in(Singleton.class);
		bind(ActivityMapper.class).annotatedWith(Names.named("Top")).
			to(TopActivityMapper.class).in(Singleton.class);
		bind(ActivityMapper.class).annotatedWith(Names.named("Menu")).
			to(MenuActivityMapper.class).in(Singleton.class);
		bind(MyActivityMapper.class).annotatedWith(Names.named("Content")).
			to(ContentActivityMapper.class).in(Singleton.class);
		bind(ActivityManager.class).annotatedWith(Names.named("Top")).
			toProvider(TopActivityManagerProvider.class).in(Singleton.class);
		bind(ActivityManager.class).annotatedWith(Names.named("Menu")).
			toProvider(MenuActivityManagerProvider.class).in(Singleton.class);
		bind(MyActivityManager.class).annotatedWith(Names.named("Content")).
			toProvider(ContentActivityManagerProvider.class).in(Singleton.class);
		bind(PlaceHistoryMapper.class).to(MyPlaceHistoryMapper.class).in(Singleton.class);
		bind(PlaceHistoryHandler.class).toProvider(PlaceHistoryHandlerProvider.class).in(Singleton.class);
		bind(Place.class).annotatedWith(Names.named("DefaultPlace")).to(LoggedOutPlace.class);
		
		bind(EventBus.class).annotatedWith(Names.named("Tasks")).to(SimpleEventBus.class).in(Singleton.class);
		bind(EventBus.class).annotatedWith(Names.named("AnnotationReview")).to(SimpleEventBus.class).in(Singleton.class);
		
		//services
		bind(IAuthenticationServiceAsync.class).in(Singleton.class);
		bind(IFileAccessServiceAsync.class).in(Singleton.class);
		bind(IFileFormatServiceAsync.class).in(Singleton.class);
		bind(IFilePermissionServiceAsync.class).in(Singleton.class);
		bind(IFileSearchServiceAsync.class).in(Singleton.class);
		bind(IFileServiceAsync.class).in(Singleton.class);
		bind(IMatrixGenerationServiceAsync.class).in(Singleton.class);
		bind(ISemanticMarkupServiceAsync.class).in(Singleton.class);
		bind(ISetupServiceAsync.class).in(Singleton.class);
		bind(ITaskServiceAsync.class).in(Singleton.class);
		bind(ITaxonomyComparisonServiceAsync.class).in(Singleton.class);
		bind(ITreeGenerationServiceAsync.class).in(Singleton.class);
		bind(IUserServiceAsync.class).in(Singleton.class);
		bind(IVisualizationServiceAsync.class).in(Singleton.class);
		
		//misc
		bind(FilePathShortener.class).in(Singleton.class);
	}
}