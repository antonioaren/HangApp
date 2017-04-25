package es.ulpgc.eite.clean.mvp.sample.category;

import android.content.Context;
import android.os.Bundle;

import java.util.List;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.Model;
import es.ulpgc.eite.clean.mvp.Presenter;

public interface Category {

    ///////////////////////////////////////////////////////////////////////////////////
    // Screen ////////////////////////////////////////////////////////////////////////

    /**
     * Methods offered to VIEW to communicate with PRESENTER
     */
    interface ViewToPresenter extends Presenter<PresenterToView> {


        void onButtonSearchClicked();

        void onButtonAddClicked();


        void onListItemClicked();

        String[] getParties();

        int[] getImages();

        List<CategoryData> LoadItems();
    }

    /**
     * Required VIEW methods available to PRESENTER
     */
    interface PresenterToView extends ContextView {
        void onCreate(Bundle savedInstanceState);

        void finishScreen();

        void setLabelSearch(String txt);

        void setAddLabel(String txt);
    }

    /**
     * Methods offered to MODEL to communicate with PRESENTER
     */
    interface PresenterToModel extends Model<ModelToPresenter> {

        String getSearchLabel();

        String getAddLabel();

        String[] getListParties();


        int[] getListImages();


        List getItems();
    }

    /**
     * Required PRESENTER methods available to MODEL
     */
    interface ModelToPresenter {
        String[] getParties();

        int[] getImages();
    }


    ///////////////////////////////////////////////////////////////////////////////////
    // Category To /////////////////////////////////////////////////////////////////////////


    interface CategoryTo {
        Context getManagedContext();

        void destroyView();

        boolean isTextVisible();

        boolean isSelectorsVisible();

        boolean isImageVisible();
    }

    ///////////////////////////////////////////////////////////////////////////////////
    // To Category /////////////////////////////////////////////////////////////////////////

    interface ToCategory {

        void setToolbarVisibility(boolean visible);

        void setTextVisibility(boolean textVisibility);

        void setImageVisibility(boolean ImageVisibility);


        void onScreenStarted();
    }


}