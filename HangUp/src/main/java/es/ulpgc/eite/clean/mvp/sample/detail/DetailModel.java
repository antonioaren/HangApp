package es.ulpgc.eite.clean.mvp.sample.detail;

import es.ulpgc.eite.clean.mvp.GenericModel;

/**
 * Created by eleonora on 17/04/2017.
 */

public class DetailModel extends GenericModel<Detail.ModelToPresenter> implements Detail.PresenterToModel {


    @Override
    public void onCreate(Detail.ModelToPresenter presenter) {
        super.onCreate(presenter);
    }

    @Override
    public void onDestroy(boolean b) {

    }

}