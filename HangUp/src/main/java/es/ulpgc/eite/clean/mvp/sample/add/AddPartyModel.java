package es.ulpgc.eite.clean.mvp.sample.add;


import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.R;
import es.ulpgc.eite.clean.mvp.sample.app.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.app.InformationData;


/**
 * Created by eleonora on 17/04/2017.
 */

public class AddPartyModel extends GenericModel<Add.ModelToPresenter> implements Add.PresenterToModel {


    String placeLabel, dateLabel, timeInitLabel, timeFinishLabel, publishLabel, titleLabel;
    private int hourFinish;
    private String day;
    private int hourInit;
    private String month;
    private String place;
    private int year;
    List<CategoryData> partyAdded;
    List<InformationData> party;
    public AddPartyModel() {
        this.party = new ArrayList<InformationData>();

        this.partyAdded = new ArrayList<CategoryData>();

    }


    @Override
    public void onCreate(Add.ModelToPresenter presenter) {
        super.onCreate(presenter);

        placeLabel = "Place :";
        dateLabel = "Date :";
        timeInitLabel = "Starts :";
        timeFinishLabel = "Finishes :";
        publishLabel = "Publish";
        titleLabel = "Publish your own party";
    }

    @Override
    public void onDestroy(boolean b) {
        Log.d(TAG, "calling onDestroy()");
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
    public String getPublishBtnLabel() {
        return this.publishLabel;
    }

    @Override
    public void setPublishLabel(String publishLabel) {
        this.publishLabel = publishLabel;
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
    public String getTitleLabel() {
        return this.titleLabel;
    }

    @Override
    public void setTitleLabel(String titleLabel) {
        this.titleLabel = titleLabel;
    }

    @Override
    public String getPlaceOfTheParty() {
        //return getPresenter().getPlace();
        return place;
    }

    @Override
    public String getDateOfTheParty() {
        //String day = getPresenter().getDay();
        //String month = getPresenter().getMonth();
        //String year = String.valueOf(getPresenter().getYear());
        String date = day + "" + month + "" + year;
        return date;
    }

    @Override
    public String getHourOfParty() {
        //String hourInit = String.valueOf(getPresenter().getInitTIme());
        //String hourFinish = String.valueOf(getPresenter().getFinishTime());
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
        partyAdded.add(new CategoryData(R.drawable.astro, "name", "0", getParty(), "details", "story", "date", "hour"));
        return this.partyAdded;
    }

    @Override
    public List<InformationData> getParty() {
        party.add(new InformationData(R.drawable.astro, "name", "0", "details", "story", "date", "hour"));
        return party;
    }
}