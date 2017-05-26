package es.ulpgc.eite.clean.mvp.sample.product;

import android.util.Log;

import java.util.UUID;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.R;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import io.realm.Realm;
import io.realm.RealmConfiguration;
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



    private String deleteLabel;
    private RealmResults<ProductData>itemsDatabase;
    private boolean isFirstTime;

    @Override
    public void onCreate(Product.ModelToPresenter modelToPresenter) {
        this.addlabel="AddParty";
        this.deleteLabel="delete";
        RealmConfiguration setting = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(setting);

        if (!isFirstTime) {
            CreateDatabaseTablesFromJson();
    }}

    @Override
    public void onDestroy(boolean b) {

    }

    @Override
    public CategoryData getItem() {
        return Item;
    }

    @Override
    public void AddProductByCategoryId(ProductData product, String CategoryId) {

    }

    @Override
    public void insertProduct( final int image, final String title, final String participants) {

          realmDatabase = Realm.getDefaultInstance();
          realmDatabase.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                ProductData event = realmDatabase.createObject(ProductData.class, UUID.randomUUID().toString());
                event.setImage(image);
                event.setProductName(title);
                event.setParticipants(participants);


            }


    });}

    @Override
    public void setItem(CategoryData itemSelected) {
        Item = itemSelected;
    }

    @Override
    public void setItem(ProductData itemSelected) {

    }


    @Override
    public void setIsFirstimeRunning(boolean isFirstTimeRunning) {
        this.isFirstTime = isFirstTimeRunning;
    }

    @Override
    public void CreateDatabaseTablesFromJson() {
        Log.d("PruebaPasaDatos", "CreateDatabaseTablesFromJson()");
        insertProduct(R.drawable.disco,"verbena","1000");
        insertProduct(R.drawable.astro,"concierto","30000000");
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

}

    public void setAddLabel(String txt) {
      this.addlabel=txt;
    }

    @Override
    public String getAddLabel() {
        return addlabel;
    }

    @Override
    public String getDeleteLabel() {
        return deleteLabel;
    }

    public void setDeleteLabel(String deleteLabel) {
        this.deleteLabel = deleteLabel;
    }

}
