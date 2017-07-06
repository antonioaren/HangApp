package es.ulpgc.eite.clean.mvp.sample.addProduct;


import android.util.Log;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import es.ulpgc.eite.clean.mvp.sample.realmoperation.RealmOperation;


/**
 * Created by eleonora on 17/04/2017.
 */

public class AddProductModel
        extends GenericModel<AddProduct.ModelToPresenter>
        implements AddProduct.PresenterToModel {


    private static final String PLACE_LABEl = "Place:";
    private static final String DATE_LABEL = "Date:";
    private static final String TIME_INIT_LABEL = "Starts:";
    private static final String TIME_FINISH_LABEL = "Finishes:";
    private static final String PUBLISH_LABEL = "Publish:";
    private static final String NAME_LABEL = "Name:";
    private static final String DETAILS_LABEL = "Details:";
    private static final String SELECT_PHOTO_LABEL = "Select a photo:";
    private static final String WARNING_EMPTY = "All field are required:";

    @Override
    public void onCreate(AddProduct.ModelToPresenter presenter) {
        super.onCreate(presenter);


    }

    @Override
    public void onDestroy(boolean b) {
        Log.d(TAG, "calling onDestroy()");
    }

    @Override
    public String getNameLabel() {
        return NAME_LABEL;
    }



    @Override
    public String getPlaceLabel() {
        return PLACE_LABEl;
    }



    @Override
    public String getDateLabel() {
        return DATE_LABEL;
    }



    @Override
    public String getTimeInitLabel() {
        return TIME_INIT_LABEL;
    }



    @Override
    public String getTimeFinishLabel() {
        return TIME_FINISH_LABEL;
    }

    @Override
    public String getWarningEmpty() {
        return WARNING_EMPTY;
    }


    @Override
    public String getDetailsLabel() {
        return DETAILS_LABEL;
    }


    @Override
    public String getSelectTextLabel() {
        return SELECT_PHOTO_LABEL;
    }


    @Override
    public String getPublishBtnLabel() {
        return PUBLISH_LABEL;
    }


    @Override
    public void insertProductToDatabase(ProductData productData, String categoryId) {
        RealmOperation realmOperation = RealmOperation.getInstances();
        realmOperation.addProductByCategoryId(productData, categoryId);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

}