package es.ulpgc.eite.clean.mvp.sample.information;

import android.content.Context;

import es.ulpgc.eite.clean.mvp.ContextView;

/**
 * Created by alumno on 31/03/2017.
 */

public interface PartiesByCategories {
    void onCreate(PresenterToView presenterToView);

    void onResume(PresenterToView presenterToView);
    Context getManagedContext();
    public interface PresenterToView extends ContextView {


        void setLabel(String titleLabel);

        void setText(String titleLabel);
    }

    public interface ViewToPresenter {

        public String[] getContentDefaultList() ;




        void onListCategoryItemClicked();
    }

    public interface PresenterToModel {
        String getTitleLabel();

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

        void onCreate(PresenterToView presenterToView);

        void onResume(PresenterToView presenterToView);
    }

     interface ToPartiesByCategories {
        void setListVisibility(boolean visibility);

        void onScreenStarted();
    }
interface DetailTo{
    Context getManagedContext();
    void destroyView();
}

    public interface ToDetail {
    }
}
