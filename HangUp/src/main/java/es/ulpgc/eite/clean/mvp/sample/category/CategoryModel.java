package es.ulpgc.eite.clean.mvp.sample.category;

import android.util.Log;

import java.util.UUID;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;


public class CategoryModel extends GenericModel<Category.ModelToPresenter>
        implements Category.PresenterToModel {


    private RealmResults<CategoryData> itemsDatabase;

    private Realm realmDatabase;

    private int numberOfCategories;


    private String id;

    public CategoryModel() {
        this.numberOfCategories = 0;
    }

    /**
     * Method that recovers a reference to the PRESENTER
     * You must ALWAYS call {@link super#onCreate(Object)} here
     *
     * @param presenter Presenter interface
     */

    @Override
    public void onCreate(Category.ModelToPresenter presenter) {
        super.onCreate(presenter);


        RealmConfiguration setting = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(setting);

    }

    ///////////////////////////////////////////////////////////////////////////////////

    @Override
    public void CreateDatabaseTables() {
        Log.d(TAG, "CreateDatabaseTables()");

        insertEvent("Fiestas", "disco.jpg");
        insertEvent("Música", "musica.png");
        insertEvent("ULPGC", "ulpgc.png");
        insertEvent("Astronomía", "astro.jpeg");
        insertEvent("Automovilismo", "cars.jpeg");
    }

    /**
     * Called by layer PRESENTER when VIEW pass for a reconstruction/destruction.
     * Usefull for kill/stop activities that could be running on the background Threads
     *
     * @param isChangingConfiguration Informs that a change is occurring on the configuration
     */


    @Override
    public void onDestroy(boolean isChangingConfiguration) {

    }


    // Presenter To Model ////////////////////////////////////////////////////////////





    ///////////////////////////  DATABASE /////////////////////////////////////////////

    @Override
    public RealmResults<CategoryData> getEvents() {
        Log.d(TAG, "getEvent()");
        itemsDatabase = realmDatabase.where(CategoryData.class).findAll();
        return itemsDatabase;
    }



    @Override
    public void setItemsFromDatabase() {
        itemsDatabase = realmDatabase.where(CategoryData.class).findAll();
    }


    @Override
    public void insertEvent(final String Categoryname, final String image) {
        realmDatabase = Realm.getDefaultInstance();
        this.id = UUID.randomUUID().toString();
        realmDatabase.executeTransaction(new Realm.Transaction() {

            @Override
            public void execute(Realm realm) {

                CategoryData event = realmDatabase.createObject(CategoryData.class, id);

                event.setCategoryName(Categoryname);
                event.setImage(image);
            }

        });
        this.numberOfCategories++;

    }

    @Override
    public void deleteItem(final String id) {
        realmDatabase.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                CategoryData category = realm.where(CategoryData.class).equalTo("id", id).findFirst();
                category.deleteFromRealm();

            }
        });
        this.numberOfCategories--;

    }

    //metodos paara comprobar test con espresso
    public String getId() {
        return id;
    }

    @Override
    public int getNumberOfCategories() {
        return this.numberOfCategories;
    }
}


