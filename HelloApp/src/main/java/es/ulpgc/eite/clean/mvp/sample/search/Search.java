package es.ulpgc.eite.clean.mvp.sample.search;

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

    void onResume(PresenterToView presenterToView);

    void onButtonSecundarySearchPressed();


    interface SearchToHangApp {

        boolean isTextVisible();

        Context getManagedContext();
    }

    interface ToSearch {
       

        void setTextVisibility(boolean visible);
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




        //void onStartingView();
    }



    /**
     * Required VIEW methods available to PRESENTER
     */
    interface PresenterToView extends ContextView {
        void onCreate(Bundle savedInstanceState);

        void finishScreen();





        void setSearchBtnLabel(String txt);


        void hideToolbar();

        void hideText();

        void showText();

        void setText(String txt);

        void setLabel(String txt);

        void setLabelSearch(String txt);
    }

    /**
     * Methods offered to MODEL to communicate with PRESENTER
     */
    interface PresenterToModel extends Model<Search.ModelToPresenter> {


        String getSearchBtnLabel();


        /**
         * Required PRESENTER methods available to MODEL
         */


    }

    public interface ModelToPresenter {
    }
}