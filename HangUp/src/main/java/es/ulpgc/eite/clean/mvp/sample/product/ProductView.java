package es.ulpgc.eite.clean.mvp.sample.product;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import es.ulpgc.eite.clean.mvp.sample.util.RealmRecyclerViewAdapter;
import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmList;

/**
 * Created by alumno on 31/03/2017.
 */

public class ProductView
        extends GenericActivity<Product.PresenterToView, Product.ViewToPresenter, ProductPresenter>
        implements Product.PresenterToView {

    private RecyclerView recycler;
    private TextView titleHeader;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        titleHeader = (TextView) findViewById(R.id.TitleCategory);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(layoutManager);

//      // Realm realm = Realm.getDefaultInstance();
        //RealmOperation realmOperation = RealmOperation.getInstances();
        //recycler.setAdapter(new ProductAdapter(realmOperation.getAllProductsByCategoryId()));

        Realm realm = Realm.getDefaultInstance();
        recycler.setAdapter(new ProductAdapter(
                realm.where(ProductData.class).findAll()));

        FloatingActionButton fButtonAdd = (FloatingActionButton) findViewById(R.id.fButtonAddProduct);
        fButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().onButtonAddClicked();
            }
        });

        initComponentSwipeAndMove();
    }
    @Override
    protected void onResume() {
        super.onResume(ProductPresenter.class, this);

    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void setTitleHeader(String txt) {
        titleHeader.setText(txt);
    }

    @Override
    public void settingAdapter(RealmList<ProductData> items) {
        if (recycler != null) {



            ProductView.ProductAdapter recyclerAdapter =
                    (ProductView.ProductAdapter) recycler.getAdapter();

            recyclerAdapter.setItemList(items);
        }
    }

    @Override
    public void setToast(String txt) {
        Toast.makeText(this, txt, Toast.LENGTH_SHORT).show();
    }

    private void initComponentSwipeAndMove() {

        recycler.setItemAnimator(new DefaultItemAnimator());

        ItemTouchHelper swipeToDismissTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                getPresenter().OnSwipedItem(getPresenter().getProductList().
                        get(viewHolder.getAdapterPosition()).getId());
            }
        });
        swipeToDismissTouchHelper.attachToRecyclerView(recycler);
    }

    private class ProductAdapter extends
            RealmRecyclerViewAdapter<ProductData, ProductAdapter.ProductViewHolder> {

        private List<ProductData> items;


        public ProductAdapter(OrderedRealmCollection<ProductData> items) {
            super(items);
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
            holder.imageCard.setImageURI(uriloadImageFromStorage(items.get(position).getImage()));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getPresenter().onItemClicked(holder.item);
                }
            });
        }



        private Uri uriloadImageFromStorage(String path) {
            return Uri.parse(path);
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
            public final TextView title;
            public final TextView Place;
            final ImageView imageCard;
            public ProductData item;

            public ProductViewHolder(View v) {
                super(v);
                itemView = v;
                title = (TextView) v.findViewById(R.id.title);
                Place = (TextView) v.findViewById(R.id.place);
                imageCard = (ImageView) v.findViewById(R.id.imageProductCard);

            }
        }
    }
}
