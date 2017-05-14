package es.ulpgc.eite.clean.mvp.sample.category;

import java.util.List;
import java.util.Random;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import es.ulpgc.eite.clean.mvp.sample.add.AddPartyModel;
import io.realm.Realm;
import io.realm.RealmResults;

import static android.R.attr.id;


public class CategoryModel extends GenericModel<Category.ModelToPresenter>
        implements Category.PresenterToModel {

    private String HangAppText;
    private String HangAppButtonSearchLabel;
    private String HangAppButtonAddLabel;
    private List<ProductData> itemsDatabase;
    private List<CategoryData> items;
    private List<ProductData> Disco;
    private List<ProductData> Ulpgc;
    private List<ProductData> Cars;
    private List<ProductData> Musica;
    private List<ProductData> Astro;
    private List<ProductData> newParty;

    private Random randomAssistance1, randomAssistance2, randomAssistance3, randomAssistance4, randomAssistance5;
    private int[] participants;
    private AddPartyModel addPartyModel;

    private boolean usingWrapper;
    private Realm realmDatabase;


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

    private void LoadCategory() {

    }

    public void reload() {

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
        // realmDatabase=Realm.getDefaultInstance();
        LoadCategory();

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
    public List<CategoryData> getListCategory() {
        return this.items;
    }


    @Override
    public List<ProductData> getDisco() {
        return Disco;
    }

    @Override
    public List<ProductData> getUlpgc() {
        return Ulpgc;
    }

    @Override
    public List<ProductData> getCars() {
        return Cars;
    }

    @Override
    public List<ProductData> getMusica() {
        return Musica;
    }

    @Override
    public List<ProductData> getAstro() {
        return Astro;
    }

    @Override
    public List<ProductData> getNewParty() {
        return newParty;
    }

    @Override
    public int getParticipantsAt(int i) {
        return participants[i];
    }

    ///////////////////////////  DATABASE ///////////////////////////
   @Override
   public void setDatabaseItemsFromJson(){
      // setItemsFromJsonStream("database.json");
       //setItemsFromJsonObjectArray();
   }



    @Override
    public List<ProductData> getEvents() {
        RealmResults<ProductData> results = realmDatabase.where(ProductData.class).findAll();
        return results;
    }

    @Override
    public void setItemsFromDatabase(){
        itemsDatabase = realmDatabase.where(ProductData.class).findAll();
    }
    @Override
    public void insertEvent(String id, int image, String productName, String participants, String category, String detail, String day, String hour, String web) {

        ProductData event = realmDatabase.createObject(ProductData.class);

        realmDatabase.beginTransaction();

        event.setId(id);
        event.setImage(image);
        event.setProductName(productName);
        event.setParticipants(participants);
        event.setDetailText(detail);
        event.setDay(day);
        event.setHour(hour);


        realmDatabase.commitTransaction();
    }
    public void updateEvent(){

    }
    public void deteleEvent(){

        realmDatabase.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.where(ProductData.class).equalTo("id", id);
                 //   .findAll();

            }
        });


    }
}


