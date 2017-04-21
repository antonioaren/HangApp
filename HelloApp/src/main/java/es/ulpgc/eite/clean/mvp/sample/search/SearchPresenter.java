package es.ulpgc.eite.clean.mvp.sample.search;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.Navigator;

/**
 * Created by alumno on 29/03/2017.
 */
public class SearchPresenter  extends GenericPresenter<Search.PresenterToView, Search.PresenterToModel, Search.ModelToPresenter, SearchModel>
        implements Search.ViewToPresenter, Search.ModelToPresenter, Search.HangAppTo, Search.ToSearch, Search.DetailTo, Search.PartiesByCategoriesTo {


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


    public String[] getCategories() {
        SearchModel model= new SearchModel();
        String[]list= model.getListCategories();
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