package es.ulpgc.eite.clean.mvp.sample.product;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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
    private FloatingActionButton FButtonAdd;
    private LinearLayoutManager linearmanager;
    private RealmList<ProductData> items;
    private TextView TitleHeader;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        TitleHeader = (TextView) findViewById(R.id.TitleCategory);
        recycler = (RecyclerView) findViewById(R.id.recycler);
        recycler.setHasFixedSize(true);
        linearmanager = new LinearLayoutManager(this);
        recycler.setLayoutManager(linearmanager);

        Realm realm = Realm.getDefaultInstance();

        recycler.setAdapter(
                new ProductView.ProductAdapter(realm.where(ProductData.class).findAll()));

        FButtonAdd = (FloatingActionButton) findViewById(R.id.fButtonAddProduct);
        FButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().onButtonAddClicked();
            }
        });

        InitComponentSwipeAndMove();
    }
    @Override
    protected void onResume() {
        super.onResume(ProductPresenter.class, this);

    }


    ////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void setTitleHeader(String txt) {
        TitleHeader.setText(txt);
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

    @Override
    public void setToast(String txt) {
        Toast.makeText(this, txt, Toast.LENGTH_SHORT).show();
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
    }

    private class ProductAdapter extends
            RealmRecyclerViewAdapter<ProductData, ProductAdapter.ProductViewHolder> {

        private List<ProductData> items;
        private Integer count = 0;

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
            holder.imageCard.setImageURI(UriloadImageFromStorage(items.get(position).getImage()));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getPresenter().onItemClicked(holder.item);
                }
            });
        }

        private Bitmap loadImageFromStorage(String path) {
            Bitmap b = null;
            try {
                b = BitmapFactory.decodeStream(new FileInputStream(new File(path, "profile.jpg")));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return b;
        }


        private Uri UriloadImageFromStorage(String path) {
            Uri ImagenContent = Uri.parse(path);
            return ImagenContent;
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
            public TextView title;
            public TextView Place;
            ImageView imageCard;
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
