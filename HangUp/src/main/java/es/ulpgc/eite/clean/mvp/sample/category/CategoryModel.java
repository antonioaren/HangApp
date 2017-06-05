package es.ulpgc.eite.clean.mvp.sample.category;

import android.content.ContentProvider;
import android.content.Context;
import android.content.SharedPreferences;
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
import static android.content.Context.MODE_PRIVATE;


public class CategoryModel extends GenericModel<Category.ModelToPresenter>
        implements Category.PresenterToModel {

    private String HangAppButtonSearchLabel;
    private String HangAppButtonAddLabel;
    private RealmResults<CategoryData> itemsDatabase;

    private Realm realmDatabase;
    private int[] participants;

    public CategoryModel() {
        participants = new int[]{
                1, 2, 3, 4, 5};
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
        HangAppButtonAddLabel = "Add";
        HangAppButtonSearchLabel = "Search";

        RealmConfiguration setting = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(setting);

        //TODO Error al crear el objeto SharedPreferences.
        //CheckIfIsFirstTimeRunning();

        //Comentar esto y descomentar el metodo que se llama justo arriba de este
        //Para saber si se ha corrido la primera vez.
        CreateDatabaseTables();

    }

    ///////////////////////////////////////////////////////////////////////////////////

    @Override
    public void CreateDatabaseTables() {
        Log.d(TAG, "CreateDatabaseTables()");
        insertEvent("Fiestas", R.drawable.disco);
        insertEvent("Música", R.drawable.musica);
        insertEvent("ULPGC", R.drawable.ulpgc);
        insertEvent("Astronomía", R.drawable.astro);
        insertEvent("Automovilismo", R.drawable.cars);
    }

    //TODO Usarlo, resolver problema objeto.
    private void CheckIfIsFirstTimeRunning() {
        Log.d(TAG, "CheckIfIsFirstTimeRunning");

        SharedPreferences pref = getPresenter().getAppContext().getSharedPreferences("PREF", MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = pref.edit();

        //Si no está creado "FirstRunning", crear la base de datos, si está creado significa que ya
        //está creada la base de datos.
        if (!pref.getBoolean("FirstRunning", true)) {
            CreateDatabaseTables();
            //Crear boolean y hacer commit.
            prefEditor.putBoolean("FirstRunning", false);
            prefEditor.commit();
        }
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

    @Override
    public String getSearchLabel() {
        return HangAppButtonSearchLabel;
    }

    @Override
    public String getAddLabel() {
        return HangAppButtonAddLabel;
    }

    @Override
    public int getParticipantsAt(int i) {
        return participants[i];
    }

    ///////////////////////////  DATABASE /////////////////////////////////////////////

    @Override
    public RealmResults<CategoryData> getEvents() {
        Log.d(TAG, "getEvent()");
        RealmResults<CategoryData> results = realmDatabase.where(CategoryData.class).findAll();
        return results;
    }

    @Override
    public int getNumberOfEvents() {

        return getEvents().size();

    }

    @Override
    public void setItemsFromDatabase() {
        itemsDatabase = realmDatabase.where(CategoryData.class).findAll();
    }

    @Override
    public void insertEvent(final String Categoryname, final int image) {
        realmDatabase = Realm.getDefaultInstance();
        realmDatabase.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                CategoryData event = realmDatabase.createObject(CategoryData.class, UUID.randomUUID().toString());

                event.setCategoryName(Categoryname);
                event.setImage(image);
            }

        });

    }

    @Override
    public void AddProductByCategoryId(ProductData product, final String CategoryId) {

    }


    public void deteleEvent() {
        realmDatabase.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.where(ProductData.class).equalTo("id", id);
            }
        });


    }

    public void setSearchLabel(String label) {
        this.HangAppButtonSearchLabel = label;
    }

    public void setAddLabel(String label) {
        this.HangAppButtonAddLabel = label;
    }


}


