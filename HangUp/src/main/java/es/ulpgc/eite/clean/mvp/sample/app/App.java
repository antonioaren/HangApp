package es.ulpgc.eite.clean.mvp.sample.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import es.ulpgc.eite.clean.mvp.sample.addCategory.AddCategory;
import es.ulpgc.eite.clean.mvp.sample.addCategory.AddCategoryView;
import es.ulpgc.eite.clean.mvp.sample.addParty.Add;
import es.ulpgc.eite.clean.mvp.sample.addParty.AddPartyView;
import es.ulpgc.eite.clean.mvp.sample.category.Category;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import es.ulpgc.eite.clean.mvp.sample.data.Repository;
import es.ulpgc.eite.clean.mvp.sample.data.repositories.ProductRepository;
import es.ulpgc.eite.clean.mvp.sample.detail.DetailPresenter;
import es.ulpgc.eite.clean.mvp.sample.detail.DetailView;
import es.ulpgc.eite.clean.mvp.sample.product.Product;
import es.ulpgc.eite.clean.mvp.sample.product.ProductView;
import es.ulpgc.eite.clean.mvp.sample.search.Search;
import es.ulpgc.eite.clean.mvp.sample.search.SearchView;
import io.realm.Realm;


public class App extends Application implements Mediator, Navigator {



    private CategoryState toCategoryState;
    private ProductState CategoryToProduct;
    private DetailState ProductToDetail;

    private SearchState CategoryToSearch;
    private AddPartyState toAddState;
    private AddCategoryState toaddCategoryState;
    private SearchState toSearchState;


    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        toCategoryState = new CategoryState();
        CategoryToSearch = new SearchState();
    }

    @Override
    public Context getAppContext() {
        return getApplicationContext();
    }


    //////////////// Mediator //////////////////////////////////////////////////////////////////////

    @Override
    public void startingCategoryScreen(Category.ToCategory presenter) {
        if (toCategoryState != null) {

        }
        presenter.onScreenStarted();
    }

    @Override
    public void startingProductScreen(Product.ToProduct presenter) {
        if (CategoryToProduct != null) {
            presenter.setItem(CategoryToProduct.ItemSelected);
        }
        CategoryToProduct = null;
        presenter.onScreenStarted();
    }

    @Override
    public void startingDetailScreen(DetailPresenter presenter) {

        presenter.onScreenStarted();

    }

    @Override
    public void startingSearchScreen(Search.ToSearch presenter) {
        if (CategoryToSearch != null) {

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
public void startinAddCategoryScreen(AddCategory.ToAdd presenter){
    if(toaddCategoryState!=null){
        presenter.setTextVisibility(toaddCategoryState.textVisibility);
    }

presenter.onScreenStarted();
}

    /////////////// Navigator /////////////////////////////////////////////////////////////////////

    @Override
    public void goToProductScreen(Category.CategoryTo presenter) {
        CategoryToProduct = new ProductState();
        CategoryToProduct.ItemSelected = presenter.getSelectedItem();

        Context view = presenter.getManagedContext();
        if (view != null) {
            view.startActivity(new Intent(view, ProductView.class));
        }
    }

    @Override
    public void goDetailScreen(Product.ProductTo presenter) {
        ProductToDetail = new DetailState();
        ProductToDetail.ItemSelected = presenter.getSelectedItem();

        Context view = presenter.getManagedContext();
        if (view != null) {
            view.startActivity(new Intent(view, DetailView.class));
        }
    }

    @Override
    public void goToSearchScreen(Category.CategoryTo presenter) {
        CategoryToSearch = new SearchState();
        //Añadir los estados que falten para pasarles a la busquedad. Guardar posicion, etc.


        Context view = presenter.getManagedContext();
        if (view != null) {
            view.startActivity(new Intent(view, SearchView.class));
        }
    }

    @Override
    public void goToAddCategoryScreen(Category.CategoryTo presenter) {
        toaddCategoryState = new AddCategoryState();

        //Añadir los estados que falten para pasarles a la busquedad. Guardar posicion, etc.

        Context view = presenter.getManagedContext();
        if (view != null) {
            view.startActivity(new Intent(view, AddCategoryView.class));
        }

    }
    @Override
    public void goToAddPartyScreen(Product.ProductTo presenter) {
        toAddState = new AddPartyState();

        //Añadir los estados que falten para pasarles a la busquedad. Guardar posicion, etc.
         toAddState.descriptionOfTheParty=presenter.getDescriptionOfTheParty();
        toAddState.placeOfTheParty=presenter.getPlaceOfTheParty();
        toAddState.dateOfTheParty=presenter.getDateOfTheParty();
        toAddState.hourOfParty=presenter.getHourOfParty();
        Context view = presenter.getManagedContext();
        if (view != null) {
            view.startActivity(new Intent(view, AddPartyView.class));
        }

    }


    @Override
    public void SaveDataAdd(AddCategory.AddTo presenter) {
        toaddCategoryState = new AddCategoryState();

       // toAddState.placeOfTheParty = presenter.getPlaceOfTheParty();
       // toAddState.dateOfTheParty = presenter.getDateOfTheParty();
        //toAddState.hourOfParty = presenter.getHourOfParty();

     presenter.destroyView();
    }
    
    @Override
    public void deleteEvent(Search.SearchTo presenter){
        toSearchState= new SearchState();
        toSearchState.nameToDelete=presenter.getNameToDelete();
        presenter.destroyView();
    }


    //////////////// State /////////////////////////////////////////////////////////////////////////

    private class CategoryState {

    }

    private class ProductState {
        CategoryData ItemSelected;
    }

    private class DetailState {
        public ProductData ItemSelected;
    }

    private class SearchState {


        public String nameToDelete;
    }

    private class AddPartyState {
        boolean textVisibility;
        boolean selectorsVisibility;
        public String descriptionOfTheParty;
        public String placeOfTheParty;
        public String dateOfTheParty;
        public String hourOfParty;


        Repository.ProductRepository.OnSaveProductCallback callback;


        ProductRepository product;

    }
private class AddCategoryState{
    boolean textVisibility;



}}



