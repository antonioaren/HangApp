package es.ulpgc.eite.clean.mvp.sample.addProduct;


import android.content.Context;
import android.widget.ImageButton;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.Model;
import es.ulpgc.eite.clean.mvp.Presenter;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;


public interface AddProduct {


    ///////////////////////////////////////////////////////////////////////////////////
    // State /////////////////////////////////////////////////////////////////////////

    interface ToAdd {
        void onScreenStarted();

        void setCategoryId(String categoryId);
    }


    interface AddTo {
        Context getManagedContext();

        void destroyView();


    }


    ///////////////////////////////////////////////////////////////////////////////////
    // Screen ////////////////////////////////////////////////////////////////////////

    /**
     * Methods offered to VIEW to communicate with PRESENTER
     */

    interface ViewToPresenter extends Presenter<PresenterToView> {
        void onButtonAddClicked();


    }

    /**
     * Required VIEW methods available to PRESENTER
     */

    interface PresenterToView extends ContextView {

        void openDialog();

        void finishScreen();


        void setPublishBtnLabel(String txt);


        void setNameLabel(String txt);

        void setPlaceLabel(String txt);

        void setDateLabel(String txt);


        void setTimeInitLabel(String txt);

        void setTimeFinishLabel(String txt);

        void setDetailsLabel(String detailsLabel);

        void setTimeInitText(String txt);

        String getEventName();

        String getEventPlace();

        String getEventDate();

        String getEventTimeInit();

        String getEventTimeFinish();

        String getEventDetails();

        ImageButton getEventImage();

        String getStringImageUri();

        void setToast(String txt);

        boolean getIsImageChosen();

        void setImageChosen(boolean imageChosen);
    }

    /**
     * Methods offered to MODEL to communicate with PRESENTER
     */

    interface PresenterToModel extends Model<ModelToPresenter> {

        String getNameLabel();


        String getPlaceLabel();

        String getDetailsLabel();


        String getSelectTextLabel();


        String getPublishBtnLabel();

        String getDateLabel();

        String getTimeInitLabel();

        String getTimeFinishLabel();

        String getWarningEmpty();






        void insertProductToDatabase(ProductData productData, String categoryId);
    }

    /**
     * Required PRESENTER methods available to MODEL
     */
    interface ModelToPresenter {

    }


}
