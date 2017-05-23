package es.ulpgc.eite.clean.mvp.sample.addCategory;

/**
 * Created by eleonora on 23/05/2017.
 */

public class ItemPhotosList {


    private int image;
    private String text;

public ItemPhotosList(int image,String text ){
    this.image=image;
    this.text=text;
}

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
