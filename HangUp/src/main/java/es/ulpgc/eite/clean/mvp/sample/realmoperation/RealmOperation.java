package es.ulpgc.eite.clean.mvp.sample.realmoperation;

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

    private static RealmOperation instances;

    private Realm realmDatabase;
    private String id;

    public RealmOperation() {
        RealmConfiguration setting = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(setting);
        realmDatabase = Realm.getDefaultInstance();
    }

    //Synchronized: Por si es llamado por otros al mismo tiempo. Este encolaa las peticiones para
    //que no de errores de punteros a null, dado que se han creado dos objetos.

    public static synchronized RealmOperation getInstances() {
        if (instances == null) {
            instances = new RealmOperation();
        }
        return instances;
    }

    public void createDatabaseDefault() {
        insertEventCategory("Fiestas", "disco.jpg");
        insertEventCategory("Musica", "musica.png");
        insertEventCategory("ULPGC", "ulpgc.png");
        insertEventCategory("Astronomia", "astro.jpeg");
        insertEventCategory("Automovilismo", "cars.jpeg");
    }

    public RealmResults<CategoryData> getCategoryEvents() {
        RealmResults<CategoryData> itemsDatabase = realmDatabase.where(CategoryData.class).findAll();
        return itemsDatabase;
    }

//    public void insertEventCategoryByCategoryData(final CategoryData categoryData) {
//        this.id = UUID.randomUUID().toString();
//        realmDatabase.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                CategoryData event = realmDatabase.createObject(CategoryData.class, id);
//                event.setCategoryName(categoryData.getCategoryName());
//                event.setImage(categoryData.getImage());
//            }
//
//        });
//    }

    public void insertEventCategory(final String categoryName, final String image) {
        this.id = UUID.randomUUID().toString();
        realmDatabase.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                CategoryData event = realmDatabase.createObject(CategoryData.class, id);
                event.setCategoryName(categoryName);
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

    public void deleteAllDatabase() {
        for (CategoryData item : getCategoryEvents()) {
            deleteItemCategory(item.getId());
        }
    }

    public void addProductByCategoryId(final ProductData product, final String categoryId) {
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
                        .equalTo("id", categoryId).findFirst();

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
        return category.getItemInfo();
    }


    //Para realizar test en espresso
    public String getId() {
        return id;
    }


}
