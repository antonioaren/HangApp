package es.ulpgc.eite.clean.mvp.sample.add;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;
import es.ulpgc.eite.clean.mvp.sample.hangapp.HangAppView;

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




        t=(Toolbar)findViewById(R.id.toolbar);

        setSupportActionBar(t);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        textViewTitle=(TextView)findViewById(R.id.textView);

        textPlace=(TextView) findViewById(R.id.textPlace);
        editTextPlace=(EditText)findViewById(R.id.editTextPlace);
        textdate=(TextView)findViewById(R.id.textDate);
        datePicker=(DatePicker)findViewById(R.id.datePicker);
        textViewInit=(TextView)findViewById(R.id.textViewInit);
        timePickerInit=(TimePicker)findViewById(R.id.timePickerInit);//timePickerInit
        textViewFinish=(TextView)findViewById(R.id.textViewFinish);
        timePickerFinish=(TimePicker)findViewById(R.id.timePickerFinish);

        buttonPublish=(Button)findViewById(R.id.buttonPublish);
        buttonPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public Toolbar getToolbar() {
        return null;
    }




    @Override
    public void finishScreen() {

    }

    @Override
    public void hideToolbar() {

    }

    @Override
    public void hideHelloMsg() {

    }

    @Override
    public void setPublishBtnLabel(String txt) {

    }

//    @Override
//    public void hideToolbar() {
//
//    }

    @Override
    public void hideText() {

    }

    @Override
    public void showText() {

    }

    @Override
    public void setText(String txt) {

    }

    @Override
    public void setLabel(String txt) {

    }

    @Override
    public void setLabelSearch(String txt) {

    }

    @Override
    public void setAddLabel(String txt) {

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), HangAppView.class);
        startActivityForResult(myIntent, 0);

//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}