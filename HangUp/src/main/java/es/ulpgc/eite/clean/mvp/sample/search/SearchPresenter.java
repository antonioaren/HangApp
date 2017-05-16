package es.ulpgc.eite.clean.mvp.sample.search;

import android.content.Context;
import android.util.Log;

import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.Mediator;
import es.ulpgc.eite.clean.mvp.sample.app.Navigator;
import es.ulpgc.eite.clean.mvp.sample.category.Category;

/**
 * Created by alumno on 29/03/2017.
 */
public class SearchPresenter
        extends GenericPresenter<Search.PresenterToView, Search.PresenterToModel, Search.ModelToPresenter, SearchModel>
        implements Search.ViewToPresenter, Search.ModelToPresenter, Search.SearchTo, Search.ToSearch {


    private boolean informationVisible;
    private boolean imageVisibility;
    private boolean participantExists;
    private boolean buttonClicked;

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
    public void onResume(Search.PresenterToView view) {
        setView(view);
        Log.d(TAG, "calling onResume()");


        if (configurationChangeOccurred()) {
            getView().setLabel(getModel().getSearchBtnLabel());
            getView().setLabel(getModel().getCategoryLabel());
            getView().setLabel(getModel().getDateLabel());
            getView().setLabel(getModel().getPlaceLabel());


            if (buttonClicked) {
                getView().setText(getModel().getSearchText());
            }
        }
    }

    @Override
    public void onDestroy(boolean isChangingConfiguration) {
        super.onDestroy(isChangingConfiguration);
        Log.d(TAG, "calling onDestroy()");
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "calling onBackPressed()");
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

    @Override
    public String[] getCategories() {
        String[] list = getModel().getListCategories();
        return list;
    }

    @Override
    public void onItemListClicked() {
        Log.d(TAG, "calling onItemListClicked");
        Navigator app = (Navigator) getView().getApplication();
        //Revisar esta llamada.
        app.goToProductScreen((Category.CategoryTo) this);
    }


    @Override
    public Context getManagedContext() {
        return getActivityContext();
    }

    @Override
    public void setImageVisibility(boolean visible) {
    }

    @Override
    public void setInformationVisibility(boolean visible) {
    }

    @Override
    public void setParticipantsVisibility(boolean visible) {
    }

    @Override
    public void destroyView() {
    }

    @Override
    public boolean isTextVisible() {
        return false;
    }
}