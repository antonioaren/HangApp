package es.ulpgc.eite.clean.mvp.sample.add;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;


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
            }
        });

    }

    @Override
    public Toolbar getToolbar() {
        return t;
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


}