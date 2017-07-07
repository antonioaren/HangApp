package es.ulpgc.eite.clean.mvp.sample.addProduct;

import android.annotation.SuppressLint;
import android.app.TimePickerDialog;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.Date;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;
import es.ulpgc.eite.clean.mvp.sample.util.DateFormatter;


/**
 * Created by eleonora on 23/03/2017.
 */

public class AddProductView extends GenericActivity<AddProduct.PresenterToView, AddProduct.ViewToPresenter, AddProductPresenter>
        implements AddProduct.PresenterToView {


    private EditText eventName;
    private EditText eventPlace;
    private TextView eventDate;
    private TextView eventTimeInit;
    private TextView eventTimeFinish;
    private EditText eventDetails;
    private ImageButton eventImage;

    private Button buttonPublish;

    private Integer hour;
    private Integer minutes;
    private boolean isImageChosen;


    private static final int PICK_IMAGE = 100;

    private Uri imageUri;
    private Date date;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addparty);

        eventName = (EditText) findViewById(R.id.name);
        eventName.requestFocus();

        eventPlace = (EditText) findViewById(R.id.place);

        eventDate = (TextView) findViewById(R.id.date);
        eventDate.setOnClickListener(new View.OnClickListener() {
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
                                eventDate.setText(DateFormatter.convertDateToString(date));
                            }
                        },
                        now.get(Calendar.YEAR),
                        now.get(Calendar.MONTH),
                        now.get(Calendar.DAY_OF_MONTH)
                );
                d.setMinDate(now);
                d.show(getFragmentManager(), this.getClass().getName());
            }
        });

        eventTimeInit = (TextView) findViewById(R.id.timeI);
        eventTimeInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar time = Calendar.getInstance();
                hour = time.get(Calendar.HOUR_OF_DAY);
                minutes = time.get(Calendar.MINUTE);

                TimePickerDialog timepicker = new TimePickerDialog(getActivityContext(),
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                hour = hourOfDay;
                                minutes = minute;

                                eventTimeInit.setText(hour.toString() + ":" + minutes.toString());
                            }
                        }, hour, minutes, true);
                timepicker.show();
            }
        });

        eventTimeFinish = (TextView) findViewById(R.id.TimeF);
        eventTimeFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar time = Calendar.getInstance();
                hour = time.get(Calendar.HOUR_OF_DAY);
                minutes = time.get(Calendar.MINUTE);

                TimePickerDialog timepicker = new TimePickerDialog(getActivityContext(),
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                hour = hourOfDay;
                                minutes = minute;
                                eventTimeFinish.setText(hour.toString() + ":" + minutes.toString());
                            }
                        }, hour, minutes, true);
                timepicker.show();
            }
        });

        eventDetails = (EditText) findViewById(R.id.details);

        eventImage = (ImageButton) findViewById(R.id.imageButton);
        eventImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        buttonPublish = (Button) findViewById(R.id.addParty);
        buttonPublish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPresenter().onButtonAddClicked();
            }
        });
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onResume() {
        super.onResume(AddProductPresenter.class, this);
    }

    @Override
    public void finishScreen() {
        finish();
    }

    @Override
    public void openDialog() {

    }

    private void openGallery() {
        startActivityForResult(new Intent
                (Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI), PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            eventImage.setImageURI(imageUri);
            setImageChosen(true);


        }
    }

    /////////////////////////// LABELS /////////////////////////////////////////


    @Override
    public void setNameLabel(String txt) {
        eventName.setHint(txt);
    }

    @Override
    public void setPlaceLabel(String txt) {
        eventPlace.setHint(txt);
    }

    @Override
    public void setDateLabel(String txt) {
        eventDate.setHint(txt);
    }

    @Override
    public void setTimeInitLabel(String txt) {
        eventTimeInit.setHint(txt);
    }

    @Override
    public void setTimeFinishLabel(String txt) {
        eventTimeFinish.setHint(txt);
    }

    @Override
    public void setDetailsLabel(String txt) {
        eventDetails.setHint(txt);
    }

    @Override
    public void setTimeInitText(String txt) {
        eventTimeInit.setText(txt);
    }

    @Override
    public void setPublishBtnLabel(String txt) {
        buttonPublish.setText(txt);
    }


    ///////////////////////////// CAPTAR DATOS ////////////////////////////////

    @Override
    public String getEventName() {
        return eventName.getText().toString();
    }

    @Override
    public String getEventPlace() {
        return eventPlace.getText().toString();
    }

    @Override
    public String getEventDate() {
        return eventDate.getText().toString();
    }

    @Override
    public String getEventTimeInit() {
        return eventTimeInit.getText().toString();
    }

    @Override
    public String getEventTimeFinish() {
        return eventTimeFinish.getText().toString();
    }

    @Override
    public String getEventDetails() {
        return eventDetails.getText().toString();
    }

    @Override
    public ImageButton getEventImage() {
        return eventImage;
    }

    @Override
    public String getStringImageUri() {
        return imageUri.toString();
    }

    ///////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void setToast(String txt) {
        Toast.makeText(this, txt, Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean getIsImageChosen() {
        return isImageChosen;
    }

    @Override
    public void setImageChosen(boolean imageChosen) {
        this.isImageChosen = imageChosen;
    }

    private String saveToInternalStorage(Bitmap bitmapImage) {

        ContextWrapper cw = new ContextWrapper(getApplicationContext());

        // path to /data/data/yourapp/app_data/imageDir
        File directory = cw.getDir("imageDir", MODE_PRIVATE);

        //recorremos URI para para obtener el nombre del archivo.
        String filename = imageUri.toString().substring(imageUri.toString().lastIndexOf("/"));


        // Create imageDir
        File mypath = new File(directory, filename + ".jpg");

        FileOutputStream fos;
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