package es.ulpgc.eite.clean.mvp.sample.category;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryView
        extends GenericActivity<Category.PresenterToView, Category.ViewToPresenter, CategoryPresenter>
        implements Category.PresenterToView {

    private Button buttonSearch;
    private Button buttonAdd;
    private RecyclerView recycler;
    private CategoryAdapter adapter;
    private RecyclerView.LayoutManager lManager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangapp);
//    ERROR el mediador ya trae la conexion con con el presemtador
//    En tal caso se hace a través del mediador.
//    CategoryPresenter hap = new CategoryPresenter();

//    faltaba declarar el list view

//    ImageView image=(ImageView)findViewById(R.id.image);
//    title=(TextView)findViewById(R.id.title);
//    information=(TextView)findViewById(R.id.information);
//    String[] parties = hap.getParties();
//
//    list = (ListView)findViewById(R.id.list);
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

        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        adapter = new CategoryAdapter();
        recycler.setAdapter(adapter);
    }

    /**
     * Method that initialized MVP objects
     * {@link super#onResume(Class, Object)} should always be called
     */

    @Override
    protected void onResume() {
        super.onResume(CategoryPresenter.class, this);

        List<CategoryData> items = getPresenter().getItems();
        adapter.setItems(getPresenter().getItems());
    }

    ///////////////////////////////////////////////////////////////////////////////////
    // Presenter To View /////////////////////////////////////////////////////////////


    @Override
    public void finishScreen() {
        finish();
    }

    @Override
    public void setLabelSearch(String txt) {
        buttonSearch.setText(txt);
    }

    @Override
    public void setAddLabel(String txt) {
        buttonAdd.setText(txt);
    }

    @Override
    public void setItem(List Items) {
    }
}

class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

    private List<CategoryData> items;


    public static class CategoryViewHolder extends RecyclerView.ViewHolder {

        //public ImageView imagen;
        public TextView title;
        public TextView information;

        public CategoryViewHolder(View v) {
            super(v);
            //imagen = (ImageView) v.findViewById(R.id.image);
            title = (TextView) v.findViewById(R.id.title);
            //       information = (TextView) v.findViewById(R.id.information);
        }
    }

    public CategoryAdapter() {
        this.items = new ArrayList<>();
        ;
    }

    public void setItems(List<CategoryData> items) {
        this.items = items;
        this.notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.categorycard, viewGroup, false);
        return new CategoryViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CategoryViewHolder viewHolder, int position) {
        Log.d("my_debug", "onBindViewHolder(" + position + ")");

        String nombre = items.get(position).getNombre();
        //String descripcion = items.get(position).getDescripcion();

        //viewHolder.imagen.setImageResource(items.get(position).getImagen());
        viewHolder.title.setText(items.get(position).getNombre());
        //viewHolder.information.setText(items.get(position).getDescripcion());
    }
}

