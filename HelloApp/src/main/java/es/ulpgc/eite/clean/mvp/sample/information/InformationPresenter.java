package es.ulpgc.eite.clean.mvp.sample.information;

import android.app.Application;
import android.content.Context;

import es.ulpgc.eite.clean.mvp.Presenter;

/**
 * Created by alumno on 31/03/2017.
 */

public class InformationPresenter implements Presenter<Information.PresenterToView> {
    @Override
    public void onCreate(Information.PresenterToView presenterToView) {

    }

    @Override
    public void onResume(Information.PresenterToView presenterToView) {

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
