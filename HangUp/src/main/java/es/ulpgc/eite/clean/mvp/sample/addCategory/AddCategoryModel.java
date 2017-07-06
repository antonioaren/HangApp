package es.ulpgc.eite.clean.mvp.sample.addCategory;


import android.util.Log;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.Model;
import es.ulpgc.eite.clean.mvp.sample.realmoperation.RealmOperation;

/**
 * Created by eleonora on 17/04/2017.
 */

public class AddCategoryModel
        extends GenericModel<AddCategory.ModelToPresenter>
        implements AddCategory.PresenterToModel, Model<AddCategory.ModelToPresenter> {


    private static final String NAME_LABEL = "Name:";
    private static final String PHOTO_LABEL = "Photo:";
    private static final String BUTTON_ADD_LABEL = "ADD";

    private static final String LABEL_RADIO_0 = "Astro";
    private static final String LABEL_RADIO_1 = "Academic";
    private static final String LABEL_RADIO_2 = "Car";

    private static final String LABEL_RADIO_3 = "Disco";

    private static final String NOTIFY_ADDED = "Added";
    private static final String NOTIFY_DELETED = "Deleted";

    private final String[] images;


    public AddCategoryModel() {

        this.images = new String[]{"", "astro.jpeg", "ulpgc.png", "cars.jpeg", "disco.jpg"};
    }

    @Override
    public void onCreate(AddCategory.ModelToPresenter presenter) {
        super.onCreate(presenter);


    }

    @Override
    public void onDestroy(boolean b) {
        Log.d(TAG, "calling onDestroy()");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public String getNameLabel() {
        return NAME_LABEL;
    }


    @Override
    public String getPhotoLabel() {
        return PHOTO_LABEL;
    }


    @Override
    public String getLabelRadio0() {
        return LABEL_RADIO_0;
    }


    @Override
    public String getLabelRadio1() {
        return LABEL_RADIO_1;
    }


    @Override
    public String getLabelRadio2() {
        return LABEL_RADIO_2;
    }


    @Override
    public String getLabelRadio3() {
        return LABEL_RADIO_3;
    }


    @Override
    public String getButtonAddlabel() {
        return BUTTON_ADD_LABEL;
    }


    @Override
    public String getToastNotifyingAdded() {
        return NOTIFY_ADDED;
    }

    public String getNotifyDeleted() {
        return NOTIFY_DELETED;
    }

    @Override
    public void insertEvent(final String categoryName, final String image) {
        RealmOperation realmOperation = RealmOperation.getInstances();
        realmOperation.insertEventCategory(categoryName, image);
    }
    @Override
    public String getImageByIdSelected(int id) {
        String imageName;
        if (id >= 0 && id < 5) {
            imageName = images[id];
        } else {
            imageName = null;
        }
        return imageName;
    }

    @Override
    public String getImage(int i) {
        return this.images[i];
    }
}