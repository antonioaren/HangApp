package es.ulpgc.eite.clean.mvp.sample.product;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import io.realm.RealmList;

/**
 * Created by alumno on 31/03/2017.
 */

public class ProductView
        extends GenericActivity<Product.PresenterToView, Product.ViewToPresenter, ProductPresenter>
        implements Product.PresenterToView {

    private TextView Detalle;
    private TextView Story;
    private TextView Date;
    private TextView Hour;
    private TextView StoryDescription, HourDescription, DateDescription;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        /*Story = (TextView) findViewById(R.id.Story);
        Date = (TextView) findViewById(R.id.Date);
        Hour = (TextView) findViewById(R.id.Hour);*/


    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onResume() {
        super.onResume(ProductPresenter.class, this);
    }

    @Override
    public void setText(String details, String storyDescription, String dateDescription, String hourDescription) {
        Detalle = (TextView) findViewById(R.id.item_details);
        Detalle.setText(details);

        StoryDescription = (TextView) findViewById(R.id.StoryDescription);
        StoryDescription.setText(storyDescription);
        DateDescription = (TextView) findViewById(R.id.DateDescription);
        DateDescription.setText(dateDescription);
        HourDescription = (TextView) findViewById(R.id.HourDescription);
        HourDescription.setText(hourDescription);

    }

    //TODO Implementar adaptador
    public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

        public RealmList<ProductData> items;

        public ProductAdapter(RealmList<ProductData> items  /*OrderedRealmCollection<ModelItem> items*/) {
            //super(items, true);

            this.items = items;


        }

        @Override
        public int getItemCount() {
            return items.size();
        }

        @Override
        public ProductViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {//i es la posición.
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            View v = inflater.inflate(R.layout.card_category, viewGroup, false);
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
