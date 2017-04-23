package es.ulpgc.eite.clean.mvp.sample.search;

import android.content.Context;
import android.util.Log;

import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.Mediator;
import es.ulpgc.eite.clean.mvp.sample.app.Navigator;
import es.ulpgc.eite.clean.mvp.sample.hangapp.HangApp;

/**
 * Created by alumno on 29/03/2017.
 */
public class SearchPresenter  extends GenericPresenter<Search.PresenterToView, Search.PresenterToModel, Search.ModelToPresenter, SearchModel>
        implements Search.ViewToPresenter, Search.ModelToPresenter, Search.HangAppTo, Search.ToSearch, Search.DetailTo, Search.PartiesByCategoriesTo, HangApp.toSearch {


    private boolean informationVisible;
    private boolean imageVisibility;
    private boolean participantExists;

    @Override
    public void onCreate(Search.PresenterToView view) {
        super.onCreate(SearchModel.class, this);
        setView(view);
        Log.d(TAG, "calling onCreate()");

        Log.d(TAG, "calling startingSearchScreen()");
        Mediator app = (Mediator) getView().getApplication();
        app.startingSearchScreen(this);
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
    public void setTextVisibility(boolean visible) {

    }

    @Override
    public void onScreenStarted() {

    }

    @Override
    public void onButtonSecundarySearchPressed() {

    }


    public String[] getCategories() {

        String[]list= getModel().getListCategories();
        return list;
    }
@Override
public void onItemListClicked(){
    Log.d(TAG,"calling onItemListClicked");
    Navigator app = (Navigator) getView().getApplication();
    app.goToItemList(this);
}



    @Override
    public Context getManagedContext() {
        return getActivityContext();
    }
}