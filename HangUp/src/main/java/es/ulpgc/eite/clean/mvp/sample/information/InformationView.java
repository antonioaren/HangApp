package es.ulpgc.eite.clean.mvp.sample.information;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;

/**
 * Created by alumno on 31/03/2017.
 */

public class InformationView extends GenericActivity<Information.PresenterToView, Information.ViewToPresenter, InformationPresenter>
        implements Information.PresenterToView  {
    private ImageView image1;
    private TextView textInformation1;
    private TextView numberOfParticipants1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        image1 = (ImageView) findViewById(R.id.imagePlace);
        textInformation1 = (TextView) findViewById(R.id.description);
        numberOfParticipants1 = (TextView) findViewById(R.id.number);




    }






}
