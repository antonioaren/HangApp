package es.ulpgc.eite.clean.mvp.sample.examenScreen2;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;

/**
 * Created by Pedro Arenas on 31/5/17.
 */

public class ExamenScreenModel2 extends GenericModel<ExamenScreen2.ModelToPresenter>
        implements ExamenScreen2.PresenterToModel {

    private static final String HEADER_PLACE = "Place";
    private static final String HEADER_DATE = "Date";
    private static final String HEADER_TIME_INIT = "Start";
    private static final String HEADER_TIME_END = "Finish";

    private ProductData itemSelected;


    @Override
    public void onCreate(ExamenScreen2.ModelToPresenter presenter) {
        super.onCreate(presenter);


    }

    @Override
    public void onDestroy(boolean isChangingConfiguration) {
        super.onDestroy(isChangingConfiguration);
    }


}
