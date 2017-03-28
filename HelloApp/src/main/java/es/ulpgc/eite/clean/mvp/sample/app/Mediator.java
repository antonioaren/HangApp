package es.ulpgc.eite.clean.mvp.sample.app;

import es.ulpgc.eite.clean.mvp.sample.hangapp.HangApp;
import es.ulpgc.eite.clean.mvp.sample.hello.Hello;

public interface Mediator {
  void startingDummyScreen(HangApp.ToDummy presenter);

  void startingSearchScreen(HangApp.ToDummy presenter);

  void startingHelloScreen(Hello.ToHello presenter);
}
