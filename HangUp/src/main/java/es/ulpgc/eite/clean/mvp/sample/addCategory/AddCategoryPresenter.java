package es.ulpgc.eite.clean.mvp.sample.addCategory;

import android.content.Context;
import android.util.Log;

import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.Mediator;
import es.ulpgc.eite.clean.mvp.sample.app.Navigator;

/**
 * Created by eleonora on 17/04/2017.
 */

public class AddCategoryPresenter
        extends GenericPresenter<AddCategory.PresenterToView, AddCategory.PresenterToModel, AddCategory.ModelToPresenter, AddCategoryModel>
        implements AddCategory.ViewToPresenter, AddCategory.ModelToPresenter, AddCategory.ToAdd, AddCategory.AddTo {

    private boolean isAnyValueNull;


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

        getView().setAssetsImage(getModel().getImage(1), getModel().getImage(2),
                getModel().getImage(3), getModel().getImage(4));

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
            getView().setAssetsImage(getModel().getImage(0), getModel().getImage(1), getModel().getImage(2), getModel().getImage(3));
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

        checkIsAnyValueNull();

        if (isAnyValueNull) {
            getView().setToast("All field are required");

        } else {

            String ImageName = getModel().getImageByIdSelected(getView().getRadioButtonId());
            String NewCategoryName = getView().getTextFromEditText();

            getModel().insertEvent(NewCategoryName, ImageName);
            getView().setToast(getModel().getToastNotifyingAdded());

            Navigator app = (Navigator) getView().getApplication();
            app.killingAddCategoryScreenAfterInserting(this);
        }
    }

    private void checkIsAnyValueNull() {

        if (getView().getRadioButtonId() == 0 ||
                getView().getTextFromEditText().isEmpty()) {
            setAnyValueNull(true);
        } else {
            setAnyValueNull(false);
        }
    }

    private boolean getIsAnyValueNull() {
        return isAnyValueNull;
    }

    private void setAnyValueNull(boolean anyValueNull) {
        isAnyValueNull = anyValueNull;
    }
}

