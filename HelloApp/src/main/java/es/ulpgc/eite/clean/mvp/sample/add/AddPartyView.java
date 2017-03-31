package es.ulpgc.eite.clean.mvp.sample.add;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.hangapp.HangApp;
import es.ulpgc.eite.clean.mvp.sample.hangapp.HangAppPresenter;
import es.ulpgc.eite.clean.mvp.sample.R;

/**
 * Created by eleonora on 23/03/2017.
 */

public class AddPartyView extends GenericActivity<HangApp.PresenterToView, HangApp.ViewToPresenter, HangAppPresenter>
        implements HangApp.PresenterToView {

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

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addparty);
        textViewTitle=(TextView)findViewById(R.id.textViewTitle);

        textPlace=(TextView) findViewById(R.id.textPlace);
        editTextPlace=(EditText)findViewById(R.id.editTextPlace);
        textdate=(TextView)findViewById(R.id.textDate);
        datePicker=(DatePicker)findViewById(R.id.datePicker);
        textViewInit=(TextView)findViewById(R.id.textViewInit);
        timePickerInit=(TimePicker)findViewById(R.id.timePickerInit);
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
    public void finishScreen() {

    }

    @Override
    public void hideToolbar() {

    }

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
}
