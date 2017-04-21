package es.ulpgc.eite.clean.mvp.sample.information;

import android.content.Context;
import android.util.Log;

import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.Navigator;
import es.ulpgc.eite.clean.mvp.sample.hangapp.HangApp;

/**
 * Created by eleonora on 21/04/2017.
 */

public class PartiesByCategoriesPresenter  extends GenericPresenter<PartiesByCategories.PresenterToView, PartiesByCategories.PresenterToModel, PartiesByCategories.ModelToPresenter, PartiesByCategories>
        implements PartiesByCategories.ViewToPresenter, PartiesByCategories.ModelToPresenter, PartiesByCategories.SearchTo, PartiesByCategories.ToPartiesByCategories, HangApp.DetailTo {
    @Override
    public void onCreate(PartiesByCategories.PresenterToView presenterToView) {

    }

    @Override
    public void onResume(PartiesByCategories.PresenterToView presenterToView) {

    }

    @Override
    public void onBackPressed() {

    }
@Override
    public String[] getContentList(){
    Log.d("TAG","Calling onItemCliked");
    PartiesByCategoriesModel pbcm= new PartiesByCategoriesModel();
   String[]content= pbcm.getDefaulParty();
    return content;
}
    @Override
    public void onListItemClicked() {
        Log.d(TAG,"item cliked");
        Navigator app = (Navigator) getView().getApplication();
        app.goDetailScreen(this);
    }

    @Override
    public Context getManagedContext() {
         return getActivityContext();
    }

    @Override
    public void destroyView() {

    }
}
