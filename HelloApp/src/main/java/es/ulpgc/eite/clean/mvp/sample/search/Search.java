package es.ulpgc.eite.clean.mvp.sample.search;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

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
    boolean onOptionsItemSelected(MenuItem item);

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

        String[] getCategories();

        void onItemListClicked();




        //void onStartingView();
    }



    /**
     * Required VIEW methods available to PRESENTER
     */
    interface PresenterToView extends ContextView {
        void onCreate(Bundle savedInstanceState);

        void finishScreen();





        void setSearchBtnLabel(String txt);


        ListView getListCategories();

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
        String[]getListCategories();

        /**
         * Required PRESENTER methods available to MODEL
         */


    }

    public interface ModelToPresenter {

    }

    public interface HangAppTo {
    }

    public interface ListTo {
        Context getManagedContext();
    }

    public interface DetailTo {
        Context getManagedContext();
    }

    public interface PartiesByCategoriesTo {
        Context getManagedContext();
    }
}