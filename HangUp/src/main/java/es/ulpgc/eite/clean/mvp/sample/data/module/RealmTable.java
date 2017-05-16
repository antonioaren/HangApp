package es.ulpgc.eite.clean.mvp.sample.data.module;

import es.ulpgc.eite.clean.mvp.sample.R;

/**
 * Created by eleonora on 15/05/2017.
 */

public interface RealmTable {


        String ID = "id";

        interface Category {

            String ID_CATEGORY = "id";
            String CATEGORY_NAME = "category";
            String PRODUCTS_AVAILABLES="products";
            int IMAGE= R.drawable.astro;
        }

        interface Product {
            String ID="id";
            String PRODUCT_NAME = "name";
            int IMAGE = R.drawable.astro;
            String PARTICIPANTS="participants";
            String DETAIL = "detail";
            String DATE ="date";
            String HOUR="hour";

        }


}
