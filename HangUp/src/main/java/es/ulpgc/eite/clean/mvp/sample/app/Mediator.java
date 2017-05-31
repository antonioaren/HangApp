package es.ulpgc.eite.clean.mvp.sample.app;

import android.content.Context;

import es.ulpgc.eite.clean.mvp.sample.addCategory.AddCategory;
import es.ulpgc.eite.clean.mvp.sample.addParty.Add;
import es.ulpgc.eite.clean.mvp.sample.category.Category;
import es.ulpgc.eite.clean.mvp.sample.delete.Delete;
import es.ulpgc.eite.clean.mvp.sample.detail.Detail;
import es.ulpgc.eite.clean.mvp.sample.detail.DetailPresenter;
import es.ulpgc.eite.clean.mvp.sample.product.Product;


public interface

Mediator {

    void startingDetailScreen(Detail.ToDetail presenter);

    void startingDeleteScreen(Delete.ToDelete presenter);

    void startingAddScreen(Add.ToAdd presenter);

    Context getAppContext();

    void startingCategoryScreen(Category.ToCategory presenter);

    void startingProductScreen(Product.ToProduct presenter);


    void startingAddCategoryScreen(AddCategory.ToAdd presenter);

    //modificado nombre de metodo
    void SaveDataAdd(AddCategory.AddTo presenter);


    void SaveDataFromAddParty(Add.AddTo presenter);

    void deleteEvent(Delete.DeleteTo presenter);
}