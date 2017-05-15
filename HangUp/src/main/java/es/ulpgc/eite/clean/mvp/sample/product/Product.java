package es.ulpgc.eite.clean.mvp.sample.product;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;

/**
 * Created by alumno on 31/03/2017.
 */

public interface Product {
    public interface PresenterToView extends ContextView {


        void setText(String details, String StoryDescription, String dateDescription, String hourDescription);


    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //Screen ///////////////////////////////////////////////////////////////////////////////////////

    public interface ViewToPresenter {
        void onItemClicked(ProductData item);
    }

    public interface PresenterToModel {

        CategoryData getItem();

        void insertProduct(String id, int image, String productName, String participants, String detail, String day, String hour);

        void setItem(CategoryData itemSelected);

    }

    public interface ModelToPresenter {
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //ToInformation ///////////////////////////////////////////////////////////////////////////////////////

    public interface ToInformation {
        void onScreenStarted();

        void setItem(CategoryData itemSelected);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //InformationTo ///////////////////////////////////////////////////////////////////////////////////////

    public interface InformationTo {
    }
}
