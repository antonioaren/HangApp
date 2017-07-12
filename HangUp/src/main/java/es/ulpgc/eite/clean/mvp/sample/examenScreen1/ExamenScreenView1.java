package es.ulpgc.eite.clean.mvp.sample.examenScreen1;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;

/**
 * Created by Pedro Arenas on 31/5/17.
 */

public class ExamenScreenView1
        extends GenericActivity<ExamenScreen1.PresenterToView, ExamenScreen1.ViewToPresenter, ExamenScreenPresenter1>
        implements ExamenScreen1.PresenterToView {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen_firstclick);

    }

    @Override
    protected void onResume() {
        super.onResume(ExamenScreenPresenter1.class, this);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////


}
