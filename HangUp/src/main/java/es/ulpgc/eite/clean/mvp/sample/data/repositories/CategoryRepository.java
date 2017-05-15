package es.ulpgc.eite.clean.mvp.sample.data.repositories;

import java.io.File;
import java.util.UUID;

import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.Repository;
import es.ulpgc.eite.clean.mvp.sample.data.module.RealmTable;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.RealmQuery;
import io.realm.RealmResults;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.SharedRealm;
import io.realm.rx.RxObservableFactory;

import static android.R.attr.id;

/**
 * Created by Pedro Arenas on 14/5/17.
 */

public class CategoryRepository extends RealmConfiguration implements Repository.CategoryRepository {

    protected CategoryRepository(File realmDirectory, String realmFileName, String canonicalPath, String assetFilePath, byte[] key, long schemaVersion, RealmMigration migration, boolean deleteRealmIfMigrationNeeded, SharedRealm.Durability durability, RealmProxyMediator schemaMediator, RxObservableFactory rxObservableFactory, Realm.Transaction initialDataTransaction) {
        super(realmDirectory, realmFileName, canonicalPath, assetFilePath, key, schemaVersion, migration, deleteRealmIfMigrationNeeded, durability, schemaMediator, rxObservableFactory, initialDataTransaction);
    }

    @Override
    public void addCategory(CategoryData category, OnAddCategoryCallback callback) {
            Realm realm = Realm.getInstance(this);
            realm.beginTransaction();
            CategoryData realmCategory = realm.createObject(CategoryData.class);
            realmCategory.setId(UUID.randomUUID().toString());
            realmCategory.setCategoryName(realmCategory.getCategoryName());
            realm.commitTransaction();

            if (callback != null)
                callback.onSuccess();

        }

    @Override
    public void deleteCategoryById(String Id, OnDeleteCategoryCallback callback) {

            Realm realm = Realm.getInstance(this);
            realm.beginTransaction();
            CategoryData category = realm.where(CategoryData.class).equalTo(RealmTable.ID, id).findFirst();
           category.deleteFromRealm();
            realm.commitTransaction();

            if (callback != null)
                callback.onSuccess();

        }

    @Override
    public void deleteCategoryByPosition(int position, OnDeleteCategoryCallback callback) {

            Realm realm = Realm.getInstance(this);
            realm.beginTransaction();
            RealmQuery<CategoryData> query = realm.where(CategoryData.class);
            RealmResults<CategoryData> results = query.findAll();
            results.deleteFromRealm(position);
            realm.commitTransaction();

            if (callback != null)
                callback.onSuccess();

        }

    @Override
    public void getAllCategories(OnGetAllCategoryCallback callback) {

            Realm realm = Realm.getInstance(this);
            RealmQuery<CategoryData> query = realm.where(CategoryData.class);
            RealmResults<CategoryData> results = query.findAll();

            if (callback != null)
                callback.onSuccess(results);
        }



    



    @Override
    public void DeleteCategoryByPosition(int position, OnDeleteCategoryCallback callback) {
        Realm realm = Realm.getInstance(this);
        realm.beginTransaction();
        RealmQuery<CategoryData> query = realm.where(CategoryData.class);
        RealmResults<CategoryData> results = query.findAll();
        results.deleteFromRealm(position);
        realm.commitTransaction();

        if (callback != null)
            callback.onSuccess();


    }

    @Override
    public void getCategoryById(String id, OnGetCategoryByIdCallback callback) {
        Realm realm = Realm.getInstance(this);
       CategoryData result = realm.where(CategoryData.class).equalTo(RealmTable.ID, id).findFirst();

        if (callback != null)
            callback.onSuccess(result);


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
