package es.ulpgc.eite.clean.mvp.sample.category;

import android.content.Context;
import android.util.Log;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.Mediator;
import es.ulpgc.eite.clean.mvp.sample.app.Navigator;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import io.realm.RealmResults;

public class CategoryPresenter
        extends GenericPresenter<Category.PresenterToView, Category.PresenterToModel,
        Category.ModelToPresenter, CategoryModel>
        implements Category.ViewToPresenter, Category.ModelToPresenter, Category.ToCategory, Category.CategoryTo {

    private CategoryData selectedItem;
    private String ItemId;

    /**
     * Operation called during VIEW creation in {@link GenericActivity#onResume(Class, Object)}
     * Responsible to initialize MODEL.
     * Always call {@link GenericPresenter#onCreate(Class, Object)} to initialize the object
     * Always call  {@link GenericPresenter#setView(ContextView)} to save a PresenterToView reference
     *
     * @param view The current VIEW instance
     */
    @Override
    public void onCreate(Category.PresenterToView view) {
        super.onCreate(CategoryModel.class, this);
        setView(view);
        Log.d(TAG, "calling onCreate()");
        getModel().CreateDatabaseTables();

//        if (getView().isFirstTime())
//            getModel().CreateDatabaseTables();

        Mediator app = (Mediator) getView().getApplication();
        app.startingCategoryScreen(this);
    }


    /**
     * Operation called by VIEW after its reconstruction.
     * Always call {@link GenericPresenter#setView(ContextView)}
     * to save the new instance of PresenterToView
     *
     * @param view The current VIEW instance
     */
    @Override
    public void onResume(Category.PresenterToView view) {
        setView(view);
        Log.d(TAG, "calling onResume()");
        SettingItemsAdapter();

        if (configurationChangeOccurred()) {

        }
    }

    /**
     * Helper method to inform Presenter that a onBackPressed event occurred
     * Called by {@link GenericActivity}
     */
    @Override
    public void onBackPressed() {

    }

    /**
     * Hook method called when the VIEW is being destroyed or
     * having its configuration changed.
     * Responsible to maintain MVP synchronized with Activity lifecycle.
     * Called by onDestroy methods of the VIEW layer, like: {@link GenericActivity#onDestroy()}
     *
     * @param isChangingConfiguration true: configuration changing & false: being destroyed
     */
    @Override
    public void onDestroy(boolean isChangingConfiguration) {
        super.onDestroy(isChangingConfiguration);
        Log.d(TAG, "calling onDestroy()");
    }

    // View To Presenter /////////////////////////////////////////////////////////////

    @Override
    public void onButtonSearchClicked() {
        Log.d(TAG, "calling onButtonSearchClicked()");
//      if (isViewRunning()) {
//          getModel().onChangeMsgByBtnClicked();
//          getView().setText(getModel().getText());
//          textVisible = true;
//          buttonClicked = true;

//        Navigator app = (Navigator) getView().getApplication();
//        app.goToDeleteScreen(this);
    }
    @Override
    public void onButtonAddClicked() {
        Log.d(TAG, "calling onButtonAddClicked()");
        Navigator app = (Navigator) getView().getApplication();
        app.goToAddCategoryScreen(this);
    }
    @Override
    public void onListItemClicked() {
        Log.d(TAG, "item cliked");
        Navigator app = (Navigator) getView().getApplication();
        app.goToProductScreen(this);
    }

    // To Category //////////////////////////////////////////////////////////////////////

    @Override
    public void onScreenStarted() {
        Log.d(TAG, "calling onScreenStarted()");
        if (isViewRunning()) {
            //getView().setLabelSearch(getModel().getSearchLabel());

        }
        // el setting adapter va aqui
        // getView().settingAdapter(getModel().getEvents());
        SettingItemsAdapter();

    }

    // Category To ///////////////////////////////////////////////////////////////////

    @Override
    public Context getManagedContext() {
        return getActivityContext();
    }

    @Override
    public Context getAppContext() {
        return getApplication();
    }

    @Override
    public void destroyView() {
        if (isViewRunning()) {
            getView().finishScreen();
        }
    }

    @Override
    public CategoryData getSelectedItem() {
        return selectedItem;
    }

    @Override
    public String getItemId() {
        return ItemId;
    }

    ///////////////////////////////////////////////////////////////////////////////////

    @Override
    public RealmResults<CategoryData> getCategoryList() {
        return getModel().getEvents();
    }

    @Override
    public void onItemClicked(CategoryData item, String id) {
        selectedItem = item;
        ItemId = id;
        Log.d(TAG, "calling goToDetailScreen()");

        // Al haber hecho click en uno de los elementos de la lista del maestro es necesario
        // arrancar el detalle pasándole el estado inicial correspondiente que, en este caso,
        // es el item seleccionado. Será el mediador quien se encargue de obtener este estado
        // desde el maestro y pasarselo al detalle.

        Navigator app = (Navigator) getView().getApplication();
        app.goToProductScreen(this);
    }

    @Override
    public void OnSwipedItem(String id) {
        getModel().deleteItem(id);
        SettingItemsAdapter();
    }

    private void SettingItemsAdapter() {
        getView().settingAdapter(getModel().getEvents());
    }


}

