package es.ulpgc.eite.clean.mvp.sample.add;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;
import android.widget.DatePicker;

import es.ulpgc.eite.clean.mvp.GenericModel;


/**
 * Created by eleonora on 17/04/2017.
 */

public class AddPartyModel extends GenericModel<Add.ModelToPresenter> implements Add.PresenterToModel {


    String placeLabel, dateLabel, timeInitLabel, timeFinishLabel, publishLabel, titleLabel;

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
    public String getPublishBtnLabel() {
        return this.publishLabel;
    }

    @Override
    public String getDateLabel() {
        return this.dateLabel;
    }

    @Override
    public String getTimeInitLabel() {
        return this.timeInitLabel;
    }

    @Override
    public String getTimeFinishLabel() {
        return this.timeFinishLabel;
    }

    @Override
    public String getTitleLabel() {
        return this.titleLabel;
    }


    //Metodos a implementar para procesar la informacion introducidaa


}