package es.ulpgc.eite.clean.mvp.sample.category;

import android.annotation.SuppressLint;
import android.content.Context;
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
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import io.realm.Realm;
import io.realm.RealmList;

public class CategoryView
        extends GenericActivity<Category.PresenterToView, Category.ViewToPresenter, CategoryPresenter>
        implements Category.PresenterToView {

    private Button buttonSearch;
    private Button buttonAdd;
    private TextView title;

    private ImageView image;
    private RecyclerView recycler;
    private LinearLayoutManager linearmanager;
    private CategoryAdapter adapter;
    private RecyclerView.LayoutManager lManager;
    private List<CategoryData> items;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hangapp);

        title = (TextView) findViewById(R.id.title);
        image = (ImageView) findViewById(R.id.image);

        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);
        //Realm realm= Realm.getDefaultInstance();
        //recycler.setAdapter(new CategoryAdapter(realm.where(CategoryData.class).findAllAsync()));






        linearmanager = new LinearLayoutManager(this);
        recycler.setLayoutManager(linearmanager);


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
        super.onResume(CategoryPresenter.class, this);

    }

    ///////////////////////////////////////////////////////////////////////////////////
    // Presenter To View /////////////////////////////////////////////////////////////

    //metodos para captar el adaptador y la lista de elementos
    public CategoryAdapter getAdapter() {
        return this.adapter;
    }

    public List<CategoryData> getList() {
        return this.items;
    }
    @Override
    public void settingAdapter(RealmList<CategoryData> parties) {
        adapter = new CategoryAdapter(parties);
        recycler.setAdapter(adapter);


       /* if(recycler != null) {
            CategoryAdapter recyclerAdapter =
                    (CategoryAdapter) recycler.getAdapter();
            recyclerAdapter.setItemList(items);*/
    }

    @Override
    public void finishScreen() {
        finish();
    }


    @Override
    public void hideText() {
       
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


    public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {

        public RealmList<CategoryData> items;

        public CategoryAdapter(RealmList<CategoryData> items  /*OrderedRealmCollection<ModelItem> items*/) {
            //super(items, true);

            this.items = items;


        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        @Override
        public CategoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {//i es la posición.
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            View v = inflater.inflate(R.layout.category_card, viewGroup, false);
            return new CategoryViewHolder(v);
        }

        @Override
        public void onBindViewHolder(final CategoryViewHolder holder, int position) {
            holder.item = items.get(position);
            holder.image.setImageResource(items.get(position).getImage());
            holder.title.setText(items.get(position).getCategoryName());
            holder.number.setText(items.get(position).getProductsAvalables());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getPresenter().onItemClicked(holder.item);
                }
            });
        }

        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
        }

       /* public void setItemList(List<CategoryData> items) {
            this.items = items;
            notifyDataSetChanged();

        }*/

        public class CategoryViewHolder extends RecyclerView.ViewHolder {
            public final View itemView;
            Context context;
            public ImageView image;
            public TextView title;
            public TextView number;
            public CategoryData item;

            public CategoryViewHolder(View v) {
                super(v);
                itemView = v;

                image = (ImageView) v.findViewById(R.id.image);
                title = (TextView) v.findViewById(R.id.title);
                number = (TextView) v.findViewById(R.id.numberOfPersons);
            }
        }
    }
}


