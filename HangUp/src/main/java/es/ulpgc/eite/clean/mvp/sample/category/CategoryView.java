package es.ulpgc.eite.clean.mvp.sample.category;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;

public class CategoryView
        extends GenericActivity<Category.PresenterToView, Category.ViewToPresenter, CategoryPresenter>
        implements Category.PresenterToView {

    private Button buttonSearch;
    private Button buttonAdd;

    private TextView information;
    private TextView title;
    private ListView list;
    private ImageView image;

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private List<CategoryData> items;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangapp);

//    ERROR el mediador ya trae la conexion con con el presemtador
//    En tal caso se hace a través del mediador.
//    CategoryPresenter hap = new CategoryPresenter();

//    faltaba declarar el list view

        ImageView image = (ImageView) findViewById(R.id.image);
        title = (TextView) findViewById(R.id.title);
        // information = (TextView) findViewById(R.id.information);
        String[] parties = getPresenter().getParties();
//
        //list = (ListView)findViewById(R.id.list);
//
//    ArrayAdapter<String> adaptder =
//            new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, parties);
//
//    list.setAdapter(adaptder);
//
//    list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                                  @Override
//                                  public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                                    getPresenter().onListItemClicked();}});

        //Adapter por pedro

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

        // Obtener el Recycler
        /*Cuando se obtiene la instancia del recycler se usa el método setHasFixedSize() para optimizar
        las operaciones con los ítems. Con esta característica le estamos diciendo al recycler que el
        adaptador no variará su tamaño en toda la ejecución del programa.*/

        //    recycler = (RecyclerView) findViewById(R.id.recycler);
        //   recycler.setHasFixedSize(true); //Habrá que quitarlo si la lista es dinámica.

        // Usar un administrador para LinearLayout
        /*El layout manager fue instanciado con la subclase LinearLayoutManager, indicando que el recycler
        tomará la forma de lista vertical similar al ListView. Luego se relaciona al recycler con el
        método setLayoutManager().*/

        //    lManager = new LinearLayoutManager(this);
        //   recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        //  adapter = new CategoryAdapter(items);
        // recycler.setAdapter(adapter);


    }

    /**
     * Method that initialized MVP objects
     * {@link super#onResume(Class, Object)} should always be called
     */

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onResume() {
//    super.onResume(CategoryPresenter.class, this);
//    String[]parties=getPresenter().getParties();
//    int[]images=getPresenter().getImages();
//    list=(ListView)findViewById(R.id.list);
//    ArrayAdapter<String> adaptder = new ArrayAdapter<String>(this,R.layout.content_filalista,R.id.content,parties);
//    list.setAdapter(adaptder);
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


class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private List<CategoryData> items;

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public ImageView imagen;
        public TextView title;
        // public TextView information;

        public CategoryViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.image);
            title = (TextView) v.findViewById(R.id.title);
            //information = (TextView) v.findViewById(R.id.information);
        }
    }

    public CategoryAdapter(List<CategoryData> items) {
        this.items = items;

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    //Encargado de crear los nuevos

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {//i es la posición.

        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.category_card, viewGroup, false);
        return new CategoryViewHolder(v);
    }


    //Encargado de actualizar los datos de un ViewHolder ya existente.
    @Override
    public void onBindViewHolder(CategoryViewHolder viewHolder, int i) { //i es la posición.
        viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.title.setText(items.get(i).getNombre());
        // viewHolder.information.setText(items.get(i).getDescripcion());
    }
}


