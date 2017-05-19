package addCategory;


import android.content.Context;

import java.util.List;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.Model;
import es.ulpgc.eite.clean.mvp.Presenter;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import es.ulpgc.eite.clean.mvp.sample.data.Repository;
import io.realm.RealmList;
import io.realm.RealmResults;


public interface Add {


    ///////////////////////////////////////////////////////////////////////////////////
    // State /////////////////////////////////////////////////////////////////////////

    interface ToAdd {
        void onScreenStarted();

        void setTextVisibility(boolean visible);

        void setPlace(String place);

        void setDate(String date);

        void setHour(String hour);

        RealmList<CategoryData> getDefaultList();
    }


    interface AddTo {
        Context getManagedContext();

        String getPlaceOfTheParty();

        String getDateOfTheParty();

        String getHourOfParty();

        RealmList<CategoryData> getPartyAdded();

        RealmList<ProductData> getPartyCreated();

        void settingAdapter(RealmList<CategoryData> item);

        void destroyView();

        String getDescriptionOfTheParty();
        Repository.ProductRepository.OnSaveProductCallback getCallBack();

        RealmList<ProductData> getParty();
    }


    ///////////////////////////////////////////////////////////////////////////////////
    // Screen ////////////////////////////////////////////////////////////////////////

    /**
     * Methods offered to VIEW to communicate with PRESENTER
     */

    interface ViewToPresenter extends Presenter<PresenterToView> {
        void onPublishClicked();
    }

    /**
     * Required VIEW methods available to PRESENTER
     */

    interface PresenterToView extends ContextView {

        void settingAdapter(RealmResults<CategoryData> data);

        void finishScreen();

        void hideToolbar();


        void setPublishBtnLabel(String txt);

        void setTitleLabel(String txt);

        void setPlaceLabel(String txt);

        void setDateLabel(String txt);

        void setTimeInitLabel(String txt);

        void setTimeFinishLabel(String txt);

        void hideText();

        void setText(String txt);

        void setLabel(String txt);

        String getMonth();

        String getDay();

        int getYear();

        String getPlaceOfTheParty();

        String getDescription();

        int getHourOfInit();

        int getHourOfFinish();
    }

    /**
     * Methods offered to MODEL to communicate with PRESENTER
     */

    interface PresenterToModel extends Model<ModelToPresenter> {

        String getDescription();

        String getPlaceLabel();

        String getPublishBtnLabel();

        String getDateLabel();

        String getTimeInitLabel();

        String getTimeFinishLabel();

        String getTitleLabel();

        void setPlaceLabel(String placeLabel);

        void setDateLabel(String dateLabel);

        void setTimeInitLabel(String timeInitLabel);

        void setTimeFinishLabel(String timeFinishLabel);

        void setPublishLabel(String publishLabel);

        void setTitleLabel(String titleLabel);

        String getPlaceOfTheParty();

        String getDateOfTheParty();

        String getHourOfParty();


        void setDay(String day);

        void setHourOfFinish(int hour);

        void setHourOfInit(int hour);

        void setMonth(String month);

        void setPlaceOfTheParty(String place);

        void setYear(int year);

        List<CategoryData> getPartyAdded();

        RealmList<ProductData> getParty();

        void setDescription(String description);


    }

    /**
     * Required PRESENTER methods available to MODEL
     */
    interface ModelToPresenter {

    }


}
