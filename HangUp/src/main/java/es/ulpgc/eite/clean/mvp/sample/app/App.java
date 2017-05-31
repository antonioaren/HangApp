package es.ulpgc.eite.clean.mvp.sample.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import es.ulpgc.eite.clean.mvp.sample.addCategory.AddCategory;
import es.ulpgc.eite.clean.mvp.sample.addCategory.AddCategoryView;
import es.ulpgc.eite.clean.mvp.sample.addParty.Add;
import es.ulpgc.eite.clean.mvp.sample.addParty.AddPartyView;
import es.ulpgc.eite.clean.mvp.sample.category.Category;
import es.ulpgc.eite.clean.mvp.sample.category.CategoryView;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import es.ulpgc.eite.clean.mvp.sample.data.Repository;
import es.ulpgc.eite.clean.mvp.sample.delete.Delete;
import es.ulpgc.eite.clean.mvp.sample.delete.DeleteView;
import es.ulpgc.eite.clean.mvp.sample.details.Detail;
import es.ulpgc.eite.clean.mvp.sample.details.DetailView;
import es.ulpgc.eite.clean.mvp.sample.product.Product;
import es.ulpgc.eite.clean.mvp.sample.product.ProductView;
import io.realm.Realm;


public class App extends Application implements Mediator, Navigator {


    private CategoryState toCategoryState;

    private ProductState CategoryToProduct;
    private ProductState AddToProduct;

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
            presenter.setItemSelected(CategoryToProduct.ItemSelected);
            presenter.setItemId(CategoryToProduct.ItemId);
        }

        if (AddToProduct != null) {
            presenter.setProductToAdd(AddToProduct.ProductToAdd);
        }

        //CategoryToProduct = null;
        AddToProduct = null;

        presenter.onScreenStarted();
    }

    @Override
    public void startingDetailScreen(Detail.ToDetail presenter) {
        if (ProductToDetail != null) {
            presenter.setItemSelected(ProductToDetail.ItemSelected);
        }

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

        }
        presenter.onScreenStarted();
    }

    @Override
    public void startingAddCategoryScreen(AddCategory.ToAdd presenter) {
        if (toaddCategoryState != null) {
            //presenter.setTextVisibility(toaddCategoryState.textVisibility);
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
            Intent intent = new Intent(view, ProductView.class);
            view.startActivity(intent);
        }
    }

    @Override
    public void goToProductScreenFromAddScreen(Add.AddTo presenter) {
        AddToProduct = new ProductState();
        AddToProduct.ProductToAdd = presenter.getProductAddedView();

        Context view = presenter.getManagedContext();
        if (view != null) {
            Intent intent = new Intent(view, ProductView.class);
            view.startActivity(intent);
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

        Context view = presenter.getManagedContext();
        if (view != null) {
            view.startActivity(new Intent(view, DeleteView.class));
        }
    }

    @Override
    public void goToCategoryScreen(Product.ProductTo presenter) {
        //toCategoryState = new CategoryState();

        Context view = presenter.getManagedContext();
        if (view != null) {
            view.startActivity(new Intent(view, CategoryView.class));
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


        Context view = presenter.getManagedContext();
        if (view != null) {
            view.startActivity(new Intent(view, AddPartyView.class));
        }

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public void SaveDataAdd(AddCategory.AddTo presenter) {
        toaddCategoryState = new AddCategoryState();
        toaddCategoryState.CategoryName = presenter.getCategoryName();
        toaddCategoryState.radioButtonSelected = presenter.getRadioButtonSelected();

        presenter.destroyView();
    }

    @Override
    public void SaveDataFromAddParty(Add.AddTo presenter) {
        toAddState = new AddPartyState();
        //Guardando datos
//        toAddState.nameOfTheParty = presenter.getNameOfTheParty();
//        toAddState.placeOfTheParty = presenter.getPlaceOfTheParty();
//        toAddState.dateOfTheParty = presenter.getDateOfTheParty();
//        toAddState.hourOfParty = presenter.getHourOfParty();

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
        ProductData ProductToAdd;

    }

    private class DetailState {
        public ProductData ItemSelected;
    }

    private class DeleteState {


        public String nameToDelete;
    }

    private class AddPartyState {
        public String nameOfTheParty;
        public String placeOfTheParty;
        public String dateOfTheParty;
        public String hourOfParty;
    }

    private class AddCategoryState {
        boolean textVisibility;


        public int radioButtonSelected;
        public String CategoryName;
    }
}



