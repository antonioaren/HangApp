package es.ulpgc.eite.clean.mvp.sample.add;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;


/**
 * Created by eleonora on 23/03/2017.
 */

public class AddPartyView extends GenericActivity<Add.PresenterToView, Add.ViewToPresenter, AddPartyPresenter>
        implements Add.PresenterToView {

    TextView texttitle;
    EditText titledigit;
    TextView textPlace;
    EditText placeDigit;
    TextView textDate;
    CalendarView calendar;
    TextView textHourInit, textHourFinish;
    TimePicker timeInit, timeFinish;
    Button buttonPublish;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addparty);

        texttitle = (TextView) findViewById(R.id.texttitle);
        titledigit = (EditText) findViewById(R.id.titledigit);
        textPlace=(TextView) findViewById(R.id.textPlace);
        placeDigit = (EditText) findViewById(R.id.placedigit);
        textDate = (TextView) findViewById(R.id.textDate);
        calendar = (CalendarView) findViewById(R.id.calendar);
        textHourInit = (TextView) findViewById(R.id.textHourInit);
        timeInit = (TimePicker) findViewById(R.id.timeInit);
        textHourFinish = (TextView) findViewById(R.id.textHourFinish);
        timeFinish = (TimePicker) findViewById(R.id.timeFinish);
        buttonPublish=(Button)findViewById(R.id.buttonPublish);
        buttonPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getPresenter().onPublishClicked();
            }
        });

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
        texttitle.setText(txt);
    }

    @Override
    public void setPlaceLabel(String txt) {
        textPlace.setText(txt);
    }

    @Override
    public void setDateLabel(String txt) {
        textDate.setText(txt);
    }

    @Override
    public void setTimeInitLabel(String txt) {
        textHourInit.setText(txt);
    }

    @Override
    public void setTimeFinishLabel(String txt) {
        textHourFinish.setText(txt);
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
    public String getTitleFromEditText() {
        String title = titledigit.getText().toString();

        return title;
    }

    @Override
    public String getPlaceFromEditText() {
        String place = placeDigit.getText().toString();

        return place;
    }

    @Override
    public String getHourInit() {
        String hour = String.valueOf(timeInit);

        return hour;
    }

    @Override
    public String getHourFinish() {
        String hour = String.valueOf(timeFinish);

        return hour;
    }

    @Override
    public String getDateFromCalendar() {
        SimpleDateFormat formatter = new SimpleDateFormat("DD-MMM-yyyy");
        String date = formatter.format(calendar.getDate());
        return date;
    }
}