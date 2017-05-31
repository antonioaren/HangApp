package es.ulpgc.eite.clean.mvp.sample.detail;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;

/**
 * Created by eleonora on 17/04/2017.
 */

public class DetailModel extends GenericModel<Detail.ModelToPresenter> implements Detail.PresenterToModel {


    private ProductData itemSelected;

    @Override
    public void onCreate(Detail.ModelToPresenter presenter) {
        super.onCreate(presenter);
    }

    @Override
    public void onDestroy(boolean b) {
    }

    @Override
    public void setItemSelected(ProductData itemSelected) {
        this.itemSelected = itemSelected;
    }

    @Override
    public ProductData getItemSelected() {
        return itemSelected;
    }
}