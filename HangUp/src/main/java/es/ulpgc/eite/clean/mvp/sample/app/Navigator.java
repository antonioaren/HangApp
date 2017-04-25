package es.ulpgc.eite.clean.mvp.sample.app;

import es.ulpgc.eite.clean.mvp.sample.category.Category;
import es.ulpgc.eite.clean.mvp.sample.search.Search;

public interface Navigator {


    void goToSearchScreen(Category.CategoryTo presenter);

    void goToAddScreen(Category.CategoryTo presenter);

    void goToProcessedInformationScreen(Search.ProcessedTo presenter);

    void goToItemList(Category.CategoryTo presenter);


}