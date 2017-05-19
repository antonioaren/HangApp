package es.ulpgc.eite.clean.mvp.sample.search;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.Model;
import es.ulpgc.eite.clean.mvp.Presenter;


/**
 * Created by eleonora on 28/03/2017.
 */

public interface Search {
    void onCreate(PresenterToView presenterToView);

    interface ToSearch {

        void setTextVisibility(boolean visible);

        void onScreenStarted();
    }

    interface SearchTo {
        Context getManagedContext();
        void setImageVisibility(boolean visible);
        void setInformationVisibility(boolean visible);
        void setParticipantsVisibility(boolean visible);
        void destroyView();

        boolean isTextVisible();
    }

    interface ProcessedTo{






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

        void onButtonSecundarySearchPressed();

        String[] getCategories();

        void onItemListClicked();

        void onDeleteClicked();


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

        void hideToolbar();

        void hideText();

        void showText();

        void setText(String txt);

        void setLabel(String txt);


        String getTextFromEditText();
    }

    /**
     * Methods offered to MODEL to communicate with PRESENTER
     */
    interface PresenterToModel extends Model<Search.ModelToPresenter> {


        String getName();

        void setName(String name);

        String getSearchText();

        String getPlaceLabel();

        String getCategoryLabel();

        String getDateLabel();

        String getSearchBtnLabel();
        String[]getListCategories();

        void deteleEvent(String name);

        /**
         * Required PRESENTER methods available to MODEL
         */


    }

    public interface ModelToPresenter {

    }

//    public interface SearchTo {
//    }


//    public interface SearchTo {
//        Context getManagedContext();
//    }

    interface toParties {
        Context getManagetContext();
    }
}