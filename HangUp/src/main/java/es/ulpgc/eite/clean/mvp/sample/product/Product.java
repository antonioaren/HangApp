package es.ulpgc.eite.clean.mvp.sample.product;

import android.content.Context;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import io.realm.RealmList;

/**
 * Created by alumno on 31/03/2017.
 */

public interface Product {
    interface PresenterToView extends ContextView {

        ////////////////////////////////////////////////////////////////////////////////////////////////
        void setTitleHeader(String txt);

        void settingAdapter(RealmList<ProductData> items);


        void setToast(String txt);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //Screen ///////////////////////////////////////////////////////////////////////////////////////

    interface ViewToPresenter {
        void onItemClicked(ProductData item);

        void onButtonAddClicked();

        void OnSwipedItem(String id);
    }

    interface PresenterToModel {

        CategoryData getItemCategorySelected();

        void AddProductByCategoryId(ProductData product, String CategoryId);

        void setItemCategorySelected(CategoryData itemSelected);

        void deleteItemById(String id);

        //String getItemCategoryId();

        //void setItemCategoryId(String itemId);

        String getNotifyAdded();

        String getNotifyDeleted();

//        void setProductFromAddAndInsert(ProductData productToAdd);

        RealmList<ProductData> getAllProductsByCategoryId(String CategoryId);

    }

    interface ModelToPresenter {
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //ToDetail ///////////////////////////////////////////////////////////////////////////////////////

    public interface ToProduct {

        void onScreenStarted();

        void setItemCategorySelected(CategoryData itemSelected);

        void setItemCategoryId(String itemId);

//        void setProductFromAdd(ProductData productToAdd);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //DetailTo ///////////////////////////////////////////////////////////////////////////////////////

    interface ProductTo {
        String getCategoryId();

        Context getManagedContext();

        ProductData getItemProductSelected();
    }
}
