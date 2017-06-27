package es.ulpgc.eite.clean.mvp.sample.app;

import es.ulpgc.eite.clean.mvp.sample.addParty.AddProduct;
import es.ulpgc.eite.clean.mvp.sample.category.Category;
import es.ulpgc.eite.clean.mvp.sample.product.Product;

public interface Navigator {

    void goToProductScreenFromAddScreen(AddProduct.AddTo presenter);
    void goDetailScreen(Product.ProductTo presenter);
    void goToAddCategoryScreen(Category.CategoryTo presenter);
    void goToAddPartyScreen(Product.ProductTo presenter);
    void goToProductScreen(Category.CategoryTo presenter);
    void goToCategoryScreen(Product.ProductTo presenter);
}