package es.ulpgc.eite.clean.mvp.sample.app;

import android.content.Context;

import es.ulpgc.eite.clean.mvp.sample.addCategory.AddCategory;
import es.ulpgc.eite.clean.mvp.sample.addParty.Add;
import es.ulpgc.eite.clean.mvp.sample.category.Category;
import es.ulpgc.eite.clean.mvp.sample.detail.DetailPresenter;
import es.ulpgc.eite.clean.mvp.sample.product.Product;
import es.ulpgc.eite.clean.mvp.sample.search.Search;


public interface
Mediator {


    void startingSearchScreen(Search.ToSearch presenter);

  void startingAddScreen(Add.ToAdd presenter);

    Context getAppContext();

    void startingCategoryScreen(Category.ToCategory presenter);

  void startingProductScreen(Product.ToProduct presenter);

  void startingDetailScreen(DetailPresenter Presenter);


  void startinAddCategoryScreen(AddCategory.ToAdd presenter);
}