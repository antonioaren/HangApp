package es.ulpgc.eite.clean.mvp.sample.data;


/**
 * Created by Pedro Arenas on 27/4/17.
 */


public class InformationData_Old {
    private int image;
    private String name;
    private String numberOfParticipants;
    private String Details, story, date, hour;


    public InformationData_Old(int image, String name, String numberOfParticipants, String details, String story, String date, String hour) {
        this.image = image;
        this.name = name;
        this.numberOfParticipants = numberOfParticipants;
        this.Details = details;
        this.story = story;
        this.date = date;
        this.hour = hour;
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

    public String getStory() {
        return story;
    }

    public String getDate() {
        return date;
    }

    public String getHour() {
        return hour;
    }
}
