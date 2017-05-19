package es.ulpgc.eite.clean.mvp.sample.search;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;

import static es.ulpgc.eite.clean.mvp.sample.R.layout.activity_search;

/**
 * Created by eleonora on 23/03/2017.
 */

public class SearchView  extends GenericActivity<Search.PresenterToView, Search.ViewToPresenter, SearchPresenter>
        implements Search.PresenterToView {

    // ActionBar ab;
Button delete;
    TextView text;
    EditText ediText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_search);
        delete=(Button)findViewById(R.id.delete);
       delete .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().onDeleteClicked();

            }
        });
        text=(TextView)findViewById(R.id.textView);
        ediText=(EditText)findViewById(R.id.editText);

    }


    @SuppressLint("MissingSuperCall")
    @Override
    public void onResume() {
        super.onResume(SearchPresenter.class, this);
       String[] categories = getPresenter().getCategories();


    }

    @Override
    public void finishScreen() {
        finish();
    }

    @Override
    public void setDeleteBtnLabel(String txt) {
        delete.setText(txt);
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
public String getTextFromEditText(){
   return ediText.getText().toString();
}

    /*
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
    */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Intent myIntent = new Intent(getApplicationContext(), CategoryView.class);
        //startActivityForResult(myIntent, 0);

        /*
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
           // return true;
        }
        */

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        /*
        if (id == R.id.action_settings) {
            return true;
        }
        */

        return super.onOptionsItemSelected(item);

    }
//metodo de prueba para pasar a la segunda lista,de fiestas
//   @Override
//   public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//      String value= (String) parent.getItemAtPosition(position);
//      Intent intent= new Intent(this,PartiesByCategoriesView.class);
//      intent.putExtra("categories",value);
//      startActivity(intent);
//  }
}

