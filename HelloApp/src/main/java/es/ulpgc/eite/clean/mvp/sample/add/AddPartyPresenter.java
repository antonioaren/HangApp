package es.ulpgc.eite.clean.mvp.sample.add;

import android.content.Context;
import android.util.Log;

import es.ulpgc.eite.clean.mvp.GenericPresenter;

/**
 * Created by eleonora on 17/04/2017.
 */

public class AddPartyPresenter extends GenericPresenter<Add.PresenterToView, Add.PresenterToModel, Add.ModelToPresenter, AddPartyModel>
        implements Add.ViewToPresenter, Add.ModelToPresenter, Add.DummyTo, Add.SearchTo,  Add.AddTo, Add.HangAppTo {


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
        Log.d(TAG,"Calling onBackPressed()");

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