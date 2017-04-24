package es.ulpgc.eite.clean.mvp.sample.app;

import es.ulpgc.eite.clean.mvp.sample.category.HangApp;

import es.ulpgc.eite.clean.mvp.sample.search.Search;

public interface Navigator {


    void goToSearchScreen(HangApp.SearchTo presenter);

    void goToAddScreen(HangApp.AddTo presenter);

    void goToProcessedInformationScreen(Search.ProcessedTo presenter);

    void goDetailScreen(HangApp.DetailTo presenter);
}