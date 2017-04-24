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
        setContentView(R.layout.activity_procesed_search);
         image1=(ImageView)findViewById(R.id.Lugar);
        textInformation1=(TextView)findViewById(R.id.textView1);
        numberOfParticipants1=(TextView)findViewById(R.id.textView1_1);

        image2=(ImageView)findViewById(R.id.Lugar2);
        textInformation2=(TextView)findViewById(R.id.textView2);
        numberOfParticipants2=(TextView)findViewById(R.id.textView2_1);

        image3=(ImageView)findViewById(R.id.Lugar3);
        textInformation3=(TextView)findViewById(R.id.textView3);
        numberOfParticipants3=(TextView)findViewById(R.id.textView3_1);

        image4=(ImageView)findViewById(R.id.Lugar4);
        textInformation4=(TextView)findViewById(R.id.textView4);
        numberOfParticipants4=(TextView)findViewById(R.id.textView4_1);

        image5=(ImageView)findViewById(R.id.Lugar5);
        textInformation5=(TextView)findViewById(R.id.textView5);
        numberOfParticipants5=(TextView)findViewById(R.id.textView5_1);

        image6=(ImageView)findViewById(R.id.Lugar6);
        textInformation6=(TextView)findViewById(R.id.textView6);
        numberOfParticipants6=(TextView)findViewById(R.id.textView6_1);

        image7=(ImageView)findViewById(R.id.Lugar7);
        textInformation7=(TextView)findViewById(R.id.textView7);
        numberOfParticipants7=(TextView)findViewById(R.id.textView7_1);

        image8=(ImageView)findViewById(R.id.Lugar8);
        textInformation8=(TextView)findViewById(R.id.textView8);
        numberOfParticipants8=(TextView)findViewById(R.id.textView8_1);

        image9=(ImageView)findViewById(R.id.Lugar9);
        textInformation9=(TextView)findViewById(R.id.textView9);
        numberOfParticipants9=(TextView)findViewById(R.id.textView9_1);

        image10=(ImageView)findViewById(R.id.Lugar10);
        textInformation10=(TextView)findViewById(R.id.textView10);
        numberOfParticipants1=(TextView)findViewById(R.id.textView10_1);



    }






}
