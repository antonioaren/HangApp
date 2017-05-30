package es.ulpgc.eite.clean.mvp.sample.product;

import java.util.UUID;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

/**
 * Created by Pedro Arenas on 25/4/17.
 */

public class ProductModel extends GenericModel<Product.ModelToPresenter>
        implements Product.PresenterToModel {
    private Realm realmDatabase;
    private CategoryData Item;
    private String addlabel;

    private String itemId;


    private String deleteLabel;
    private RealmResults<ProductData> itemsDatabase;

    @Override
    public void onCreate(Product.ModelToPresenter modelToPresenter) {
        addlabel = "Add";
        deleteLabel = "delete";
        RealmConfiguration setting = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(setting);
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
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    @Override
    public void setProductToAddFromAddAndInsert(ProductData productToAdd) {
        AddProductByCategoryId(productToAdd, getItemId());
    }

    @Override
    public String getItemId() {
        return itemId;
    }

    @Override
    public void AddProductByCategoryId(final ProductData product, final String CategoryId) {
        realmDatabase = Realm.getDefaultInstance();
        realmDatabase.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                ProductData event = realmDatabase.createObject(ProductData.class,
                        UUID.randomUUID().toString());
                event.setProductName(product.getProductName());
                event.setPlace(product.getPlace());
                event.setDate(product.getPlace());
                event.setTimeI(product.getTimeI());
                event.setTimeF(product.getTimeF());
                //event.setDetailText(product.getDetailText());

                CategoryData category = realm.where(CategoryData.class)
                        .equalTo(itemId, CategoryId).findFirst();
                category.getItemInfo().add(event);
            }
        });
    }


    @Override
    public void CreateDatabaseTables() {
        //insertProduct(R.drawable.disco, "verbena", "1000","");
        //insertProduct(R.drawable.astro, "concierto", "30000000","");
    }

    @Override
    public void setItemsFromDatabase() {
        itemsDatabase = realmDatabase.where(ProductData.class).findAll();
    }


    @Override
    public String getAddLabel() {
        return addlabel;
    }

    @Override
    public String getDeleteLabel() {
        return deleteLabel;
    }


}
