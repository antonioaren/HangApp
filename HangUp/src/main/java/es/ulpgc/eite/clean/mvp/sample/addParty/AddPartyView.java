package es.ulpgc.eite.clean.mvp.sample.addParty;

import android.annotation.SuppressLint;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
    private EditText EventDetails;
    private ImageButton EventImage;

    private Button buttonPublish;

    private static final int PICK_IMAGE = 100;
    private Bitmap imageBitMap;
    private Date date;

    private Integer count = 0;


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
        EventTimeInit = (EditText) findViewById(R.id.timeI);
        //Todo: Añadir TimePicker Parecido al calendar.

        EventTimeFinish = (EditText) findViewById(R.id.TimeF);

        EventDetails = (EditText) findViewById(R.id.details);

        EventImage = (ImageButton) findViewById(R.id.imageButton);
        EventImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        buttonPublish = (Button) findViewById(R.id.Add);
        buttonPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SaveData();
                getPresenter().onPublishButtonClicked();
            }
        });
    }

    private void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            Uri imageUri = data.getData();
            imageBitMap = null;
            try {
                imageBitMap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
            } catch (IOException e) {
                e.printStackTrace();
            }
            EventImage.setImageBitmap(imageBitMap);
        }
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
    public void setTextSelectLabel(String txt) {

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
    public int getRadioButtonId() {
        return 0;
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
        product.setImage(saveToInternalStorage(imageBitMap));

        getPresenter().DataFromAddView(product);
    }

    private String saveToInternalStorage(Bitmap bitmapImage) {
        ContextWrapper cw = new ContextWrapper(getApplicationContext());

        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", MODE_PRIVATE);
        // Create imageDir

        File mypath = new File(directory, "profile.jpg");

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(mypath);
            // Use the compress method on the BitMap object to write image to the OutputStream
            bitmapImage.compress(Bitmap.CompressFormat.JPEG, 100, fos);

            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return directory.getAbsolutePath();
    }
}