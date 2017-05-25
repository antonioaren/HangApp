package es.ulpgc.eite.clean.mvp.sample.app;

import es.ulpgc.eite.clean.mvp.sample.addParty.Add;
import es.ulpgc.eite.clean.mvp.sample.category.Category;
import es.ulpgc.eite.clean.mvp.sample.product.Product;

public interface Navigator {


    void goDetailScreen(Product.ProductTo presenter);

    void goToSearchScreen(Category.CategoryTo presenter);

    void goToAddCategoryScreen(Category.CategoryTo presenter);


    void goToAddPartyScreen(Product.ProductTo presenter);

    void SaveDataAdd(Add.AddTo presenter);


    void goToProductScreen(Category.CategoryTo presenter);


}