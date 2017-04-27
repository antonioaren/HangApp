package es.ulpgc.eite.clean.mvp.sample.category;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;
import es.ulpgc.eite.clean.mvp.sample.app.ModelData;

public class CategoryView
        extends GenericActivity<Category.PresenterToView, Category.ViewToPresenter, CategoryPresenter>
        implements Category.PresenterToView {

    private Button buttonSearch;
    private Button buttonAdd;

    // private TextView information;
    private TextView title;

    private ImageView image;

    private RecyclerView recycler;
    private LinearLayoutManager linearmanager;
    private CategoryAdapter adapter;
    //private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;
    private List<ModelData> items;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangapp);

//    ERROR el mediador ya trae la conexion con con el presemtador
//    En tal caso se hace a través del mediador.
//    CategoryPresenter hap = new CategoryPresenter();


        title = (TextView) findViewById(R.id.title);
        image = (ImageView) findViewById(R.id.image);
        // information = (TextView) findViewById(R.id.information);
        // Obtener el Recycler
        /*Cuando se obtiene la instancia del recycler se usa el método setHasFixedSize() para optimizar
        las operaciones con los ítems. Con esta característica le estamos diciendo al recycler que el
        adaptador no variará su tamaño en toda la ejecución del programa.*/

        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setHasFixedSize(true); //Habrá que quitarlo si la lista es dinámica.

        // Usar un administrador para LinearLayout
        /*El layout manager fue instanciado con la subclase LinearLayoutManager, indicando que el recycler
        tomará la forma de lista vertical similar al ListView. Luego se relaciona al recycler con el
        método setLayoutManager().*/

        linearmanager = new LinearLayoutManager(this);
        recycler.setLayoutManager(linearmanager);

        /*
        //Adapter por pedro
        // Crear un nuevo adaptador
        List<ModelData> parties = getPresenter().getListOfParties();
        adapter = new CategoryAdapter(parties);
        //al adaptador le pasamos el contenido de la lista
        recycler.setAdapter(adapter);

        */




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




        /**
         * Method that initialized MVP objects
         * {@link super#onResume(Class, Object)} should always be called
         */
    }



    @SuppressLint("MissingSuperCall")
    @Override
    protected void onResume() {
        super.onResume(CategoryPresenter.class, this);
//    String[]parties=getPresenter().getParties();
//    int[]images=getPresenter().getImages();
//    list=(ListView)findViewById(R.id.list);
//    ArrayAdapter<String> adaptder = new ArrayAdapter<String>(this,R.layout.content_filalista,R.id.content,parties);
//    list.setAdapter(adaptder);



/*

        //Adapter por pedro
        // Crear un nuevo adaptador
        List<ModelData> parties = getPresenter().getListOfParties();
        adapter = new CategoryAdapter(parties);
        //al adaptador le pasamos el contenido de la lista
        recycler.setAdapter(adapter);
        */
    }

    ///////////////////////////////////////////////////////////////////////////////////
    // Presenter To View /////////////////////////////////////////////////////////////

    @Override

    public void settingAdapter(List<ModelData> parties) {
        adapter = new CategoryAdapter(parties);
        recycler.setAdapter(adapter);
    }

    @Override
    public void finishScreen() {
        finish();
    }


    @Override
    public void hideText() {
        title.setVisibility(View.GONE);
    }

    @Override
    public void showText() {
        title.setVisibility(View.VISIBLE);
    }

    @Override
    public void setText(String txt) {
        title.setText(txt);
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

    private List<ModelData> items;

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item

        /// public CardView cv;
        public ImageView image;
        public TextView title;
        public TextView number;

        public CategoryViewHolder(View v) {
            super(v);
            //cv = (CardView) v.findViewById(R.id.cv);
            image = (ImageView) v.findViewById(R.id.image);
            title = (TextView) v.findViewById(R.id.title);
            number = (TextView) v.findViewById(R.id.numberOfPersons);
        }
    }

    public CategoryAdapter(List<ModelData> items) {
        this.items = items;

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    //Encargado de crear los nuevos

    @Override
    public CategoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {//i es la posición.
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        View v = inflater.inflate(R.layout.category_card, viewGroup, false);

        return new CategoryViewHolder(v);
    }


    //Encargado de actualizar los datos de un ViewHolder ya existente.
    @Override
    public void onBindViewHolder(CategoryViewHolder viewHolder, int i) { //i es la posición.
        viewHolder.image.setImageResource(items.get(i).getImage());
        viewHolder.title.setText(items.get(i).getName());
        viewHolder.number.setText(items.get(i).getNumberOfParticipants());

    }

    //Necesario hacer el override de este metodo
    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

}


