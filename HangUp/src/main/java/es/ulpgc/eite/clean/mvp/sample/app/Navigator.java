package es.ulpgc.eite.clean.mvp.sample.app;

import es.ulpgc.eite.clean.mvp.sample.category.Category;
import es.ulpgc.eite.clean.mvp.sample.product.Product;

public interface Navigator {


    void goDetailScreen(Product.ProductTo presenter);



    void goToAddCategoryScreen(Category.CategoryTo presenter);


    void goToAddPartyScreen(Product.ProductTo presenter);




    void goToProductScreen(Category.CategoryTo presenter);
    void gotoDeleteProductScreen(Product.ProductTo presenter);
    void goToDeleteScreen(Category.CategoryTo presenter);
}