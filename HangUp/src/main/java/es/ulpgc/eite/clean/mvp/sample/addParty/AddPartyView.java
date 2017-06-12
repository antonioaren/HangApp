package es.ulpgc.eite.clean.mvp.sample.addParty;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.util.Calendar;
import java.util.Date;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import es.ulpgc.eite.clean.mvp.sample.util.DateFormatter;


/**
 * Created by eleonora on 23/03/2017.
 */

public class AddPartyView extends GenericActivity<Add.PresenterToView, Add.ViewToPresenter, AddPartyPresenter>
        implements Add.PresenterToView {


    private EditText EventName;
    private EditText EventPlace;
    private TextView EventDate;
    private EditText EventTimeInit;
    private EditText EventTimeFinish;
    private TextView textSelect;
    private RadioGroup rg;
    private RadioButton r0, r1, r2, r3;
    private Button buttonPublish;
    private EditText EventDetails;

    private Date date;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addparty);


        EventName = (EditText) findViewById(R.id.name);
        EventName.requestFocus();
        EventPlace = (EditText) findViewById(R.id.place);
        EventPlace.requestFocus();
        EventDate = (TextView) findViewById(R.id.date);
        EventDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar now = Calendar.getInstance();
                final DatePickerDialog d = DatePickerDialog.newInstance(
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                                Calendar checkedCalendar = Calendar.getInstance();
                                checkedCalendar.set(year, monthOfYear, dayOfMonth);
                                date = checkedCalendar.getTime();
                                EventDate.setText(DateFormatter.convertDateToString(date));
                            }
                        },
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                d.setMaxDate(now);
                d.show(getFragmentManager(), this.getClass().getName());

            }
        });
        textSelect = (TextView) findViewById(R.id.textselect);
        rg = (RadioGroup) findViewById(R.id.rg);
        r0 = (RadioButton) findViewById(R.id.r0);
        r1 = (RadioButton) findViewById(R.id.r1);
        r2 = (RadioButton) findViewById(R.id.r2);
        r3 = (RadioButton) findViewById(R.id.r3);
        EventTimeInit = (EditText) findViewById(R.id.timeI);
        //Todo: Añadir TimePicker Parecido al calendar.

        EventTimeFinish = (EditText) findViewById(R.id.TimeF);

        EventDetails = (EditText) findViewById(R.id.details);

        buttonPublish = (Button) findViewById(R.id.Add);
        buttonPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveData();
                getPresenter().onPublishButtonClicked();
            }
        });
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onResume() {
        super.onResume(AddPartyPresenter.class, this);
    }


    @Override
    public void finishScreen() {
        finish();
    }


    /////////////////////////// LABELS /////////////////////////////////////////


    @Override
    public void setNameLabel(String txt) {
        EventName.setHint(txt);
    }

    @Override
    public void setPlaceLabel(String txt) {
        EventPlace.setHint(txt);
    }

    @Override
    public void setDateLabel(String txt) {
        EventDate.setHint(txt);
    }

    @Override
    public void setTimeInitLabel(String txt) {
        EventTimeInit.setHint(txt);
    }

    @Override
    public void setTimeFinishLabel(String txt) {
        EventTimeFinish.setHint(txt);
    }

    @Override
    public void setDetailsLabel(String txt) {
        EventDetails.setHint(txt);
    }

//    @Override
//    public void setTextSelectPhotoLabel(String txt) {
//        textselect.setText(txt);
//    }

    @Override
    public void setPublishBtnLabel(String txt) {
        buttonPublish.setText(txt);
    }


    ///////////////////////////// CAPTAR DATOS ///////////////////////////////

    private void SaveData() {
        ProductData product = new ProductData();

        product.setProductName(EventName.getText().toString());
        product.setPlace(EventPlace.getText().toString());
        product.setDate(EventDate.getText().toString());
        product.setTimeI(EventTimeInit.getText().toString());
        product.setTimeF(EventTimeFinish.getText().toString());
        product.setDetailText(EventDetails.getText().toString());

        getPresenter().DataFromAddView(product);
    }

    @Override
    public int getRadioButtonId() {
        int identificator = 1;
        int id = rg.getCheckedRadioButtonId();
        if (id == R.id.r0) {
            identificator = 0;
        } else if (id == R.id.r1) {
            identificator = 1;
        } else if (id == R.id.r2) {
            identificator = 2;
        } else if (id == R.id.r3) {
            identificator = 3;
        } else {
            identificator = 0;
        }
        return identificator;
    }
}