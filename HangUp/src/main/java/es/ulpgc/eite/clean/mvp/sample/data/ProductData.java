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
    @Required
    private String place;
    @Required
    private String date;
    @Required
    private String TimeI;
    @Required
    private String TimeF;
    @Required
    private String detailText;

    public ProductData() {
    }

    public ProductData(String id, String productName, String place, String date, String timeI, String timeF, String detailText) {
        this.id = id;
        this.productName = productName;
        this.place = place;
        this.date = date;
        this.TimeI = timeI;
        this.TimeF = timeF;
        this.detailText = detailText;
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
        return TimeI;
    }

    public void setTimeI(String timeI) {
        TimeI = timeI;
    }

    public String getTimeF() {
        return TimeF;
    }

    public void setTimeF(String timeF) {
        TimeF = timeF;
    }

    public String getDetailText() {
        return detailText;
    }

    public void setDetailText(String detailText) {
        this.detailText = detailText;
    }

}
