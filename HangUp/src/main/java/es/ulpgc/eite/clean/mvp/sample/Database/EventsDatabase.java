package es.ulpgc.eite.clean.mvp.sample.Database;

import io.realm.RealmObject;

/**
 * Created by eleonora on 10/05/2017.
 */
//Calse de la base de datos
public class EventsDatabase extends RealmObject {
//    @PrimaryKey
  private String id;
    private String productName;
    private int image;
    private String number;
    private String detailText;
    private String Category;
    private String day;
    private String hour;
    private String web;

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }


    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }



    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
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

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDetailText() {
        return detailText;
    }

    public void setDetailText(String detailText) {
        this.detailText = detailText;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }




}
