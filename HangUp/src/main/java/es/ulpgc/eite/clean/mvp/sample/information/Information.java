package es.ulpgc.eite.clean.mvp.sample.information;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.sample.app.CategoryData;

/**
 * Created by alumno on 31/03/2017.
 */

public interface Information {
    public interface PresenterToView extends ContextView {


        void setText(String details, String StoryDescription, String dateDescription, String hourDescription);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //Screen ///////////////////////////////////////////////////////////////////////////////////////

    public interface ViewToPresenter {
    }

    public interface PresenterToModel {

        CategoryData getItem();

        void setItem(CategoryData itemSelected);

    }

    public interface ModelToPresenter {
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //ToInformation ///////////////////////////////////////////////////////////////////////////////////////

    public interface ToInformation {
        void onScreenStarted();

        void setItem(CategoryData itemSelected);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    //InformationTo ///////////////////////////////////////////////////////////////////////////////////////

    public interface InformationTo {
    }
}
