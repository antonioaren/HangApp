package es.ulpgc.eite.clean.mvp.sample.deleteProduct;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.Model;
import es.ulpgc.eite.clean.mvp.Presenter;


/**
 * Created by eleonora on 28/03/2017.
 */

public interface DeleteProduct {
    void onCreate(PresenterToView presenterToView);

    interface ToDelete {


        void onScreenStarted();
    }

    interface DeleteTo {
        Context getManagedContext();

        void destroyView();


        String getNameToDelete();
    }

    interface ProcessedTo {


        Context getManagedContext();

        void destroyView();

        boolean isInformationVisible();

        boolean isImageVisible();

        boolean ParticipantsExist();
    }
    ///////////////////////////////////////////////////////////////////////////////////
    // Screen ////////////////////////////////////////////////////////////////////////

    /**
     * Methods offered to VIEW to communicate with PRESENTER
     */
    interface ViewToPresenter extends Presenter<PresenterToView> {


        void onItemListClicked();

        void onDeleteClicked();

        void onDeleteButtonClicked();

        // void onDeleteIdClicked();


        //void onStartingView();
    }

    /**
     * Required VIEW methods available to PRESENTER
     */
    interface PresenterToView extends ContextView {
        void onCreate(Bundle savedInstanceState);

        @SuppressLint("MissingSuperCall")
        void onResume();

        void finishScreen();


        void setDeleteBtnLabel(String txt);

        void setDeleIdBtnLabel(String txt);

        void setText2label(String txt);


        void setText1label(String txt);

        String getTextFromEditText();
    }

    /**
     * Methods offered to MODEL to communicate with PRESENTER
     */
    interface PresenterToModel extends Model<DeleteProduct.ModelToPresenter> {





        String getDeleteBtnLabel();

        void setDeleteBtnLabel(String deleteBtnLabel);


        String getTextLabel();

        void setTextLabel(String textLabel);

        void deteleEvent(final String name);


        /**
         * Required PRESENTER methods available to MODEL
         */


    }

    public interface ModelToPresenter {

    }


//    public interface SearchTo {
//        Context getManagedContext();
//    }

    interface toParties {
        Context getManagetContext();
    }
}