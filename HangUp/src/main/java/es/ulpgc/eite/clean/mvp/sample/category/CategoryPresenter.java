package es.ulpgc.eite.clean.mvp.sample.category;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import es.ulpgc.eite.clean.mvp.ContextView;
import es.ulpgc.eite.clean.mvp.GenericActivity;
import es.ulpgc.eite.clean.mvp.GenericPresenter;
import es.ulpgc.eite.clean.mvp.sample.app.Mediator;
import es.ulpgc.eite.clean.mvp.sample.app.Navigator;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import es.ulpgc.eite.clean.mvp.sample.data.ProductData;
import io.realm.RealmResults;

public class CategoryPresenter
        extends GenericPresenter<Category.PresenterToView, Category.PresenterToModel,
        Category.ModelToPresenter, CategoryModel>
        implements Category.ViewToPresenter, Category.ModelToPresenter, Category.ToCategory, Category.CategoryTo {

    private CategoryData selectedItem;
    private String itemId;

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

        CheckIfIsFirstTimeRunningToCreateDatabaseDefault();

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
        settingItemsAdapter();

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

        if (configurationChangeOccurred()) {

        }
    }

    // View To Presenter /////////////////////////////////////////////////////////////

    private void CheckIfIsFirstTimeRunningToCreateDatabaseDefault() {
        Log.d(TAG, "CheckIfIsFirstTimeRunningToCreateDatabaseDefault");


        SharedPreferences pref = getAppContext().getSharedPreferences("PREF", Context.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = pref.edit();

        //Si no está creado "FirstRunning", crear la base de datos, si está creado significa que ya
        //está creada la base de datos.

        if (pref.getBoolean("FirstRunning", true)) {
            prefEditor.putBoolean("FirstRunning", false);
            getModel().createDatabaseTables();
            prefEditor.commit();
        }
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
            settingItemsAdapter();
        }
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
        return itemId;
    }

    ///////////////////////////////////////////////////////////////////////////////////

    @Override
    public RealmResults<CategoryData> getCategoryList() {
        return getModel().getCategoryEvents();
    }

    @Override
    public void onItemClicked(CategoryData item, String id) {
        selectedItem = item;
        itemId = id;
        Log.d(TAG, "calling goToDetailScreen()");

        // Al haber hecho click en uno de los elementos de la lista del maestro es necesario
        // arrancar el detalle pasándole el estado inicial correspondiente que, en este caso,
        // es el item seleccionado. Será el mediador quien se encargue de obtener este estado
        // desde el maestro y pasarselo al detalle.

        Navigator app = (Navigator) getView().getApplication();
        app.goToProductScreen(this);
    }

    @Override
    public void onSwipedItem(String id) {

        getModel().deleteItem(id);
        getView().setToast(getModel().getNotifyDeleted());
        settingItemsAdapter();

    }

    @Override
    public void deletedAllCategories() {
        getModel().deleteAllCategory();
        settingItemsAdapter();
    }

    @Override
    public void addDefaultDb() {
        getModel().deleteAllCategory();
        getModel().createDatabaseTables();
        settingItemsAdapter();
    }

    private void settingItemsAdapter() {
        getView().settingItemsAdapter(getModel().getCategoryEvents());
    }


}

