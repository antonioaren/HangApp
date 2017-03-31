package es.ulpgc.eite.clean.mvp.sample.search;

import android.app.Application;
import android.content.Context;

import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.Presenter;
import es.ulpgc.eite.clean.mvp.sample.hangapp.HangApp;
import es.ulpgc.eite.clean.mvp.sample.hangapp.HangAppModel;

/**
 * Created by alumno on 29/03/2017.
 */
public class SearchPresenter  extends GenericPresenter<Search.PresenterToView, Search.PresenterToModel, Search.ModelToPresenter, SearchModel>
        implements HangApp.ViewToPresenter, HangApp.ModelToPresenter, HangApp.DummyTo, HangApp.ToDummy, HangApp.SearchTo, HangApp.ToHangApp, HangApp.HangAppToAdd, HangApp.AddTo {


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
    public void onSecundaryButtonsearchPressed(){

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
