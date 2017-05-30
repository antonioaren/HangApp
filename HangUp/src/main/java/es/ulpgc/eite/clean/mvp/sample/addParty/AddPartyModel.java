package es.ulpgc.eite.clean.mvp.sample.addParty;


import android.util.Log;

import java.util.UUID;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import io.realm.Realm;
import io.realm.RealmConfiguration;


/**
 * Created by eleonora on 17/04/2017.
 */

public class AddPartyModel extends GenericModel<Add.ModelToPresenter> implements Add.PresenterToModel {


    private String placeLabel, dateLabel, timeInitLabel, timeFinishLabel, publishLabel, titleLabel;
    private String nameLabel;
    private String name;
    private String place;
    private int hourFinish;
    private int hourInit;
    private String day;
    private String month;
    private int year;

    // private Repository.ProductRepository.OnSaveProductCallback callback;

    private Realm realmDatabase;
    private String itemId;

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
        publishLabel = "Add";
        RealmConfiguration setting = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(setting);
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
    public String getPublishBtnLabel() {
        return publishLabel;
    }
    @Override
    public void setPublishLabel(String publishLabel) {
        this.publishLabel = publishLabel;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPlaceOfTheParty() {

        return place;
    }

    @Override
    public void setPlaceOfTheParty(String place) {
        this.place = place;
    }

    @Override
    public String getDateOfTheParty() {

        String date = day + "" + month + "" + year;
        return date;
    }


    @Override
    public String getHourInit() {
        return String.valueOf(hourInit);
    }

    @Override
    public void setHourOfInit(int hour) {
        hourInit = hour;
    }

    public String getHourFinish() {
        return String.valueOf(hourFinish);
    }

    @Override
    public void setHourOfFinish(int hour) {
        hourFinish = hour;
    }

    @Override
    public String getHourOfParty() {

        String hour = hourInit + "" + "-" + hourFinish;
        return hour;
    }




    @Override
    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public void setYear(int year) {
        this.year=year;
    }

    @Override
    public void setDay(String day) {
        this.day = day;
    }


    @Override
    public String getItemId() {
        return itemId;
    }

    @Override
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Override
    public void insertEvent(final String CategoryId, final String name, final String place, final String date, final int hourOfInit, final int hourOfFinish) {
        //product.insertProduct(image,name,numberOfParticipants);

        final String InitialHour = String.valueOf(hourOfInit);
        final String FinalHour = String.valueOf(hourOfFinish);

        realmDatabase = Realm.getDefaultInstance();
        realmDatabase.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                ProductData event = realmDatabase.createObject(ProductData.class,
                        UUID.randomUUID().toString());
                event.setProductName(name);
                event.setPlace(place);
                event.setDate(date);
                event.setTimeI(InitialHour);
                event.setTimeF(FinalHour);
                //event.setDetailText(product.getDetailText());

                CategoryData category = realm.where(CategoryData.class)
                        .equalTo(itemId, CategoryId).findFirst();
                category.getItemInfo().add(event);
            }
        });
    }
}