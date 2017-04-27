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
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private ImageView image5;
    private ImageView image6;
    private ImageView image7;
    private ImageView image8;
    private ImageView image9;
    private ImageView image10;

    private TextView textInformation1;
    private TextView numberOfParticipants1;
    private TextView textInformation2;
    private TextView numberOfParticipants2;
    private TextView textInformation3;
    private TextView numberOfParticipants3;
    private TextView textInformation4;
    private TextView numberOfParticipants4;
    private TextView textInformation5;
    private TextView numberOfParticipants5;
    private TextView textInformation6;
    private TextView numberOfParticipants6;
    private TextView textInformation7;
    private TextView numberOfParticipants7;
    private TextView textInformation8;
    private TextView numberOfParticipants8;
    private TextView textInformation9;
    private TextView numberOfParticipants9;
    private TextView textInformation10;
    private TextView numberOfParticipants10;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        image1 = (ImageView) findViewById(R.id.imagePlace);
        textInformation1 = (TextView) findViewById(R.id.description);
        numberOfParticipants1 = (TextView) findViewById(R.id.number);




    }






}
