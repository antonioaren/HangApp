package es.ulpgc.eite.clean.mvp.sample.add;

import android.content.Context;
import android.util.Log;

import java.util.List;

import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.Mediator;
import es.ulpgc.eite.clean.mvp.sample.category.CategoryView;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.InformationData;
import es.ulpgc.eite.clean.mvp.sample.data.InformationData_Old;
import io.realm.RealmList;
import io.realm.annotations.Required;

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

        if (isViewRunning()) {
            getModel().setDay(getView().getDay());
            getModel().setHourOfFinish(getView().getHourOfFinish());
            getModel().setHourOfInit(getView().getHourOfInit());
            getModel().setMonth(getView().getMonth());
            getModel().setPlaceOfTheParty(getView().getPlaceOfTheParty());
            getModel().setYear(getView().getYear());
             getModel().setDescription(getView().getDescription());

//           List<InformationData_Old>list= new ArrayList<>();
//            list.add(new InformationData_Old(R.drawable.astro,"name","0", "details","story","date", "hour"));
//           CategoryModel categoryModel= new CategoryModel();
//            List<CategoryData>category=categoryModel.getListCategory();
//            category.add(new CategoryData(R.drawable.astro,"name",
//                    "0", list, "detail",
//                   "story", "date", "hour"));
//            CategoryView categoryView= new CategoryView();
//            categoryView.settingAdapter(category);

        }


    }

    @Override
    public void setTextVisibility(boolean visible) {
    }

    @Override
    public void setPlace(String place) {

    }

    @Override
    public void setDate(String date) {

    }

    @Override
    public void setHour(String hour) {

    }

    @Override
    public String getPlaceOfTheParty() {
        return getModel().getPlaceOfTheParty();
    }

    @Override
    public String getDateOfTheParty() {
        return getModel().getDateOfTheParty();
    }

    @Override
    public String getHourOfParty() {
        return getModel().getHourOfParty();
    }

    @Override
    public RealmList<CategoryData> getDefaultList() {
        return null;
    }

    @Override
    public RealmList<CategoryData> getPartyAdded() {

        return (RealmList<CategoryData>) getModel().getPartyAdded();
    }

    @Override
    public RealmList<InformationData> getPartyCreated() {

        return (RealmList<InformationData>) getModel().getParty();
    }

    @Override
    public void settingAdapter(RealmList<CategoryData> item) {
        CategoryView categoryView = new CategoryView();
        categoryView.settingAdapter(item);
    }

}