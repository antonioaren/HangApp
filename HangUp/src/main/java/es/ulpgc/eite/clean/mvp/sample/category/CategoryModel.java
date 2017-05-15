package es.ulpgc.eite.clean.mvp.sample.category;

import android.content.Context;

import java.util.Random;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.R;
import es.ulpgc.eite.clean.mvp.sample.add.AddPartyModel;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import io.realm.Realm;
import io.realm.RealmResults;

import static android.R.attr.id;


public class CategoryModel extends GenericModel<Category.ModelToPresenter>
        implements Category.PresenterToModel {

    private String HangAppText;
    private String HangAppButtonSearchLabel;
    private String HangAppButtonAddLabel;
    private RealmResults<CategoryData> itemsDatabase;
    private boolean isFirstTimeRunning;
    private Context context;

//    private List<CategoryData> items;
//    private List<ProductData> Disco;
//    private List<ProductData> Ulpgc;
//    private List<ProductData> Cars;
//    private List<ProductData> Musica;
//    private List<ProductData> Astro;
//    private List<ProductData> newParty;

    private Random randomAssistance1, randomAssistance2, randomAssistance3, randomAssistance4, randomAssistance5;
    private int[] participants;
    private AddPartyModel addPartyModel;

    private boolean usingWrapper;
    private Realm realmDatabase;
    private final String PREFS_NAME = "MyprefsFile";


    public CategoryModel() {
        randomAssistance1 = new Random();
        randomAssistance2 = new Random();
        randomAssistance3 = new Random();
        randomAssistance4 = new Random();
        randomAssistance5 = new Random();
        participants = new int[]{
                randomAssistance1.nextInt(2001), randomAssistance2.nextInt(2001),
                randomAssistance3.nextInt(2001), randomAssistance4.nextInt(2001),
                randomAssistance5.nextInt(2001)};

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
        HangAppButtonAddLabel = "AddOne";
        HangAppButtonSearchLabel = "SearchOne";
        HangAppText = "Add";

        if (isFirstTimeRunning) {
            CreateDatabaseTablesFromJson();
        }

    }

    @Override
    public void CreateDatabaseTablesFromJson() {
//       RealmConfiguration config = new RealmConfiguration.Builder(context)
//                .setModules(new ModuleRealm()).build();
//        Realm.setDefaultConfiguration(config);

        insertEvent("0", "Fiestas", R.drawable.disco);
        insertEvent("1", "Música", R.drawable.musica);
        insertEvent("2", "ULPGC", R.drawable.ulpgc);
        insertEvent("3", "Astronomía", R.drawable.astro);
        insertEvent("4", "Automovilismo", R.drawable.cars);

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

    ///////////////////////////////////////////////////////////////////////////////////
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
        RealmResults<CategoryData> results = realmDatabase.where(CategoryData.class).findAll();
        return results;
    }

    @Override
    public void setItemsFromDatabase() {
        itemsDatabase = realmDatabase.where(CategoryData.class).findAll();
    }

    @Override
    public void insertEvent(String id, String Categoryname, int image) {

        CategoryData event = realmDatabase.createObject(CategoryData.class);
        realmDatabase.beginTransaction();

        event.setId(id);
        event.setCategoryName(Categoryname);
        event.setImage(image);

        realmDatabase.commitTransaction();
    }

    public void updateEvent() {
    }

    public void deteleEvent() {
        realmDatabase.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.where(ProductData.class).equalTo("id", id);
                //   .findAll();
            }
        });


    }
}


