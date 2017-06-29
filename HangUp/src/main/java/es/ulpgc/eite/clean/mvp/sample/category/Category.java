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


        void onButtonAddClicked();
        void onListItemClicked();

        List<CategoryData> getCategoryList();

        void onItemClicked(CategoryData item, String id);

        void OnSwipedItem(String id);
    }

    /**
     * Required VIEW methods available to PRESENTER
     */
    interface PresenterToView extends ContextView {
        void onCreate(Bundle savedInstanceState);

        void settingItemsAdapter(RealmResults<CategoryData> items);

        void finishScreen();

        void setToast(String txt);
    }

    /**
     * Methods offered to MODEL to communicate with PRESENTER
     */
    interface PresenterToModel extends Model<ModelToPresenter> {

        void CreateDatabaseTables();

        ///////////////////////////  DATABASE  ////////////////////////////////
        RealmResults<CategoryData> getCategoryEvents();

        void insertEvent(String Categoryname, String image);

        void deleteItem(String name);


        //metodo para comprobar test con espresso
        int getNumberOfCategories();

        String getToastNotifyingAdded();

        String getNotifyDeleted();
    }

    /**
     * Required PRESENTER methods available to MODEL
     */
    interface ModelToPresenter {
        Context getAppContext();

        Context getManagedContext();
    }


    ///////////////////////////////////////////////////////////////////////////////////
    // AddProduct To /////////////////////////////////////////////////////////////////////////


    interface CategoryTo {
        Context getManagedContext();
        void destroyView();
        CategoryData getSelectedItem();
        String getItemId();
    }

    ///////////////////////////////////////////////////////////////////////////////////
    // To AddProduct /////////////////////////////////////////////////////////////////////////

    interface ToCategory {
        void onScreenStarted();
    }


}