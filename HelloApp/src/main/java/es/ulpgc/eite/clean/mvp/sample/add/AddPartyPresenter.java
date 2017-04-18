package es.ulpgc.eite.clean.mvp.sample.add;

import android.app.Application;
import android.content.Context;

import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.Navigator;

/**
 * Created by eleonora on 17/04/2017.
 */

public class AddPartyPresenter extends GenericPresenter<Add.PresenterToView, Add.PresenterToModel, Add.ModelToPresenter, AddModel>
        implements Add.ViewToPresenter, Add.ModelToPresenter, Add.DummyTo, Add.SearchTo,  Add.AddTo {


    @Override
    public void onPublishClicked() {

    }

    @Override
    public void onCreate(Add.PresenterToView presenterToView) {

    }

    @Override
    public void onResume(Add.PresenterToView presenterToView) {

    }

    @Override
    public void onDestroy(boolean b) {

    }

    @Override
    public void onBackPressed() {

       Navigator app = (Navigator) getView().getApplication();
    app.OnOptionsItemSelected();
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
    public Context getManagedContext(){
        return getActivityContext();
    }
    @Override
    public void destroyView() {

    }

    @Override
    public boolean isTextVisible() {
        return false;
    }
}
