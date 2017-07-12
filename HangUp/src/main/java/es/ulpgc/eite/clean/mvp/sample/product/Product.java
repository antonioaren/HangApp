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
        RealmList<ProductData> getProductList();

        void onItemClicked(ProductData item);

        void onButtonAddClicked();

        void OnSwipedItem(String id);

        void onButtonAuthorsClicked();
    }

    interface PresenterToModel {

        CategoryData getItemCategorySelected();

        String getNotifyDeleted();

        void addProductByCategoryId(ProductData product, String CategoryId);

        void setItemCategorySelected(CategoryData itemSelected);

        void deleteItemById(String id);



        RealmList<ProductData> getAllProductsByCategoryId(String CategoryId);

    }

    interface ModelToPresenter {
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //ToDetail ///////////////////////////////////////////////////////////////////////////////////////

    interface ToProduct {

        void onScreenStarted();

        void setItemCategorySelected(CategoryData itemSelected);

        void setItemCategoryId(String itemId);


    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //DetailTo ///////////////////////////////////////////////////////////////////////////////////////

    interface ProductTo {
        String getCategoryId();

        Context getManagedContext();

        ProductData getItemProductSelected();
    }
}
