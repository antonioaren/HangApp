package es.ulpgc.eite.clean.mvp.sample.addParty;

import android.content.Context;
import android.util.Log;

import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.Mediator;
import es.ulpgc.eite.clean.mvp.sample.app.Navigator;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;

/**
 * Created by eleonora on 17/04/2017.
 */

public class AddProductPresenter
        extends GenericPresenter<AddProduct.PresenterToView, AddProduct.PresenterToModel, AddProduct.ModelToPresenter, AddProductModel>
        implements AddProduct.ViewToPresenter, AddProduct.ModelToPresenter, AddProduct.ToAdd, AddProduct.AddTo {


    private ProductData product;


    @Override
    public void onCreate(AddProduct.PresenterToView view) {
        super.onCreate(AddProductModel.class, this);
        setView(view);
        Log.d(TAG, "calling onCreate()");

        Log.d(TAG, "calling startingAddProductScreen()");
        Mediator app = (Mediator) getView().getApplication();
        app.startingAddProductScreen(this);
    }

    @Override
    public void onScreenStarted() {
        Log.d(TAG, "calling onScreenStarted()");
        LoadInitialComponents();
    }

    @Override
    public void onResume(AddProduct.PresenterToView view) {
        setView(view);
        Log.d(TAG, "calling onResume()");
        LoadInitialComponents();

        if (configurationChangeOccurred()) {
            LoadInitialComponents();
        }
    }

    @Override
    public void onDestroy(boolean isChangingConfiguration) {
        Log.d(TAG, "calling onDestroy()");
        super.onDestroy(isChangingConfiguration);

    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "calling onBackPressed()");

    }

    @Override
    public Context getManagedContext() {
        return getActivityContext();
    }

    @Override
    public void destroyView() {
        if (isViewRunning()) {
            getView().finishScreen();
        }
    }


    @Override
    public void onPublishButtonClicked() {
        Log.d(TAG, "callingOnPublish");

        Navigator app = (Navigator) getView().getApplication();
        app.goToProductScreenFromAddScreen(this);
    }

    @Override
    public void DataFromAddView(ProductData product) {
        this.product = product;
    }

    @Override
    public ProductData getProductAddedView() {
        return product;
    }

    private void LoadInitialComponents() {
        getView().setNameLabel(getModel().getNameLabel());
        getView().setPlaceLabel(getModel().getPlaceLabel());
        getView().setDateLabel(getModel().getDateLabel());
        getView().setTimeInitLabel(getModel().getTimeInitLabel());
        getView().setTimeFinishLabel(getModel().getTimeFinishLabel());
        getView().setDetailsLabel(getModel().getDetailsLabel());
        getView().setPublishBtnLabel(getModel().getPublishBtnLabel());
    }
}