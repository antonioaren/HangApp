package es.ulpgc.eite.clean.mvp.sample.data.module;

import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import io.realm.annotations.RealmModule;

/**
 * Created by Pedro Arenas on 14/5/17.
 */

@RealmModule(classes = {ProductData.class, CategoryData.class})
public class ModuleRealm {
}
