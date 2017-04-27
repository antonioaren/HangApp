package es.ulpgc.eite.clean.mvp.sample.category;

/**
 * Created by Pedro Arenas on 24/4/17.
 */

public class CategoryData {
    private int image;
    private String name;
    private String numberOfParticipants;

    public CategoryData(int image, String name, String numberOfParticipants) {
        this.image = image;
        this.name = name;
        this.numberOfParticipants = numberOfParticipants;
    }

    public String getName() {
        return name;
    }

    public String getNumberOfParticipants() {
        return numberOfParticipants;
    }

    public int getImage() {
        return image;
    }


}
