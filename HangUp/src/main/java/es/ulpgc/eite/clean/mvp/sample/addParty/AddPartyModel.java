package es.ulpgc.eite.clean.mvp.sample.addParty;


import android.util.Log;

import java.util.List;
import java.util.UUID;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import es.ulpgc.eite.clean.mvp.sample.data.Repository;
import es.ulpgc.eite.clean.mvp.sample.product.ProductModel;
import io.realm.Realm;


/**
 * Created by eleonora on 17/04/2017.
 */

public class AddPartyModel extends GenericModel<Add.ModelToPresenter> implements Add.PresenterToModel {


    private String placeLabel, dateLabel, timeInitLabel, timeFinishLabel, publishLabel, titleLabel;
    private String nameLabel;
    private String detailsLabel;


    public AddPartyModel() {

    }


    @Override
    public void onCreate(Add.ModelToPresenter presenter) {
        super.onCreate(presenter);

        titleLabel = "Publish your own party";

        nameLabel = "Name";
        placeLabel = "Place";
        dateLabel = "Date";
        timeInitLabel = "Starts";
        timeFinishLabel = "Finishes";
        detailsLabel = "Party's Details";

        publishLabel = "Add";

    }

    @Override
    public void onDestroy(boolean b) {
        Log.d(TAG, "calling onDestroy()");
    }


    @Override
    public String getTitleLabel() {
        return this.titleLabel;
    }

    @Override
    public void setTitleLabel(String titleLabel) {
        this.titleLabel = titleLabel;
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
    public String getPublishBtnLabel() {
        return publishLabel;
    }

    @Override
    public void setPublishLabel(String publishLabel) {
        this.publishLabel = publishLabel;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
}