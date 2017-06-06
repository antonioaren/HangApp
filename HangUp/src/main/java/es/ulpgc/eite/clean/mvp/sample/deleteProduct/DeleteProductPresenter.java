package es.ulpgc.eite.clean.mvp.sample.deleteProduct;

import android.content.Context;
import android.util.Log;

import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.Mediator;
import es.ulpgc.eite.clean.mvp.sample.app.Navigator;
import es.ulpgc.eite.clean.mvp.sample.product.Product;


/**
 * Created by alumno on 29/03/2017.
 */
public class DeleteProductPresenter
        extends GenericPresenter<DeleteProduct.PresenterToView, DeleteProduct.PresenterToModel, DeleteProduct.ModelToPresenter, DeleteProductModel>
        implements DeleteProduct.ViewToPresenter, DeleteProduct.ModelToPresenter, DeleteProduct.DeleteTo, DeleteProduct.ToDelete {


    @Override
    public void onCreate(DeleteProduct.PresenterToView view) {
        super.onCreate(DeleteProductModel.class, this);
        setView(view);
        Log.d(TAG, "calling onCreate()");

        Log.d(TAG, "calling startingSearchScreen()");
        Mediator app = (Mediator) getView().getApplication();
        app.startingDeleteProductScreen(this);
    }


    @Override
    public void onResume(DeleteProduct.PresenterToView view) {
        setView(view);
        Log.d(TAG, "calling onResume()");


        if (configurationChangeOccurred()) {
            getView().setDeleteBtnLabel(getModel().getDeleteBtnLabel());
            getView().setText1label(getModel().getText1Label());
            getView().setDeleIdBtnLabel(getModel().getDeleteIdBtnLabel());
            getView().setText2label(getModel().getText2Label());


//            if (buttonClicked) {
//                //getView().setText(getModel().getSearchText());
//            }
        }
    }

    @Override
    public Context getManagedContext() {
        return getActivityContext();
    }

    @Override
    public void onScreenStarted() {
        Log.d(TAG, "calling onScreenStarted");
    }

    @Override
    public void destroyView() {
        Log.d(TAG, "calling destroyView");
    }

    @Override
    public void onDestroy(boolean isChangingConfiguration) {
        super.onDestroy(isChangingConfiguration);
        Log.d(TAG, "calling onDestroy()");
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG, "calling onBackPressed()");
    }


    @Override
    public void onItemListClicked() {
        Log.d(TAG, "calling onItemListClicked");
        Navigator app = (Navigator) getView().getApplication();
        //Revisar esta llamada.
        app.goToProductScreen((Product.ProductTo) this);
    }

    @Override
    public void onDeleteButtonClicked() {
        getModel().deteleEvent(getView().getTextFromEditText());
        Mediator app = (Mediator) getView().getApplication();
        app.deleteProduct(this);
    }

    @Override
    public String getNameToDelete() {
        return getView().getTextFromEditText();
    }
}