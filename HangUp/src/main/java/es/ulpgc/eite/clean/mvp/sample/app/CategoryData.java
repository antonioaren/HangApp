package es.ulpgc.eite.clean.mvp.sample.app;

import java.util.List;

/**
 * Created by Pedro Arenas on 24/4/17.
 */

public class CategoryData {
    private int image;
    private String name;
    private String numberOfParticipants;
    private String Detalle;

    private List<InformationData> ItemInfo;

    public CategoryData(int image, String name, String numberOfParticipants, List<InformationData> item,
                        String details) {
        this.image = image;
        this.name = name;
        this.numberOfParticipants = numberOfParticipants;
        this.ItemInfo = item;
        this.Detalle = details;
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

    public List<InformationData> getItemInfo() {
        return ItemInfo;
    }
}
