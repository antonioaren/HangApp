package es.ulpgc.eite.clean.mvp.sample.information;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;

/**
 * Created by Pedro Arenas on 25/4/17.
 */

public class InformationModel extends GenericModel<Information.ModelToPresenter>
        implements Information.PresenterToModel {

    private CategoryData Item;


    @Override
    public void onCreate(Information.ModelToPresenter modelToPresenter) {

    }

    @Override
    public void onDestroy(boolean b) {

    }

    @Override
    public CategoryData getItem() {
        return Item;
    }

    @Override
    public void setItem(CategoryData itemSelected) {
        Item = itemSelected;
    }
}
