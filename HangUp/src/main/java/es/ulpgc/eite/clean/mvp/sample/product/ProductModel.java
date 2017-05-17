package es.ulpgc.eite.clean.mvp.sample.product;

import java.util.UUID;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import es.ulpgc.eite.clean.mvp.sample.data.module.RealmTable;
import io.realm.Realm;

/**
 * Created by Pedro Arenas on 25/4/17.
 */

public class ProductModel extends GenericModel<Product.ModelToPresenter>
        implements Product.PresenterToModel {

    private Realm realmDatabase;
    private ProductData Item;


    @Override
    public void onCreate(Product.ModelToPresenter modelToPresenter) {

    }

    @Override
    public void onDestroy(boolean b) {

    }

    @Override
    public ProductData getItem() {
        return Item;
    }

    @Override
    public void AddProductByCategoryId(ProductData product, final String CategoryId) {
        realmDatabase = Realm.getDefaultInstance();
        realmDatabase.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                ProductData RealmData = realm.createObject(ProductData.class, UUID.randomUUID().toString());

                RealmData.setProductName("");
                RealmData.setImage(0);
                RealmData.setDate("");
                RealmData.setHour("");
                RealmData.setParticipants("");
                RealmData.setDetailText("");

                CategoryData category = realmDatabase.where(CategoryData.class).
                        equalTo(RealmTable.ID, CategoryId).findFirst();

                category.getItemInfo().add(RealmData);
            }
        });
    }

    @Override
    public void setItem(CategoryData itemSelected) {

    }

    @Override
    public void setItem(ProductData itemSelected) {
        Item = itemSelected;
    }
}
