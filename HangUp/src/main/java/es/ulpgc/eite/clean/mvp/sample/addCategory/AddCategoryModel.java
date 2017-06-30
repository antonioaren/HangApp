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


    private String nameLabel, photoLabel, buttonPhotoLabel, buttonAddlabel;

    private String labelRadio0;
    private String labelRadio1;
    private String labelRadio2;
    private String labelRadio3;

    private String ValueAdded, ValueDeleted;

    private String[] images;


    public AddCategoryModel() {

        this.images = new String[]{"", "astro.jpeg", "ulpgc.png", "cars.jpeg", "disco.jpg"};
    }

    @Override
    public void onCreate(AddCategory.ModelToPresenter presenter) {
        super.onCreate(presenter);

        nameLabel = "Name:";
        photoLabel = "Photo:";
        buttonPhotoLabel = "Select...";
        buttonAddlabel = "AddProduct";

        labelRadio0 = "astro";
        labelRadio1 = "academic";
        labelRadio2 = "car";
        labelRadio3 = "disco";

        ValueAdded = "Added";
        ValueDeleted = "Deleted";
    }

    @Override
    public void onDestroy(boolean b) {
        Log.d(TAG, "calling onDestroy()");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////


    @Override
    public String getNameLabel() {
        return nameLabel;
    }
    @Override
    public void setNameLabel(String nameLabel) {
        this.nameLabel = nameLabel;
    }

    @Override
    public String getPhotoLabel() {
        return photoLabel;
    }
    @Override
    public void setPhotoLabel(String photoLabel) {
        this.photoLabel = photoLabel;
    }

    @Override
    public String getLabelRadio0() {
        return labelRadio0;
    }
    @Override
    public void setLabelRadio0(String labelRadio0) {
        this.labelRadio0 = labelRadio0;
    }

    @Override
    public String getLabelRadio1() {
        return labelRadio1;
    }
    @Override
    public void setLabelRadio1(String labelRadio1) {
        this.labelRadio1 = labelRadio1;
    }

    @Override
    public String getLabelRadio2() {
        return labelRadio2;
    }
    @Override
    public void setLabelRadio2(String labelRadio2) {
        this.labelRadio2 = labelRadio2;
    }

    @Override
    public String getLabelRadio3() {
        return labelRadio3;
    }
    @Override
    public void setLabelRadio3(String labelRadio3) {
        this.labelRadio3 = labelRadio3;
    }

    @Override
    public String getButtonAddlabel() {
        return buttonAddlabel;
    }
    @Override
    public void setButtonAddlabel(String buttonAddlabel) {
        this.buttonAddlabel = buttonAddlabel;
    }

    @Override
    public String getToastNotifyingAdded() {
        return ValueAdded;
    }

    @Override
    public String getValueDeleted() {
        return ValueDeleted;
    }

    @Override
    public void insertEvent(final String Categoryname, final String image) {
        RealmOperation realmOperation = RealmOperation.getInstances();
        realmOperation.insertEventCategory(Categoryname, image);
    }
    @Override
    public String getImageByIdSelected(int id) {
        String imageName = "";
        if (id >= 0) {
            imageName = images[id];
        } else {
            imageName = images[0];
        }
        return imageName;
    }

    @Override
    public String getImage(int i) {
        return this.images[i];
    }
}