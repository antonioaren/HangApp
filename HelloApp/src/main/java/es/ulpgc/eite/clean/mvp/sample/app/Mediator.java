package es.ulpgc.eite.clean.mvp.sample.app;

import es.ulpgc.eite.clean.mvp.sample.hangapp.HangApp;
import es.ulpgc.eite.clean.mvp.sample.hello.Hello;
import es.ulpgc.eite.clean.mvp.sample.information.PartiesByCategories;

public interface Mediator {
  void startingDummyScreen(HangApp.ToDummy presenter);

  void startingSearchScreen(HangApp.toSearch presenter);

  void startingHelloScreen(Hello.ToHello presenter);

  void startingAddScreen(HangApp.toAdd presenter);




  void startingHangAppScreen(HangApp.ToHangApp presenter);





  void startingPartiesListScreen(PartiesByCategories.ToPartiesByCategories presenter);
}