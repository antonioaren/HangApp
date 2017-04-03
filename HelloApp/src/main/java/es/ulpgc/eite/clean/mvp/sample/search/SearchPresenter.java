package es.ulpgc.eite.clean.mvp.sample.search;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.Presenter;
import es.ulpgc.eite.clean.mvp.sample.app.Navigator;
import es.ulpgc.eite.clean.mvp.sample.hangapp.HangApp;
import es.ulpgc.eite.clean.mvp.sample.hangapp.HangAppModel;
import es.ulpgc.eite.clean.mvp.sample.search.Search.ViewToPresenter;

/**
 * Created by alumno on 29/03/2017.
 */
public class SearchPresenter implements Presenter<Search.PresenterToView> {


    private boolean informationVisible;
    private boolean imageVisibility;
    private boolean participantExists;

    @Override
    public void onCreate(Search.PresenterToView presenterToView) {

    }

    @Override
    public void onResume(Search.PresenterToView presenterToView) {

    }

    @Override
    public void onDestroy(boolean b) {

    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public Application getApplication() {
        return null;
    }

    @Override
    public Context getApplicationContext() {
        return null;
    }

    @Override
    public Context getActivityContext() {
        return null;
    }


}
