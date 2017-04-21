package es.ulpgc.eite.clean.mvp.sample.information;

import android.content.Context;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.Model;

/**
 * Created by alumno on 31/03/2017.
 */

public interface PartiesByCategories extends Model<PartiesByCategories.ModelToPresenter> {
    public interface PresenterToView extends ContextView {
    }

    public interface ViewToPresenter {

        public String[] getContentDefaultList() ;




        void onListCategoryItemClicked();
    }

    public interface PresenterToModel {
        String[]getCulturalParties();

        String[]getConcerts();

        String[]getVerbenas();

        String[]getcinemas();

        String[]discotecas();

        String[]getDefaulParty();
    }

    public interface SearchTo {
    }

    public interface ModelToPresenter {

    }

    public interface ToPartiesByCategories {
    }
interface DetailTo{
    Context getManagedContext();
    void destroyView();
}

}
