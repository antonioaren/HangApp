package es.ulpgc.eite.clean.mvp.sample.category;

import android.content.Context;
import android.os.Bundle;

import java.util.List;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.Model;
import es.ulpgc.eite.clean.mvp.Presenter;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.InformationData;
import es.ulpgc.eite.clean.mvp.sample.data.InformationData_Old;
import io.realm.RealmList;

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

        List<CategoryData> getListOfParties();

        void onItemClicked(CategoryData item);
    }

    /**
     * Required VIEW methods available to PRESENTER
     */
    interface PresenterToView extends ContextView {
        void onCreate(Bundle savedInstanceState);

        void settingAdapter(RealmList<CategoryData> parties);
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

        String getSearchLabel();

        String getAddLabel();


        List<CategoryData> getListCategory();

        List<InformationData_Old> getDisco();

        List<InformationData_Old> getUlpgc();

        List<InformationData_Old> getCars();

        List<InformationData_Old> getMusica();

        List<InformationData_Old> getAstro();

        List<InformationData_Old> getNewParty();

        int getParticipantsAt(int i);

        ///////////////////////////  DATABASE ////////////////////////
        void setDatabaseItemsFromJson();

        ///////////////////////////  DATABASE ////////////////////////
        List<InformationData> getEvents();

        void setItemsFromDatabase();

        void insertEvent(String id, int image, String productName, String numberOfParticipants, String category, String detail, String day, String hour, String web);
    }

    /**
     * Required PRESENTER methods available to MODEL
     */
    interface ModelToPresenter {


        List<CategoryData> getListOfParties();
    }


    ///////////////////////////////////////////////////////////////////////////////////
    // Add To /////////////////////////////////////////////////////////////////////////


    interface CategoryTo {
        Context getManagedContext();

        void destroyView();

        CategoryData getSelectedItem();

        boolean isTextVisible();

        boolean isSelectorsVisible();

        boolean isImageVisible();
    }

    ///////////////////////////////////////////////////////////////////////////////////
    // To Add /////////////////////////////////////////////////////////////////////////

    interface ToCategory {

        void setToolbarVisibility(boolean visible);

        void setTextVisibility(boolean textVisibility);

        void setImageVisibility(boolean ImageVisibility);


        void onScreenStarted();

        void setPlace(String placeOfTheParty);

        void setDate(String dateOfTheParty);

        void setHour(String hourOfParty);
    }


}