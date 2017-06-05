package es.ulpgc.eite.clean.mvp.sample.addParty;


import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;

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

        void setTextSelectPhotoLabel(String txt);

        void setPublishBtnLabel(String txt);


        void setNameLabel(String txt);

        void setPlaceLabel(String txt);

        void setDateLabel(String txt);

        void setTimeInitLabel(String txt);

        void setTimeFinishLabel(String txt);

        void setDetailsLabel(String detailsLabel);

        //
        String getName();

        String getPlaceOfTheParty();


        String getHourOfInit();

        @TargetApi(Build.VERSION_CODES.M)
        String getHourOfFinish();

        String getDateOfTheParty();


    }

    /**
     * Methods offered to MODEL to communicate with PRESENTER
     */

    interface PresenterToModel extends Model<ModelToPresenter> {

        String getNameLabel();

        void setNameLabel(String nameLabel);

        String getPlaceLabel();

        String getDetailsLabel();

        void setDetailsLabel(String detailsLabel);

        String getSelectPhotoTextLabel();

        void setSelectPhotoTextlabel(String text);

        String getPublishBtnLabel();

        String getDateLabel();

        String getTimeInitLabel();

        String getTimeFinishLabel();


        void setPlaceLabel(String placeLabel);

        void setDateLabel(String dateLabel);

        void setTimeInitLabel(String timeInitLabel);

        void setTimeFinishLabel(String timeFinishLabel);

        void setPublishLabel(String publishLabel);

        String getTitleLabel();

        void setTitleLabel(String titleLabel);


    }

    /**
     * Required PRESENTER methods available to MODEL
     */
    interface ModelToPresenter {

    }


}
