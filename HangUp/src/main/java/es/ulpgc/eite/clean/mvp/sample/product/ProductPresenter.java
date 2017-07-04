package es.ulpgc.eite.clean.mvp.sample.product;

import android.content.Context;
import android.util.Log;

import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.Navigator;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.app.Mediator;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import io.realm.RealmList;

/**
 * Created by alumno on 31/03/2017.
 */

public class ProductPresenter
        extends GenericPresenter<Product.PresenterToView, Product.PresenterToModel,
        Product.ModelToPresenter, ProductModel>
        implements Product.ViewToPresenter, Product.ModelToPresenter, Product.ToProduct
        , Product.ProductTo {

    private ProductData itemSelected;
    private String categoryId;


    @Override
    public void onCreate(Product.PresenterToView view) {
        super.onCreate(ProductModel.class, this);
        setView(view);

        Mediator app = (Mediator) getApplication();
        app.startingProductScreen(this);
    }
    @Override
    public void onResume(Product.PresenterToView view) {
        Log.d(TAG, "calling onResume()");
        setView(view);

        if (configurationChangeOccurred()) {

        }
    }
    @Override
    public void onDestroy(boolean isChangingConfiguration) {
        super.onDestroy(isChangingConfiguration);
    }
    @Override
    public void onBackPressed() {

    }
    @Override
    public void onScreenStarted() {
        if (isViewRunning()) {
            getView().setTitleHeader(getModel().getItemCategorySelected().getCategoryName());
            settingItemsAdapter();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void setItemCategorySelected(CategoryData itemSelected) {
        getModel().setItemCategorySelected(itemSelected);
    }

    @Override
    public ProductData getItemProductSelected() {
        return itemSelected;
    }

    @Override
    public String getCategoryId() {
        return categoryId;
    }

    @Override
    public void setItemCategoryId(String itemId) {
        categoryId = itemId;
    }

    @Override
    public RealmList<ProductData> getProductList() {
        return getModel().getAllProductsByCategoryId(categoryId);
    }

    private void settingItemsAdapter() {
        getView().settingAdapter(getModel().getAllProductsByCategoryId(categoryId));
    }

    @Override
    public void onItemClicked(ProductData item) {
        itemSelected = item;
        Navigator app = (Navigator) getApplication();
        app.goDetailScreen(this);
    }

    @Override
    public void onButtonAddClicked() {
        Log.d(TAG, "calling onButtonAddClicked()");
        Navigator app = (Navigator) getView().getApplication();
        app.goToAddProductScreen(this);
    }

    @Override
    public void OnSwipedItem(String id) {
        getModel().deleteItemById(id);
        getView().setToast(getModel().getNotifyDeleted());
        settingItemsAdapter();
    }

    @Override
    public Context getManagedContext() {
        return getActivityContext();
    }
}
