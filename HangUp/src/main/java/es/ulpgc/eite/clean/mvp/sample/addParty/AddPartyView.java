package es.ulpgc.eite.clean.mvp.sample.addParty;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.RadialPickerLayout;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;
import es.ulpgc.eite.clean.mvp.sample.category.CategoryView;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;

import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import es.ulpgc.eite.clean.mvp.sample.util.DateFormatter;
import io.realm.RealmResults;

import static es.ulpgc.eite.clean.mvp.sample.R.id.textPlace;


/**
 * Created by eleonora on 23/03/2017.
 */

public class AddPartyView extends GenericActivity<Add.PresenterToView, Add.ViewToPresenter, AddPartyPresenter>
        implements Add.PresenterToView {

    private TextView title;
    private EditText EventName;
    private EditText EventPlace;
    private EditText EventTimeFinish;

    private TextView EventDate;
    private TimePicker timePickerInit;
    private TextView EventTimeInit;
    private TimePicker timePickerFinish;
    private Button buttonPublish;

    private Date date;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addparty);

        title = (TextView) findViewById(R.id.textView);

        EventName = (EditText) findViewById(R.id.name);
        EventName.requestFocus();
        EventPlace = (EditText) findViewById(R.id.place);
        EventPlace.requestFocus();
        EventDate = (EditText) findViewById(R.id.date);
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
        EventTimeInit = (EditText) findViewById(R.id.timeI);
        //Todo: Añadir TimePicker Parecido al calendar.

        EventTimeFinish = (EditText) findViewById(R.id.TimeF);

        buttonPublish = (Button) findViewById(R.id.Add);
        buttonPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
    public void finishScreen() {
        finish();
    }


    /////////////////////////// LABELS /////////////////////////////////////////

    @Override
    public void setTitleLabel(String txt) {
        title.setText(txt);
    }
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
    public void setPublishBtnLabel(String txt) {
        buttonPublish.setText(txt);
    }


    ///////////////////////////// CAPTAR DATOS ///////////////////////////////

    public ProductData GetData() {
        ProductData product = new ProductData();
        product.setProductName(EventName.getText().toString());
        product.setPlace(EventPlace.getText().toString());
        product.setDate(EventDate.getText().toString());
        product.setTimeI(EventTimeInit.getText().toString());
        product.setTimeF(EventTimeFinish.getText().toString());
        return product;
    }

    @Override
    public String getDescription() {
        return EventName.getText().toString();
    }

    @Override
    public String getPlaceOfTheParty() {
        return EventPlace.getText().toString();
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public int getHourOfInit() {
        int hour = timePickerInit.getHour();
        return hour;
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public int getHourOfFinish() {
        int hour = timePickerFinish.getHour();
        return hour;
    }

}