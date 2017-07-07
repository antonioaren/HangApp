package es.ulpgc.eite.clean.mvp.sample.category;

import android.util.Log;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.realmoperation.RealmOperation;
import io.realm.RealmResults;


public class CategoryModel extends GenericModel<Category.ModelToPresenter>
        implements Category.PresenterToModel {

    private RealmResults<CategoryData> itemsDatabase;
    private RealmOperation realmOperation;


    //private String id;

    private static final String NOTIFY_DELETED = "Deleted";


    @Override
    public void onCreate(Category.ModelToPresenter presenter) {
        super.onCreate(presenter);
        realmOperation = RealmOperation.getInstances();
    }

    ///////////////////////////////////////////////////////////////////////////////////

    @Override
    public void createDatabaseTables() {
        Log.d(TAG, "createDatabaseTables()");

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

    ///////////////////////////  DATABASE /////////////////////////////////////////////

    @Override
    public RealmResults<CategoryData> getCategoryEvents() {
        return realmOperation.getCategoryEvents();
    }

    @Override
    public void insertEvent(final String Categoryname, final String image) {

        realmOperation.insertEventCategory(Categoryname, image);


    }

    @Override
    public void deleteItem(final String id) {
        realmOperation.deleteItemCategory(id);
    }

    //metodo paara comprobar test con espresso
//    public String getId() {
//        return id;
//    }


    @Override
    public String getNotifyDeleted() {
        return NOTIFY_DELETED;
    }
}


