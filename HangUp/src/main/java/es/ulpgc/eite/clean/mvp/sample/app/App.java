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
import es.ulpgc.eite.clean.mvp.sample.delete.Delete;
import es.ulpgc.eite.clean.mvp.sample.delete.DeleteView;
import es.ulpgc.eite.clean.mvp.sample.detail.DetailPresenter;
import es.ulpgc.eite.clean.mvp.sample.detail.DetailView;
import es.ulpgc.eite.clean.mvp.sample.product.Product;
import es.ulpgc.eite.clean.mvp.sample.product.ProductView;
import io.realm.Realm;


public class App extends Application implements Mediator, Navigator {


    private CategoryState toCategoryState;
    private ProductState CategoryToProduct;
    private DetailState ProductToDetail;

    private DeleteState CategoryToSearch;
    private AddPartyState toAddState;
    private AddCategoryState toaddCategoryState;
    private DeleteState toDeleteState;
    private DeleteState ProductToDelete;


    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        toCategoryState = new CategoryState();
        CategoryToSearch = new DeleteState();
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
            presenter.setIdItem(CategoryToProduct.ItemId);
        }
        CategoryToProduct = null;
        presenter.onScreenStarted();
    }

    @Override
    public void startingDetailScreen(DetailPresenter presenter) {

        presenter.onScreenStarted();

    }

    @Override
    public void startingDeleteScreen(Delete.ToDelete presenter) {
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
    public void startinAddCategoryScreen(AddCategory.ToAdd presenter) {
        if (toaddCategoryState != null) {
            presenter.setTextVisibility(toaddCategoryState.textVisibility);
        }

        presenter.onScreenStarted();
    }

    /////////////// Navigator /////////////////////////////////////////////////////////////////////

    @Override
    public void goToProductScreen(Category.CategoryTo presenter) {
        CategoryToProduct = new ProductState();
        CategoryToProduct.ItemSelected = presenter.getSelectedItem();
        CategoryToProduct.ItemId = presenter.getItemId();

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
    public void goToDeleteScreen(Category.CategoryTo presenter) {
        CategoryToSearch = new DeleteState();
        //Añadir los estados que falten para pasarles a la busquedad. Guardar posicion, etc.


        Context view = presenter.getManagedContext();
        if (view != null) {
            view.startActivity(new Intent(view, DeleteView.class));
        }
    }


    @Override
    public void gotoDeleteProductScreen(Product.ProductTo presenter) {
        ProductToDelete = new DeleteState();
        //Añadir los estados que falten para pasarles a la busquedad. Guardar posicion, etc.


        Context view = presenter.getManagedContext();
        if (view != null) {
            view.startActivity(new Intent(view, DeleteView.class));
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
        toAddState.descriptionOfTheParty = presenter.getDescriptionOfTheParty();
        toAddState.placeOfTheParty = presenter.getPlaceOfTheParty();
        toAddState.dateOfTheParty = presenter.getDateOfTheParty();
        toAddState.hourOfParty = presenter.getHourOfParty();
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
    public void deleteEvent(Delete.DeleteTo presenter) {
        toDeleteState = new DeleteState();
        toDeleteState.nameToDelete = presenter.getNameToDelete();
        presenter.destroyView();
    }


    //////////////// State /////////////////////////////////////////////////////////////////////////

    private class CategoryState {

    }

    private class ProductState {
        CategoryData ItemSelected;
        String ItemId;
    }

    private class DetailState {
        public ProductData ItemSelected;
    }

    private class DeleteState {


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

    private class AddCategoryState {
        boolean textVisibility;


    }
}



