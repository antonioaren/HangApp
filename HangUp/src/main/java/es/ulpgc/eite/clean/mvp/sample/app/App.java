package es.ulpgc.eite.clean.mvp.sample.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import es.ulpgc.eite.clean.mvp.sample.addCategory.AddCategory;
import es.ulpgc.eite.clean.mvp.sample.addCategory.AddCategoryView;
import es.ulpgc.eite.clean.mvp.sample.addProduct.AddProduct;
import es.ulpgc.eite.clean.mvp.sample.addProduct.AddProductView;
import es.ulpgc.eite.clean.mvp.sample.category.Category;
import es.ulpgc.eite.clean.mvp.sample.category.CategoryView;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import es.ulpgc.eite.clean.mvp.sample.details.Detail;
import es.ulpgc.eite.clean.mvp.sample.details.DetailView;
import es.ulpgc.eite.clean.mvp.sample.product.Product;
import es.ulpgc.eite.clean.mvp.sample.product.ProductView;
import io.realm.Realm;


public class App extends Application implements Mediator, Navigator {


    private CategoryState toCategoryState;
    private ProductState CategoryToProduct;
    private DetailState ProductToDetail;
    private ProductAddState ProductToadd;

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
            presenter.setItemCategorySelected(CategoryToProduct.ItemSelected);
            presenter.setItemCategoryId(CategoryToProduct.ItemId);
        }

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
        if (ProductToadd != null) {
            presenter.setCategoryId(ProductToadd.IdCategory);
        }
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
    public void goDetailScreen(Product.ProductTo presenter) {
        ProductToDetail = new DetailState();
        ProductToDetail.ItemSelected = presenter.getItemProductSelected();

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
    public void goToAddProductScreen(Product.ProductTo presenter) {
        ProductToadd = new ProductAddState();
        ProductToadd.IdCategory = presenter.getCategoryId();


        Context view = presenter.getManagedContext();
        if (view != null) {
            view.startActivity(new Intent(view, AddProductView.class));
        }

    }



    @Override
    public void KillingAddCategoryScreenAfterInserting(AddCategory.AddTo presenter) {
        presenter.destroyView();
    }

    @Override
    public void KillingAddProductScreenAfterInserting(AddProduct.AddTo presenter) {
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

    //Necesario para poder pasar la id de la categoria que nos encontramos
    //Para poder añadir el producto
    private class ProductAddState {
        String IdCategory;
    }

}



