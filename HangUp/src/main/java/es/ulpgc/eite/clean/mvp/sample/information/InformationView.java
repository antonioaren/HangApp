package es.ulpgc.eite.clean.mvp.sample.information;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;

/**
 * Created by alumno on 31/03/2017.
 */

public class InformationView
        extends GenericActivity<Information.PresenterToView, Information.ViewToPresenter, InformationPresenter>
        implements Information.PresenterToView {

    private TextView Detalle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);
    }

    @SuppressLint("MissingSuperCall")
    @Override
    protected void onResume() {
        super.onResume(InformationPresenter.class, this);
    }

    @Override
    public void setText(String details) {
        Detalle = (TextView) findViewById(R.id.item_details);
        Detalle.setText(details);
    }
}
