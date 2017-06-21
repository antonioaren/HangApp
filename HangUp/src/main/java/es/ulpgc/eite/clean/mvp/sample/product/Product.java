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

        void setAddLabel(String msg);


        void settingAdapter(RealmList<ProductData> items);

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //Screen ///////////////////////////////////////////////////////////////////////////////////////

    interface ViewToPresenter {
        void onItemClicked(ProductData item);

        void onButtonAddClicked();

        void onButtonDeleteClicked();

        void OnSwipedItem(String id);

    }

    interface PresenterToModel {

        CategoryData getItem();

        String getItemId();

        void AddProductByCategoryId(ProductData product, String CategoryId);

        void setItem(CategoryData itemSelected);

        void deleteItemById(String id);

        String getAddLabel();




        void setItemId(String itemId);

        void setProductToAddFromAddAndInsert(ProductData productToAdd);

        RealmList<ProductData> getAllProductsByCategoryId(String CategoryId);
    }

    interface ModelToPresenter {
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //ToDetail ///////////////////////////////////////////////////////////////////////////////////////

    public interface ToProduct {
        void onScreenStarted();

        void setItemSelected(CategoryData itemSelected);

        void setItemId(String itemId);

        void setProductToAdd(ProductData productToAdd);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //DetailTo ///////////////////////////////////////////////////////////////////////////////////////

    interface ProductTo {
        Context getManagedContext();


        ProductData getSelectedItem();



    }
}
