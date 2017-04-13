package es.ulpgc.eite.clean.mvp.sample.search;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
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
import es.ulpgc.eite.clean.mvp.sample.hangapp.HangAppView;

import static es.ulpgc.eite.clean.mvp.sample.R.layout.activity_search;

/**
 * Created by eleonora on 23/03/2017.
 */

public class SearchView  extends GenericActivity<Search.PresenterToView, Search.ViewToPresenter, SearchPresenter>
        implements Search.PresenterToView  {
private ImageView imageSearch;
    TextView text;
    TextView textLocation;
    EditText editTextLocation;
    TextView categories;
    ListView listCategories;
    TextView textDate;
    CalendarView calendar;
    Button buttonSearch;
    Toolbar t;
    // ActionBar ab;

       @Override
         public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_search);
           t = (Toolbar) findViewById(R.id.toolbar);
           setSupportActionBar(t);
           getSupportActionBar().setDisplayHomeAsUpEnabled(true);
           getSupportActionBar().setDisplayShowHomeEnabled(true);

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
                getPresenter().onButtonSecundarySearchPressed();

            }
        });
    }


    @Override
    public void finishScreen() {

    }

    @Override
    public void setSearchBtnLabel(String txt) {

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
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent myIntent = new Intent(getApplicationContext(), HangAppView.class);
        startActivityForResult(myIntent, 0);

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
}


