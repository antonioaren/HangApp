package es.ulpgc.eite.clean.mvp.sample.information;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.sample.R;

/**
 * Created by eleonora on 21/04/2017.
 */

public class PartiesByCategoriesView  extends GenericActivity<PartiesByCategories.PresenterToView, PartiesByCategories.ViewToPresenter, PartiesByCategoriesPresenter>
        implements PartiesByCategories.PresenterToView, AdapterView.OnItemClickListener {
   ListView List;
    PartiesByCategoriesPresenter presenter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partiesbycategories);
        List=(ListView)findViewById(R.id.List);
        presenter= new PartiesByCategoriesPresenter();
        String[]partiesDefault=presenter.getContentDefaultList();
        ArrayAdapter<String> adaptder = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,partiesDefault);
        List.setAdapter(adaptder);
        List.setOnItemClickListener(this);



    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
