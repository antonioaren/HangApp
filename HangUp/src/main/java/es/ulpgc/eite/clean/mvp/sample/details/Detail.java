package es.ulpgc.eite.clean.mvp.sample.details;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;

/**
 * Created by Pedro Arenas on 31/5/17.
 */

public interface Detail {
    public interface PresenterToView extends ContextView {

    }

    public interface ViewToPresenter {
    }

    public interface PresenterToModel {
        void setItemSelected(ProductData itemSelected);

        ProductData getItemSelected();
    }

    public interface ModelToPresenter {
    }

    public interface ToDetail {
        void setItemSelected(ProductData itemSelected);

        void onScreenStarted();
    }

    public interface DetailTo {
    }
}
