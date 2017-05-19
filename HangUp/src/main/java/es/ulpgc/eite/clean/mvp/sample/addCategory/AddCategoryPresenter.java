package es.ulpgc.eite.clean.mvp.sample.addCategory;

import android.content.Context;
import android.util.Log;

import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import es.ulpgc.eite.clean.mvp.sample.data.Repository;
import io.realm.RealmList;

/**
 * Created by eleonora on 17/04/2017.
 */

public class AddCategoryPresenter
        extends GenericPresenter<Add.PresenterToView, Add.PresenterToModel, Add.ModelToPresenter, AddCategoryModel>
        implements Add.ViewToPresenter, Add.ModelToPresenter, Add.ToAdd, Add.AddTo {


    private boolean buttonClicked;
    private Repository.ProductRepository.OnSaveProductCallback callback;
    @Override
    public void onCreate(Add.PresenterToView view) {
        super.onCreate(AddCategoryModel.class, this);
        setView(view);
        Log.d(TAG, "calling onCreate()");

        Log.d(TAG, "calling startingAddScreen()");
//        Mediator app = (Mediator) getView().getApplication();
//        app.startingAddScreen(this);
    }

    @Override
    public void onScreenStarted() {
        Log.d(TAG, "calling onScreenStarted()");


    }

    @Override
    public void onResume(Add.PresenterToView view) {
        setView(view);
        Log.d(TAG, "calling onResume()");


        if (configurationChangeOccurred()) {


            if (buttonClicked) {
                //getView().setText(getModel().getPublishBtnLabel());
            }

        }

    }

    @Override
    public void onDestroy(boolean isChangingConfiguration) {
        Log.d(TAG, "calling onDestroy()");
        super.onDestroy(isChangingConfiguration);

    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "calling onBackPressed()");

    }
    @Override
    public Context getManagedContext(){
        return getActivityContext();
    }

    @Override
    public void destroyView() {
        if (isViewRunning()) {
            getView().finishScreen();
        }
    }


    @Override
    public Repository.ProductRepository.OnSaveProductCallback getCallBack() {
        return callback;
    }

    @Override
    public RealmList<ProductData> getParty() {
        return null;
    }






    @Override
    public void setTextVisibility(boolean visible) {
    }

    @Override
    public RealmList<CategoryData> getDefaultList() {
        return null;
    }


    @Override
    public void onSelectClicked() {

    }

    @Override
    public void onAddClicked() {

    }
}