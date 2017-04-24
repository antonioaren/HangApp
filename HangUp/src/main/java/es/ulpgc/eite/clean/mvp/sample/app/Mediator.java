package es.ulpgc.eite.clean.mvp.sample.app;

import es.ulpgc.eite.clean.mvp.sample.category.HangApp;


public interface Mediator {

  void startingSearchScreen(HangApp.toSearch presenter);

  void startingAddScreen(HangApp.toAdd presenter);

  void startingHangAppScreen(HangApp.ToHangApp presenter);
}