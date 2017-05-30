package es.ulpgc.eite.clean.mvp.sample.addParty;


import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import es.ulpgc.eite.clean.mvp.sample.product.ProductModel;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;


/**
 * Created by eleonora on 17/04/2017.
 */

public class AddPartyModel extends GenericModel<Add.ModelToPresenter> implements Add.PresenterToModel {


    private String placeLabel, dateLabel, timeInitLabel, timeFinishLabel, publishLabel, titleLabel;
    private String description;
    private int hourFinish;
    private String day;
    private int hourInit;
    private String month;
    private String place;
    private int year;
    private List<CategoryData> partyAdded;
    private List<ProductData> party;
    // private Repository.ProductRepository.OnSaveProductCallback callback;
    private ProductModel product;
    private String nameLabel;
    private Realm realmDatabase;


    public AddPartyModel() {
     this.party= new ArrayList<>();
      this.partyAdded= new ArrayList<>();
        this.product=new ProductModel();
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
    public String getPlaceOfTheParty() {

        return place;
    }

    @Override
    public String getDateOfTheParty() {

        String date = day + "" + month + "" + year;
        return date;
    }

    @Override
    public String getHourOfParty() {

        String hour = hourInit + "" + "-" + hourFinish;
        return hour;
    }

    @Override
    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public void setHourOfFinish(int hour) {
        hourFinish = hour;
    }

    @Override
    public void setHourOfInit(int hour) {
        hourInit = hour;
    }

    @Override
    public void setMonth(String month) {
        this.month = month;
    }

    @Override
    public void setPlaceOfTheParty(String place) {
        this.place = place;
    }

    @Override
    public void setYear(int year) {
        this.year=year;
    }

    @Override
    public List<CategoryData> getPartyAdded() {

        return this.partyAdded;
    }

    @Override
    public RealmList<ProductData> getParty() {

        return (RealmList<ProductData>) this.party;
    }

    @Override
    public void setDescription(String description) {
        this.description= description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void insertEvent(final int image, final String name,final String numberOfParticipants) {
        //product.insertProduct(image,name,numberOfParticipants);
        realmDatabase = Realm.getDefaultInstance();
        realmDatabase.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                ProductData event = realmDatabase.createObject(ProductData.class,
                        UUID.randomUUID().toString());
                event.setProductName(name);
                event.setI
                //event.setDetailText(product.getDetailText());

                CategoryData category = realm.where(CategoryData.class)
                        .equalTo(itemId, CategoryId).findFirst();
                category.getItemInfo().add(event);
            }
        });
    }
}