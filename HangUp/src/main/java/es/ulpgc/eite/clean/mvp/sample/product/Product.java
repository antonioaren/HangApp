package es.ulpgc.eite.clean.mvp.sample.product;

import android.content.Context;

import java.util.List;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;

/**
 * Created by alumno on 31/03/2017.
 */

public interface Product {
    public interface PresenterToView extends ContextView {


       // void setText(String details, String StoryDescription, String dateDescription, String hourDescription);


        void setAddLabel(String msg);

        void setDeleteLabel(String msg);

        void settingAdapter(List<ProductData> items);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //Screen ///////////////////////////////////////////////////////////////////////////////////////

    public interface ViewToPresenter {
        void onItemClicked(ProductData item);

        void onButtonAddClicked();

        void onButtonDeleteClicked();
    }

    public interface PresenterToModel {

        CategoryData getItem();

        void AddProductByCategoryId(ProductData product, String CategoryId);

        void insertProduct( int image, String title , String participants);

        void insertProduct(int image, String title,
                           String participants, String CategoryId);

        void setItem(CategoryData itemSelected);

        void setItem(ProductData itemSelected);

        String getAddLabel();


        void CreateDatabaseTables();

        void setItemsFromDatabase();

        String getDeleteLabel();

        void setItemId(String itemId);
    }

    public interface ModelToPresenter {
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //ToProduct ///////////////////////////////////////////////////////////////////////////////////////

    public interface ToProduct {
        void onScreenStarted();

        void setItem(CategoryData itemSelected);

        void setIdItem(String itemId);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //ProductTo ///////////////////////////////////////////////////////////////////////////////////////

    public interface ProductTo {
        Context getManagedContext();


        ProductData getSelectedItem();

        String getDescriptionOfTheParty();

        String getPlaceOfTheParty();

        String getDateOfTheParty();

        String getHourOfParty();
    }
}
