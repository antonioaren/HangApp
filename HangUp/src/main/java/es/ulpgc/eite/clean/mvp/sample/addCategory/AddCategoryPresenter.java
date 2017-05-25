package es.ulpgc.eite.clean.mvp.sample.addCategory;

import android.content.Context;
import android.util.Log;

import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.Mediator;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import es.ulpgc.eite.clean.mvp.sample.data.Repository;
import io.realm.RealmList;

/**
 * Created by eleonora on 17/04/2017.
 */

public class AddCategoryPresenter
        extends GenericPresenter<AddCategory.PresenterToView, AddCategory.PresenterToModel, AddCategory.ModelToPresenter, AddCategoryModel>
        implements AddCategory.ViewToPresenter, AddCategory.ModelToPresenter, AddCategory.ToAdd, AddCategory.AddTo {


    private boolean buttonClicked;
    private Repository.ProductRepository.OnSaveProductCallback callback;
    @Override
    public void onCreate(AddCategory.PresenterToView view) {
        super.onCreate(AddCategoryModel.class, this);
        setView(view);
        Log.d(TAG, "calling onCreate()");

        Log.d(TAG, "calling startingAddCategoryScreen()");
        Mediator app = (Mediator) getView().getApplication();
    app.startinAddCategoryScreen(this);
    }

    @Override
    public void onScreenStarted() {
        Log.d(TAG, "calling onScreenStarted()");


    }

    @Override
    public void onResume(AddCategory.PresenterToView view) {
        setView(view);
        Log.d(TAG, "calling onResume()");


        if (configurationChangeOccurred()) {

            getView().setTitleLabel(getModel().getTitleLabel());
            getView().setNameLabel(getModel().getNameLabel());
            getView().setPhotoLabel(getModel().getPhotoLabel());
            getView().setRadioButtonLabels(getModel().getLabelRadio0(),getModel().getLabelRadio1(),getModel().getLabelRadio2(),getModel().getLabelRadio3());
            getView().setAddBtnLabel(getModel().getButtonAddlabel());


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
    public void onAddClicked() {
       int image= getModel().getImageByIdSelected(getView().getRadioButtonId());
        getModel().insertEvent(getView().getTextFromEditText(),image );
        Mediator app= (Mediator)getView().getApplication();
        app.SaveDataAdd(this);
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
    public String getDescriptionOfTheParty() {
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
     Mediator app=(Mediator)getView().getApplication();
        //app.selectImageFromGalery(this);
    }

@Override
    public String[]getNames(){
    return getModel().getNames();
}
@Override
    public Integer[]getImages(){
    return getModel().getImages();
}
}

