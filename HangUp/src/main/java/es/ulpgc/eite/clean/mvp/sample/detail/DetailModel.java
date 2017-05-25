package es.ulpgc.eite.clean.mvp.sample.detail;

import es.ulpgc.eite.clean.mvp.GenericModel;

/**
 * Created by eleonora on 17/04/2017.
 */

public class DetailModel extends GenericModel<Detail.ModelToPresenter> implements Detail.PresenterToModel {


    private String titleLabel;
    private String DescriptionLabel;

    public void setTitleLabel(String titleLabel) {
        this.titleLabel = titleLabel;
    }

    public void setDescriptionLabel(String descriptionLabel) {
        DescriptionLabel = descriptionLabel;
    }

    public void setDateLabel(String dateLabel) {
        this.dateLabel = dateLabel;
    }

    public void setHourLabel(String hourLabel) {
        this.hourLabel = hourLabel;
    }

    private String dateLabel;
    private String hourLabel;

    @Override
    public void onCreate(Detail.ModelToPresenter presenter) {
        super.onCreate(presenter);
        this.titleLabel="Detail";
        this.DescriptionLabel="description";
        this.dateLabel="Date";
        this.hourLabel="Hour";

    }

    @Override
    public void onDestroy(boolean b) {
  super.onDestroy(b);
    }

    @Override
    public String getTitleLabel() {
        return titleLabel;
    }
    @Override
    public String getDescriptionLabel() {
        return DescriptionLabel;
    }
    @Override
    public String getDateLabel() {
        return dateLabel;
    }
    @Override
    public String getHourLabel() {
        return hourLabel;
    }
}