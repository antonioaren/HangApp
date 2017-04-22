package es.ulpgc.eite.clean.mvp.sample.hangapp;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;


public class HangAppView
        extends GenericActivity<HangApp.PresenterToView, HangApp.ViewToPresenter, HangAppPresenter>
        implements HangApp.PresenterToView {

  private Button buttonSearch;
  private Button buttonAdd;

  private TextView information;
  private TextView title;
  private ListView list;
  private ImageView image;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_hangapp);
    HangAppPresenter hap = new HangAppPresenter();
    //faltaba declarar el list view

    ImageView image=(ImageView)findViewById(R.id.image);


    title=(TextView)findViewById(R.id.title);
    information=(TextView)findViewById(R.id.information);
    String[] parties = hap.getParties();

    list = (ListView)findViewById(R.id.list);

    ArrayAdapter<String> adaptder =
            new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, parties);

    list.setAdapter(adaptder);

    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                  @Override
                                  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                    getPresenter().onListItemClicked();
                                  }});



    buttonSearch = (Button) findViewById(R.id.buttonSearch);
    buttonSearch.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        getPresenter().onButtonSearchClicked();

      }
    });
    buttonAdd = (Button) findViewById(R.id.buttonAdd);
    buttonAdd.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        getPresenter().onButtonAddClicked();
      }
    });
  }

  /**
   * Method that initialized MVP objects
   * {@link super#onResume(Class, Object)} should always be called
   */

  @SuppressLint("MissingSuperCall")
  @Override
  protected void onResume() {
    super.onResume(HangAppPresenter.class, this);
  }


  ///////////////////////////////////////////////////////////////////////////////////
  // Presenter To View /////////////////////////////////////////////////////////////

  @Override
  public void finishScreen() {
    finish();
  }


  @Override
  public void hideText() {
    information.setVisibility(View.GONE);
  }

  @Override
  public void showText() {
    information.setVisibility(View.VISIBLE);
  }

  @Override
  public void setText(String txt) {
    information.setText(txt);
  }

  @Override
  public void setLabel(String txt) {

  }

  @Override
  public void setLabelSearch(String txt) {
    buttonSearch.setText(txt);
  }

  @Override
  public void setAddLabel(String txt) {
    buttonAdd.setText(txt);
  }
}
