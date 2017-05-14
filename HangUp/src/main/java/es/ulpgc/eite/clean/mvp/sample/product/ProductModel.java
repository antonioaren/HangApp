package es.ulpgc.eite.clean.mvp.sample.product;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;

/**
 * Created by Pedro Arenas on 25/4/17.
 */

public class ProductModel extends GenericModel<Product.ModelToPresenter>
        implements Product.PresenterToModel {

    private CategoryData Item;


    @Override
    public void onCreate(Product.ModelToPresenter modelToPresenter) {

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
