package es.ulpgc.eite.clean.mvp.sample.category;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.Database.EventsDatabase;
import es.ulpgc.eite.clean.mvp.sample.R;
import es.ulpgc.eite.clean.mvp.sample.add.AddPartyModel;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.InformationData;
import io.realm.Realm;
import io.realm.RealmResults;

import static android.R.attr.id;


public class CategoryModel extends GenericModel<Category.ModelToPresenter>
        implements Category.PresenterToModel {

    private String HangAppText;
    private String HangAppButtonSearchLabel;
    private String HangAppButtonAddLabel;
     private List<EventsDatabase>itemsDatabase;
    private List<CategoryData> items;
    private List<InformationData> Disco;
    private List<InformationData> Ulpgc;
    private List<InformationData> Cars;
    private List<InformationData> Musica;
    private List<InformationData> Astro;
    private List<InformationData> newParty;

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
        addPartyModel = new AddPartyModel();
        Disco = new ArrayList();
        Disco.add(new InformationData(R.drawable.disco, "Fiestas Nocturnas",
            String.valueOf(getParticipantsAt(0)), "Prueba detalle Astro",
            "La disco existe desde hace mucho tiempo", "este viernes", "de 12:00 pm hasta las 5:00 am"));

        Ulpgc = new ArrayList();
        Ulpgc.add(new InformationData(R.drawable.ulpgc, "Fiestas Nocturnas",
            String.valueOf(getParticipantsAt(1)), "Prueba detalle Astro",
            "La disco existe desde hace mucho tiempo", "este viernes", "de 12:00 pm hasta las 5:00 am"));

        Cars = new ArrayList();
        Cars.add(new InformationData(R.drawable.cars, "Fiestas Nocturnas",
            String.valueOf(getParticipantsAt(2)), "Prueba detalle Astro",
            "La disco existe desde hace mucho tiempo", "este viernes", "de 12:00 pm hasta las 5:00 am"));

        Musica = new ArrayList();
        Musica.add(new InformationData(R.drawable.musica, "Fiestas Nocturnas",
            String.valueOf(getParticipantsAt(3)), "Prueba detalle Astro",
            "La disco existe desde hace mucho tiempo", "este viernes", "de 12:00 pm hasta las 5:00 am"));

        Astro = new ArrayList();
        Astro.add(new InformationData(R.drawable.astro, "Fiestas Nocturnas",
            String.valueOf(getParticipantsAt(4)), "Prueba detalle Astro",
            "La disco existe desde hace mucho tiempo", "este viernes", "de 12:00 pm hasta las 5:00 am"));

    }

    private void LoadCategory() {
        items = new ArrayList();
        items.add(new CategoryData(R.drawable.disco, "Fiestas Nocturnas",
            String.valueOf(getParticipantsAt(0)), getDisco(), "Detalle Disco ",
            "La disco existe desde hace mucho tiempo", "este viernes", "de 12:00 pm hasta las 5:00 am"));
        items.add(new CategoryData(R.drawable.ulpgc, "Charlas Ulpgc",
            String.valueOf(getParticipantsAt(1)), getUlpgc(), "Orla Ulpgc",
            "La Universidad de Las Palmas de Gran Canaria comienza su andadura el curso 89-90 como consecuencia de un gran movimiento social que tiene lugar en esta isla de Gran Canaria y que culmina con la aprobación, por parte del Parlamento de Canarias, de la Ley de Reorganización Universitaria de Canarias, el 26 de abril de 1989.  ", "viernes 5 abril", "12:00 am"));
        items.add(new CategoryData(R.drawable.cars, "Automovilismo",
            String.valueOf(getParticipantsAt(2)), getCars(), "Carrera de formula 1 ",
            "la formula se remonta en 1949", "proximo viernes", "5:00 pm"));
        items.add(new CategoryData(R.drawable.musica, "Musica en directo",
            String.valueOf(getParticipantsAt(3)), getMusica(), "Detalle Musica",
            "La musica existe desde que se descubrio la escritura", "sabado 29 de abril", "16:00"));
        items.add(new CategoryData(R.drawable.astro, "Astronomía",
            String.valueOf(getParticipantsAt(4)), getAstro(), "Detalle Astro",
            "La astronomia se remonta en el siglo 300 A.C en la Antigua Grecia", "Hoy", "00:00"));
    }

    public void reload() {
        items.add(new CategoryData(R.drawable.astro, "title", "0", getNewParty(), "detail", "mmmmmmmmmmm", addPartyModel.getDateOfTheParty(), addPartyModel.getHourOfParty()));
        newParty = new ArrayList();
        newParty.add(new InformationData(R.drawable.astro, "title", "0", "detail", "yguy", addPartyModel.getDateOfTheParty(), addPartyModel.getHourOfParty()));
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
    public List<InformationData> getDisco() {
        return Disco;
    }

    @Override
    public List<InformationData> getUlpgc() {
        return Ulpgc;
    }

    @Override
    public List<InformationData> getCars() {
        return Cars;
    }

    @Override
    public List<InformationData> getMusica() {
        return Musica;
    }

    @Override
    public List<InformationData> getAstro() {
        return Astro;
    }

    @Override
    public List<InformationData> getNewParty() {
        return newParty;
    }

    @Override
    public int getParticipantsAt(int i) {
        return participants[i];
    }

    ///////////////////////////  DATABASE ////////////////////////
   @Override
   public void setDatabaseItemsFromJson(){
      // setItemsFromJsonStream("database.json");
       //setItemsFromJsonObjectArray();
   }



    @Override
    public List<EventsDatabase> getEvents(){
        RealmResults<EventsDatabase> results=realmDatabase.where(EventsDatabase.class).findAll();
        return results;
    }

    @Override
    public void setItemsFromDatabase(){
        itemsDatabase = realmDatabase.where(EventsDatabase.class).findAll();
    }
    @Override
    public void insertEvent(String id,int image,String productName,String numberOfParticipants,String category,String detail,String day,String hour,String web){
        EventsDatabase event=realmDatabase.createObject(EventsDatabase.class);
        realmDatabase.beginTransaction();//metodo que empieza a escuchar todas las acciones que hagamos para insertar un evento
         event.setId(id);
        event.setImage(image);
        event.setProductName(productName);
       // event.setNumber(numberOfParticipants);
        event.setCategory(category);
        event.setDetailText(detail);
      //  event.setDay(day);
       // event.setHour(hour);
        event.setWeb(web);
        realmDatabase.commitTransaction();//Almacena registro en la base de datos
    }
    public void updateEvent(){

    }
    public void deteleEvent(){

        realmDatabase.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.where(EventsDatabase.class).equalTo("id", id);
                 //   .findAll();

            }
        });


    }
}


