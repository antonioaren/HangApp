package es.ulpgc.eite.clean.mvp.sample.search;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.module.RealmTable;
import io.realm.Realm;

/**
 * Created by alumno on 31/03/2017.
 */

public class SearchModel  extends GenericModel<Search.ModelToPresenter>
        implements Search.PresenterToModel {
    String[]categories;
    String SearchBtnLabel;
    String placeLabel;
    String categoryLabel;
    String dateLabel;
    String SearchText;
    private Realm realmDatabase;
   @Override
    public String getName() {
        return name;
    }
    @Override
    public void setName(String name) {
        this.name = name;
    }

    String name;
    public SearchModel(){
        this.categories= new String[]{"Cines","Culturales","Conciertos","Verbenas","Discotecas"};
    }
    @Override
    public void onCreate(Search.ModelToPresenter presenter) {
        super.onCreate(presenter);
        SearchText = "SEARCH";
        SearchBtnLabel = "Search";
        placeLabel = "ByPlace";
        categoryLabel = "ByCategory";
        dateLabel = "ByDate";
    }

    @Override
    public void onDestroy(boolean b) {

    }


    @Override
    public String getSearchText() {
        return SearchText;
    }

    @Override
    public String getPlaceLabel() {
        return placeLabel;
    }

    @Override
    public String getCategoryLabel() {
        return categoryLabel;
    }

    @Override
    public String getDateLabel() {
        return dateLabel;
    }

    @Override
    public String getSearchBtnLabel() {
        return SearchBtnLabel;
    }

    @Override
    public String[] getListCategories() {
        return this.categories;
    }
   @Override
    public void deteleEvent(String name) {
        realmDatabase = Realm.getDefaultInstance();



                Realm realm = Realm.getDefaultInstance();
                realm.beginTransaction();
                CategoryData result = realm.where(CategoryData.class).equalTo(RealmTable.ID, name).findFirst();
                result.deleteFromRealm();
                realm.commitTransaction();

//Remove elements.

            }}

