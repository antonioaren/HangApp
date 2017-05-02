package es.ulpgc.eite.clean.mvp.sample.add;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;

import static es.ulpgc.eite.clean.mvp.sample.R.styleable.Toolbar;


/**
 * Created by eleonora on 23/03/2017.
 */

public class AddPartyView extends GenericActivity<Add.PresenterToView, Add.ViewToPresenter, AddPartyPresenter>
        implements Add.PresenterToView {

    TextView textViewTitle;
    TextView textPlace;
    EditText editTextPlace;
    TextView textdate;
    DatePicker datePicker;
    TextView textViewInit;
    TimePicker timePickerInit;
    TextView textViewFinish;
    TimePicker timePickerFinish;
    Button buttonPublish;
    Toolbar t;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addparty);


        t = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(t);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        textViewTitle = (TextView) findViewById(R.id.textView);

        textPlace=(TextView) findViewById(R.id.textPlace);
        editTextPlace = (EditText) findViewById(R.id.editTextPlace);
        textdate = (TextView) findViewById(R.id.textDate);
        datePicker = (DatePicker) findViewById(R.id.datePicker);
        textViewInit = (TextView) findViewById(R.id.textViewInit);
        timePickerInit = (TimePicker) findViewById(R.id.timePickerInit);//timePickerInit
        textViewFinish = (TextView) findViewById(R.id.textViewFinish);
        timePickerFinish = (TimePicker) findViewById(R.id.timePickerFinish);

        buttonPublish=(Button)findViewById(R.id.buttonPublish);
        buttonPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().onPublishClicked();
//             Intent intent=new Intent(AddPartyView.this,CategoryView.class);
//                intent.putExtra("place",getPlaceOfTheParty());
//                intent.putExtra("date",getDateOfTheParty());
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume(AddPartyPresenter.class, this);
    }
    @Override
    public void finishScreen() {
        finish();
    }

    @Override
    public void hideToolbar() {

    }


    @Override
    public void setPublishBtnLabel(String txt) {
        buttonPublish.setText(txt);
    }

    @Override
    public void setTitleLabel(String txt) {
        textViewTitle.setText(txt);
    }

    @Override
    public void setPlaceLabel(String txt) {
        textPlace.setText(txt);
    }

    @Override
    public void setDateLabel(String txt) {
        textdate.setText(txt);
    }

    @Override
    public void setTimeInitLabel(String txt) {
        textViewInit.setText(txt);
    }

    @Override
    public void setTimeFinishLabel(String txt) {
        textViewFinish.setText(txt);
    }
//    @Override
//    public void hideToolbar() {
//
//    }

    @Override
    public void hideText() {

    }



    @Override
    public void setText(String txt) {

    }

    @Override
    public void setLabel(String txt) {

    }

    @Override
    public String getMonth() {
        //captamos el valor del dia ,mes y año elegido en el calendario
        String month = String.valueOf(datePicker.getMonth());
      //  String year = String.valueOf(datePicker.getYear());
       // String day = String.valueOf(datePicker.getDayOfMonth());
        //Creamos la fecha en el formato DD/MM/AAAA
        //String date = day + "" + month + "" + year;
        return month;
    }

    @Override
    public String getDay(){
        String day=String.valueOf(datePicker.getDayOfMonth());
      return day;
    }
    @Override
    public int getYear() {
        int year = datePicker.getYear();
        return year;
    }

    @Override
    public String getPlaceOfTheParty() {
        return editTextPlace.getText().toString();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public int getHourOfInit() {
        int hour = timePickerInit.getHour();

        return hour;
    }

    //captamos la hora del timePicker que indica el fin de la fiesta
    //@TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public int getHourOfFinish() {
        int hour = timePickerFinish.getHour();
        return hour;



    }
}