package es.ulpgc.eite.clean.mvp.sample.realmoperation;

import java.util.UUID;

import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;

/**
 * Created by Pedro Arenas on 27/6/17.
 */

public class Singleton {

    private static Singleton Instances;
    private Realm realmDatabase;

    public Singleton() {
        RealmConfiguration setting = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(setting);
        realmDatabase = Realm.getDefaultInstance();

    }

    public static Singleton getInstances() {
        if (Instances == null) {
            Instances = new Singleton();
        }
        return Instances;
    }

    public void insertEventCategory(final String Categoryname, final String image) {
        realmDatabase.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                CategoryData event = realmDatabase.createObject(CategoryData.class, UUID.randomUUID().toString());

                event.setCategoryName(Categoryname);
                event.setImage(image);
            }

        });
    }

    public void deleteItemCategory(final String id) {
        realmDatabase.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                CategoryData category = realm.where(CategoryData.class).equalTo("id", id).findFirst();
                category.deleteFromRealm();
            }
        });
    }

    public void AddProductByCategoryId(final ProductData product, final String CategoryId) {
        realmDatabase.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                ProductData event = realmDatabase.createObject(ProductData.class, UUID.randomUUID().toString());
                event.setImage(product.getImage());
                event.setProductName(product.getProductName());
                event.setPlace(product.getPlace());
                event.setDate(product.getDate());
                event.setTimeI(product.getTimeI());
                event.setTimeF(product.getTimeF());
                event.setDetailText(product.getDetailText());
                event.setImage(product.getImage());

                CategoryData category = realm.where(CategoryData.class)
                        .equalTo("id", CategoryId).findFirst();

                category.getItemInfo().add(event);
            }
        });
    }

    public void deleteProductItemById(final String id) {
        realmDatabase.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                ProductData product = realm.where(ProductData.class).equalTo("id", id).findFirst();
                product.deleteFromRealm();
            }
        });

    }

    public RealmList<ProductData> getAllProductsByCategoryId(final String CategoryId) {
        realmDatabase = Realm.getDefaultInstance();
        CategoryData category = realmDatabase.where(CategoryData.class).
                equalTo("id", CategoryId).findFirst();
        RealmList<ProductData> products = category.getItemInfo();
        return products;
    }


}
