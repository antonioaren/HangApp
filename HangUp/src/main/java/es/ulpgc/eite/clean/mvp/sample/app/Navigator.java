package es.ulpgc.eite.clean.mvp.sample.app;

import es.ulpgc.eite.clean.mvp.sample.addParty.Add;
import es.ulpgc.eite.clean.mvp.sample.category.Category;
import es.ulpgc.eite.clean.mvp.sample.product.Product;

public interface Navigator {


    void goDetailScreen(Product.ProductTo presenter);

    void goToSearchScreen(Category.CategoryTo presenter);

    void goToAddScreen(Category.CategoryTo presenter);


    void SaveDataAdd(Add.AddTo presenter);


    void goToProductScreen(Category.CategoryTo presenter);


}