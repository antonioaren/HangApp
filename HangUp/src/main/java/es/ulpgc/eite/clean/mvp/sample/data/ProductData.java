package es.ulpgc.eite.clean.mvp.sample.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by eleonora on 10/05/2017.
 */
//Clase de la base de datos
public class ProductData extends RealmObject {
    @PrimaryKey
    private String id;
    @Required
    private String productName;

    private int image;
    @Required
    private String participants;
    @Required
    private String detailText;
    @Required
    private String day;
    @Required
    private String hour;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getImage() {
        return image;
    }
    public void setImage(int image) {
        this.image = image;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public String getDetailText() {
        return detailText;
    }
    public void setDetailText(String detailText) {
        this.detailText = detailText;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

public ProductData(int image,  String productName, String participants, String detailText, String day, String hour){
    this.image=image;

    this.productName=productName;
    this.participants=participants;
    this.detailText=detailText;
    this.day=day;
    this.hour=hour;
}
public ProductData(){

}
}
