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
public class SearchPresenter  extends GenericPresenter<Search.ViewToPresenter, Search.PresenterToModel, Search.ModelToPresenter, SearchModel> implements Search, Search.ProcessedTo {


    @Override
    public void onCreate(Search.PresenterToView presenterToView) {

    }

    @Override
    public void onResume(Search.PresenterToView presenterToView) {

    }

    @Override
    public void onCreate(ViewToPresenter viewToPresenter) {

    }

    @Override
    public void onResume(ViewToPresenter viewToPresenter) {

    }

    @Override
    public void onDestroy(boolean b) {

    }


    @Override
    public void onButtonSecundarySearchPressed(){
        Log.d(TAG,"Calling on button search");

        Navigator app = (Navigator) getView().getApplication();
        app.goToProcessedInformationScreen(this);
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
    public boolean isInformationVisible() {
        return false;
    }

    @Override
    public boolean isImageVisible() {
        return false;
    }

    @Override
    public boolean ParticipantsExist() {
        return false;
    }

    @Override
    public Context getManagedContext() {
        return null;
    }

    @Override
    public void destroyView() {

    }
}
