package es.ulpgc.eite.clean.mvp.sample.examenScreen2;

import android.util.Log;

import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.Mediator;
import es.ulpgc.eite.clean.mvp.sample.realmoperation.RealmOperation;

/**
 * Created by Pedro Arenas on 31/5/17.
 */

public class ExamenScreenPresenter2
        extends GenericPresenter<ExamenScreen2.PresenterToView, ExamenScreen2.PresenterToModel, ExamenScreen2.ModelToPresenter, ExamenScreenModel2>
        implements ExamenScreen2.ViewToPresenter, ExamenScreen2.ModelToPresenter, ExamenScreen2.ToDetail {

    private RealmOperation realmOperation;


    @Override
    public void onCreate(ExamenScreen2.PresenterToView View) {
        super.onCreate(ExamenScreenModel2.class, this);
        setView(View);
        realmOperation = RealmOperation.getInstances();

        Mediator app = (Mediator) getApplication();
        app.startingExamenScreen2(this);

    }

    @Override
    public void onResume(ExamenScreen2.PresenterToView View) {
        Log.d(TAG, "Calling onResume()");
        setView(View);

        if (configurationChangeOccurred()) {

        }

    }

    @Override
    public void onDestroy(boolean isChangingConfiguration) {
        super.onDestroy(isChangingConfiguration);
    }

    @Override
    public void onBackPressed() {

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void onScreenStarted() {
        if (isViewRunning()) {
            Integer size = realmOperation.getCategoryEvents().size();
            getView().setSizeDbOnScreen(size.toString());
        }
    }

}
