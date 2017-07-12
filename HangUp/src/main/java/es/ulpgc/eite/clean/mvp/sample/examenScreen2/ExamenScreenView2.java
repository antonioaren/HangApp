package es.ulpgc.eite.clean.mvp.sample.examenScreen2;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;

/**
 * Created by Pedro Arenas on 31/5/17.
 */

public class ExamenScreenView2
        extends GenericActivity<ExamenScreen2.PresenterToView, ExamenScreen2.ViewToPresenter, ExamenScreenPresenter2>
        implements ExamenScreen2.PresenterToView {

    private TextView numberRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_examen_nextclick);

        numberRegister = (TextView) findViewById(R.id.numberRegistersDB);

    }

    @Override
    protected void onResume() {
        super.onResume(ExamenScreenPresenter2.class, this);
    }

    @Override
    public void setSizeDbOnScreen(String txt) {
        numberRegister.setText(txt);
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////

}
