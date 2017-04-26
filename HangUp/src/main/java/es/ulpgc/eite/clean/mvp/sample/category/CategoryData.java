package es.ulpgc.eite.clean.mvp.sample.category;

/**
 * Created by Pedro Arenas on 24/4/17.
 */

public class CategoryData {
    private int image;
    private String name;
    private String description;

    public CategoryData(int image, String name, String descrition) {
        this.image = image;
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImage() {
        return image;
    }


}
