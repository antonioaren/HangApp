package es.ulpgc.eite.clean.mvp.sample.detail;

import android.app.Application;
import android.content.Context;

import es.ulpgc.eite.clean.mvp.Presenter;

/**
 * Created by eleonora on 19/04/2017.
 */

public class DetailPresenter implements Presenter<Detail.PresenterToView> {
    @Override
    public void onCreate(Detail.PresenterToView presenterToView) {

    }

    @Override
    public void onResume(Detail.PresenterToView presenterToView) {

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
