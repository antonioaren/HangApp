package es.ulpgc.eite.clean.mvp.sample.category;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.util.RealmRecyclerViewAdapter;
import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmResults;

public class CategoryView
        extends GenericActivity<Category.PresenterToView, Category.ViewToPresenter, CategoryPresenter>
        implements Category.PresenterToView {


    //    private Button buttonSearch;


    private ImageView image;
    private FloatingActionButton fButtonAddCategory;
    private RecyclerView recycler;
    private LinearLayoutManager linearmanager;
    private RealmResults<CategoryData> items;
    private boolean isFirstTime;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Realm.init(this);

        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);

        linearmanager = new LinearLayoutManager(this);
        recycler.setLayoutManager(linearmanager);


        fButtonAddCategory = (FloatingActionButton) findViewById(R.id.fButtonAddCategory);
        fButtonAddCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().onButtonAddClicked();
            }
        });

        Realm realm = Realm.getDefaultInstance();

        recycler.setAdapter(new CategoryAdapter(realm.where(CategoryData.class).findAllAsync()));
        InitComponentSwipeAndMove();
        //CheckIfIsFirstTimeRunning();
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


    private void InitComponentSwipeAndMove() {

        recycler.setItemAnimator(new DefaultItemAnimator());

        ItemTouchHelper swipeToDismissTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                getPresenter().OnSwipedItem(items.get(viewHolder.getAdapterPosition()).getId());
            }
        });

        swipeToDismissTouchHelper.attachToRecyclerView(recycler);
        CheckIfIsFirstTimeRunning();
    }

    private void CheckIfIsFirstTimeRunning() {
        Log.d(TAG, "CheckIfIsFirstTimeRunning");


        SharedPreferences pref = getSharedPreferences("PREF", MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = pref.edit();

        //Si no está creado "FirstRunning", crear la base de datos, si está creado significa que ya
        //está creada la base de datos.
        isFirstTime = false;
        if (pref.getBoolean("FirstRunning", true)) {
            prefEditor.putBoolean("FirstRunning", true);
            prefEditor.commit();
            isFirstTime = true;
        }
    }

    @Override
    public boolean isFirstTime() {
        return isFirstTime;
    }

    ///////////////////////////////////////////////////////////////////////////////////
    // Presenter To View /////////////////////////////////////////////////////////////

    @Override
    public void settingAdapter(RealmResults<CategoryData> items) {
        if (recycler != null) {
            this.items = items;
            CategoryView.CategoryAdapter recyclerAdapter =
                    (CategoryView.CategoryAdapter) recycler.getAdapter();
            recyclerAdapter.setItemList(items);
        }
    }

    @Override
    public void finishScreen() {
        finish();
    }

    @Override
    public void setLabelSearch(String txt) {
        // buttonSearch.setText(txt);
    }


    public class CategoryAdapter extends
            RealmRecyclerViewAdapter<CategoryData, CategoryAdapter.CategoryViewHolder> {
        private List<CategoryData> items;
        // private RealmResults<CategoryData> items;

        public CategoryAdapter(OrderedRealmCollection<CategoryData> items) {
            super(items, true);
            this.items = items;
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        @Override
        public CategoryViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            View v = inflater.inflate(R.layout.card_category, viewGroup, false);
            return new CategoryViewHolder(v);
        }

        @Override
        public void onBindViewHolder(final CategoryViewHolder holder, final int position) {
            holder.item = items.get(position);
            holder.image.setImageResource(items.get(position).getImage());
            holder.title.setText(items.get(position).getCategoryName());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getPresenter().onItemClicked(holder.item, items.get(position).getId());
                }
            });
        }

        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
        }

        public void setItemList(List<CategoryData> itemList) {
            this.items = itemList;
            notifyDataSetChanged();
        }

        public class CategoryViewHolder extends RecyclerView.ViewHolder {
            public final View itemView;
            public ImageView image;
            public TextView title;
            public CategoryData item;

            public CategoryViewHolder(View v) {
                super(v);
                itemView = v;
                image = (ImageView) v.findViewById(R.id.image);
                title = (TextView) v.findViewById(R.id.title);
            }
        }
    }
}


