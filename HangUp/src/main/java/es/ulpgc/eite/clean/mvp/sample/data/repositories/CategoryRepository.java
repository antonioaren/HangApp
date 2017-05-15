package es.ulpgc.eite.clean.mvp.sample.data.repositories;

import java.io.File;
import java.util.UUID;

import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.Repository;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.SharedRealm;
import io.realm.rx.RxObservableFactory;

/**
 * Created by Pedro Arenas on 14/5/17.
 */

public class CategoryRepository extends RealmConfiguration implements Repository.CategoryRepository {

    protected CategoryRepository(File realmDirectory, String realmFileName, String canonicalPath, String assetFilePath, byte[] key, long schemaVersion, RealmMigration migration, boolean deleteRealmIfMigrationNeeded, SharedRealm.Durability durability, RealmProxyMediator schemaMediator, RxObservableFactory rxObservableFactory, Realm.Transaction initialDataTransaction) {
        super(realmDirectory, realmFileName, canonicalPath, assetFilePath, key, schemaVersion, migration, deleteRealmIfMigrationNeeded, durability, schemaMediator, rxObservableFactory, initialDataTransaction);
    }

    @Override
    public void addCategory() {
        CategoryData category, OnAddCategoryCallback callback) {
            Realm realm = Realm.getInstance(this);
            realm.beginTransaction();
            CategoryData realmCategory = realm.createObject(CategoryData.class);
            realmCategory.setId(UUID.randomUUID().toString());
            realmCategory.setCategoryName(realmCategory.getCategoryName());
            realm.commitTransaction();

            if (callback != null)
                callback.onSuccess();

        }}

    @Override
    public void DeleteCategoryById() {

    }

    @Override
    public void DeleteCategoryByPosition() {

    }

    @Override
    public void getCategoryById() {

    }


//    @Override
//    public void getAllCategories() {
//        //Todo - Programar el mediador (.app.App), para que el getInstances funcione.
//        Realm realm = Realm.getInstance(simpleRealmApp.getInstance());
//
//        RealmQuery<CategoryData> query = realm.where(CategoryData.class);
//        RealmResults<CategoryData> results = query.findAll();
//
//        //Todo - subscribir callbacks en el presentador.
//
//        if (callback != null) {
//            callback.onSuccess(results);
//        }
//    }
}
