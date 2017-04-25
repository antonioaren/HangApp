package es.ulpgc.eite.clean.mvp.sample.app;

import es.ulpgc.eite.clean.mvp.sample.add.Add;
import es.ulpgc.eite.clean.mvp.sample.category.Category;
import es.ulpgc.eite.clean.mvp.sample.detail.DetailPresenter;
import es.ulpgc.eite.clean.mvp.sample.information.Information;
import es.ulpgc.eite.clean.mvp.sample.search.Search;


public interface
Mediator {

  void startingSearchScreen(Search.ToSearch presenter);

  void startingAddScreen(Add.ToAdd presenter);

  void startingCategoryScreen(Category.ToCategory presenter);

  void startingInformationScreen(Information.ToInformation presenter);

  void startingDetailScreen(DetailPresenter Presenter);
}