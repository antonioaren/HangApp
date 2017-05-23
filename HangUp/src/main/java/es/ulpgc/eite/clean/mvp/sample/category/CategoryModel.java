package es.ulpgc.eite.clean.mvp.sample.category;

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


public class CategoryModel extends GenericModel<Category.ModelToPresenter>
        implements Category.PresenterToModel {

    private String HangAppButtonSearchLabel;
    private String HangAppButtonAddLabel;
    private RealmResults<CategoryData> itemsDatabase;


    private boolean usingWrapper;
    private Realm realmDatabase;


  //  private Random randomAssistance1, randomAssistance2, randomAssistance3, randomAssistance4, randomAssistance5;
    private int[] participants;
    private boolean isFirstTime;


    public CategoryModel() {
//        randomAssistance1 = new Random();
//        randomAssistance2 = new Random();
//        randomAssistance3 = new Random();
//        randomAssistance4 = new Random();
//        randomAssistance5 = new Random();
        participants = new int[]{
               1,2,3,4,5};

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

            CreateDatabaseTablesFromJson();
        }



//        SharedPreferences pref =
//                ((Category.CategoryTo)presenter).getManagedContext().getSharedPreferences("es.ulpgc.eite.clean.mvp.sample", MODE_PRIVATE);
//        if (pref.getBoolean("FirstRun", true)) {
//            CreateDatabaseTablesFromJson();
//            pref.edit().putBoolean("FirstRun", false).commit();







    ///////////////////////////////////////////////////////////////////////////////////


    @Override
    public void CreateDatabaseTablesFromJson() {
        Log.d("PruebaPasaDatos", "CreateDatabaseTablesFromJson()");
       // Realm.init(this);
        insertEvent("Fiestas", R.drawable.disco);
        insertEvent("Música", R.drawable.musica);
        insertEvent("ULPGC", R.drawable.ulpgc);
        insertEvent("Astronomía", R.drawable.astro);
        insertEvent("Automovilismo", R.drawable.cars);


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
//        realmDatabase = Realm.getDefaultInstance();
//        realmDatabase.executeTransaction(new Realm.Transaction() {
//            @Override
//            public void execute(Realm realm) {
//                ProductData RealmData = realm.createObject(ProductData.class, UUID.randomUUID().toString());
//
//                RealmData.setProductName("");
//                RealmData.setImage(0);
//                RealmData.setDate("");
//                RealmData.setHour("");
//                RealmData.setParticipants("");
//                RealmData.setDetailText("");
//
//                CategoryData category = realmDatabase.where(CategoryData.class).
//                        equalTo(RealmTable.ID, CategoryId).findFirst();
//
//                category.getItemInfo().add(RealmData);
//            }
//        });
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

    public void setSearchLabel(String label) {
     this.HangAppButtonSearchLabel=label;
    }

    public void setAddLabel(String label) {
    this.HangAppButtonAddLabel=label;
    }


}


