package es.ulpgc.eite.clean.mvp.sample.product;

import java.util.UUID;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import io.realm.Realm;

/**
 * Created by Pedro Arenas on 25/4/17.
 */

public class ProductModel extends GenericModel<Product.ModelToPresenter>
        implements Product.PresenterToModel {
 Realm realmDatabase;
    private CategoryData Item;


    @Override
    public void onCreate(Product.ModelToPresenter modelToPresenter) {

    }

    @Override
    public void onDestroy(boolean b) {

    }

    @Override
    public CategoryData getItem() {
        return Item;
    }

    @Override
    public void insertProduct(String id,int image,String productName,String participants,String detail,String day,String hour){
        ProductData event = realmDatabase.createObject(ProductData.class);
        realmDatabase.beginTransaction();

        event.setId(UUID.randomUUID().toString());
       event.setImage(image);
        event.setProductName(productName);
        event.setParticipants(participants);
        event.setDetailText(detail);
        event.setDay(day);
        event.setHour(hour);
        realmDatabase.commitTransaction();
    }

    @Override
    public void setItem(CategoryData itemSelected) {
        Item = itemSelected;
    }
}
