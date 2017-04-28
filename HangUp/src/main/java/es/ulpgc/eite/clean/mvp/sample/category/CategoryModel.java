package es.ulpgc.eite.clean.mvp.sample.category;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.R;
import es.ulpgc.eite.clean.mvp.sample.app.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.app.InformationData;

//GenericModel<Information.ModelToPresenter>
public class CategoryModel extends GenericModel<Category.ModelToPresenter>
        implements Category.PresenterToModel {

    private String HangAppText;
    private String HangAppButtonSearchLabel;
    private String HangAppButtonAddLabel;
    private List<CategoryData> items;

    private List<InformationData> Disco;
    private List<InformationData> Ulpgc;
    private List<InformationData> Cars;
    private List<InformationData> Musica;
    private List<InformationData> Astro;
    private Random randomAssistance;
    private int participants;
    public CategoryModel() {
        randomAssistance = new Random();
        participants = randomAssistance.nextInt(2001);

        Disco = new ArrayList<InformationData>();
        Disco.add(new InformationData(R.drawable.disco, "Fiestas Nocturnas", String.valueOf(participants), "Prueba detalle Astro"));

        Ulpgc = new ArrayList<InformationData>();
        Ulpgc.add(new InformationData(R.drawable.ulpgc, "Fiestas Nocturnas", String.valueOf(participants), "Prueba detalle Astro"));

        Cars = new ArrayList<InformationData>();
        Cars.add(new InformationData(R.drawable.cars, "Fiestas Nocturnas", String.valueOf(participants), "Prueba detalle Astro"));

        Musica = new ArrayList<InformationData>();
        Musica.add(new InformationData(R.drawable.musica, "Fiestas Nocturnas", String.valueOf(participants), "Prueba detalle Astro"));

        Astro = new ArrayList<InformationData>();
        Astro.add(new InformationData(R.drawable.astro, "Fiestas Nocturnas", String.valueOf(participants), "Prueba detalle Astro"));

    }

    private void LoadCategory() {
        items = new ArrayList<CategoryData>();
        items.add(new CategoryData(R.drawable.disco, "Fiestas Nocturnas", String.valueOf(participants), getDisco(), "Detalle Disco"));
        items.add(new CategoryData(R.drawable.ulpgc, "Charlas Ulpgc", String.valueOf(participants), getUlpgc(), "Detalle Ulpgc"));
        items.add(new CategoryData(R.drawable.cars, "Automovilismo", String.valueOf(participants), getCars(), "Detalle Cars"));
        items.add(new CategoryData(R.drawable.musica, "Musica en directo", String.valueOf(participants), getMusica(), "Detalle Musica"));
        items.add(new CategoryData(R.drawable.astro, "Astronomía", String.valueOf(participants), getAstro(), "Detalle Astro"));
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
}


