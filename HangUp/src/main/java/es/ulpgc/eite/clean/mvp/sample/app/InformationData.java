package es.ulpgc.eite.clean.mvp.sample.app;

/**
 * Created by Pedro Arenas on 27/4/17.
 */

public class InformationData {
    private int image;
    private String name;
    private String numberOfParticipants;
    private String Details;


    public InformationData(int image, String name, String numberOfParticipants, String details) {
        this.image = image;
        this.name = name;
        this.numberOfParticipants = numberOfParticipants;
        this.Details = details;
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

    public String getDetails() {
        return Details;
    }
}
