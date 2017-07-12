package es.ulpgc.eite.clean.mvp.sample.examenScreen1;

import es.ulpgc.eite.clean.mvp.ContextView;

/**
 * Created by Pedro Arenas on 31/5/17.
 */

public interface ExamenScreen1 {
    interface PresenterToView extends ContextView {


    }

    interface ViewToPresenter {
    }

    interface PresenterToModel {


    }

    interface ModelToPresenter {
    }

    interface ToDetail {

        void onScreenStarted();
    }


}
