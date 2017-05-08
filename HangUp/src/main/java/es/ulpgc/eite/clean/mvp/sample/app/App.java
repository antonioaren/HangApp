package es.ulpgc.eite.clean.mvp.sample.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.clean.mvp.sample.R;
import es.ulpgc.eite.clean.mvp.sample.add.Add;
import es.ulpgc.eite.clean.mvp.sample.add.AddPartyView;
import es.ulpgc.eite.clean.mvp.sample.category.Category;
import es.ulpgc.eite.clean.mvp.sample.category.CategoryView;
import es.ulpgc.eite.clean.mvp.sample.detail.DetailPresenter;
import es.ulpgc.eite.clean.mvp.sample.information.Information;
import es.ulpgc.eite.clean.mvp.sample.information.InformationView;
import es.ulpgc.eite.clean.mvp.sample.search.Search;
import es.ulpgc.eite.clean.mvp.sample.search.SearchView;


public class App extends Application implements Mediator, Navigator {


    private CategoryState toCategoryState;
    private SearchState toSearchState, HangappToSearch;
    private AddState toAddState, addToState;
    private InformationState CategoryToInformation;

    private PartiesByCategoryState partiesState;
    private InformationState toprocessedInformationState, processedInformationToState;

    @Override
    public void onCreate() {
        super.onCreate();

        toCategoryState = new CategoryState();
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


        }
        presenter.onScreenStarted();
    }

    @Override
    public void startingCategoryScreen(Category.ToCategory presenter) {
        if (toCategoryState != null) {
            presenter.setTextVisibility(toCategoryState.textVisibility);
            presenter.setImageVisibility(toCategoryState.imageVisibility);
        }
        presenter.onScreenStarted();
    }

    @Override
    public void startingInformationScreen(Information.ToInformation presenter) {
        if (CategoryToInformation != null) {

            presenter.setItem(CategoryToInformation.ItemSelected);
        }
        CategoryToInformation = null;
        presenter.onScreenStarted();
    }

    @Override
    public void startingDetailScreen(DetailPresenter Presenter) {

    }

    @Override
    public void addingItems(Category.ToCategory presenter) {

        if (toAddState != null) {
            presenter.setPlace(toAddState.placeOfTheParty);
            presenter.setDate(toAddState.dateOfTheParty);
            presenter.setHour(toAddState.hourOfParty);
        }

    }


    ///////////////////////////////////////////////////////////////////////////////////
    // Navigator /////////////////////////////////////////////////////////////////////


    @Override
    public void goToSearchScreen(Category.CategoryTo presenter) {
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
    public void publishParty(Add.AddTo presenter) {

        /*
        AddPartyModel addParty = new AddPartyModel();
        CategoryModel categoryModel = new CategoryModel();
        CategoryView categoryView = new CategoryView();
        InformationData information = new InformationData(R.drawable.astro, "name", "123", "detail", "story", addParty.getDateOfTheParty(), addParty.getHourOfParty());
        List<InformationData> list = new ArrayList();
        list.add(information);
        List<CategoryData> item = new ArrayList();
        item.add(new CategoryData(R.drawable.astro, "name", "123", list, "details", "story", addParty.getDateOfTheParty(), addParty.getHourOfParty()));
        categoryView.settingAdapter(item);
        categoryView.getAdapter().notifyItemInserted(categoryView.getList().indexOf(item));
        */

        toAddState = new AddState();

        toAddState.placeOfTheParty = presenter.getPlaceOfTheParty();
        toAddState.dateOfTheParty = presenter.getDateOfTheParty();
        toAddState.hourOfParty = presenter.getHourOfParty();
        //reformando metodo 
        InformationData information = new InformationData(R.drawable.astro, "name", "123", "detail", "story", toAddState.dateOfTheParty, toAddState.hourOfParty);
        List<InformationData> list = new ArrayList();
        list.add(information);
        List<CategoryData> item = new ArrayList();
        item.add(new CategoryData(R.drawable.astro, "name", "123", list, "details", "story", toAddState.dateOfTheParty, toAddState.hourOfParty));
        CategoryView categoryView = new CategoryView();
        categoryView.settingAdapter(item);
        presenter.destroyView();
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
        CategoryToInformation = new InformationState();
        CategoryToInformation.ItemSelected = presenter.getSelectedItem();

        Context view = presenter.getManagedContext();
        if (view != null) {
            view.startActivity(new Intent(view, InformationView.class));
        }
    }


    ///////////////////////////////////////////////////////////////////////////////////
    // State /////////////////////////////////////////////////////////////////////////



    private class CategoryState {
        boolean textVisibility;
        boolean imageVisibility;
    }

    private class SearchState {
        boolean textVisibility;

    }

    private class AddState {
        boolean textVisibility;
        boolean selectorsVisibility;

        String placeOfTheParty;
        String dateOfTheParty;
        String hourOfParty;
    }


    private class InformationState {
        public CategoryData ItemSelected;
    }

    private class ListState {
        boolean textVisility;
    }

    private class PartiesByCategoryState {
        boolean listVisibility;
    }
}

