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

    private String CategoryName;
    private int image;
    private int productsAvailables;
    private RealmList<ProductData> ItemInfo;

    public CategoryData() {

    }

    public CategoryData(String id, int image, String category, RealmList<ProductData> itemInfo) {
        this.id = id;
        this.image = image;
        this.CategoryName = category;
        this.ItemInfo = itemInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public RealmList<ProductData> getItemInfo() {
        return ItemInfo;
    }

    public void setItemInfo(RealmList<ProductData> itemInfo) {
        ItemInfo = itemInfo;
    }

    public int getProductsAvailables() {
        return productsAvailables;
    }

    public void setProductsAvailables(int productsAvailables) {
        this.productsAvailables = productsAvailables;
    }
}
