package es.ulpgc.eite.clean.mvp.sample.app;

import es.ulpgc.eite.clean.mvp.sample.add.Add;
import es.ulpgc.eite.clean.mvp.sample.category.Category;
import es.ulpgc.eite.clean.mvp.sample.search.Search;

public interface Navigator {


    void goToSearchScreen(Category.CategoryTo presenter);

    void goToAddScreen(Category.CategoryTo presenter);

    void addPartyData(Add.AddTo presenter);

    void goToProcessedInformationScreen(Search.ProcessedTo presenter);

    void goToInformationScreen(Category.CategoryTo presenter);


}