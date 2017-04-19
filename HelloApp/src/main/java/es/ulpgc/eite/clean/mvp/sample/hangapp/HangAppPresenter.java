package es.ulpgc.eite.clean.mvp.sample.hangapp;


import android.content.Context;
import android.util.Log;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.Mediator;
import es.ulpgc.eite.clean.mvp.sample.app.Navigator;

public class HangAppPresenter extends GenericPresenter
        <HangApp.PresenterToView, HangApp.PresenterToModel, HangApp.ModelToPresenter, HangAppModel>
        implements HangApp.ViewToPresenter, HangApp.ModelToPresenter, HangApp.DummyTo, HangApp.ToDummy, HangApp.SearchTo, HangApp.ToHangApp, HangApp.HangAppToAdd, HangApp.AddTo, HangApp.DetailTo {

  //Actualizando cosas
  private boolean toolbarVisible;
  private boolean buttonClicked;
  private boolean textVisible;
  private boolean imageVisibility;
  private boolean selectorsVisible;
  /**
   * Operation called during VIEW creation in {@link GenericActivity#onResume(Class, Object)}
   * Responsible to initialize MODEL.
   * Always call {@link GenericPresenter#onCreate(Class, Object)} to initialize the object
   * Always call  {@link GenericPresenter#setView(ContextView)} to save a PresenterToView reference
   *
   * @param view The current VIEW instance
   */
  @Override
  public void onCreate(HangApp.PresenterToView view) {
    super.onCreate(HangAppModel.class, this);
    setView(view);
    Log.d(TAG, "calling onCreate()");

    Log.d(TAG, "calling startingMainScreen()");
    Mediator app = (Mediator) getView().getApplication();
    app.startingHangAppScreen(this);
  }

  /**
   * Operation called by VIEW after its reconstruction.
   * Always call {@link GenericPresenter#setView(ContextView)}
   * to save the new instance of PresenterToView
   *
   * @param view The current VIEW instance
   */
  @Override
  public void onResume(HangApp.PresenterToView view) {
    setView(view);
    Log.d(TAG, "calling onResume()");


    if(configurationChangeOccurred()) {
      getView().setLabel(getModel().getSearchLabel());
      getView().setLabel(getModel().getSearchLabel());

      checkToolbarVisibility();
      checkTextVisibility();

      if (buttonClicked) {
        getView().setText(getModel().getText());
      }
    }

  }

  /**
   * Helper method to inform Presenter that a onBackPressed event occurred
   * Called by {@link GenericActivity}
   */
  @Override
  public void onBackPressed() {
    Log.d(TAG, "calling onBackPressed()");

  }

  /**
   * Hook method called when the VIEW is being destroyed or
   * having its configuration changed.
   * Responsible to maintain MVP synchronized with Activity lifecycle.
   * Called by onDestroy methods of the VIEW layer, like: {@link GenericActivity#onDestroy()}
   *
   * @param isChangingConfiguration true: configuration changing & false: being destroyed
   */
  @Override
  public void onDestroy(boolean isChangingConfiguration) {
    super.onDestroy(isChangingConfiguration);
    Log.d(TAG, "calling onDestroy()");
  }


  ///////////////////////////////////////////////////////////////////////////////////
  // View To Presenter /////////////////////////////////////////////////////////////


  @Override
  public void onButtonSearchClicked() {
    Log.d(TAG, "calling onButtonSearchClicked()");
//      if (isViewRunning()) {
//          getModel().onChangeMsgByBtnClicked();
//          getView().setText(getModel().getText());
//          textVisible = true;
//          buttonClicked = true;

    Navigator app = (Navigator) getView().getApplication();
    app.goToSearchScreen(this);
  }
  //  checkTextVisibility();

  //Metodo ya funciona
  @Override
  public void onButtonAddClicked() {
    Log.d(TAG,"calling onButtonAddClicked()");
    Navigator app = (Navigator) getView().getApplication();
    app.goToAddScreen(this);
  }

  @Override
  public void onListItemClicked() {
    Log.d(TAG,"item cliked");
    Navigator app = (Navigator) getView().getApplication();
    app.goDetailScreen(this);
  }


  ///////////////////////////////////////////////////////////////////////////////////
  // To HangApp //////////////////////////////////////////////////////////////////////

  @Override
  public void onScreenStarted() {
    Log.d(TAG, "calling onScreenStarted()");
    if(isViewRunning()) {
      getView().setLabel(getModel().getSearchLabel());
      getView().setLabel(getModel().getAddLabel());
    }
    checkToolbarVisibility();
    checkTextVisibility();
  }

  @Override
  public void setToolbarVisibility(boolean visible) {
    toolbarVisible = visible;
  }

  @Override
  public void setTextVisibility(boolean visible) {
    textVisible = visible;
  }

  @Override
  public void setImageVisibility(boolean ImageVisibility) {
    imageVisibility=ImageVisibility;
  }




  ///////////////////////////////////////////////////////////////////////////////////
  // HangApp To //////////////////////////////////////////////////////////////////////


  @Override
  public Context getManagedContext(){
    return getActivityContext();
  }

  @Override
  public void destroyView(){
    if(isViewRunning()) {
      getView().finishScreen();
    }
  }
  @Override
  public boolean isToolbarVisible() {
    return toolbarVisible;
  }

  @Override
  public boolean isTextVisible() {
    return textVisible;
  }

  @Override
  public boolean isSelectorsVisible() {
    return selectorsVisible;
  }
  @Override
  public boolean isImageVisible(){
    return imageVisibility;
  }

  ///////////////////////////////////////////////////////////////////////////////////

  private void checkToolbarVisibility(){
    Log.d(TAG, "calling checkToolbarVisibility()");
    if(isViewRunning()) {
      if (!toolbarVisible) {
        //  getView().hideToolbar();
      }
    }

  }

  private void checkTextVisibility(){
    Log.d(TAG, "calling checkTextVisibility()");
    if(isViewRunning()) {
      if(!textVisible) {
        getView().hideText();
      } else {
        getView().showText();
      }
    }
  }
  @Override
  public String[] getParties() {
    HangAppModel model= new HangAppModel();
    String[]list= model.getListParties();
    return list;
  }
}

