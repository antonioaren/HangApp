package es.ulpgc.eite.clean.mvp.sample.authors;

import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.Mediator;

/**
 * Created by eleonora on 12/07/2017.
 */

public class AuthorsPresenter extends GenericPresenter<Authors.PresenterToView, Authors.PresenterToModel,
        Authors.ModelToPresenter, AuthorsModel>
        implements Authors.ViewToPresenter, Authors.ModelToPresenter, Authors.ToAuthors
        , Authors.AuthorsTo {


    @Override
    public void onCreate(Authors.PresenterToView presenterToView) {
        super.onCreate(AuthorsModel.class, this);

        Mediator app = (Mediator) getApplication();
        app.startingAuthorsScreen(this);
    }

    @Override
    public void onScreenStarted() {
        if (isViewRunning()) {
            getView().setText(getModel().getTxt());
            getView().setImage(getModel().getImage());
        }
    }

    @Override
    public void onResume(Authors.PresenterToView View) {
        setView(View);

        if (configurationChangeOccurred()) {
            getView().setText(getModel().getTxt());
            getView().setImage(getModel().getImage());
        }
    }

    @Override
    public void onBackPressed() {

        getModel().getProducts();

    }

//    @Override
//    public void onCreate(Authors.PresenterToView view) {
//        super.onCreate(AuthorsModel.class, this);
//        setView(view);
//
//        Mediator app = (Mediator) getApplication();
//        app.startingAuthorsScreen(this);
//    }
//    @Override
//    public void onResume(Product.PresenterToView view) {
//        Log.d(TAG, "calling onResume()");
//        setView(view);
//
//        if (configurationChangeOccurred()) {
//
//        }
//    }
//    @Override
//    public void onDestroy(boolean isChangingConfiguration) {
//        super.onDestroy(isChangingConfiguration);
//    }
//    @Override
//    public void onBackPressed() {
//
//    }


}