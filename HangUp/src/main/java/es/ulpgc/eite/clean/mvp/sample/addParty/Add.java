package es.ulpgc.eite.clean.mvp.sample.addParty;


import android.content.Context;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.Model;
import es.ulpgc.eite.clean.mvp.Presenter;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;


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

        String getName();

        String getPlaceOfTheParty();


        String getDateOfTheParty();

        int getHourOfInit();

        int getHourOfFinish();
    }

    /**
     * Methods offered to MODEL to communicate with PRESENTER
     */

    interface PresenterToModel extends Model<ModelToPresenter> {


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

        String getHourInit();

        void setHourOfInit(int hour);

        void setMonth(String month);

        void setPlaceOfTheParty(String place);

        void setYear(int year);


        void setName(String name);

        String getName();


        String getItemId();

        void setItemId(String itemId);

        void insertEvent(String CategoryId, String name, String place, String date, int hourOfInit, int hourOfFinish);
    }

    /**
     * Required PRESENTER methods available to MODEL
     */
    interface ModelToPresenter {

    }


}
