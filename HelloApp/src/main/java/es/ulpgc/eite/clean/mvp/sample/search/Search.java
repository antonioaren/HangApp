package es.ulpgc.eite.clean.mvp.sample.search;

import android.content.Context;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.Model;
import es.ulpgc.eite.clean.mvp.Presenter;

/**
 * Created by eleonora on 28/03/2017.
 */

public interface Search {
    interface SearchToHangApp {

        boolean isToolbarVisible();

        Context getManagedContext();
    }

    interface ToSearch {
        void onScreenStarted();
        void setToolbarVisibility(boolean visible);
        void setTextVisibility(boolean visible);
    }

    interface SearchTo {
        Context getManagedContext();
        void destroyView();
        boolean isToolbarVisible();
        boolean isTextVisible();
    }

    ///////////////////////////////////////////////////////////////////////////////////
    // Screen ////////////////////////////////////////////////////////////////////////

    /**
     * Methods offered to VIEW to communicate with PRESENTER
     */
    interface ViewToPresenter extends Presenter<Search.PresenterToView> {
        void onSayHelloBtnClicked();
        void onGoToByeBtnClicked();
        //void onStartingView();
    }

    /**
     * Required VIEW methods available to PRESENTER
     */
    interface PresenterToView extends ContextView {
        void finishScreen();
        void hideToolbar();
        void hideHelloMsg();
        void showHelloMsg();
        void setHelloMsg(String txt);

        void setSearchBtnLabel(String txt);

        void setAddBtnLabel(String txt);
    }

    /**
     * Methods offered to MODEL to communicate with PRESENTER
     */
    interface PresenterToModel extends Model<Search.ModelToPresenter> {
        void onChangeMsgByBtnClicked();
        String getHelloMsg();

        String getSearchBtnLabel();

        String getAddBtnLabel();
    }

    /**
     * Required PRESENTER methods available to MODEL
     */
    interface ModelToPresenter {

    }


}
