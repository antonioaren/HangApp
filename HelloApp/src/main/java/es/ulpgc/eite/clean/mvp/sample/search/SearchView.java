package es.ulpgc.eite.clean.mvp.sample.search;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;
import es.ulpgc.eite.clean.mvp.sample.hangapp.HangApp;
import es.ulpgc.eite.clean.mvp.sample.hangapp.HangAppPresenter;

/**
 * Created by eleonora on 23/03/2017.
 */

public class SearchView  extends GenericActivity<HangApp.PresenterToView, HangApp.ViewToPresenter, HangAppPresenter>
        implements HangApp.PresenterToView  {
private ImageView imageSearch;
    TextView text;
    TextView textLocation;
    EditText editTextLocation;
    TextView categories;
    ListView listCategories;
    TextView textDate;
    CalendarView calendar;
    Button buttonSearch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        imageSearch=(ImageView)findViewById(R.id.imageViewSearch);
        text= (TextView)findViewById(R.id.textView);
       textLocation=(TextView)findViewById(R.id.textLocation);
        editTextLocation=(EditText)findViewById(R.id.editTextLocation);
        categories=(TextView)findViewById(R.id.textCategories);
        listCategories=(ListView)findViewById(R.id.listCategories);
         String[]categories= new String[]{"Cines","Culturales","Conciertos","Discotecas","Verbenas"};
        ArrayAdapter<String> adaptader = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categories);
        listCategories.setAdapter(adaptader);
        textDate=(TextView)findViewById(R.id.textDate);
        calendar=(CalendarView)findViewById(R.id.calendarView);
        buttonSearch=(Button)findViewById(R.id.buttonSearch);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
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




}
