package es.ulpgc.eite.clean.mvp.sample.information;

import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.app.Mediator;

/**
 * Created by alumno on 31/03/2017.
 */

public class InformationPresenter extends GenericPresenter<Information.PresenterToView, Information.PresenterToModel,
        Information.ModelToPresenter, InformationModel>
        implements Information.ViewToPresenter, Information.ModelToPresenter, Information.ToInformation
        , Information.InformationTo {
    @Override
    public void onCreate(Information.PresenterToView view) {
        super.onCreate(InformationModel.class, this);
        setView(view);

        Mediator app = (Mediator) getApplication();
        app.startingInformationScreen(this);

    }

    @Override
    public void onResume(Information.PresenterToView view) {
        setView(view);
    }

    @Override
    public void onDestroy(boolean isChangingConfiguration) {
        super.onDestroy(isChangingConfiguration);
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public void onScreenStarted() {
        if (isViewRunning()) {
            CategoryData item = getModel().getItem();
            getView().setText(item.getDetails());
        }
    }

    @Override
    public void setItem(CategoryData itemSelected) {
        getModel().setItem(itemSelected);
    }
}
