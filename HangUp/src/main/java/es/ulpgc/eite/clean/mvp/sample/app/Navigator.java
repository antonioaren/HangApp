package es.ulpgc.eite.clean.mvp.sample.app;

import es.ulpgc.eite.clean.mvp.sample.addCategory.AddCategory;
import es.ulpgc.eite.clean.mvp.sample.addProduct.AddProduct;
import es.ulpgc.eite.clean.mvp.sample.category.Category;
import es.ulpgc.eite.clean.mvp.sample.product.Product;

public interface Navigator {

    void goDetailScreen(Product.ProductTo presenter);
    void goToAddCategoryScreen(Category.CategoryTo presenter);

    void goToAddProductScreen(Product.ProductTo presenter);
    void goToProductScreen(Category.CategoryTo presenter);
    void goToCategoryScreen(Product.ProductTo presenter);

    void KillingAddCategoryScreenAfterInserting(AddCategory.AddTo presenter);

    void KillingAddProductScreenAfterInserting(AddProduct.AddTo presenter);
}