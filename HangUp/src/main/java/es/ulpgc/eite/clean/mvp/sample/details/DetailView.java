package es.ulpgc.eite.clean.mvp.sample.details;

import android.os.Bundle;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;

/**
 * Created by Pedro Arenas on 31/5/17.
 */

public class DetailView
        extends GenericActivity<Detail.PresenterToView, Detail.ViewToPresenter, DetailPresenter>
        implements Detail.PresenterToView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

    }

    @Override
    protected void onResume() {
        super.onResume(DetailPresenter.class, this);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
}
