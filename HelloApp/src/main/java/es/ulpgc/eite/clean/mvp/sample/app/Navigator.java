package es.ulpgc.eite.clean.mvp.sample.app;

import es.ulpgc.eite.clean.mvp.sample.hangapp.HangApp;
import es.ulpgc.eite.clean.mvp.sample.hello.Hello;
import es.ulpgc.eite.clean.mvp.sample.information.PartiesByCategories;
import es.ulpgc.eite.clean.mvp.sample.search.Search;

public interface Navigator {
  void goToNextScreen(HangApp.DummyTo presenter);

  void goToSearchScreen(HangApp.SearchTo presenter);

  void goToByeScreen(Hello.HelloToBye presenter);



  void goToPartyList(Search.ListTo presenter);

  void goToAddScreen(HangApp.AddTo presenter);












  void goDetailScreen(HangApp.DetailTo presenter);



  void goToItemList(Search.PartiesByCategoriesTo presenter);

  void goDetailScreenFromPartyList(PartiesByCategories.DetailTo presenter);
}