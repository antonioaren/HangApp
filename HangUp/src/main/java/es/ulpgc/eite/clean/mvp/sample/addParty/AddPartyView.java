package es.ulpgc.eite.clean.mvp.sample.addParty;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
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
import es.ulpgc.eite.clean.mvp.sample.category.CategoryView;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import io.realm.RealmResults;


/**
 * Created by eleonora on 23/03/2017.
 */

public class AddPartyView extends GenericActivity<Add.PresenterToView, Add.ViewToPresenter, AddPartyPresenter>
        implements Add.PresenterToView {

    TextView textViewTitle;
    TextView textViewDescription;
    EditText editTextDescrition;
    TextView textPlace;
    EditText editTextPlace;
    TextView textdate;
    DatePicker datePicker;
    TextView textViewInit;
    TimePicker timePickerInit;
    TextView textViewFinish;
    TimePicker timePickerFinish;
    Button buttonPublish;
    Toolbar toolbar;


    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addparty);


        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        textViewTitle = (TextView) findViewById(R.id.textViewTitle);
          textViewDescription=(TextView)findViewById(R.id.textViewDescription);
        editTextDescrition=(EditText)findViewById(R.id.editTextDescription);
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

    @SuppressLint("MissingSuperCall")
    @Override
    public void onResume() {
        super.onResume(AddPartyPresenter.class, this);
    }

    @Override
    public void settingAdapter(RealmResults<CategoryData> data) {
        CategoryView category = new CategoryView();
        category.settingAdapter(data);
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
        String month = String.valueOf(datePicker.getMonth());
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
    @Override
    public String getDescription(){
        return editTextDescrition.getText().toString();
    }
   // @RequiresApi(api = Build.VERSION_CODES.M)
    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public int getHourOfInit() {
        int hour = timePickerInit.getHour();
        return hour;
    }

    //@RequiresApi(api = Build.VERSION_CODES.M)
    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public int getHourOfFinish() {
        int hour = timePickerFinish.getHour();
        return hour;
    }

}