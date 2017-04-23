package es.ulpgc.eite.clean.mvp.sample.add;

import android.content.Context;
import android.util.Log;

import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.Mediator;
import es.ulpgc.eite.clean.mvp.sample.hangapp.HangApp;

/**
 * Created by eleonora on 17/04/2017.
 */

public class AddPartyPresenter extends GenericPresenter<Add.PresenterToView, Add.PresenterToModel, Add.ModelToPresenter, AddPartyModel>
        implements Add.ViewToPresenter, Add.ModelToPresenter, Add.DummyTo, Add.SearchTo,  Add.AddTo, Add.HangAppTo, HangApp.toAdd {
private boolean buttonClicked;

    @Override
    public void onPublishClicked() {

    }

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


    }




    @Override
    public void onResume(Add.PresenterToView view) {
        setView(view);
        Log.d(TAG, "calling onResume()");


        if(configurationChangeOccurred()) {

            getView().setLabel(getModel().getPublishBtnLabel());
            getView().setLabel(getModel().getPlaceLabel());
            getView().setLabel(getModel().getDateLabel());
            getView().setLabel(getModel().getTimeInitLabel());
            getView().setLabel(getModel().getTimeFinishLabel());

            if (buttonClicked) {
                getView().setText(getModel().getTitleLabel());
            }


        }
    }

    @Override
    public void onDestroy(boolean isChangingConfiguration) {
        super.onDestroy(isChangingConfiguration);
        Log.d(TAG, "calling onDestroy()");
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG,"Calling onBackPressed()");

    }



    @Override
    public Context getManagedContext(){
        return getActivityContext();
    }
    @Override
    public void destroyView() {
        if(isViewRunning()) {
            getView().finishScreen();
        }
    }

    @Override
    public boolean isTextVisible() {
        return false;
    }


    @Override
    public void setTextVisibility(boolean visible) {

    }

    @Override
    public void setSelectorsVisibility(boolean visible) {

    }
}