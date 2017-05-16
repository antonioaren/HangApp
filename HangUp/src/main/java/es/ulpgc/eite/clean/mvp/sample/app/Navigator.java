package es.ulpgc.eite.clean.mvp.sample.app;

import es.ulpgc.eite.clean.mvp.sample.add.Add;
import es.ulpgc.eite.clean.mvp.sample.category.Category;
import es.ulpgc.eite.clean.mvp.sample.product.Product;
import es.ulpgc.eite.clean.mvp.sample.search.Search;

public interface Navigator {


    void goDetailScreen(Product.ProductTo presenter);

    void goToSearchScreen(Category.CategoryTo presenter);

    void goToAddScreen(Category.CategoryTo presenter);


    void SaveDataAdd(Add.AddTo presenter);


    void goToProductScreen(Category.CategoryTo presenter);


}