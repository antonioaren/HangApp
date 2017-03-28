package es.ulpgc.eite.clean.mvp.sample.app;

import es.ulpgc.eite.clean.mvp.sample.hangapp.HangApp;
import es.ulpgc.eite.clean.mvp.sample.hello.Hello;

public interface Navigator {
  void goToNextScreen(HangApp.DummyTo presenter);

  void goToSearchScreen(HangApp.SearchTo presenter);

  void goToByeScreen(Hello.HelloToBye presenter);

  void goToAddScreen(HangApp.HangAppToAdd presenter);
}
