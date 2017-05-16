package es.ulpgc.eite.clean.mvp.sample.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.List;

import es.ulpgc.eite.clean.mvp.sample.R;
import es.ulpgc.eite.clean.mvp.sample.add.Add;
import es.ulpgc.eite.clean.mvp.sample.add.AddPartyView;
import es.ulpgc.eite.clean.mvp.sample.category.Category;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import es.ulpgc.eite.clean.mvp.sample.data.Repository;
import es.ulpgc.eite.clean.mvp.sample.data.repositories.ProductRepository;
import es.ulpgc.eite.clean.mvp.sample.detail.DetailPresenter;
import es.ulpgc.eite.clean.mvp.sample.detail.DetailView;
import es.ulpgc.eite.clean.mvp.sample.product.Product;
import es.ulpgc.eite.clean.mvp.sample.product.ProductModel;
import es.ulpgc.eite.clean.mvp.sample.product.ProductView;
import es.ulpgc.eite.clean.mvp.sample.search.Search;
import es.ulpgc.eite.clean.mvp.sample.search.SearchView;
import io.realm.RealmList;


public class App extends Application implements Mediator, Navigator {


    private boolean isFirstTimeRunning;

    private CategoryState toCategoryState;
    private ProductState CategoryToProduct;
    private DetailState ProductToDetail;

    private SearchState CategoryToSearch;
    private AddState toAddState;

    @Override
    public void onCreate() {
        super.onCreate();
        toCategoryState = new CategoryState();
        CategoryToSearch = new SearchState();
        CheckisFirstTimeRunning();
    }

    private void CheckisFirstTimeRunning() {
        SharedPreferences pref = getSharedPreferences("es.ulpgc.eite.clean.mvp.sample", MODE_PRIVATE);
        isFirstTimeRunning = false;
        if (pref.getBoolean("FirstRun", true)) {
            isFirstTimeRunning = true;
            pref.edit().putBoolean("FirstRun", false).commit();
        }
    }


    //////////////// Mediator //////////////////////////////////////////////////////////////////////

    @Override
    public void startingCategoryScreen(Category.ToCategory presenter) {
        if (toCategoryState != null) {

        }
        presenter.setIsFirstInit(isFirstTimeRunning);
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

    ////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void addingItems(Category.ToCategory presenter) {

        if (toAddState != null) {
//            presenter.setPlace(toAddState.placeOfTheParty);
//            presenter.setDate(toAddState.dateOfTheParty);
//            presenter.setHour(toAddState.hourOfParty);
        }

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
    public void goToAddScreen(Category.CategoryTo presenter) {
        toAddState = new AddState();

        //Añadir los estados que falten para pasarles a la busquedad. Guardar posicion, etc.

        Context view = presenter.getManagedContext();
        if (view != null) {
            view.startActivity(new Intent(view, AddPartyView.class));
        }

    }

    //Todo Que hacen estas funciones. Estorban
    @Override
    public void publishParty(Add.AddTo presenter) {
        toAddState = new AddState();
        toAddState.descriptionOfTheParty = presenter.getDescriptionOfTheParty();
        toAddState.placeOfTheParty = presenter.getPlaceOfTheParty();
        toAddState.dateOfTheParty = presenter.getDateOfTheParty();
        toAddState.hourOfParty = presenter.getHourOfParty();
        //  toAddState.callback=presenter.getCallBack();

        //        //reformando metodo
        toAddState.newparty = presenter.getParty();
        // toAddState.newparty.add(new ProductData(R.drawable.astro,toAddState.descriptionOfTheParty, "0",  "details", "story", toAddState.dateOfTheParty, toAddState.hourOfParty));

        ProductModel product = new ProductModel();
        product.insertProduct("0", R.drawable.astro, toAddState.descriptionOfTheParty, "0", toAddState.descriptionOfTheParty, toAddState.dateOfTheParty, toAddState.hourOfParty);//      toAddState.list = presenter.getPartyAdded();
//       toAddState.list.add(new CategoryData("0", R.drawable.astro, "category", toAddState.newparty));
//    CategoryView cv= new CategoryView();
//    cv.settingAdapter((RealmResults<CategoryData>) toAddState.list);
//    cv.getAdapter().notifyItemInserted(1);
//     presenter.destroyView();

    }

    @Override
    public void goToProcessedInformationScreen(Search.ProcessedTo presenter) {

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


    }

    private class AddState {
        boolean textVisibility;
        boolean selectorsVisibility;
        public String descriptionOfTheParty;
        String placeOfTheParty;
        String dateOfTheParty;
        String hourOfParty;
        List<CategoryData> partyAdded;
        RealmList<ProductData> newparty;
        List<CategoryData> list;

        Repository.ProductRepository.OnSaveProductCallback callback;


        ProductRepository product;

    }
}

