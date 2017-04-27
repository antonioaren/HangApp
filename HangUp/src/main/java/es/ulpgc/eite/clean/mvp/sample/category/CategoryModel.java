package es.ulpgc.eite.clean.mvp.sample.category;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.R;
import es.ulpgc.eite.clean.mvp.sample.app.CategoryData;


public class CategoryModel extends GenericModel<Category.ModelToPresenter>
        implements Category.PresenterToModel {

    private String HangAppText;
    private String HangAppButtonSearchLabel;
    private String HangAppButtonAddLabel;
    private List<CategoryData> items;


    public CategoryModel() {

        items = new ArrayList<CategoryData>();
        items.add(new CategoryData(R.drawable.astro, "Fiestas Nocturnas", "230", "Prueba detalle Astro"));
        items.add(new CategoryData(R.drawable.ulpgc, "Charlas Ulpgc", "456", "prueba detalle Ulpgc"));
        items.add(new CategoryData(R.drawable.cars, "Automovilismo", "342", "prueba detalle Automovilismo"));
        items.add(new CategoryData(R.drawable.musica, "Musica en directo", "645", "prueba detalle Musica en directo"));
        items.add(new CategoryData(R.drawable.astro, "Astronomía", "459", "prueba detalle Astronomía"));

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
    public List<CategoryData> getListOfParties() {
        return this.items;
    }


}


