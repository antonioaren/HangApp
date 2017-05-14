package es.ulpgc.eite.clean.mvp.sample.product;

import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.app.Mediator;

/**
 * Created by alumno on 31/03/2017.
 */

public class ProductPresenter
        extends GenericPresenter<Product.PresenterToView, Product.PresenterToModel,
        Product.ModelToPresenter, ProductModel>
        implements Product.ViewToPresenter, Product.ModelToPresenter, Product.ToInformation
        , Product.InformationTo {

    @Override
    public void onCreate(Product.PresenterToView view) {
        super.onCreate(ProductModel.class, this);
        setView(view);

        Mediator app = (Mediator) getApplication();
        app.startingInformationScreen(this);

    }

    @Override
    public void onResume(Product.PresenterToView view) {
        setView(view);
    }

    @Override
    public void onDestroy(boolean isChangingConfiguration) {
        super.onDestroy(isChangingConfiguration);
    }

    @Override
    public void onBackPressed() {

    }

    @Override
    public void onScreenStarted() {
        if (isViewRunning()) {

        }
    }

    @Override
    public void setItem(CategoryData itemSelected) {
        getModel().setItem(itemSelected);
    }
}
