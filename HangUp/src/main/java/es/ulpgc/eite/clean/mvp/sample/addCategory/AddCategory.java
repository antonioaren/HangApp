package es.ulpgc.eite.clean.mvp.sample.addCategory;


import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.Model;
import es.ulpgc.eite.clean.mvp.Presenter;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import es.ulpgc.eite.clean.mvp.sample.data.Repository;
import io.realm.RealmList;


public interface AddCategory {


    ///////////////////////////////////////////////////////////////////////////////////
    // State /////////////////////////////////////////////////////////////////////////

    interface ToAdd {
        void onScreenStarted();

        void setTextVisibility(boolean visible);



        RealmList<CategoryData> getDefaultList();
    }


    interface AddTo {
        Context getManagedContext();






        void destroyView();


        Repository.ProductRepository.OnSaveProductCallback getCallBack();

        RealmList<ProductData> getParty();

        String getDescriptionOfTheParty();


    }


    ///////////////////////////////////////////////////////////////////////////////////
    // Screen ////////////////////////////////////////////////////////////////////////

    /**
     * Methods offered to VIEW to communicate with PRESENTER
     */

    interface ViewToPresenter extends Presenter<PresenterToView> {


        void onSelectClicked();

        void onAddClicked();

        String[]getNames();

        Integer[]getImages();
    }

    /**
     * Required VIEW methods available to PRESENTER
     */

    interface PresenterToView extends ContextView {


        void onCreate(Bundle savedInstanceState);

        @SuppressLint("MissingSuperCall")
        void onResume();

        void finishScreen();

        void hideToolbar();



        void setAddBtnLabel(String txt);

        void setTitleLabel(String txt);


        void hideText();



        void setNameLabel(String txt);

        String getTextFromEditText();

        void setPhotoLabel(String txt);

        void setButtonPhotoLabel(String txt);


         int getRadioButtonId();
    }

    /**
     * Methods offered to MODEL to communicate with PRESENTER
     */

    interface PresenterToModel extends Model<ModelToPresenter> {


        void setTitleLabel(String titleLabel);

        String getNameLabel();

        void setNameLabel(String nameLabel);

        String getPhotoLabel();

        void setPhotoLabel(String photoLabel);

        String getButtonPhotoLabel();

        void setButtonPhotoLabel(String buttonPhotoLabel);

        String getButtonAddlabel();

        void setButtonAddlabel(String buttonAddlabel);

        void setNameCategory(String name);

        String getTitleLabel();


        void insertEvent(String Categoryname, int image);



        String[]getNames();

        Integer[] getImages();

        int getImageByMessage(int id);
    }

    /**
     * Required PRESENTER methods available to MODEL
     */
    interface ModelToPresenter {


    }


}
