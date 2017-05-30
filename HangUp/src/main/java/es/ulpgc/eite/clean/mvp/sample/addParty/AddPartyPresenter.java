package es.ulpgc.eite.clean.mvp.sample.addParty;

import android.content.Context;
import android.util.Log;

import java.util.UUID;

import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.Mediator;
import es.ulpgc.eite.clean.mvp.sample.app.Navigator;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import es.ulpgc.eite.clean.mvp.sample.data.Repository;

/**
 * Created by eleonora on 17/04/2017.
 */

public class AddPartyPresenter
        extends GenericPresenter<Add.PresenterToView, Add.PresenterToModel, Add.ModelToPresenter, AddPartyModel>
        implements Add.ViewToPresenter, Add.ModelToPresenter, Add.ToAdd, Add.AddTo {



    private Repository.ProductRepository.OnSaveProductCallback callback;
    private ProductData product;

    @Override
    public void onCreate(Add.PresenterToView view) {
        super.onCreate(AddPartyModel.class, this);
        setView(view);
        Log.d(TAG, "calling onCreate()");

        Log.d(TAG, "calling startingAddScreen()");
        Mediator app = (Mediator) getView().getApplication();
        app.startingAddScreen(this);
    }

    @Override
    public void onScreenStarted() {
        Log.d(TAG, "calling onScreenStarted()");
        LoadInitialComponents();
    }

    @Override
    public void onResume(Add.PresenterToView view) {
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

//    public String getDescriptionOfTheParty() {
//        return getModel().getDescription();
//    }
//
//    public Repository.ProductRepository.OnSaveProductCallback getCallBack() {
//        return callback;
//    }
//
//    public RealmList<ProductData> getParty() {
//        return null;
//    }

    @Override
    public void onPublishButtonClicked() {
        Log.d(TAG, "callingOnPublish");
        String id = UUID.randomUUID().toString();
        String name = getView().getName();
        String place = getView().getPlaceOfTheParty();
        String date = getView().getDateOfTheParty();
        int hourInit = getView().getHourOfInit();
        int hourFinish = getView().getHourOfFinish();
        getModel().insertEvent(id, name, place, date, hourInit, hourFinish);
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

    @Override
    public String getNameOfTheParty() {
        return getView().getName();
    }

    @Override
    public String getPlaceOfTheParty() {
        return getView().getPlaceOfTheParty();
    }

    @Override
    public String getDateOfTheParty() {
        return getView().getDateOfTheParty();
    }

    @Override
    public String getHourOfParty() {
        return getView().getHourOfInit() + " " + getView().getHourOfFinish();
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