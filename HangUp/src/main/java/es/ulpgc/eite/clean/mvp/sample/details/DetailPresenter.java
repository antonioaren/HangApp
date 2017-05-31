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
        if (isViewRunning()) {
            setHeaders();
            setDataInTheScreen();
        }
    }

    @Override
    public void setItemSelected(ProductData itemSelected) {
        getModel().setItemSelected(itemSelected);
    }

    private void setHeaders() {
        getView().setHeaderPlace(getModel().getHeaderPlaceLabel());
        getView().setHeaderDate(getModel().getHeaderDateLabel());
        getView().setHeaderTimeInit(getModel().getHeaderTimeInitLabel());
        getView().setHeaderTimeEnd(getModel().getHeaderTimeEndLabel());
    }

    private void setDataInTheScreen() {
        getView().setEventName(getModel().getItemSelected().getProductName());
        getView().setDetail(getModel().getItemSelected().getDetailText());
        getView().setPlace(getModel().getItemSelected().getPlace());
        getView().setDate(getModel().getItemSelected().getDate());
        getView().setTimeInit(getModel().getItemSelected().getTimeI());
        getView().setTimeEnd(getModel().getItemSelected().getTimeF());
    }


}
