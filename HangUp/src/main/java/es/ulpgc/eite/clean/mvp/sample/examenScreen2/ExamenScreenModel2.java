package es.ulpgc.eite.clean.mvp.sample.examenScreen2;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;

/**
 * Created by Pedro Arenas on 31/5/17.
 */

public class ExamenScreenModel2 extends GenericModel<ExamenScreen2.ModelToPresenter>
        implements ExamenScreen2.PresenterToModel {

    @Override
    public void onCreate(ExamenScreen2.ModelToPresenter presenter) {
        super.onCreate(presenter);


    }

    @Override
    public void onDestroy(boolean isChangingConfiguration) {
        super.onDestroy(isChangingConfiguration);
    }


}
