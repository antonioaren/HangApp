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
        Context getManagedContext();


        void destroyView();


        String getCategoryName();

        int getRadioButtonSelected();


    }


    ///////////////////////////////////////////////////////////////////////////////////
    // Screen ////////////////////////////////////////////////////////////////////////

    /**
     * Methods offered to VIEW to communicate with PRESENTER
     */

    interface ViewToPresenter extends Presenter<PresenterToView> {


        void onAddClicked();


        Integer[] getImages();
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

        int getRadioButtonId();
    }

    /**
     * Methods offered to MODEL to communicate with PRESENTER
     */

    interface PresenterToModel extends Model<ModelToPresenter> {


        String getTitleLabel();

        void setTitleLabel(String titleLabel);

        String getNameLabel();

        void setNameLabel(String nameLabel);

        String getPhotoLabel();

        void setPhotoLabel(String photoLabel);


        String getLabelRadio0();

        void setLabelRadio0(String labelRadio0);

        String getLabelRadio1();

        void setLabelRadio1(String labelRadio1);

        String getLabelRadio2();

        void setLabelRadio2(String labelRadio2);

        String getLabelRadio3();

        void setLabelRadio3(String labelRadio3);

        String getButtonAddlabel();

        void setButtonAddlabel(String buttonAddlabel);

        void setNameCategory(String name);


        void insertEvent(String Categoryname, int image);


        Integer[] getImages();

        int getImageByIdSelected(int id);
    }

    /**
     * Required PRESENTER methods available to MODEL
     */
    interface ModelToPresenter {


    }


}
