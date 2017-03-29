package es.ulpgc.eite.clean.mvp.sample.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import es.ulpgc.eite.clean.mvp.sample.hangapp.HangApp;
import es.ulpgc.eite.clean.mvp.sample.hangapp.HangAppView;
import es.ulpgc.eite.clean.mvp.sample.hello.Hello;
import es.ulpgc.eite.clean.mvp.sample.search.SearchView;


public class App extends Application implements Mediator, Navigator {

  private DummyState toDummyState, dummyToState;
  private HelloState toHelloState;
  private ByeState helloToByeState;
  private HangAppState toHangAppState;
  private SearchState toSearchState, searchToState;
  private AddState toAddState,addToState;

  @Override
  public void onCreate() {
    super.onCreate();
    toDummyState = new DummyState();
    toDummyState.toolbarVisibility = false;
    toDummyState.textVisibility = false;

    toHelloState = new HelloState();
  }

  ///////////////////////////////////////////////////////////////////////////////////
  // Mediator //////////////////////////////////////////////////////////////////////

  @Override
  public void startingDummyScreen(HangApp.ToDummy presenter){
    if(toDummyState != null) {
      presenter.setToolbarVisibility(toDummyState.toolbarVisibility);
      presenter.setTextVisibility(toDummyState.textVisibility);
    }
    presenter.onScreenStarted();
  }

  @Override
  public void startingHelloScreen(Hello.ToHello presenter){
    if(toHelloState != null) {
      presenter.setToolbarVisibility(toHelloState.toolbarVisibility);
      //presenter.setTextVisibility(toHelloState.textVisibility);
    }
    presenter.onScreenStarted();
  }


  ///////////////////////////////////////////////////////////////////////////////////
  // Navigator /////////////////////////////////////////////////////////////////////


  @Override
  public void goToNextScreen(HangApp.DummyTo presenter) {
    dummyToState = new DummyState();
    dummyToState.toolbarVisibility = presenter.isToolbarVisible();
    dummyToState.textVisibility = presenter.isTextVisible();

    Context view = presenter.getManagedContext();
    if (view != null) {
      view.startActivity(new Intent(view, HangAppView.class));
      presenter.destroyView();
    }

  }


  @Override
  public void goToByeScreen(Hello.HelloToBye presenter) {
    helloToByeState = new ByeState();
    helloToByeState.toolbarVisibility = presenter.isToolbarVisible();
    //helloToByeState.textVisibility = presenter.isTextVisible();

    Context view = presenter.getManagedContext();
    if (view != null) {
      view.startActivity(new Intent(view, HangAppView.class));
      //presenter.destroyView();
    }

  }
//----------------------Metodos para nuestra app-----------------------------------------------------------

public void onCreateHome() {
  super.onCreate();
  toSearchState = new SearchState();
  toSearchState.textVisibility = false;


  toHangAppState = new HangAppState();
}

  @Override
  public void startingSearchScreen(HangApp.toSearch presenter){
    if(toSearchState != null) {
      presenter.setTextVisibility(toSearchState.textVisibility);

    }
    presenter.onScreenStarted();
  }

  @Override
  public void startingAddScreen(HangApp.toAdd presenter){
    if(toAddState != null) {
      presenter.setTextVisibility(toAddState.textVisibility);
      presenter.setSelectorsVisibility(toAddState.selectorsVisibility);
      //presenter.setTextVisibility(toHelloState.textVisibility);
    }
    presenter.onScreenStarted();
  }
  @Override
  public void startingMainScreen(HangApp.ToHangApp presenter){
    if(toAddState != null) {
      presenter.setTextVisibility(toHangAppState.textVisibility);
      presenter.setImageVisibility(toHangAppState.imageVisibility);
      //presenter.setTextVisibility(toHelloState.textVisibility);
    }
    presenter.onScreenStarted();
  }

  ///////////////////////////////////////////////////////////////////////////////////
  // Navigator /////////////////////////////////////////////////////////////////////


  @Override
  public void goToSearchScreen(HangApp.SearchTo presenter) {
    searchToState = new SearchState();

    searchToState.textVisibility = presenter.isTextVisible();

    Context view = presenter.getManagedContext();
    if (view != null) {
      view.startActivity(new Intent(view, SearchView.class));
      presenter.destroyView();
    }

  }


  @Override
  public void goToAddScreen(HangApp.HangAppToAdd presenter) {
   addToState = new AddState();
    helloToByeState.toolbarVisibility = presenter.isTextVisible();
    //helloToByeState.textVisibility = presenter.isTextVisible();

    Context view = presenter.getManagedContext();
    if (view != null) {
      view.startActivity(new Intent(view, HangAppView.class));
      //presenter.destroyView();
    }

  }
  ///////////////////////////////////////////////////////////////////////////////////
  // State /////////////////////////////////////////////////////////////////////////

  private class DummyState {
    boolean toolbarVisibility;
    boolean textVisibility;
  }

  private class ByeState {
    boolean toolbarVisibility;
    //boolean textVisibility;
  }

  private class HelloState {
    boolean toolbarVisibility;
    //boolean textVisibility;
  }
private class HangAppState{
   boolean textVisibility;
   boolean imageVisibility;
  }
private class SearchState{
  boolean textVisibility;

}
private class AddState{
  boolean textVisibility;
  boolean selectorsVisibility;
}

}
