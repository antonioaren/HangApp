package es.ulpgc.eite.clean.mvp.sample.product;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;

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
}
