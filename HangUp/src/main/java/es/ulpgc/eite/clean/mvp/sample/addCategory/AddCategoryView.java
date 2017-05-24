package es.ulpgc.eite.clean.mvp.sample.addCategory;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;


/**
 * Created by eleonora on 23/03/2017.
 */

public class AddCategoryView extends GenericActivity<AddCategory.PresenterToView, AddCategory.ViewToPresenter, AddCategoryPresenter>
        implements AddCategory.PresenterToView{
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
    ListView list;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcategory);
        textViewTitle = (TextView) findViewById(R.id.title);
        textViewName = (TextView) findViewById(R.id.textName);
        editTextName = (EditText) findViewById(R.id.content_name);
        textPhoto = (TextView) findViewById(R.id.textPhoto);
        onResume();


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
        list=(ListView)findViewById(R.id.list);


        String[]name=getPresenter().getNames();
        Integer[]photos=getPresenter().getImages();
        ListAdapter adapter=new ListAdapter(this,photos,name);
        list.setAdapter(adapter);

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
        Integer[]images= getPresenter().getImages();
        String[]name= getPresenter().getNames();


     int position= list.getSelectedItemPosition();


     return images[position];

    }


public class ListAdapter extends ArrayAdapter<String>{
    private final Activity context;

    private final String[] name;
    private final Integer[]images;

    public ListAdapter(Activity context, Integer[]images,String[]name){
        super(context,R.layout.item_photos,name);
        this.context=context;
        this.name=name;
        this.images=images;
    }
    public View getView(int position,View view,ViewGroup parent){
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.item_photos,null,true);
        RadioButton radio=(RadioButton)rowView.findViewById(R.id.radio);
        radio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getItem(2);
            }
        });
        ImageView image=(ImageView)rowView.findViewById(R.id.imagePhoto);
        image.setImageResource(images[position]);
        //Obtengo el valor de la imagen y lo almaceno en tag





        TextView text=(TextView)rowView.findViewById(R.id.topic);
        text.setText(name[position]);

  rowView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

      }
  });
        return rowView;
    }

}



}


