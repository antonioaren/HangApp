package es.ulpgc.eite.clean.mvp.sample.detail;

import android.content.Context;
import android.util.Log;

import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.Mediator;

/**
 * Created by eleonora on 17/04/2017.
 */

public class DetailPresenter
        extends GenericPresenter<Detail.PresenterToView, Detail.PresenterToModel, Detail.ModelToPresenter, DetailModel>
        implements Detail.ViewToPresenter, Detail.ModelToPresenter, Detail.ToAdd, Detail.AddTo {


    @Override
    public void onPublishClicked() {

    }

    @Override
    public void onCreate(Detail.PresenterToView view) {
        super.onCreate(DetailModel.class, this);
        setView(view);
        Log.d(TAG, "calling onCreate()");

        Log.d(TAG, "calling startingAddScreen()");
        Mediator app = (Mediator) getView().getApplication();
        app.startingDetailScreen(this);
    }

    @Override
    public void onScreenStarted() {
        Log.d(TAG, "calling onScreenStarted()");
    }

    @Override
    public void onResume(Detail.PresenterToView view) {
        setView(view);
        Log.d(TAG, "calling onResume()");


        if (configurationChangeOccurred()) {


        }
    }

    @Override
    public void onDestroy(boolean isChangingConfiguration) {
        super.onDestroy(isChangingConfiguration);
        Log.d(TAG, "calling onDestroy()");
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "Calling onBackPressed()");

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
    public boolean isTextVisible() {
        return false;
    }

    @Override
    public boolean isSelectorsVisible() {
        return false;
    }

    @Override
    public void setTextVisibility(boolean visible) {

    }
}