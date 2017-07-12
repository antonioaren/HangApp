package es.ulpgc.eite.clean.mvp.sample.examenScreen1;

import android.util.Log;

import es.ulpgc.eite.clean.mvp.GenericPresenter;

/**
 * Created by Pedro Arenas on 31/5/17.
 */

public class ExamenScreenPresenter1
        extends GenericPresenter<ExamenScreen1.PresenterToView, ExamenScreen1.PresenterToModel, ExamenScreen1.ModelToPresenter, ExamenScreenModel1>
        implements ExamenScreen1.ViewToPresenter, ExamenScreen1.ModelToPresenter, ExamenScreen1.ToDetail {


    @Override
    public void onCreate(ExamenScreen1.PresenterToView View) {
        super.onCreate(ExamenScreenModel1.class, this);
        setView(View);
    }

    @Override
    public void onResume(ExamenScreen1.PresenterToView View) {
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

    }


}
