package es.ulpgc.eite.clean.mvp.sample.add;

import es.ulpgc.eite.clean.mvp.GenericModel;

/**
 * Created by eleonora on 17/04/2017.
 */

public class AddPartyModel extends GenericModel<Add.ModelToPresenter> implements Add.PresenterToModel{
   

    String placeLabel,dateLabel,timeInitLabel,timeFinishLabel,publishLabel;
    @Override
    public void onCreate(Add.ModelToPresenter presenter) {
        super.onCreate(presenter);
        placeLabel="Place :";
        dateLabel="Date :";
        timeInitLabel="Starts :";
        timeFinishLabel="Finishes :";
        publishLabel="Publish";
    }

    @Override
    public void onDestroy(boolean b) {

    }
    @Override
    public String getPlaceLabel(){
    return this.placeLabel;
}

    @Override
    public String gePublishBtnLabel() {
        return this.publishLabel;
    }

    @Override
    public String getDateLabel() {
        return  this.dateLabel;
    }

    @Override
    public String getTimeInitLabel() {
        return this.timeInitLabel;
    }

    @Override
    public String getTimeFinishLabel() {
        return this.timeFinishLabel;
    }

}