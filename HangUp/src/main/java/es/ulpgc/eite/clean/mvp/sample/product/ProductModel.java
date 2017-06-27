package es.ulpgc.eite.clean.mvp.sample.product;


import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.realmoperation.Singleton;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by Pedro Arenas on 25/4/17.
 */

public class ProductModel extends GenericModel<Product.ModelToPresenter>
        implements Product.PresenterToModel {

    private Singleton realmdatabase;
    private CategoryData Item;

    private String itemId;

    private RealmResults<ProductData> itemsDatabase;

    @Override
    public void onCreate(Product.ModelToPresenter modelToPresenter) {
        realmdatabase = Singleton.getInstances();
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

    @Override
    public String getItemId() {
        return itemId;
    }

    @Override
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Override
    public void setProductFromAddAndInsert(ProductData productToAdd) {
        AddProductByCategoryId(productToAdd, itemId);
    }

    @Override
    public void AddProductByCategoryId(final ProductData product, final String CategoryId) {
        realmdatabase.AddProductByCategoryId(product, CategoryId);
    }

    @Override
    public RealmList<ProductData> getAllProductsByCategoryId(final String CategoryId) {
        return realmdatabase.getAllProductsByCategoryId(CategoryId);
//        realmDatabase = Realm.getDefaultInstance();
//        CategoryData category = realmDatabase.where(CategoryData.class).
//                equalTo("id", CategoryId).findFirst();
//        RealmList<ProductData> products = category.getItemInfo();
    }

    @Override
    public void deleteItemById(final String id) {
        realmdatabase.deleteProductItemById(id);
//        realmDatabase.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                ProductData product = realm.where(ProductData.class).equalTo("id", id).findFirst();
//                product.deleteFromRealm();
//            }
//        });
    }

    @Override
    public String getAddLabel() {
        return null;
    }


}
