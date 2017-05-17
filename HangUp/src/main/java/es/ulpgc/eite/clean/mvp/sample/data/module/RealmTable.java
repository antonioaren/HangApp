package es.ulpgc.eite.clean.mvp.sample.data.module;

/**
 * Created by eleonora on 15/05/2017.
 */

public interface RealmTable {


        String ID = "id";

        interface Category {

            String CATEGORY_NAME = "CategoryName";
            String IMAGE = "image";
            String PRODUCTS = "ItemInfo";
            String PRODUCTS_AVAILABLES = "productsAvailables";

        }

        interface Product {

            String PRODUCT_NAME = "productName";
            String IMAGEN = "image";
            String PARTICIPANTS="participants";
            String DETAIL = "detailText";
            String DATE ="date";
            String HOUR="hour";

        }


}
