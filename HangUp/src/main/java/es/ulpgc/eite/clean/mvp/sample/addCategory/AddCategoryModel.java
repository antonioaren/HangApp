package es.ulpgc.eite.clean.mvp.sample.addCategory;


import android.util.Log;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.Model;


/**
 * Created by eleonora on 17/04/2017.
 */

public class AddCategoryModel extends GenericModel<AddCategory.ModelToPresenter> implements AddCategory.PresenterToModel, Model<AddCategory.ModelToPresenter> {



    private String titleLabel,nameLabel,photoLabel,buttonPhotoLabel,buttonAddlabel;
   private String namecategory;


    public AddCategoryModel() {

    }


    @Override
    public void onCreate(AddCategory.ModelToPresenter presenter) {
        super.onCreate(presenter);

        titleLabel = "Publish a category";
       nameLabel="Name:";
        photoLabel = "Photo:";
        buttonPhotoLabel="Select...";
        buttonAddlabel="Add";
    }

    @Override
    public void onDestroy(boolean b) {
        Log.d(TAG, "calling onDestroy()");
    }




    @Override
    public String getTitleLabel() {
        return this.titleLabel;
    }
     @Override
    public void setTitleLabel(String titleLabel) {
        this.titleLabel = titleLabel;
    }
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
    public String getButtonPhotoLabel() {
        return buttonPhotoLabel;
    }
    @Override
    public void setButtonPhotoLabel(String buttonPhotoLabel) {
        this.buttonPhotoLabel = buttonPhotoLabel;
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
    public void setNameCategory(String name){
        this.namecategory=name;
    }

}