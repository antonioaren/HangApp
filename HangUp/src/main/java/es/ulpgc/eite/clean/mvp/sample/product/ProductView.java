package es.ulpgc.eite.clean.mvp.sample.product;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import es.ulpgc.eite.clean.mvp.sample.util.RealmRecyclerViewAdapter;
import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by alumno on 31/03/2017.
 */

public class ProductView
        extends GenericActivity<Product.PresenterToView, Product.ViewToPresenter, ProductPresenter>
        implements Product.PresenterToView {

    public RecyclerView recycler;
    private Button buttonAdd, buttonDelete;
    private LinearLayoutManager linearmanager;
    private RealmList<ProductData> items;
    private ProductAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Realm.init(this);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);
        linearmanager = new LinearLayoutManager(this);
        recycler.setLayoutManager(linearmanager);
        Realm realm = Realm.getDefaultInstance();

        recycler.setAdapter(
                new ProductView.ProductAdapter(realm.where(ProductData.class).findAll()));

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().onButtonAddClicked();
            }
        });

        buttonDelete = (Button) findViewById(R.id.buttonDelete);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().onButtonDeleteClicked();
            }
        });

        InitComponents();

    }

    @Override
    protected void onResume() {
        super.onResume(ProductPresenter.class, this);

    }

    private void InitComponents() {

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
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void setAddLabel(String msg) {
        buttonAdd.setText(msg);
    }

    @Override
    public void setDeleteLabel(String msg) {
        buttonDelete.setText(msg);
    }

    @Override
    public void settingAdapter(RealmList<ProductData> items) {
        if (recycler != null) {
            this.items = items;
            ProductView.ProductAdapter recyclerAdapter =
                    (ProductView.ProductAdapter) recycler.getAdapter();
            recyclerAdapter.setItemList(items);
        }
    }

    public class ProductAdapter extends
            RealmRecyclerViewAdapter<ProductData, ProductAdapter.ProductViewHolder> {

        private List<ProductData> items;

        public ProductAdapter(OrderedRealmCollection<ProductData> items) {
            super(items, true);
            this.items = items;
        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        @Override
        public ProductViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            View v = inflater.inflate(R.layout.card_product, viewGroup, false);
            return new ProductViewHolder(v);
        }

        @Override
        public void onBindViewHolder(final ProductViewHolder holder, int position) {
            holder.item = items.get(position);
            holder.title.setText(items.get(position).getProductName());
            holder.Place.setText(items.get(position).getPlace());
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

        public void setItemList(List<ProductData> items) {
            this.items = items;
            notifyDataSetChanged();
        }


        public class ProductViewHolder extends RecyclerView.ViewHolder {

            public final View itemView;
            Context context;
            public TextView title;
            public TextView Place;
            public ProductData item;

            public ProductViewHolder(View v) {
                super(v);
                itemView = v;
                title = (TextView) v.findViewById(R.id.title);
                Place = (TextView) v.findViewById(R.id.place);
            }
        }
    }
}
