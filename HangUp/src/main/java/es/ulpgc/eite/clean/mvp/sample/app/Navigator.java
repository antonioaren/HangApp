package es.ulpgc.eite.clean.mvp.sample.app;

import es.ulpgc.eite.clean.mvp.sample.addParty.Add;
import es.ulpgc.eite.clean.mvp.sample.addParty.AddPartyPresenter;
import es.ulpgc.eite.clean.mvp.sample.category.Category;
import es.ulpgc.eite.clean.mvp.sample.product.Product;
import es.ulpgc.eite.clean.mvp.sample.product.ProductPresenter;

public interface Navigator {

    void goToProductScreenFromAddScreen(Add.AddTo presenter);
    void goDetailScreen(Product.ProductTo presenter);
    void goToAddCategoryScreen(Category.CategoryTo presenter);
    void goToAddPartyScreen(Product.ProductTo presenter);
    void goToProductScreen(Category.CategoryTo presenter);
    void gotoDeleteProductScreen(Product.ProductTo presenter);
    void goToDeleteScreen(Category.CategoryTo presenter);


    void goToCategoryScreen(Product.ProductTo presenter);
}