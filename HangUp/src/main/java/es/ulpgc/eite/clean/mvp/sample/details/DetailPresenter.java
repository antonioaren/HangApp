package es.ulpgc.eite.clean.mvp.sample.details;

import android.util.Log;

import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.Presenter;
import es.ulpgc.eite.clean.mvp.sample.app.Mediator;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;

/**
 * Created by Pedro Arenas on 31/5/17.
 */

public class DetailPresenter
        extends GenericPresenter<Detail.PresenterToView, Detail.PresenterToModel, Detail.ModelToPresenter, DetailModel>
        implements Detail.ViewToPresenter, Detail.ModelToPresenter, Detail.ToDetail, Detail.DetailTo {


    @Override
    public void onCreate(Detail.PresenterToView View) {
        super.onCreate(DetailModel.class, this);
        setView(View);

        Mediator app = (Mediator) getApplication();
        app.startingDetailScreen(this);
    }

    @Override
    public void onResume(Detail.PresenterToView View) {
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


    @Override
    public void setItemSelected(ProductData itemSelected) {
        getModel().setItemSelected(itemSelected);
    }


}
