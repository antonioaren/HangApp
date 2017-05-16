package es.ulpgc.eite.clean.mvp.sample.category;

import android.content.Context;
import android.os.Bundle;

import java.util.List;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.Model;
import es.ulpgc.eite.clean.mvp.Presenter;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import io.realm.RealmResults;

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

        List<CategoryData> getCategoryList();

        void onItemClicked(CategoryData item);
    }

    /**
     * Required VIEW methods available to PRESENTER
     */
    interface PresenterToView extends ContextView {
        void onCreate(Bundle savedInstanceState);

        void settingAdapter(RealmResults<CategoryData> parties);

        void finishScreen();

        void hideText();

        void showText();

        void setText(String txt);

        void setLabel(String txt);

        void setLabelSearch(String txt);

        void setAddLabel(String txt);

        void showCategories(RealmResults<CategoryData> categories);
    }

    /**
     * Methods offered to MODEL to communicate with PRESENTER
     */
    interface PresenterToModel extends Model<ModelToPresenter> {

        void CreateDatabaseTablesFromJson();

        String getSearchLabel();

        String getAddLabel();

        int getParticipantsAt(int i);

        ///////////////////////////  DATABASE ////////////////////////
        RealmResults<CategoryData> getEvents();

        void setItemsFromDatabase();

        void insertEvent(String Categoryname, int image);

        void setIsFirstimeRunning(boolean isFirstTimeRunning);
    }

    /**
     * Required PRESENTER methods available to MODEL
     */
    interface ModelToPresenter {


        void subscribeCallbacks();

        void unSubscribeCallbacks();
    }


    ///////////////////////////////////////////////////////////////////////////////////
    // Add To /////////////////////////////////////////////////////////////////////////


    interface CategoryTo {
        Context getManagedContext();

        void destroyView();
        CategoryData getSelectedItem();
    }

    ///////////////////////////////////////////////////////////////////////////////////
    // To Add /////////////////////////////////////////////////////////////////////////

    interface ToCategory {
        void onScreenStarted();
        void setIsFirstInit(boolean isFirstTimeRunning);

        boolean getTextVisibility();
    }


}