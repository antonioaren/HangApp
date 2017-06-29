package es.ulpgc.eite.clean.mvp.sample.addParty;


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



    private String placeLabel, dateLabel, timeInitLabel, timeFinishLabel, publishLabel, titleLabel;
    private String nameLabel;
    private String detailsLabel;
    private String selectPhotoLabel;
    private String WarningEmpty;

    @Override
    public void onCreate(AddProduct.ModelToPresenter presenter) {
        super.onCreate(presenter);

        titleLabel = "Publish your own party";
        nameLabel = "Name";
        placeLabel = "Place";
        dateLabel = "Date";
        timeInitLabel = "Starts";
        timeFinishLabel = "Finishes";
        detailsLabel = "Details";
        selectPhotoLabel = "Select a photo : ";
        publishLabel = "Publish";

        WarningEmpty = "All field are required";
    }

    @Override
    public void onDestroy(boolean b) {
        Log.d(TAG, "calling onDestroy()");
    }

    @Override
    public String getNameLabel() {
        return nameLabel;
    }

    @Override
    public void setNameLabel(String nameLabel) {
        this.nameLabel = nameLabel;
    }

    @Override
    public String getPlaceLabel() {
        return this.placeLabel;
    }

    @Override
    public void setPlaceLabel(String placeLabel) {
        this.placeLabel = placeLabel;
    }

    @Override
    public String getDateLabel() {
        return this.dateLabel;
    }

    @Override
    public void setDateLabel(String dateLabel) {
        this.dateLabel = dateLabel;
    }

    @Override
    public String getTimeInitLabel() {
        return this.timeInitLabel;
    }

    @Override
    public void setTimeInitLabel(String timeInitLabel) {
        this.timeInitLabel = timeInitLabel;
    }

    @Override
    public String getTimeFinishLabel() {
        return this.timeFinishLabel;
    }

    @Override
    public String getWarningEmpty() {
        return WarningEmpty;
    }

    @Override
    public void setTimeFinishLabel(String timeFinishLabel) {
        this.timeFinishLabel = timeFinishLabel;
    }

    @Override
    public String getDetailsLabel() {
        return detailsLabel;
    }

    @Override
    public void setDetailsLabel(String detailsLabel) {
        this.detailsLabel = detailsLabel;
    }

    @Override
    public String getSelectTextLabel() {
        return selectPhotoLabel;
    }

    @Override
    public void setSelectTextlabel(String text) {
        this.selectPhotoLabel = text;
    }

    @Override
    public String getPublishBtnLabel() {
        return publishLabel;
    }

    @Override
    public void setPublishLabel(String publishLabel) {
        this.publishLabel = publishLabel;
    }

    @Override
    public void insertProductToDatabase(ProductData productData, String categoryId) {
        RealmOperation realmOperation = RealmOperation.getInstances();
        realmOperation.AddProductByCategoryId(productData, categoryId);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

}