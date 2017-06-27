package es.ulpgc.eite.clean.mvp.sample.realmoperation;

import android.util.Log;

import java.util.UUID;

import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by Pedro Arenas on 27/6/17.
 */

public class RealmOperation {

    private static RealmOperation Instances;
    private Realm realmDatabase;
    private RealmResults<CategoryData> itemsDatabase;


    private RealmOperation() {
        RealmConfiguration setting = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(setting);
        realmDatabase = Realm.getDefaultInstance();
    }

    //Synchronized: Por si es llamado por otros al mismo tiempo. Este encolaa las peticiones para
    //que no de errores de punteros a null, dado que se han creado dos objetos.
    public static synchronized RealmOperation getInstances() {
        if (Instances == null) {
            Instances = new RealmOperation();
        }
        return Instances;
    }

    public RealmResults<CategoryData> getCategoryEvents() {
        itemsDatabase = realmDatabase.where(CategoryData.class).findAll();
        return itemsDatabase;
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
