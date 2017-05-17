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
        void setAddLabel(String msg);

        void settingAdapter(List<ProductData> items);


        //void setText(String details, String StoryDescription, String dateDescription, String hourDescription);


    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //Screen ///////////////////////////////////////////////////////////////////////////////////////

    public interface ViewToPresenter {
        void onItemClicked(ProductData item);
    }

    public interface PresenterToModel {

        CategoryData getItem();


        void insertProduct( int image, String title , String participants);

        void setItem(CategoryData itemSelected);

        String getAddLabel();

        void setIsFirstimeRunning(boolean isFirstTimeRunning);

        void CreateDatabaseTablesFromJson();

        void setItemsFromDatabase();
    }

    public interface ModelToPresenter {
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //ToProduct ///////////////////////////////////////////////////////////////////////////////////////

    public interface ToProduct {
        void onScreenStarted();

        void setItem(CategoryData itemSelected);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //ProductTo ///////////////////////////////////////////////////////////////////////////////////////

    public interface ProductTo {
        Context getManagedContext();


        ProductData getSelectedItem();
    }
}
