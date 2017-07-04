package es.ulpgc.eite.clean.mvp.sample.data;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by eleonora on 10/05/2017.
 */
//Clase de la base de datos
public class ProductData extends RealmObject {
    @PrimaryKey
    private String id;

    private String productName;
    private String place;
    private String date;
    private String timeI;
    private String timeF;
    private String detailText;
    private String image;


    public ProductData() {
    }

    public ProductData(String id, String productName, String place, String date, String timeI,
                       String timeF, String detailText, String image) {
        this.id = id;
        this.productName = productName;
        this.place = place;
        this.date = date;
        this.timeI = timeI;
        this.timeF = timeF;
        this.detailText = detailText;
        this.image = image;
    }

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

    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }

    public String getTimeI() {
        return timeI;
    }
    public void setTimeI(String timeI) {
        this.timeI = timeI;
    }

    public String getTimeF() {
        return timeF;
    }
    public void setTimeF(String timeF) {
        this.timeF = timeF;
    }

    public String getDetailText() {
        return detailText;
    }
    public void setDetailText(String detailText) {
        this.detailText = detailText;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
}
