package es.ulpgc.eite.clean.mvp.sample.information;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;
import es.ulpgc.eite.clean.mvp.sample.hangapp.HangApp;
import es.ulpgc.eite.clean.mvp.sample.hangapp.HangAppPresenter;

/**
 * Created by eleonora on 21/04/2017.
 */

public class PartiesByCategoriesView  extends GenericActivity<PartiesByCategories.PresenterToView, PartiesByCategories.ViewToPresenter, PartiesByCategoriesPresenter>
        implements PartiesByCategories.PresenterToView {
   ListView List;
    PartiesByCategoriesPresenter presenter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partiesbycategories);
        List=(ListView)findViewById(R.id.List);
        String[]parties=presenter.getContentList();
        ArrayAdapter<String> adaptder = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,parties);
        List.setAdapter(adaptder);
        List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getPresenter().onListItemClicked();
            }});


    }}
