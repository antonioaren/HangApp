package es.ulpgc.eite.clean.mvp.sample.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import es.ulpgc.eite.clean.mvp.sample.add.Add;
import es.ulpgc.eite.clean.mvp.sample.add.AddPartyView;


import es.ulpgc.eite.clean.mvp.sample.category.Category;
import es.ulpgc.eite.clean.mvp.sample.detail.DetailPresenter;
import es.ulpgc.eite.clean.mvp.sample.information.Information;
import es.ulpgc.eite.clean.mvp.sample.information.InformationView;
import es.ulpgc.eite.clean.mvp.sample.search.Search;
import es.ulpgc.eite.clean.mvp.sample.search.SearchView;


public class App extends Application implements Mediator, Navigator {


    private HangAppState toHangAppState;
    private SearchState toSearchState, HangappToSearch;
    private AddState toAddState, addToState;

    private PartiesByCategoryState partiesState;
    private ProcessedInformationState toprocessedInformationState, processedInformationToState;

    @Override
    public void onCreate() {
        super.onCreate();

        toHangAppState = new HangAppState();
        toSearchState = new SearchState();
        toSearchState.textVisibility = false;

    }

    ///////////////////////////////////////////////////////////////////////////////////
    // Mediator //////////////////////////////////////////////////////////////////////

    @Override
    public void startingSearchScreen(Search.ToSearch presenter) {
        if (toSearchState != null) {
            presenter.setTextVisibility(toSearchState.textVisibility);

        }
        presenter.onScreenStarted();
    }

    @Override
    public void startingAddScreen(Add.ToAdd presenter) {
        if (toAddState != null) {
            presenter.setTextVisibility(toAddState.textVisibility);
            //presenter.setSelectorsVisibility(toAddState.selectorsVisibility);
            //presenter.setTextVisibility(toHelloState.textVisibility);
        }
        presenter.onScreenStarted();
    }

    @Override
    public void startingCategoryScreen(es.ulpgc.eite.clean.mvp.sample.category.Category.ToCategory presenter) {
        if (toHangAppState != null) {
            presenter.setTextVisibility(toHangAppState.textVisibility);
            presenter.setImageVisibility(toHangAppState.imageVisibility);
        }
        presenter.onScreenStarted();
    }

    @Override
    public void startingInformationScreen(Information.ToInformation presenter) {
        presenter.onScreenStarted();
    }

    @Override
    public void startingDetailScreen(DetailPresenter Presenter) {

    }


//  @Override
//public void startingInformatioScreen(){
//  if(partiesState!=null){
//    presenter.setListVisibility(partiesState.listVisibility);
//  }
// presenter.onScreenStarted();

    ///////////////////////////////////////////////////////////////////////////////////
    // Navigator /////////////////////////////////////////////////////////////////////


    @Override
    public void goToSearchScreen(es.ulpgc.eite.clean.mvp.sample.category.Category.CategoryTo presenter) {
        HangappToSearch = new SearchState();

        HangappToSearch.textVisibility = presenter.isTextVisible();

        Context view = presenter.getManagedContext();
        if (view != null) {
            view.startActivity(new Intent(view, SearchView.class));
        }

    }

//  @Override
//  public void goToPartyList(Search.ListTo presenter){
//      Context view = presenter.getManagedContext();
//      SearchView sv= new SearchView();
//      ListView list=sv.getListCategories();
//      int position= list.getSelectedItemPosition();
//      if(view!=null){
//          if(position==0){
//              view.startActivity(new Intent(view,DetailView.class));
//          }
//          view.startActivity(new Intent(view, SearchView.class));
//      }
//  }

    @Override
    public void goToAddScreen(Category.CategoryTo presenter) {
        addToState = new AddState();

        addToState.textVisibility = presenter.isTextVisible();
        addToState.selectorsVisibility = presenter.isSelectorsVisible();
        Context view = presenter.getManagedContext();
        if (view != null) {
            view.startActivity(new Intent(view, AddPartyView.class));
        }

    }

    @Override
    public void goToProcessedInformationScreen(Search.ProcessedTo presenter) {

    }

//@Override
//public void goBackFromAdd(Detail.SearchTo presenter){
//  Context view = presenter.getManagedContext();
//  if (view != null) {
//    view.startActivity(new Intent(view, CategoryView.class));
//    presenter.destroyView();
//
//
//  }}


//    Context view = presenter.getManagedContext();
//    if (view != null) {
//      view.startActivity(new Intent(view, InformationView.class));
//      presenter.destroyView();
//    }
//  }

//    @Override
//    public void goDetailScreen(Detail.DetailTo presenter) {
//        Context view = presenter.getManagedContext();
//        if (view != null) {
//            view.startActivity(new Intent(view, DetailView.class));
//        }
//    }

    @Override
    public void goToInformationScreen(Category.CategoryTo presenter) {
        Context view = presenter.getManagedContext();
        if (view != null) {
            view.startActivity(new Intent(view, InformationView.class));
        }
    }


    ///////////////////////////////////////////////////////////////////////////////////
    // State /////////////////////////////////////////////////////////////////////////


    class HangAppState {
        boolean textVisibility;
        boolean imageVisibility;
    }

    class SearchState {
        boolean textVisibility;

    }

    class AddState {
        boolean textVisibility;
        boolean selectorsVisibility;
    }


    class ProcessedInformationState {
        boolean informationVisibility;
        boolean imageVisibility;
        boolean containsParticipants;
    }

    class ListState {
        boolean textVisility;
    }

    class PartiesByCategoryState {
        boolean listVisibility;
    }
}

