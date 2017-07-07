package es.ulpgc.eite.clean.mvp.sample.addCategory;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.Model;
import es.ulpgc.eite.clean.mvp.Presenter;


public interface AddCategory {


    ///////////////////////////////////////////////////////////////////////////////////
    // State /////////////////////////////////////////////////////////////////////////

    interface ToAdd {
        void onScreenStarted();
    }


    interface AddTo {
        void destroyView();
    }


    ///////////////////////////////////////////////////////////////////////////////////
    // Screen ////////////////////////////////////////////////////////////////////////

    /**
     * Methods offered to VIEW to communicate with PRESENTER
     */

    interface ViewToPresenter extends Presenter<PresenterToView> {


        void onAddClicked();


    }

    /**
     * Required VIEW methods available to PRESENTER
     */

    interface PresenterToView extends ContextView {


        void onCreate(Bundle savedInstanceState);

        @SuppressLint("MissingSuperCall")
        void onResume();

        void finishScreen();

        void setAddBtnLabel(String txt);


        void setNameLabel(String txt);

        String getTextFromEditText();

        void setPhotoLabel(String txt);

        void setRadioButtonLabels(String txt0, String txt1, String txt2, String txt3);

        void setAssetsImage(String image1, String image2, String image3, String image4);

        int getRadioButtonId();

        void setToast(String txt);
    }

    /**
     * Methods offered to MODEL to communicate with PRESENTER
     */

    interface PresenterToModel extends Model<ModelToPresenter> {




        String getNameLabel();


        String getPhotoLabel();


        String getLabelRadio0();


        String getLabelRadio1();


        String getLabelRadio2();


        String getLabelRadio3();


        String getButtonAddlabel();


        String getToastNotifyingAdded();

        String getNotifyDeleted();

        void insertEvent(String Categoryname, String image);

        String getImageByIdSelected(int id);


        String getImage(int i);
    }

    /**
     * Required PRESENTER methods available to MODEL
     */
    interface ModelToPresenter {

        Context getManagedContext();
    }


}
