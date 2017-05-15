package es.ulpgc.eite.clean.mvp.sample.data.repositories;

import java.io.File;
import java.util.UUID;

import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import es.ulpgc.eite.clean.mvp.sample.data.Repository;
import es.ulpgc.eite.clean.mvp.sample.data.module.RealmTable;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.SharedRealm;
import io.realm.rx.RxObservableFactory;

import static android.R.attr.id;

/**
 * Created by Pedro Arenas on 14/5/17.
 */

public class ProductRepository extends RealmConfiguration implements Repository.ProductRepository  {


    protected ProductRepository(File realmDirectory, String realmFileName, String canonicalPath, String assetFilePath, byte[] key, long schemaVersion, RealmMigration migration, boolean deleteRealmIfMigrationNeeded, SharedRealm.Durability durability, RealmProxyMediator schemaMediator, RxObservableFactory rxObservableFactory, Realm.Transaction initialDataTransaction) {
        super(realmDirectory, realmFileName, canonicalPath, assetFilePath, key, schemaVersion, migration, deleteRealmIfMigrationNeeded, durability, schemaMediator, rxObservableFactory, initialDataTransaction);
    }

    @Override
    public void addProduct(OnSaveProductCallback callback, ProductData product) {
    Realm realm = Realm.getInstance(this);
      realm.beginTransaction();
      ProductData realmProduct = realm.createObject(ProductData.class);
       realmProduct.setId(UUID.randomUUID().toString());
     realmProduct.setProductName(realmProduct.getProductName());
       realmProduct.setParticipants(realmProduct.getParticipants());
     realmProduct.setDetailText(realmProduct.getDetailText());
    realm.commitTransaction();
////en proceso....
 if (callback != null)
        callback.onSuccess();
    }


    public void deleteStudentById() {
//        Realm realm = Realm.getInstance(SimpleRealmApp.getInstance());
//        realm.beginTransaction();
//        Student result = realm.where(Student.class).equalTo(RealmTable.ID, id).findFirst();
//        result.removeFromRealm();
//        realm.commitTransaction();
//
//        if (callback != null)
//            callback.onSuccess();
    }

    public void deleteStudentByPosition() {
//        Realm realm = Realm.getInstance(SimpleRealmApp.getInstance());
//        realm.beginTransaction();
//        RealmQuery<Student> query = realm.where(Student.class);
//        RealmResults<Student> results = query.findAll();
//        results.remove(position);
//        realm.commitTransaction();
//
//        if (callback != null)
//            callback.onSuccess();
    }

    public void getAllStudents() {
//        Realm realm = Realm.getInstance(SimpleRealmApp.getInstance());
//        RealmResults<Student> results = realm.where(Student.class).findAll();
//
//        if (callback != null)
//            callback.onSuccess(results);
    }

    public void getAllStudentsByUniversityId() {
//        Realm realm = Realm.getInstance(SimpleRealmApp.getInstance());
//        University university = realm.where(University.class).equalTo(RealmTable.ID, id).findFirst();
//        RealmList<Student> students = university.getStudents();
//
//        if (callback != null)
//            callback.onSuccess(students);

    }

    public void getStudentById() {
//        Realm realm = Realm.getInstance(SimpleRealmApp.getInstance());
//        Student student = realm.where(Student.class).equalTo(RealmTable.ID, id).findFirst();
//
//        if (callback != null)
//            callback.onSuccess(student);
    }



    @Override
    public void addProductByCategoryId(ProductData product, String categoryId, OnSaveProductCallback callback) {
               Realm realm = Realm.getInstance(this);
              realm.beginTransaction();
//
       ProductData realmProduct = realm.createObject(ProductData.class);
       realmProduct.setId(UUID.randomUUID().toString());
       realmProduct.setProductName(realmProduct.getProductName());
       realmProduct.setParticipants(realmProduct.getParticipants());
       realmProduct.setDetailText(realmProduct.getDetailText());
        realmProduct.setDay(realmProduct.getDay());
        realmProduct.setHour(realmProduct.getHour());

         CategoryData category = realm.where(CategoryData.class)
        .equalTo(RealmTable.ID, id).findFirst();
         category.getItemInfo().add(realmProduct);

         realm.commitTransaction();

         if (callback != null)
          callback.onSuccess();
      }

    @Override
    public void deleteProductById(String id, OnDeleteProductCallback callback) {

    }

    @Override
    public void deleteProductByPosition(int position, OnDeleteProductCallback callback) {

    }

    @Override
    public void getAllProducts(OnGetAllProductsCallback callback) {

    }

    @Override
    public void getAllProductsByCategoryId(String id, OnGetProductsCallback callback) {

    }

    @Override
    public void getProductsById(String id, OnGetProductByIdCallback callback) {

    }
}
