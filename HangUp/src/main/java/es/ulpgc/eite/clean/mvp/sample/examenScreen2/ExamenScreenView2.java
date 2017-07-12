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

//    private TextView eventName, detail, place, date, timeInit, timeEnd;


    private TextView numberRegister;

//    private TextView headerDate;
//    private TextView headerTimeInit;
//    private TextView headerTimeEnd;
//    private ImageView image;


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

//    @Override
//    public void setHeaderPlace(String txt) {
//        headerPlace.setText(txt);
//    }
//
//    @Override
//    public void setHeaderDate(String txt) {
//        headerDate.setText(txt);
//    }
//
//    @Override
//    public void setHeaderTimeInit(String txt) {
//        headerTimeInit.setText(txt);
//    }
//
//    @Override
//    public void setHeaderTimeEnd(String txt) {
//        headerTimeEnd.setText(txt);
//    }
//
//    @Override
//    public void setEventName(String txt) {
//        eventName.setText(txt);
//    }
//
//    @Override
//    public void setDetail(String txt) {
//        detail.setText(txt);
//    }
//
//    @Override
//    public void setPlace(String txt) {
//        place.setText(txt);
//    }
//
//    @Override
//    public void setDate(String txt) {
//        date.setText(txt);
//    }
//
//    @Override
//    public void setTimeInit(String txt) {
//        timeInit.setText(txt);
//    }
//
//    @Override
//    public void setTimeEnd(String txt) {
//        timeEnd.setText(txt);
//    }
//
//    @Override
//    public void setImage(Uri img) {
//        image.setImageURI(img);
//    }
}
