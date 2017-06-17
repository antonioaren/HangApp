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

        String getFileName();
    }


    ///////////////////////////////////////////////////////////////////////////////////
    // Screen ////////////////////////////////////////////////////////////////////////

    /**
     * Methods offered to VIEW to communicate with PRESENTER
     */

    interface ViewToPresenter extends Presenter<PresenterToView> {
        void onPublishButtonClicked();


        void DataFromAddView(ProductData product);


        void setNameImage(String fileName);

        void ButtonTimeInitClicked();

        void timeFromTimePicker(Integer hour, Integer minutes);

        void ButtonTimeFinishClicked();

    }

    /**
     * Required VIEW methods available to PRESENTER
     */

    interface PresenterToView extends ContextView {

        void openDialog();

        void finishScreen();

//        void setTextSelectPhotoLabel(String txt);

        void setPublishBtnLabel(String txt);


        void setNameLabel(String txt);

        void setPlaceLabel(String txt);

        void setDateLabel(String txt);


        void setTimeInitLabel(String txt);

        void setTimeFinishLabel(String txt);

        void setDetailsLabel(String detailsLabel);

        void setTimeInitText(String txt);
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

        String getSelectTextLabel();

        void setSelectTextlabel(String text);

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


        int getImageByIdSelected(int id);
    }

    /**
     * Required PRESENTER methods available to MODEL
     */
    interface ModelToPresenter {

    }


}
