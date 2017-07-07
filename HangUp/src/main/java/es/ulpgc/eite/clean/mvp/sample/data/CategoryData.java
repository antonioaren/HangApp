package es.ulpgc.eite.clean.mvp.sample.data;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Pedro Arenas on 24/4/17.
 */

public class CategoryData extends RealmObject {
    @PrimaryKey
    private String id;

    private String categoryName;
    private String image;
    private RealmList<ProductData> itemInfo;

    public CategoryData() {

    }

    public CategoryData(String id, String image, String category, RealmList<ProductData> itemInfo) {
        this.id = id;
        this.image = image;
        this.categoryName = category;
        this.itemInfo = itemInfo;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public RealmList<ProductData> getItemInfo() {
        return itemInfo;
    }
    //  public void setItemInfo(RealmList<ProductData> itemInfo) {
    // this.itemInfo = itemInfo;
    // }
}
