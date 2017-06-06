package es.ulpgc.eite.clean.mvp.sample.deleteProduct;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import io.realm.Realm;

/**
 * Created by alumno on 31/03/2017.
 */

public class DeleteProductModel extends GenericModel<DeleteProduct.ModelToPresenter>
        implements DeleteProduct.PresenterToModel {


    String DeleteIdBtnLabel, DeleteBtnLabel;
    String text1Label, text2Label;

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
    public void onCreate(DeleteProduct.ModelToPresenter presenter) {
        super.onCreate(presenter);
        text1Label = "Write a category to delete ";
        DeleteBtnLabel = "Delete";
        text2Label = "Or delete a category By Id";
        DeleteIdBtnLabel = "Delete by Id";


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
    public void deteleEvent(final String name) {
        realmDatabase = Realm.getDefaultInstance();
        realmDatabase.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                realmDatabase.where(ProductData.class).equalTo("CategoryName", name)
                        .findAll()
                        .deleteAllFromRealm();
            }
        });


//Remove elements.

    }


}

