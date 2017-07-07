package es.ulpgc.eite.clean.mvp.sample.product;


import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.realmoperation.RealmOperation;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import io.realm.RealmList;

/**
 * Created by Pedro Arenas on 25/4/17.
 */

public class ProductModel extends GenericModel<Product.ModelToPresenter>
        implements Product.PresenterToModel {

    private RealmOperation realmDatabase;
    private CategoryData item;
    //private static final String NOTIFY_ADDED = "Added";
    private static final String NOTIFY_DELETED = "Deleted";


    @Override
    public void onCreate(Product.ModelToPresenter presenter) {
        super.onCreate(presenter);
        realmDatabase = RealmOperation.getInstances();
    }

    @Override
    public void onDestroy(boolean b) {
    }

    //////////////////////////////////////////////////////////////////////////////////////

    @Override
    public CategoryData getItemCategorySelected() {
        return item;
    }
    @Override
    public void setItemCategorySelected(CategoryData itemSelected) {
        item = itemSelected;
    }


    @Override
    public String getNotifyDeleted() {
        return NOTIFY_DELETED;
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void addProductByCategoryId(final ProductData product, final String CategoryId) {
        realmDatabase.addProductByCategoryId(product, CategoryId);
    }
    @Override
    public void deleteItemById(final String id) {
        realmDatabase.deleteProductItemById(id);
    }
    @Override
    public RealmList<ProductData> getAllProductsByCategoryId(final String CategoryId) {
        return realmDatabase.getAllProductsByCategoryId(CategoryId);
    }

}
