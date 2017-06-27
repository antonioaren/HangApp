package es.ulpgc.eite.clean.mvp.sample.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import es.ulpgc.eite.clean.mvp.sample.addCategory.AddCategory;
import es.ulpgc.eite.clean.mvp.sample.addCategory.AddCategoryView;
import es.ulpgc.eite.clean.mvp.sample.addParty.AddProduct;
import es.ulpgc.eite.clean.mvp.sample.addParty.AddProductView;
import es.ulpgc.eite.clean.mvp.sample.category.Category;
import es.ulpgc.eite.clean.mvp.sample.category.CategoryView;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import es.ulpgc.eite.clean.mvp.sample.details.Detail;
import es.ulpgc.eite.clean.mvp.sample.details.DetailView;
import es.ulpgc.eite.clean.mvp.sample.product.Product;
import es.ulpgc.eite.clean.mvp.sample.product.ProductView;
import io.realm.Realm;
import io.realm.RealmResults;


public class App extends Application implements Mediator, Navigator {


    private CategoryState toCategoryState;
    private ProductState CategoryToProduct;
    private ProductState AddToProduct;
    private DetailState ProductToDetail;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        toCategoryState = new CategoryState();
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
    public void startingAddCategoryScreen(AddCategory.ToAdd presenter) {
        presenter.onScreenStarted();
    }

    @Override
    public void startingAddProductScreen(AddProduct.ToAdd presenter) {
        presenter.onScreenStarted();
    }

    /////////////// Navigator /////////////////////////////////////////////////////////////////////

    @Override
    public void goToCategoryScreen(Product.ProductTo presenter) {
        //toCategoryState = new CategoryState();

        Context view = presenter.getManagedContext();
        if (view != null) {
            view.startActivity(new Intent(view, CategoryView.class));
        }

    }

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
    public void goToProductScreenFromAddScreen(AddProduct.AddTo presenter) {
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
    public void goToAddCategoryScreen(Category.CategoryTo presenter) {

        //Añadir los estados que falten para pasarles a la busquedad. Guardar posicion, etc.

        Context view = presenter.getManagedContext();
        if (view != null) {
            view.startActivity(new Intent(view, AddCategoryView.class));
        }

    }

    @Override
    public void goToAddPartyScreen(Product.ProductTo presenter) {
        Context view = presenter.getManagedContext();
        if (view != null) {
            view.startActivity(new Intent(view, AddProductView.class));
        }

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void KillingAddCategoryScreenAfterInserting(AddCategory.AddTo presenter) {
        presenter.destroyView();
    }

    @Override
    public void SaveDataFromAddParty(AddProduct.AddTo presenter) {
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


}



