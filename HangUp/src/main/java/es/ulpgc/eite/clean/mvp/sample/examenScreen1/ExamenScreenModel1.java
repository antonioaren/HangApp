package es.ulpgc.eite.clean.mvp.sample.examenScreen1;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;

/**
 * Created by Pedro Arenas on 31/5/17.
 */

public class ExamenScreenModel1 extends GenericModel<ExamenScreen1.ModelToPresenter>
        implements ExamenScreen1.PresenterToModel {

    @Override
    public void onCreate(ExamenScreen1.ModelToPresenter presenter) {
        super.onCreate(presenter);
    }

    @Override
    public void onDestroy(boolean isChangingConfiguration) {
        super.onDestroy(isChangingConfiguration);
    }

}
