package es.ulpgc.eite.clean.mvp.sample.add;

import android.annotation.TargetApi;
import android.os.Build;
import android.util.Log;
import android.widget.DatePicker;

import es.ulpgc.eite.clean.mvp.GenericModel;

import static es.ulpgc.eite.clean.mvp.sample.R.id.datePicker;
import static es.ulpgc.eite.clean.mvp.sample.R.id.editTextPlace;
import static es.ulpgc.eite.clean.mvp.sample.R.id.timePickerFinish;
import static es.ulpgc.eite.clean.mvp.sample.R.id.timePickerInit;

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
    /*@Override
    public DatePicker getDatePicker() {
        //captamos el valor del dia ,mes y año elegido en el calendario
        String month = String.valueOf(datePicker.getMonth());
        String year = String.valueOf(datePicker.getYear());
        String day = String.valueOf(datePicker.getDayOfMonth());
        //Creamos la fecha en el formato DD/MM/AAAA
        String date = day + "" + month + "" + year;
        return date;
    }
    @Override
    public String getPlaceOfTheParty() {
        return editTextPlace.getText().toString();
    }
    @Override
    public String getHourOfInit() {
        int hour = timePickerInit.getHour();
        String init = String.valueOf(hour);
        return init;
    }
 @Override
    public String getDateOfTheParty() {
        //captamos el valor del dia ,mes y año elegido en el calendario
        String month = String.valueOf(datePicker.getMonth());
        String year = String.valueOf(datePicker.getYear());
        String day = String.valueOf(datePicker.getDayOfMonth());
        //Creamos la fecha en el formato DD/MM/AAAA
        String date = day + "" + month + "" + year;
        return date;
    }
    //captamos la hora del timePicker que indica el fin de la fiesta
    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public int getHourOfFinish() {
        int hour = timePickerFinish.getHour();
        return hour;



 }*/

}