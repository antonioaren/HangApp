package es.ulpgc.eite.clean.mvp.sample.product;

import java.util.UUID;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import io.realm.Realm;
import io.realm.RealmResults;

import static android.R.attr.id;

/**
 * Created by Pedro Arenas on 25/4/17.
 */

public class ProductModel extends GenericModel<Product.ModelToPresenter>
        implements Product.PresenterToModel {
 Realm realmDatabase;
    private CategoryData Item;
    private String addlabel;
    private RealmResults<ProductData>itemsDatabase;

    @Override
    public void onCreate(Product.ModelToPresenter modelToPresenter) {
    this.addlabel="AddParty";
    }

    @Override
    public void onDestroy(boolean b) {

    }

    @Override
    public CategoryData getItem() {
        return Item;
    }

    @Override
    public void insertProduct(String id, final int image, final String title, String date, final String hour, String place, final String detail, final String participants) {

          realmDatabase = Realm.getDefaultInstance();
          realmDatabase.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                ProductData event = realmDatabase.createObject(ProductData.class, UUID.randomUUID().toString());
                event.setImage(image);
                event.setProductName(title);
                event.setParticipants(participants);
               // event.setDetailText(detail);
               // event.setDay(day);
               // event.setHour(hour);

            }


    });}

    @Override
    public void setItem(CategoryData itemSelected) {
        Item = itemSelected;
    }

    @Override
    public String getAddLabel() {
        return addlabel;
    }


    @Override
    public void setItemsFromDatabase() {
        itemsDatabase = realmDatabase.where(ProductData.class).findAll();
    }




    public void updateEvent() {
    }

    public void deteleEvent() {
        realmDatabase.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.where(ProductData.class).equalTo("id", id);
            }
        });


}}
