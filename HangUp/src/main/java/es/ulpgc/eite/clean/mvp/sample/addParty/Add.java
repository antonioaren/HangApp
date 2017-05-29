package es.ulpgc.eite.clean.mvp.sample.addParty;


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

    }


    interface AddTo {
        Context getManagedContext();



        void destroyView();


        ProductData getProductAddedView();
    }


    ///////////////////////////////////////////////////////////////////////////////////
    // Screen ////////////////////////////////////////////////////////////////////////

    /**
     * Methods offered to VIEW to communicate with PRESENTER
     */

    interface ViewToPresenter extends Presenter<PresenterToView> {
        void onPublishButtonClicked();


        void DataFromAddView(ProductData product);
    }

    /**
     * Required VIEW methods available to PRESENTER
     */

    interface PresenterToView extends ContextView {

        void finishScreen();

        void setPublishBtnLabel(String txt);

        void setTitleLabel(String txt);

        void setNameLabel(String txt);

        void setPlaceLabel(String txt);

        void setDateLabel(String txt);

        void setTimeInitLabel(String txt);

        void setTimeFinishLabel(String txt);

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

        String getNameLabel();

        void setNameLabel(String nameLabel);

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


        void insertEvent(int image, String name, String numberOfParticipants);
    }

    /**
     * Required PRESENTER methods available to MODEL
     */
    interface ModelToPresenter {

    }


}
