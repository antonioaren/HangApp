package es.ulpgc.eite.clean.mvp.sample.delete;

import android.content.Context;
import android.util.Log;

import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.Mediator;
import es.ulpgc.eite.clean.mvp.sample.app.Navigator;
import es.ulpgc.eite.clean.mvp.sample.category.Category;

/**
 * Created by alumno on 29/03/2017.
 */
public class DeletePresenter
        extends GenericPresenter<Delete.PresenterToView, Delete.PresenterToModel, Delete.ModelToPresenter, DeleteModel>
        implements Delete.ViewToPresenter, Delete.ModelToPresenter, Delete.DeleteTo, Delete.ToDelete {


    private boolean informationVisible;
    private boolean imageVisibility;
    private boolean participantExists;
    private boolean buttonClicked;

    @Override
    public void onCreate(Delete.PresenterToView view) {
        super.onCreate(DeleteModel.class, this);
        setView(view);
        Log.d(TAG, "calling onCreate()");

        Log.d(TAG, "calling startingSearchScreen()");
        Mediator app = (Mediator) getView().getApplication();
        app.startingDeleteScreen(this);
    }



    @Override
    public void onResume(Delete.PresenterToView view) {
        setView(view);
        Log.d(TAG, "calling onResume()");


        if (configurationChangeOccurred()) {
            getView().setDeleteBtnLabel(getModel().getDeleteBtnLabel());
            getView().setText1label(getModel().getText1Label());
            getView().setDeleIdBtnLabel(getModel().getDeleteIdBtnLabel());
            getView().setText2label(getModel().getText2Label());


//            if (buttonClicked) {
//                //getView().setText(getModel().getSearchText());
//            }
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
    public void onItemListClicked() {
        Log.d(TAG, "calling onItemListClicked");
        Navigator app = (Navigator) getView().getApplication();
        //Revisar esta llamada.
        app.goToProductScreen((Category.CategoryTo) this);
    }

    @Override
    public void onDeleteClicked() {
        getModel().deteleEvent(getView().getTextFromEditText());
        Mediator app= (Mediator)getView().getApplication();
        app.deleteEvent(this);
    }

    @Override
    public void onDeleteIdClicked() {

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

    @Override
    public String getNameToDelete() {
        return getView().getTextFromEditText();
    }
}