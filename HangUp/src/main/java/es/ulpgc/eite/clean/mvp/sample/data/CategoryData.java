package es.ulpgc.eite.clean.mvp.sample.data;

import java.util.List;

import io.realm.RealmObject;

/**
 * Created by Pedro Arenas on 24/4/17.
 */

public class CategoryData extends RealmObject {
    private int image;
    private String name;
    private String numberOfParticipants;
    private String Detalle;
    private String story;
    private String Date;
    private String hour;
    private List<InformationData> ItemInfo;

    public CategoryData(int image, String name, String numberOfParticipants, List<InformationData> item,
                        String details, String story, String Date, String hour) {
        this.image = image;
        this.name = name;
        this.numberOfParticipants = numberOfParticipants;
        this.ItemInfo = item;
        this.Detalle = details;
        this.story = story;
        this.Date = Date;
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

    public String getDetalle() {
        return Detalle;
    }

    public String getStory() {
        return story;
    }

    public String getDate() {
        return Date;
    }

    public String getHour() {
        return hour;
    }
    public List<InformationData> getItemInfo() {
        return ItemInfo;
    }
}
