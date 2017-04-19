package es.ulpgc.eite.clean.mvp.sample.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import es.ulpgc.eite.clean.mvp.sample.add.AddPartyView;
import es.ulpgc.eite.clean.mvp.sample.detail.DetailView;
import es.ulpgc.eite.clean.mvp.sample.hangapp.HangApp;
import es.ulpgc.eite.clean.mvp.sample.hangapp.HangAppView;
import es.ulpgc.eite.clean.mvp.sample.hello.Hello;
import es.ulpgc.eite.clean.mvp.sample.information.InformationView;
import es.ulpgc.eite.clean.mvp.sample.search.Search;
import es.ulpgc.eite.clean.mvp.sample.search.SearchView;


public class App extends Application implements Mediator, Navigator {

  private DummyState toDummyState, dummyToState;
  private HelloState toHelloState;
  private ByeState helloToByeState;
  private HangAppState toHangAppState;
  private SearchState toSearchState, searchToState;
  private AddState toAddState,addToState;
  private ProcessedInformationState toprocessedInformationState,processedInformationToState;

  @Override
  public void onCreate() {
    super.onCreate();
    toDummyState = new DummyState();
    toDummyState.toolbarVisibility = false;
    toDummyState.textVisibility = false;

    toHelloState = new HelloState();
    toHangAppState=new HangAppState();
    toSearchState = new SearchState();
    toSearchState.textVisibility = false;



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
  public void startingHangAppScreen(HangApp.ToHangApp presenter) {
    if(toHangAppState != null) {
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
  public void goToAddScreen(HangApp.AddTo presenter) {
    addToState = new AddState();

    addToState.textVisibility = presenter.isTextVisible();
    addToState.selectorsVisibility=presenter.isSelectorsVisible();
    Context view = presenter.getManagedContext();
    if (view != null) {
      view.startActivity(new Intent(view, AddPartyView.class));
      presenter.destroyView();
    }

  }
//@Override
//public void goBackFromAdd(Add.HangAppTo presenter){
//  Context view = presenter.getManagedContext();
//  if (view != null) {
//    view.startActivity(new Intent(view, HangAppView.class));
//    presenter.destroyView();
//
//
//  }}

  @Override
  public void goToProcessedInformationScreen(Search.ProcessedTo presenter) {
    processedInformationToState=new ProcessedInformationState();
    processedInformationToState.informationVisibility=presenter.isInformationVisible();
    processedInformationToState.imageVisibility=presenter.isImageVisible();
    processedInformationToState.containsParticipants=presenter.ParticipantsExist();

    Context view = presenter.getManagedContext();
    if (view != null) {
      view.startActivity(new Intent(view, InformationView.class));
      presenter.destroyView();
    }


  }

  @Override
  public void goDetailScreen(HangApp.DetailTo presenter) {
    Context view = presenter.getManagedContext();
    if (view != null) {
      view.startActivity(new Intent(view, DetailView.class));
      presenter.destroyView();
  }}


  ///////////////////////////////////////////////////////////////////////////////////
  // State /////////////////////////////////////////////////////////////////////////

  class DummyState {
    boolean toolbarVisibility;
    boolean textVisibility;
  }

  class ByeState {
    boolean toolbarVisibility;
    //boolean textVisibility;
  }

  class HelloState {
    boolean toolbarVisibility;
    //boolean textVisibility;
  }
  class HangAppState{
    boolean textVisibility;
    boolean imageVisibility;
  }
  class SearchState{
    boolean textVisibility;

  }
  class AddState{
    boolean textVisibility;
    boolean selectorsVisibility;
  }


  class ProcessedInformationState{
    boolean informationVisibility;
    boolean imageVisibility;
    boolean containsParticipants;
  }}

