package es.ulpgc.eite.clean.mvp.sample.app;

import android.view.MenuItem;

import es.ulpgc.eite.clean.mvp.sample.add.Add;
import es.ulpgc.eite.clean.mvp.sample.hangapp.HangApp;
import es.ulpgc.eite.clean.mvp.sample.hello.Hello;
import es.ulpgc.eite.clean.mvp.sample.search.Search;

public interface Navigator {
  void goToNextScreen(HangApp.DummyTo presenter);

  void goToSearchScreen(HangApp.SearchTo presenter);

  void goToByeScreen(Hello.HelloToBye presenter);

  void goToAddScreen(HangApp.AddTo presenter);




  boolean goBackfromAdd(Add.HangAppTo presenter, MenuItem item);

  void goToProcessedInformationScreen(Search.ProcessedTo presenter);
}
