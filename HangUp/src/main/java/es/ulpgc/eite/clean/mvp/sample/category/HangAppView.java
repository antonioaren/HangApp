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

  // private Toolbar toolbar;
  private Button buttonSearch;
  private Button buttonAdd;

  private TextView information;
  ListView list;
  ImageView image;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_hangapp);

    //faltaba declarar el list view
    ImageView image=(ImageView)findViewById(R.id.image);



    information=(TextView)findViewById(R.id.information);
    onResume();
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
    String[]parties=getPresenter().getParties();
    int[]images=getPresenter().getImages();
    list=(ListView)findViewById(R.id.list);
    ArrayAdapter<String> adaptder = new ArrayAdapter<String>(this,R.layout.content_filalista,R.id.content,parties);
    list.setAdapter(adaptder);
  }

  /*
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(es.ulpgc.eite.clean.mvp.sample.hangapp.R.menu.menu_dummy, menu);
    return true;
  }
  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();
    //noinspection SimplifiableIfStatement
    if (id == es.ulpgc.eite.clean.mvp.sample.hangapp.R.id.action_settings) {
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
  */


  ///////////////////////////////////////////////////////////////////////////////////
  // Presenter To View /////////////////////////////////////////////////////////////

  @Override
  public void finishScreen() {
    finish();
  }

//  Override
//  public void hideToolbar() {
//    toolbar.setVisibility(View.GONE);
//  }

  @Override
  public void hideText() {
    //information.setVisibility(View.GONE);
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


class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

  private List<Category> items;

  public static class CategoryViewHolder extends RecyclerView.ViewHolder {
    // Campos respectivos de un item
    public ImageView imagen;
    public TextView nombre;
    public TextView descripcion;

    public CategoryViewHolder(View v) {
      super(v);
//      imagen = (ImageView) v.findViewById(R.id.imagen);
//      nombre = (TextView) v.findViewById(R.id.nombre);
//      descripcion = (TextView) v.findViewById(R.id.descripcion);
    }
  }

  public CategoryAdapter(List<Category> items) {
    this.items = items;

  }

  @Override
  public int getItemCount() {
    return items.size();
  }

  @Override
  public CategoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
    View v = LayoutInflater.from(viewGroup.getContext())
            .inflate(R.layout.category_card, viewGroup, false);
    return new CategoryViewHolder(v);
  }

  @Override
  public void onBindViewHolder(CategoryViewHolder viewHolder, int i) {
    viewHolder.imagen.setImageResource(items.get(i).getImagen());
    viewHolder.nombre.setText(items.get(i).getNombre());
    viewHolder.descripcion.setText(items.get(i).getDescripcion());
  }
}
