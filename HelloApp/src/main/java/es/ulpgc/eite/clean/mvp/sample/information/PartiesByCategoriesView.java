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
        implements PartiesByCategories.PresenterToView {
   ListView List;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partiesbycategories);
        List=(ListView)findViewById(R.id.List);


        onResume();
        List.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getPresenter().onListCategoryItemClicked();
            }});



    }



       @Override
       public void onResume(){
       super.onResume(PartiesByCategoriesPresenter.class, this);
       String[]partiesDefault=getPresenter().getContentDefaultList();
       ArrayAdapter<String> adaptder = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,partiesDefault);
       List.setAdapter(adaptder);
   }

    @Override
    public void setLabel(String titleLabel) {

    }

    @Override
    public void setText(String titleLabel) {

    }
}
