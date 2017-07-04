package es.ulpgc.eite.clean.mvp.sample.details;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;

/**
 * Created by Pedro Arenas on 31/5/17.
 */

public class DetailView
        extends GenericActivity<Detail.PresenterToView, Detail.ViewToPresenter, DetailPresenter>
        implements Detail.PresenterToView {

    private TextView eventName, detail, place, date, timeInit, timeEnd;


    private TextView headerPlace;
    private TextView headerDate;
    private TextView headerTimeInit;
    private TextView headerTimeEnd;
    private ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        headerPlace = (TextView) findViewById(R.id.headerPlace);
        headerDate = (TextView) findViewById(R.id.headerDate);
        headerTimeInit = (TextView) findViewById(R.id.headerTimeInit);
        headerTimeEnd = (TextView) findViewById(R.id.headerTimeEnd);

        eventName = (TextView) findViewById(R.id.EventName);
        detail = (TextView) findViewById(R.id.detail);

        place = (TextView) findViewById(R.id.place);
        date = (TextView) findViewById(R.id.date);
        timeInit = (TextView) findViewById(R.id.timeInit);
        timeEnd = (TextView) findViewById(R.id.timeEnd);

        image = (ImageView) findViewById(R.id.detailimageview);
    }

    @Override
    protected void onResume() {
        super.onResume(DetailPresenter.class, this);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void setHeaderPlace(String txt) {
        headerPlace.setText(txt);
    }

    @Override
    public void setHeaderDate(String txt) {
        headerDate.setText(txt);
    }

    @Override
    public void setHeaderTimeInit(String txt) {
        headerTimeInit.setText(txt);
    }

    @Override
    public void setHeaderTimeEnd(String txt) {
        headerTimeEnd.setText(txt);
    }

    @Override
    public void setEventName(String txt) {
        eventName.setText(txt);
    }

    @Override
    public void setDetail(String txt) {
        detail.setText(txt);
    }

    @Override
    public void setPlace(String txt) {
        place.setText(txt);
    }

    @Override
    public void setDate(String txt) {
        date.setText(txt);
    }

    @Override
    public void setTimeInit(String txt) {
        timeInit.setText(txt);
    }

    @Override
    public void setTimeEnd(String txt) {
        timeEnd.setText(txt);
    }

    @Override
    public void setImage(Uri img) {
        image.setImageURI(img);
    }
}
