package es.ulpgc.eite.clean.mvp.sample.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import es.ulpgc.eite.clean.mvp.sample.addCategory.AddCategory;
import es.ulpgc.eite.clean.mvp.sample.addCategory.AddCategoryView;
import es.ulpgc.eite.clean.mvp.sample.addProduct.AddProduct;
import es.ulpgc.eite.clean.mvp.sample.addProduct.AddProductView;
import es.ulpgc.eite.clean.mvp.sample.authors.Authors;
import es.ulpgc.eite.clean.mvp.sample.authors.AuthorsPresenter;
import es.ulpgc.eite.clean.mvp.sample.authors.AuthorsView;
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


    private ProductState categoryToProduct;
    private DetailState productToDetail;
    private ProductAddState productToadd;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);

    }

    @Override
    public Context getAppContext() {
        return getApplicationContext();
    }


    //////////////// Mediator //////////////////////////////////////////////////////////////////////

    @Override
    public void startingCategoryScreen(Category.ToCategory presenter) {

        presenter.onScreenStarted();
    }

    @Override
    public void startingProductScreen(Product.ToProduct presenter) {
        if (categoryToProduct != null) {
            presenter.setItemCategorySelected(categoryToProduct.itemSelected);
            presenter.setItemCategoryId(categoryToProduct.itemId);
        }

        presenter.onScreenStarted();
    }

    @Override
    public void startingDetailScreen(Detail.ToDetail presenter) {
        if (productToDetail != null) {
            presenter.setItemSelected(productToDetail.itemSelected);
        }
        presenter.onScreenStarted();
    }

    @Override
    public void startingAddCategoryScreen(AddCategory.ToAdd presenter) {
        presenter.onScreenStarted();
    }

    @Override
    public void startingAuthorsScreen(AuthorsPresenter authorsPresenter) {

    }

    @Override
    public void startingAddProductScreen(AddProduct.ToAdd presenter) {
        if (productToadd != null) {
            presenter.setCategoryId(productToadd.idCategory);
        }
        presenter.onScreenStarted();
    }

    /////////////// Navigator /////////////////////////////////////////////////////////////////////

    @Override
    public void goToCategoryScreen(Product.ProductTo presenter) {


        Context view = presenter.getManagedContext();
        if (view != null) {
            view.startActivity(new Intent(view, CategoryView.class));
        }

    }

    @Override
    public void goToProductScreen(Category.CategoryTo presenter) {
        categoryToProduct = new ProductState();
        categoryToProduct.itemSelected = presenter.getSelectedItem();
        categoryToProduct.itemId = presenter.getItemId();

        Context view = presenter.getManagedContext();
        if (view != null) {
            Intent intent = new Intent(view, ProductView.class);
            view.startActivity(intent);
        }
    }

    @Override
    public void goDetailScreen(Product.ProductTo presenter) {
        productToDetail = new DetailState();
        productToDetail.itemSelected = presenter.getItemProductSelected();

        Context view = presenter.getManagedContext();
        if (view != null) {
            view.startActivity(new Intent(view, DetailView.class));
        }
    }

    @Override
    public void goToAddCategoryScreen(Category.CategoryTo presenter) {


        Context view = presenter.getManagedContext();
        if (view != null) {
            view.startActivity(new Intent(view, AddCategoryView.class));
        }

    }

    @Override
    public void goToAddProductScreen(Product.ProductTo presenter) {
        productToadd = new ProductAddState();
        productToadd.idCategory = presenter.getCategoryId();


        Context view = presenter.getManagedContext();
        if (view != null) {
            view.startActivity(new Intent(view, AddProductView.class));
        }

    }




    @Override
    public void killingAddCategoryScreenAfterInserting(AddCategory.AddTo presenter) {
        presenter.destroyView();
    }

    @Override
    public void killingAddProductScreenAfterInserting(AddProduct.AddTo presenter) {
        presenter.destroyView();
    }


    //Examen

    @Override
    public void startingAuthorsScreen(Authors.AuthorsTo presenter) {


        presenter.onScreenStarted();
    }


    @Override
    public void goToAuthorsScreen(Product.ProductTo presenter) {


        Context view = presenter.getManagedContext();
        if (view != null) {
            view.startActivity(new Intent(view, AuthorsView.class));
        }

    }

    //////////////// State /////////////////////////////////////////////////////////////////////////



    private class ProductState {
        CategoryData itemSelected;
        String itemId;
    }

    private class DetailState {
        public ProductData itemSelected;
    }


    //Necesario para poder pasar la id de la categoria que nos encontramos
    //Para poder añadir el producto
    private class ProductAddState {
        String idCategory;
    }

    private class productToAuthorsState {
        String text;

    }
}



