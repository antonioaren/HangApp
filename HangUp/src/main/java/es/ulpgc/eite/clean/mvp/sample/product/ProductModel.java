package es.ulpgc.eite.clean.mvp.sample.product;


import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.realmoperation.RealmOperation;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by Pedro Arenas on 25/4/17.
 */

public class ProductModel extends GenericModel<Product.ModelToPresenter>
        implements Product.PresenterToModel {

    private RealmOperation realmdatabase;
    private CategoryData Item;
    private String NotifyAdded;
    private String NotifyDeleted;


    @Override
    public void onCreate(Product.ModelToPresenter modelToPresenter) {
        realmdatabase = RealmOperation.getInstances();
        NotifyAdded = "Added";
        NotifyDeleted = "Deleted";
    }

    @Override
    public void onDestroy(boolean b) {
    }

    //////////////////////////////////////////////////////////////////////////////////////

    @Override
    public CategoryData getItemCategorySelected() {
        return Item;
    }
    @Override
    public void setItemCategorySelected(CategoryData itemSelected) {
        Item = itemSelected;
    }

    @Override
    public String getNotifyAdded() {
        return NotifyAdded;
    }
    @Override
    public String getNotifyDeleted() {
        return NotifyDeleted;
    }

    ////////////////////////////////////////////////////////////////////////////////////////
    @Override
    public void AddProductByCategoryId(final ProductData product, final String CategoryId) {
        realmdatabase.AddProductByCategoryId(product, CategoryId);
    }
    @Override
    public void deleteItemById(final String id) {
        realmdatabase.deleteProductItemById(id);
    }
    @Override
    public RealmList<ProductData> getAllProductsByCategoryId(final String CategoryId) {
        return realmdatabase.getAllProductsByCategoryId(CategoryId);
    }

}
