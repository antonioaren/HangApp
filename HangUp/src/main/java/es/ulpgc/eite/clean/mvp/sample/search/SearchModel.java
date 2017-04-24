package es.ulpgc.eite.clean.mvp.sample.search;

import es.ulpgc.eite.clean.mvp.GenericModel;

/**
 * Created by alumno on 31/03/2017.
 */

public class SearchModel  extends GenericModel<Search.ModelToPresenter>
        implements Search.PresenterToModel {
    String[]categories;
    public SearchModel(){
        this.categories= new String[]{"Cines","Culturales","Conciertos","Verbenas","Discotecas"};
    }
    @Override
    public void onCreate(Search.ModelToPresenter modelToPresenter) {

    }

    @Override
    public void onDestroy(boolean b) {

    }




    @Override
    public String getSearchBtnLabel() {
        return null;
    }

    @Override
    public String[] getListCategories() {
        return this.categories;
    }
}