package es.ulpgc.eite.clean.mvp.sample.hangapp;

import android.content.Context;
import android.os.Bundle;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.Model;
import es.ulpgc.eite.clean.mvp.Presenter;

/**
 * Created by Luis on 12/11/16.
 */

public interface HangApp {
//cambios hechos

    ///////////////////////////////////////////////////////////////////////////////////
    // State /////////////////////////////////////////////////////////////////////////

    interface ToDummy {
        void onScreenStarted();
        void setToolbarVisibility(boolean visible);
        void setTextVisibility(boolean visible);
    }

    interface DummyTo {
        Context getManagedContext();
        void destroyView();
        boolean isToolbarVisible();
        boolean isTextVisible();
    }

    interface toSearch{

        void setTextVisibility(boolean textVisibility);

        void onScreenStarted();
    }
    ///////////////////////////////////////////////////////////////////////////////////
    // Screen ////////////////////////////////////////////////////////////////////////
    interface toAdd{
        void onScreenStarted();

        void setTextVisibility(boolean visible);
        void setSelectorsVisibility(boolean visible);
    }
    /**
     * Methods offered to VIEW to communicate with PRESENTER
     */
    interface ViewToPresenter extends Presenter<PresenterToView> {


        void onButtonSearchClicked();

        void onButtonAddClicked();


        void onListItemClicked();
    }

    /**
     * Required VIEW methods available to PRESENTER
     */
    interface PresenterToView extends ContextView {
        void onCreate(Bundle savedInstanceState);

        void finishScreen();
        // void hideToolbar();
        void hideText();
        void showText();

        void setText(String txt);

        void setLabel(String txt);

        void setLabelSearch(String txt);

        void setAddLabel(String txt);
    }

    /**
     * Methods offered to MODEL to communicate with PRESENTER
     */
    interface PresenterToModel extends Model<ModelToPresenter> {
        void onChangeMsgByBtnClicked();
        String getText();


        String getSearchLabel();

        String getAddLabel();

        String[] getListParties();
    }

    /**
     * Required PRESENTER methods available to MODEL
     */
    interface ModelToPresenter {

        String[] getParties();
    }

    interface SearchTo {
        Context getManagedContext();
        void destroyView();

        boolean isTextVisible();

    }
    interface AddTo{
        Context getManagedContext();
        void destroyView();

        boolean isTextVisible();

        boolean isSelectorsVisible();

        boolean isImageVisible();
    }
    interface HangAppToAdd {
        Context getManagedContext();
        void destroyView();

        boolean isTextVisible();


    }


    interface ToHangApp{

        void setTextVisibility(boolean textVisibility);
        void setImageVisibility(boolean ImageVisibility);


        void onScreenStarted();
    }

     interface DetailTo {
        Context getManagedContext();
        void destroyView();

    }
}