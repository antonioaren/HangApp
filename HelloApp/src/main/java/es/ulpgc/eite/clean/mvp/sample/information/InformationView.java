package es.ulpgc.eite.clean.mvp.sample.information;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;
import es.ulpgc.eite.clean.mvp.sample.search.Search;
import es.ulpgc.eite.clean.mvp.sample.search.SearchPresenter;

/**
 * Created by alumno on 31/03/2017.
 */

public class InformationView extends GenericActivity<Information.PresenterToView, Information.ViewToPresenter, InformationPresenter>
        implements Information.PresenterToView  {
    ImageView image;
    TextView textInformation;
    TextView numberOfParticipants;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_);




    }






}
