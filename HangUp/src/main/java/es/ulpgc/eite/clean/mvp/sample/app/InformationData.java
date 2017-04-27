package es.ulpgc.eite.clean.mvp.sample.app;

/**
 * Created by Pedro Arenas on 27/4/17.
 */

public class InformationData {
    private int image;
    private String name;
    private String Descripción;
    private String numberOfParticipants;


    public InformationData(int image, String name, String numberOfParticipants) {
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

    public String getDescripción() {
        return Descripción;
    }
}
