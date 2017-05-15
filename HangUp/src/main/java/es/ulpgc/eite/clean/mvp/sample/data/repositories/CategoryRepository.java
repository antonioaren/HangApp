package es.ulpgc.eite.clean.mvp.sample.data.repositories;

import es.ulpgc.eite.clean.mvp.sample.data.Repository;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

/**
 * Created by Pedro Arenas on 14/5/17.
 */

public class CategoryRepository implements Repository.CategoryRepository {

    @Override
    public void addCategory() {

    }

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
