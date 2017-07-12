package es.ulpgc.eite.clean.mvp.sample.authors;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.R;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import es.ulpgc.eite.clean.mvp.sample.realmoperation.RealmOperation;
import io.realm.RealmList;
import io.realm.RealmResults;

/**
 * Created by eleonora on 12/07/2017.
 */

public class AuthorsModel extends GenericModel<Authors.ModelToPresenter>
        implements Authors.PresenterToModel {

    RealmOperation realm;

    @Override
    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    int image;

    @Override
    public String getTxt() {
        return txt;
    }

    @Override
    public RealmResults<CategoryData> getCategoryEvents() {
        return null;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    String txt;

    @Override
    public void onCreate(Authors.ModelToPresenter presenter) {
        super.onCreate(presenter);
        this.image = R.drawable.wellcome;
        this.txt = "Authors: Eleonora de ferra chermaz y pedro Antonio Arenas Lara";
        realm = RealmOperation.getInstances();
    }

    @Override
    public void onDestroy(boolean b) {
    }

    //para obtener los registros

    @Override
    public RealmList<ProductData> getProducts() {
        return realm.getAllProductsByCategoryId("Fiestas");
    }


}
