package es.ulpgc.eite.clean.mvp.sample.delete;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import io.realm.Realm;

import static android.R.attr.id;

/**
 * Created by alumno on 31/03/2017.
 */

public class DeleteModel  extends GenericModel<Delete.ModelToPresenter>
        implements Delete.PresenterToModel {


    String DeleteIdBtnLabel ,DeleteBtnLabel;
    String text1Label,text2Label;

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

    @Override
    public void onCreate(Delete.ModelToPresenter presenter) {
        super.onCreate(presenter);
        text1Label = "Write a category to delete ";
        DeleteBtnLabel="Delete";
        text2Label="Or delete a category By Id";
        DeleteIdBtnLabel="Delete by Id";


    }
    @Override
    public String getDeleteIdBtnLabel() {
        return DeleteIdBtnLabel;
    }
    @Override
    public void setDeleteIdBtnLabel(String deleteIdBtnLabel) {
        DeleteIdBtnLabel = deleteIdBtnLabel;
    }
    @Override
    public String getDeleteBtnLabel() {
        return DeleteBtnLabel;
    }
    @Override
    public void setDeleteBtnLabel(String deleteBtnLabel) {
        DeleteBtnLabel = deleteBtnLabel;
    }
    @Override
    public String getText1Label() {
        return text1Label;
    }
    @Override
    public void setText1Label(String text1Label) {
        this.text1Label = text1Label;
    }
    @Override
    public String getText2Label() {
        return text2Label;
    }
    @Override
    public void setText2Label(String text2Label) {
        this.text2Label = text2Label;
    }

    @Override
    public void onDestroy(boolean b) {

    }


    @Override
    public void deteleEvent( final String name) {
        realmDatabase = Realm.getDefaultInstance();
        realmDatabase.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                realmDatabase.where(CategoryData.class).equalTo("CategoryName", name)
                        .findAll()
                        .deleteAllFromRealm();
            }
        });


//Remove elements.

    }

    @Override
    public void deleteCategoryById(String Id) {

        realmDatabase=Realm.getDefaultInstance();
        realmDatabase.beginTransaction();
        CategoryData category = realmDatabase.where(CategoryData.class).equalTo("id", id).findFirst();
        category.deleteFromRealm();
        realmDatabase.commitTransaction();



    }

}

