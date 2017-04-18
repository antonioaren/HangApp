package es.ulpgc.eite.clean.mvp.sample.search;

import android.app.Application;
import android.content.Context;

import es.ulpgc.eite.clean.mvp.GenericPresenter;

/**
 * Created by alumno on 29/03/2017.
 */
public class SearchPresenter  extends GenericPresenter<Search.PresenterToView, Search.PresenterToModel, Search.ModelToPresenter, SearchModel>
        implements Search.ViewToPresenter, Search.ModelToPresenter, Search.HangAppTo, Search.ToSearch {


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


    @Override
    public void setTextVisibility(boolean visible) {

    }

    @Override
    public void onButtonSecundarySearchPressed() {

    }

    @Override
    public String[] getListCategories() {
        return new String[0];
    }
}
