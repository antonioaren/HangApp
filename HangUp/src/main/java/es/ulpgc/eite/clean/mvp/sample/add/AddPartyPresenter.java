package es.ulpgc.eite.clean.mvp.sample.add;

import android.content.Context;
import android.util.Log;

import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.Mediator;
import es.ulpgc.eite.clean.mvp.sample.app.Navigator;

/**
 * Created by eleonora on 17/04/2017.
 */

public class AddPartyPresenter
        extends GenericPresenter<Add.PresenterToView, Add.PresenterToModel, Add.ModelToPresenter, AddPartyModel>
        implements Add.ViewToPresenter, Add.ModelToPresenter, Add.ToAdd, Add.AddTo {


    private boolean buttonClicked;

    @Override
    public void onCreate(Add.PresenterToView view) {
        super.onCreate(AddPartyModel.class, this);
        setView(view);
        Log.d(TAG, "calling onCreate()");

        Log.d(TAG, "calling startingAddScreen()");
        Mediator app = (Mediator) getView().getApplication();
        app.startingAddScreen(this);
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

            getView().setLabel(getModel().getPlaceLabel());
            getView().setLabel(getModel().getDateLabel());
            getView().setLabel(getModel().getTimeInitLabel());
            getView().setLabel(getModel().getTimeFinishLabel());
            if (buttonClicked) {
                getView().setText(getModel().getPublishBtnLabel());
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
    public void onPublishClicked() {
        Log.d(TAG, "callingOnPublish");

        Navigator app = (Navigator) getView().getApplication();
        app.publishParty(this);
        //El codigo siguiente no va aqui, es solo por probar 
       /*CategoryView category= new CategoryView();
      List<CategoryData> party= new ArrayList<CategoryData>();
       List<InformationData>item= new ArrayList<InformationData>();
        item.add(new InformationData(R.drawable.astro,"name","123","detail","detail","detail","detail"));
        party.add(new CategoryData(R.drawable.astro,"name","123",item,"detail","detail","detail","detail"));
        category.settingAdapter(party);*/

    }

    @Override
    public void setTextVisibility(boolean visible) {
    }

    /* public void SaveParty() {
         getView().getDay();
         getView().getMonth();
         getView().getYear();
         getView().getHourOfInit();
         getView().getHourOfFinish();
         getView().getPlaceOfTheParty();
     }*/
    @Override
    public String getPlace() {
        return getView().getPlaceOfTheParty();

    }

    @Override
    public String getDay() {
        return getView().getDay();

    }

    @Override
    public String getMonth() {
        return getView().getMonth();

    }

    @Override
    public int getYear() {
        return getView().getYear();

    }

    @Override
    public int getInitTIme() {
        return getView().getHourOfInit();

    }

    @Override
    public int getFinishTime() {
        return getView().getHourOfFinish();

    }
}