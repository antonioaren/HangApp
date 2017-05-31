package es.ulpgc.eite.clean.mvp.sample.detail;


import android.content.Context;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.Model;
import es.ulpgc.eite.clean.mvp.Presenter;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;

/**
 * Created by Luis on 12/11/16.
 */

public interface Detail {


    ///////////////////////////////////////////////////////////////////////////////////
    // State /////////////////////////////////////////////////////////////////////////

    interface ToDetail {
        void onScreenStarted();

        void setItemSelected(ProductData itemSelected);
    }

    interface DetailTo {
        Context getManagedContext();

        //void destroyView();


    }

    ///////////////////////////////////////////////////////////////////////////////////
    // Screen ////////////////////////////////////////////////////////////////////////

    /**
     * Methods offered to VIEW to communicate with PRESENTER
     */

    interface ViewToPresenter extends Presenter<PresenterToView> {

    }

    /**
     * Required VIEW methods available to PRESENTER
     */

    interface PresenterToView extends ContextView {



        void finishScreen();

        void setTitleLabel(String msg);

        void setIntroductionLabel(String msg);

        void setDateLabel(String msg);

        void setHourLabel(String msg);



    }

    /**
     * Methods offered to MODEL to communicate with PRESENTER
     */

    interface PresenterToModel extends Model<ModelToPresenter> {


        void setItemSelected(ProductData itemSelected);

        ProductData getItemSelected();
    }

    /**
     * Required PRESENTER methods available to MODEL
     */
    interface ModelToPresenter {

    }


}