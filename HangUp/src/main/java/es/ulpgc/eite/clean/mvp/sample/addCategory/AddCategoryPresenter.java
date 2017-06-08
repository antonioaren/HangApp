package es.ulpgc.eite.clean.mvp.sample.addCategory;

import android.content.Context;
import android.util.Log;

import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.Mediator;
import es.ulpgc.eite.clean.mvp.sample.data.Repository;

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
        Mediator app = (Mediator) getView().getApplication();
        app.startingAddCategoryScreen(this);
    }

    @Override
    public void onScreenStarted() {
        Log.d(TAG, "calling onScreenStarted()");

        getView().setNameLabel(getModel().getNameLabel());
        getView().setPhotoLabel(getModel().getPhotoLabel());

        getView().setRadioButtonLabels(getModel().getLabelRadio0(), getModel().getLabelRadio1(),
                getModel().getLabelRadio2(), getModel().getLabelRadio3());

        getView().setAddBtnLabel(getModel().getButtonAddlabel());
    }

    @Override
    public void onResume(AddCategory.PresenterToView view) {
        setView(view);
        Log.d(TAG, "calling onResume()");


        if (configurationChangeOccurred()) {

            getView().setNameLabel(getModel().getNameLabel());
            getView().setPhotoLabel(getModel().getPhotoLabel());
            getView().setRadioButtonLabels(getModel().getLabelRadio0(), getModel().getLabelRadio1(), getModel().getLabelRadio2(), getModel().getLabelRadio3());
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
    public Context getManagedContext() {
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
        int image = getModel().getImageByIdSelected(getView().getRadioButtonId());
        getModel().insertEvent(getView().getTextFromEditText(), image);
        Mediator app = (Mediator) getView().getApplication();
        app.SaveDataAdd(this);
    }


    @Override
    public String getCategoryName() {
        return getView().getTextFromEditText();
    }

    @Override
    public int getRadioButtonSelected() {
        return getView().getRadioButtonId();
    }


    @Override
    public Integer[] getImages() {
        return getModel().getImages();
    }
}

