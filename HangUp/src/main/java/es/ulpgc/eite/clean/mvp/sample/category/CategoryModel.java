package es.ulpgc.eite.clean.mvp.sample.category;

import android.util.Log;

import java.util.UUID;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;


public class CategoryModel extends GenericModel<Category.ModelToPresenter>
        implements Category.PresenterToModel {

   
    private RealmResults<CategoryData> itemsDatabase;

    private Realm realmDatabase;

    private int numberOfCategories;

    public CategoryModel() {
        this.numberOfCategories = 0;
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


        RealmConfiguration setting = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(setting);

    }

    ///////////////////////////////////////////////////////////////////////////////////

    @Override
    public void CreateDatabaseTables() {
        Log.d(TAG, "CreateDatabaseTables()");

        insertEvent("Fiestas", "disco.jpg");
        insertEvent("Música", "musica.png");
        insertEvent("ULPGC", "ulpgc.png");
        insertEvent("Astronomía", "astro.jpeg");
        insertEvent("Automovilismo", "cars.jpeg");
    }

//    private int getBitmapFromAssets(String name) {
//
//        int im = 1;
//        int[] array = new int[1000];
//        Drawable drawableImage = null;
//
//        try {
//            //Recoger el archivo desde assets
//
//            InputStream stream = Resources.getSystem().getAssets().open(name);
//            //   Bitmap bm = BitmapFactory.decodeStream(stream);
//            drawableImage = Drawable.createFromStream(stream, null);
//
//
//            // the drawable (Captain Obvious, to the rescue!!!)
//            Bitmap bitmap = ((BitmapDrawable) drawableImage).getBitmap();
//            ByteArrayOutputStream out = new ByteArrayOutputStream();
//            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, out);
//            byte[] bitmapdata = out.toByteArray();
//            im = Integer.parseInt(bitmapdata.toString());
//
//
//        } catch (IOException e) {
//            //Captando el mensaje en caso de error al cargar el archivo
//            Log.e(TAG, e.getMessage());
//        }
//
//
//        return im;
//    }


    /**
     * Called by layer PRESENTER when VIEW pass for a reconstruction/destruction.
     * Usefull for kill/stop activities that could be running on the background Threads
     *
     * @param isChangingConfiguration Informs that a change is occurring on the configuration
     */
    @Override
    public void onDestroy(boolean isChangingConfiguration) {

    }


    // Presenter To Model ////////////////////////////////////////////////////////////

    @Override
    public String getSearchLabel() {
        return HangAppButtonSearchLabel;
    }




    ///////////////////////////  DATABASE /////////////////////////////////////////////

    @Override
    public RealmResults<CategoryData> getEvents() {
        Log.d(TAG, "getEvent()");
        itemsDatabase = realmDatabase.where(CategoryData.class).findAll();
        return itemsDatabase;
    }

    @Override
    public String getCategoryNameAtIndex(int index) {
        return null;
    }

    @Override
    public int getNumberOfEvents() {
        return getEvents().size();
    }

    @Override
    public void setItemsFromDatabase() {
        itemsDatabase = realmDatabase.where(CategoryData.class).findAll();
    }


    @Override
    public void insertEvent(final String Categoryname, final String image) {
        realmDatabase = Realm.getDefaultInstance();
        realmDatabase.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                CategoryData event = realmDatabase.createObject(CategoryData.class, UUID.randomUUID().toString());

                event.setCategoryName(Categoryname);
                event.setImage(image);
            }

        });
        this.numberOfCategories++;
    }

    @Override
    public void deleteItem(final String id) {
        realmDatabase.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                CategoryData category = realm.where(CategoryData.class).equalTo("id", id).findFirst();
                category.deleteFromRealm();

            }
        });


    }


    public int getNumberOfCategories() {
        return this.numberOfCategories;
    }
}


