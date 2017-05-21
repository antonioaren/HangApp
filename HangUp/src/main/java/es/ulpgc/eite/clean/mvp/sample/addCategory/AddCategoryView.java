package es.ulpgc.eite.clean.mvp.sample.addCategory;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;


/**
 * Created by eleonora on 23/03/2017.
 */

public class AddCategoryView extends GenericActivity<AddCategory.PresenterToView, AddCategory.ViewToPresenter, AddCategoryPresenter>
        implements AddCategory.PresenterToView {
//Clase desde la cual añadimos categegoria
   private static String APP_DIRECTORY="drawable";
    //variable que representa el directorio donde se guardaran nuestras imagenes extraidas de galeria
    private static String MEDIA_DIRECTORY=APP_DIRECTORY+"name";
    private String TEMPORAL_PICTURE_NAME="temporal.jpg";

    private final int SELECT_PICTURE=200;
    private final int PHOTO_CODE=100;

    TextView textViewTitle;
    TextView textViewName;
    EditText editTextName;
    TextView textPhoto;
    Button buttonPhoto;
    ImageView image;
    Button buttonAdd;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcategory);
        textViewTitle=(TextView)findViewById(R.id.title);
        textViewName=(TextView)findViewById(R.id.textName);
        editTextName=(EditText)findViewById(R.id.content_name);
        textPhoto=(TextView)findViewById(R.id.textPhoto);
        buttonPhoto=(Button)findViewById(R.id.buttonSelect);
        buttonPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().onSelectClicked();

            }
        });

   image=(ImageView)findViewById(R.id.image);
        buttonAdd=(Button)findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               getPresenter().onAddClicked();

            }
        });




    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onResume() {
        super.onResume(AddCategoryPresenter.class, this);
    }


    @Override
    public void finishScreen() {
        finish();
    }

    @Override
    public void hideToolbar() {

    }




    @Override
    public void hideText() {
    }


    @Override
    public void setAddBtnLabel(String txt) {
        buttonAdd.setText(txt);
    }

    @Override
    public void setTitleLabel(String txt) {
        textViewTitle.setText(txt);
    }

    @Override
    public void setNameLabel(String txt) {
    textViewName.setText(txt);
    }

   @Override
   public String getTextFromEditText(){
      return editTextName.getText().toString();
   }
    @Override
    public void setPhotoLabel(String txt) {
    textPhoto.setText(txt);
    }
    @Override
    public void setButtonPhotoLabel(String txt) {
        buttonPhoto.setText(txt);
    }

    @Override
    public int getPhotoSelected() {
        return 0;
    }

}