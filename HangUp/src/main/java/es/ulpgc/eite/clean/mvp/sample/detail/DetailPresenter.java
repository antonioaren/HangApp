package es.ulpgc.eite.clean.mvp.sample.detail;

import android.content.Context;
import android.util.Log;

import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.Mediator;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;

/**
 * Created by eleonora on 17/04/2017.
 */

public class DetailPresenter
        extends GenericPresenter<Detail.PresenterToView, Detail.PresenterToModel, Detail.ModelToPresenter, DetailModel>
        implements Detail.ViewToPresenter, Detail.ModelToPresenter, Detail.ToDetail, Detail.DetailTo {

    @Override
    public void onCreate(Detail.PresenterToView view) {
        super.onCreate(DetailModel.class, this);
        setView(view);
        Log.d(TAG, "calling onCreate()");

        Mediator app = (Mediator) getView().getApplication();
        app.startingDetailScreen(this);
    }

    @Override
    public void onResume(Detail.PresenterToView view) {
        Log.d(TAG, "calling onResume()");
        setView(view);

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


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void onScreenStarted() {
        Log.d(TAG, "calling onScreenStarted()");
    }

    @Override
    public Context getManagedContext() {
        return getActivityContext();
    }

    @Override
    public void setItemSelected(ProductData itemSelected) {
        getModel().setItemSelected(itemSelected);
    }


}