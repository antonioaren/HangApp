package es.ulpgc.eite.clean.mvp.sample.detail;

import android.os.Bundle;
import android.widget.TextView;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;

/**
 * Created by eleonora on 19/04/2017.
 */

public class DetailView  extends GenericActivity<Detail.PresenterToView, Detail.ViewToPresenter, DetailPresenter>
        implements Detail.PresenterToView {
TextView detail;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        detail=(TextView)findViewById(R.id.detail);
    }
}