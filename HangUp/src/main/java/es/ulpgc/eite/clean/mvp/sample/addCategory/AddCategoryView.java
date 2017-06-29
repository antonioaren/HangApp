package es.ulpgc.eite.clean.mvp.sample.addCategory;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;


/**
 * Created by eleonora on 23/03/2017.
 */

public class AddCategoryView extends GenericActivity<AddCategory.PresenterToView, AddCategory.ViewToPresenter, AddCategoryPresenter>
        implements AddCategory.PresenterToView {

    private TextView textViewName;
    private EditText editTextName;
    private TextView textPhoto;
    private RadioGroup radioGroup;
    private Button buttonAdd;
    private RadioButton radioButton0, radioButton1, radioButton2, radioButton3;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcategory);

        textViewName = (TextView) findViewById(R.id.textName);
        editTextName = (EditText) findViewById(R.id.content_name);

        textPhoto = (TextView) findViewById(R.id.textPhoto);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioButton0 = (RadioButton) findViewById(R.id.id0);
        radioButton1 = (RadioButton) findViewById(R.id.id1);
        radioButton2 = (RadioButton) findViewById(R.id.id2);
        radioButton3 = (RadioButton) findViewById(R.id.id3);


        buttonAdd = (Button) findViewById(R.id.buttonAddCategory);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().onAddClicked();
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume(AddCategoryPresenter.class, this);
    }

    @Override
    public void finishScreen() {
        finish();
    }

    //////////////////////////////////////Labels/////////////////////////////////////////////////

    @Override
    public void setAddBtnLabel(String txt) {
        buttonAdd.setText(txt);
    }

    @Override
    public void setNameLabel(String txt) {
        textViewName.setText(txt);
    }

    @Override
    public void setPhotoLabel(String txt) {
        textPhoto.setText(txt);
    }

    @Override
    public void setRadioButtonLabels(String txt0, String txt1, String txt2, String txt3) {
        radioButton0.setText(txt0);
        radioButton1.setText(txt1);
        radioButton2.setText(txt2);
        radioButton3.setText(txt3);
    }

    @Override
    public int getRadioButtonId() {
        int identificator;

        //Capta el id   del radio button seleccionado
        int id = radioGroup.getCheckedRadioButtonId();

        if (id == R.id.id0) {
            identificator = 0;
        } else if (id == R.id.id1) {
            identificator = 1;
        } else if (id == R.id.id2) {
            identificator = 2;
        } else if (id == R.id.id3) {
            identificator = 3;
        } else {
            identificator = 0;
        }
        return identificator;
    }

    @Override
    public String getTextFromEditText() {
        return editTextName.getText().toString();
    }

    @Override
    public void setToast(String txt) {
        Toast.makeText(this, txt, Toast.LENGTH_SHORT).show();
    }

    private Bitmap getBitMapFromAssets(String FileName) {
        AssetManager assetManager = getAssets();
        InputStream istr = null;

        try {
            istr = assetManager.open(FileName);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Bitmap imagenBitmap = BitmapFactory.decodeStream(istr);

        return imagenBitmap;
    }
}