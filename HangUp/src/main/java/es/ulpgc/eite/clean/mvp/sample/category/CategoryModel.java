package es.ulpgc.eite.clean.mvp.sample.category;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;


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
        Bitmap astro = getBitmapFromAssets("astro.jpeg");
        insertEvent("Fiestas", astro);
        insertEvent("Música", astro);
        insertEvent("ULPGC", astro);
        insertEvent("Astronomía", astro);
        insertEvent("Automovilismo", astro);
    }

    public Bitmap getBitmapFromAssets(String name) {

        int im = 1;
        Context context = getPresenter().getManagedContext();
        InputStream stream = null;
        try {
            //Recoger el archivo desde assets
            stream = context.getAssets().open(name);
        } catch (IOException e) {
            //Captando el mensaje en caso de error al cargar el archivo
            Log.e(TAG, e.getMessage());
        }
        Bitmap bm = BitmapFactory.decodeStream(stream);

        return bm;
    }

    //TODO Usarlo, resolver problema objeto.
    private void CheckIfIsFirstTimeRunning() {
        Log.d(TAG, "CheckIfIsFirstTimeRunning");

        Context context = getPresenter().getAppContext();

        SharedPreferences pref = context.getSharedPreferences("PREF", Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = pref.edit();

        //Si no está creado "FirstRunning", crear la base de datos, si está creado significa que ya
        //está creada la base de datos.

        if (!pref.getBoolean("FirstRunning", true)) {
            CreateDatabaseTables();
            //Crear boolean y hacer commit.
            prefEditor.putBoolean("FirstRunning", true);
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
    public String getCategoryNameAtIndex(int index) {
        return null;
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
    public void insertEvent(final String Categoryname, final Bitmap image) {
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
    public void deleteItemById(final String id) {
        realmDatabase.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                CategoryData category = realm.where(CategoryData.class).equalTo("id", id).findFirst();
                category.deleteFromRealm();
            }
        });
    }



    public void setSearchLabel(String label) {
        this.HangAppButtonSearchLabel = label;
    }


}


