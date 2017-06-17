package es.ulpgc.eite.clean.mvp.sample.addCategory;


import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import es.ulpgc.eite.clean.mvp.GenericModel;
import es.ulpgc.eite.clean.mvp.Model;
import es.ulpgc.eite.clean.mvp.sample.category.CategoryModel;
import es.ulpgc.eite.clean.mvp.sample.data.CategoryData;
import io.realm.Realm;

/**
 * Created by eleonora on 17/04/2017.
 */

public class AddCategoryModel extends GenericModel<AddCategory.ModelToPresenter> implements AddCategory.PresenterToModel, Model<AddCategory.ModelToPresenter> {


    private String titleLabel, nameLabel, photoLabel, buttonPhotoLabel, buttonAddlabel;
    private String namecategory;
    private Realm realmDatabase;
   
    private String labelRadio0;
    private String labelRadio1;
    private String labelRadio2;
    private String labelRadio3;

    private String[] images;
    private CategoryModel category;

    public AddCategoryModel() {


        this.images = new String[]{"astro.jpeg", "cars.jpeg", "disco.jpg", "musica.png"};
    }

    @Override
    public void onCreate(AddCategory.ModelToPresenter presenter) {
        super.onCreate(presenter);

        titleLabel = "Publish a category";
        nameLabel = "Name:";
        photoLabel = "Photo:";
        buttonPhotoLabel = "Select...";
        buttonAddlabel = "Add";
        labelRadio0 = "astro";
        labelRadio1 = "academic";
        labelRadio2 = "car";
        labelRadio3 = "disco";
    }

    @Override
    public void onDestroy(boolean b) {
        Log.d(TAG, "calling onDestroy()");
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

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
    public void setNameCategory(String name) {
        this.namecategory = name;
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
    }

    private void readImageFromAssets(String name) {
        String msg = "";
        int im = 1;
        try {
            //Recoger el archivo desde assets

//            AssetManager am = Resources.getSystem().getAssets();
//            InputStream manager = am.open(name);
            //convierte el archivo de assets en un objeto drawable
//            Drawable drawableImage = Drawable.createFromStream(manager, null);
//
//            Bitmap bm = BitmapFactory.decodeStream(manager);
//            ByteArrayOutputStream stream = new ByteArrayOutputStream();
//            bm.compress(Bitmap.CompressFormat.PNG, 100, stream);
//            byte[] byteArray = stream.toByteArray();
//            im = Integer.parseInt(byteArray.toString());

            //  image=Integer.parseInt(drawableImage.toString());
            Context context = getPresenter().getManagedContext();
            InputStream stream = context.getAssets().open(name);

        } catch (IOException e) {
            //Captando el mensaje en caso de error al cargar el archivo
            Log.e(TAG, e.getMessage());
        }

    }


    @Override
    public String[] getImages() {
        return this.images;
    }

    @Override
    public String getImageByIdSelected(int id) {
        String image = "";
        if (id >= 0) {
            image = images[id];
        } else {
            image = images[0];
        }
        return image;
    }
}