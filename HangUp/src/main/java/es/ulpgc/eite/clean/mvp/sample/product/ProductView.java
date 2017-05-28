package es.ulpgc.eite.clean.mvp.sample.product;

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
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import io.realm.OrderedRealmCollection;
import io.realm.Realm;
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
    private RealmResults<ProductData> items;

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
                new ProductView.ProductAdapter(realm.where(ProductData.class).findAllAsync()));

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

    }

    @Override
    protected void onResume() {
        super.onResume(ProductPresenter.class, this);
    }

    @Override
    public void setAddLabel(String msg) {
        buttonAdd.setText(msg);
    }

    @Override
    public void setDeleteLabel(String msg) {
        buttonDelete.setText(msg);
    }

    @Override
    public void settingAdapter(List<ProductData> items) {
        if (recycler != null) {
            ProductView.ProductAdapter recyclerAdapter =
                    (ProductView.ProductAdapter) recycler.getAdapter();
            recyclerAdapter.setItemList(items);
        }

    }


    public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

        private List<ProductData> items;

        public ProductAdapter(OrderedRealmCollection<ProductData> items) {

            //  super(items,true);
            this.items = items;


        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        @Override
        public ProductViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {//i es la posición.
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            View v = inflater.inflate(R.layout.card_product, viewGroup, false);
            return new ProductViewHolder(v);
        }

        @Override
        public void onBindViewHolder(final ProductViewHolder holder, int position) {

            holder.item = items.get(position);
            holder.image.setImageResource(items.get(position).getImage());
            holder.title.setText(items.get(position).getProductName());
            holder.number.setText(items.get(position).getParticipants());
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
        }


        public class ProductViewHolder extends RecyclerView.ViewHolder {
            public final View itemView;
            Context context;
            public ImageView image;
            public TextView title;
            public TextView number;
            public ProductData item;

            public ProductViewHolder(View v) {
                super(v);
                itemView = v;
                image = (ImageView) v.findViewById(R.id.image);
                title = (TextView) v.findViewById(R.id.title);
                number = (TextView) v.findViewById(R.id.numberOfPersons);
            }
        }
    }

}
