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
    interface SearchToHangApp {

        boolean isTextVisible();

        Context getManagedContext();
    }

    interface ToSearch {
        void onScreenStarted();



        void setTextVisibility(boolean visible);
    }

    interface SearchTo {
        Context getManagedContext();

        void destroyView();

        boolean isTextVisible();
    }

    ///////////////////////////////////////////////////////////////////////////////////
    // Screen ////////////////////////////////////////////////////////////////////////

    /**
     * Methods offered to VIEW to communicate with PRESENTER
     */
    interface ViewToPresenter extends Presenter<Search.PresenterToView> {
        void onSearchBtnClicked();

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