package es.ulpgc.eite.clean.mvp.sample.detail;

import android.os.Bundle;
import android.widget.TextView;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;


/**
 * Created by eleonora on 23/03/2017.
 */

public class DetailView extends GenericActivity<Detail.PresenterToView, Detail.ViewToPresenter, DetailPresenter>
        implements Detail.PresenterToView {

    private TextView title;
    private TextView introduction;
    private TextView content_introduction;
    private TextView date;
    private TextView content_date;
    private TextView hour;
    private TextView content_hour;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        title = (TextView) findViewById(R.id.title);
        introduction = (TextView) findViewById(R.id.DetailInfo);
        date = (TextView) findViewById(R.id.Content_date);
        hour = (TextView) findViewById(R.id.content_hour);
        content_hour = (TextView) findViewById(R.id.content_hour);
    }

    @Override
    public void finishScreen() {
        finish();
    }

    @Override
    public void setTitleLabel(String txt) {
        title.setText(txt);
    }

    @Override
    public void setIntroductionLabel(String txt) {
        introduction.setText(txt);
    }

    @Override
    public void setDateLabel(String txt) {
        date.setText(txt);
    }

    @Override
    public void setHourLabel(String txt) {
        hour.setText(txt);
    }
}