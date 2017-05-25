package es.ulpgc.eite.clean.mvp.sample.addCategory;


import android.util.Log;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.Model;
import es.ulpgc.eite.clean.mvp.sample.R;
import es.ulpgc.eite.clean.mvp.sample.category.CategoryModel;
import io.realm.Realm;


/**
 * Created by eleonora on 17/04/2017.
 */

public class AddCategoryModel extends GenericModel<AddCategory.ModelToPresenter> implements AddCategory.PresenterToModel, Model<AddCategory.ModelToPresenter> {



    private String titleLabel,nameLabel,photoLabel,buttonPhotoLabel,buttonAddlabel;
   private String namecategory;
    private Realm realmDatabase;
    CategoryModel categoryModel;
    String []names;
    Integer[]images;
    //final CharSequence[] options;
    public AddCategoryModel() {
     categoryModel= new CategoryModel();
       // options= new CharSequence[]{"Select from galery", "Cancel"};
        this.names= new String[]{"cultural","fiesta","deportivo","academico"};
        this.images=new Integer[]{R.drawable.astro,R.drawable.disco,R.drawable.cars,R.drawable.ulpgc};

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


    @Override
    public void insertEvent(final String Categoryname, final int image) {
     categoryModel.insertEvent(Categoryname, image);

    }

    public String getNamecategory() {
        return namecategory;
    }
@Override
  public String[]getNames(){
      return this.names;
  }
@Override
  public Integer[] getImages(){
    return this.images;
}


@Override
    public int getImageByMessage(int id){




    return images[id];



}
}