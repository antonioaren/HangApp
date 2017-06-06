package es.ulpgc.eite.clean.mvp.sample.deleteProduct;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import io.realm.Realm;

/**
 * Created by alumno on 31/03/2017.
 */

public class DeleteProductModel extends GenericModel<DeleteProduct.ModelToPresenter>
        implements DeleteProduct.PresenterToModel {


    String DeleteBtnLabel;


    String textLabel;

    private Realm realmDatabase;




    @Override
    public void onCreate(DeleteProduct.ModelToPresenter presenter) {
        super.onCreate(presenter);
        textLabel = "Write an event  to delete ";
        DeleteBtnLabel = "Delete";


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
    public String getTextLabel() {
        return textLabel;
    }
    @Override
    public void setTextLabel(String textLabel) {
        this.textLabel = textLabel;
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

                realmDatabase.where(ProductData.class).equalTo("productName", name)
                        .findAll()
                        .deleteAllFromRealm();
            }
        });


//Remove elements.

    }


}

