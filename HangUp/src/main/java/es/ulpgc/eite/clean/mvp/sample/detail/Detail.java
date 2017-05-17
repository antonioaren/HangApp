package es.ulpgc.eite.clean.mvp.sample.detail;


import android.content.Context;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.Model;
import es.ulpgc.eite.clean.mvp.Presenter;

/**
 * Created by Luis on 12/11/16.
 */

public interface Detail {


    ///////////////////////////////////////////////////////////////////////////////////
    // State /////////////////////////////////////////////////////////////////////////

    interface ToAdd {
        void onScreenStarted();

        void setTextVisibility(boolean visible);
    }

    interface AddTo {
        Context getManagedContext();

        void destroyView();

        boolean isTextVisible();

        boolean isSelectorsVisible();
    }

    ///////////////////////////////////////////////////////////////////////////////////
    // Screen ////////////////////////////////////////////////////////////////////////

    /**
     * Methods offered to VIEW to communicate with PRESENTER
     */

    interface ViewToPresenter extends Presenter<PresenterToView> {
        void onPublishClicked();

        //void onStartingView();
    }

    /**
     * Required VIEW methods available to PRESENTER
     */

    interface PresenterToView extends ContextView {



        void finishScreen();

        void hideToolbar();


        ;

        void setTitleLabel(String msg);

        void setIntroductionLabel(String msg);

        void setDateLabel(String msg);

        void setHourLabel(String msg);

        void hideText();


    }

    /**
     * Methods offered to MODEL to communicate with PRESENTER
     */

    interface PresenterToModel extends Model<ModelToPresenter> {


        String getTitleLabel();

        String getDescriptionLabel();

        String getDateLabel();

        String getHourLabel();
    }

    /**
     * Required PRESENTER methods available to MODEL
     */
    interface ModelToPresenter {

    }


}