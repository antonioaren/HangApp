package es.ulpgc.eite.clean.mvp.sample.authors;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import io.realm.RealmList;

/**
 * Created by eleonora on 12/07/2017.
 */

public interface Authors {
    public void onCreate();

    public interface PresenterToView extends ContextView {
        void setText(String txt);

        void setImage(int res);
    }

    public interface ViewToPresenter {
    }

    public interface ModelToPresenter {
    }

    public interface PresenterToModel {
        int getImage();

        String getTxt();


        RealmList<ProductData> getProducts();
    }

    public interface ToAuthors {
        void onScreenStarted();
    }

    public interface AuthorsTo {
        void onScreenStarted();
    }
}
