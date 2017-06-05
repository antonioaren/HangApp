package es.ulpgc.eite.clean.mvp.sample.addParty;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    private EditText EventTimeFinish;
    private EditText EventDate;
    private TextView EventTimeInit;
    private Button buttonPublish;
    private EditText EventDetails;
    private TextView textselect;
    private RadioGroup rg;
    private Date date;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addparty);


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

        EventDetails = (EditText) findViewById(R.id.details);
        textselect = (TextView) findViewById(R.id.textSelect);
        rg = (RadioGroup) findViewById(R.id.rg);


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

    @Override
    public void setTextSelectPhotoLabel(String txt) {
        textselect.setText(txt);
    }
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
        product.setImage(getPresenter().getImageForProduct());
        getPresenter().DataFromAddView(product);
    }
//
@Override
public String getName() {
    return EventName.getText().toString();
}

    @Override
    public String getPlaceOfTheParty() {
        return EventPlace.getText().toString();
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public String getHourOfInit() {
        return EventTimeInit.getText().toString();
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public String getHourOfFinish() {
        return EventTimeFinish.getText().toString();
    }

    @Override
    public String getDateOfTheParty() {
        return EventDate.getText().toString();
    }

    @Override
    public int getIdNumberOfRadiouGroup() {
        String id = String.valueOf(rg.getCheckedRadioButtonId());
        String lastdigit = id.substring(9);
        int idNumber = Integer.parseInt(lastdigit);
        // int digit =1;
//        if(id==R.id.r0){
//          digit=0;
//
//      }
//     if(id==R.id.r1){
//         digit=1;
//     }
//    if(id==R.id.r2){
//        digit=2;
//    }if(id==R.id.r3){
//           digit=3;
//        }
//     return digit;
        return idNumber;
    }

}