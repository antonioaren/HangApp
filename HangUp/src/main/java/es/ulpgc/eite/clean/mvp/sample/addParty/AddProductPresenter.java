package es.ulpgc.eite.clean.mvp.sample.addParty;

import android.content.Context;
import android.util.Log;
import android.view.View;

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


    private String categoryId;
    private boolean isAnyValueNull;

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

    ////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onScreenStarted() {
        Log.d(TAG, "calling onScreenStarted()");
        LoadInitialComponents();
    }

    @Override
    public void onButtonAddClicked() {
        Log.d(TAG, "callingOnPublish");
        CheckAnyValueIsNull();

        if (isAnyValueNull) {
            getView().setToast(getModel().getWarningEmpty());
        } else {
            getModel().insertProductToDatabase(getDataToSave(), categoryId);
            Navigator app = (Navigator) getView().getApplication();
            app.KillingAddProductScreenAfterInserting(this);
        }
    }

    @Override
    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    private ProductData getDataToSave() {

        ProductData product = new ProductData();

        product.setProductName(getView().getEventName());
        product.setPlace(getView().getEventPlace());
        product.setDate(getView().getEventDate());
        product.setTimeI(getView().getEventTimeInit());
        product.setTimeF(getView().getEventTimeFinish());
        product.setDetailText(getView().getEventDetails());
        product.setImage(getView().getStringImageUri());

        return product;
    }

    private void CheckAnyValueIsNull() {
        if (getView().getEventName() == null) {
            isAnyValueNull = true;
        } else if (getView().getEventPlace() == null) {
            isAnyValueNull = true;
        } else if (getView().getEventDate() == null) {
            isAnyValueNull = true;
        } else if (getView().getEventTimeInit() == null) {
            isAnyValueNull = true;
        } else if (getView().getEventTimeFinish() == null) {
            isAnyValueNull = true;
        } else if (getView().getEventDetails() == null) {
            isAnyValueNull = true;
        } else if (getView().getStringImageUri() == null) {
            isAnyValueNull = true;
        } else {
            isAnyValueNull = false;
        }
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