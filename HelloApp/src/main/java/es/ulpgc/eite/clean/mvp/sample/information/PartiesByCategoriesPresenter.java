package es.ulpgc.eite.clean.mvp.sample.information;

import android.content.Context;
import android.util.Log;

import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.Mediator;
import es.ulpgc.eite.clean.mvp.sample.app.Navigator;

/**
 * Created by eleonora on 21/04/2017.
 */

public class PartiesByCategoriesPresenter  extends GenericPresenter<PartiesByCategories.PresenterToView, PartiesByCategories.PresenterToModel, PartiesByCategories.ModelToPresenter, PartiesByCategoriesModel>
        implements PartiesByCategories.ViewToPresenter, PartiesByCategories.ModelToPresenter, PartiesByCategories.SearchTo, PartiesByCategories.ToPartiesByCategories,  PartiesByCategories.DetailTo, PartiesByCategories.ToDetail {


boolean buttonClicked;
boolean listVisibility;
    @Override
    public void onCreate(PartiesByCategories.PresenterToView view) {
        super.onCreate(PartiesByCategoriesModel.class, this);
        setView(view);
        Log.d(TAG, "calling onCreate()");

        Log.d(TAG, "calling startingMainScreen()");
        Mediator app = (Mediator) getView().getApplication();
        app.startingPartiesListScreen(this);
    }
    @Override
    public void onScreenStarted() {
        Log.d(TAG, "calling onScreenStarted()");
        if(isViewRunning()) {
            getView().setLabel(getModel().getTitleLabel());
            getView().setLabel(String.valueOf(getModel().getDefaulParty()));
        }
    }






    @Override
    public void onResume(PartiesByCategories.PresenterToView view) {
        setView(view);
        Log.d(TAG, "calling onResume()");


        if(configurationChangeOccurred()) {
            getView().setLabel(getModel().getTitleLabel());



            if (buttonClicked) {
                getView().setText(getModel().getTitleLabel());
            }
    }}



    @Override
    public void onBackPressed(){
  Log.d("TAG","calling onBackPressed()");
    }
@Override
    public String[] getContentDefaultList(){
    Log.d("TAG","Calling onItemCliked");
    String []defaultList=getModel().getDefaulParty();

    return defaultList;
}



    @Override
    public void onListCategoryItemClicked() {
        Log.d(TAG,"item cliked");
        Navigator app = (Navigator) getView().getApplication();
        app.goDetailScreenFromPartyList(this);
    }

    @Override
    public Context getManagedContext() {
         return getActivityContext();
    }

    @Override
    public void destroyView() {

    }

    @Override
    public void onDestroy(boolean isChangingConfiguration) {
        super.onDestroy(isChangingConfiguration);
        Log.d(TAG, "calling onDestroy()");
    }

    @Override
    public void setListVisibility(boolean visibility) {
        listVisibility=visibility;
    }


}
