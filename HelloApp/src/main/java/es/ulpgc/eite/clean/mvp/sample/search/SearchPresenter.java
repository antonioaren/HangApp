package es.ulpgc.eite.clean.mvp.sample.search;

import android.app.Application;
import android.content.Context;

import es.ulpgc.eite.clean.mvp.Presenter;

/**
 * Created by alumno on 29/03/2017.
 */
public class SearchPresenter implements Presenter<Search.PresenterToView> {


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
