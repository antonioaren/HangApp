package es.ulpgc.eite.clean.mvp.sample.product;

import android.content.Context;
import android.util.Log;

import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.Navigator;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.app.Mediator;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;

/**
 * Created by alumno on 31/03/2017.
 */

public class ProductPresenter
        extends GenericPresenter<Product.PresenterToView, Product.PresenterToModel,
        Product.ModelToPresenter, ProductModel>
        implements Product.ViewToPresenter, Product.ModelToPresenter, Product.ToProduct
        , Product.ProductTo {

    private ProductData ItemSelected;

    @Override
    public void onCreate(Product.PresenterToView view) {
        super.onCreate(ProductModel.class, this);
        setView(view);

        Mediator app = (Mediator) getApplication();
        app.startingProductScreen(this);

    }

    @Override
    public void onResume(Product.PresenterToView view) {
        setView(view);

        setView(view);
        Log.d(TAG, "calling onResume()");


        if (configurationChangeOccurred()) {
            getView().setAddLabel(getModel().getAddLabel());

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

        }
    }

    @Override
    public void setItem(CategoryData itemSelected) {
        getModel().setItem(itemSelected);
    }

    @Override
    public void onItemClicked(ProductData item) {
        ItemSelected = item;

    }

    @Override
    public void onButtonAddClicked() {
        Log.d(TAG, "calling onButtonAddClicked()");
        Navigator app = (Navigator) getView().getApplication();
        app.goToAddPartyScreen(this);
    }

    @Override
    public Context getManagedContext() {
        return getActivityContext();
    }

    @Override
    public ProductData getSelectedItem() {
        return ItemSelected;
    }
}
