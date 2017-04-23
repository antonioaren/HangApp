package es.ulpgc.eite.clean.mvp.sample;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import es.ulpgc.eite.clean.mvp.sample.information.PartiesByCategoriesModel;
import es.ulpgc.eite.clean.mvp.sample.search.SearchModel;
import es.ulpgc.eite.clean.mvp.sample.search.SearchPresenter;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
  SearchModel search= new SearchModel();
  SearchPresenter searchpr= new SearchPresenter();
  PartiesByCategoriesModel pbcm= new PartiesByCategoriesModel();
  @Test
  public void useAppContext() throws Exception {
    // Context of the app under test.
    Context appContext = InstrumentationRegistry.getTargetContext();

    assertEquals("es.ulpgc.eite.clean.mvp.dummy", appContext.getPackageName());
  }
@Test
  public void getList(){
  String[]categories= new String[]{"Cines","Culturales","Conciertos","Verbenas","Discotecas"};
  assertArrayEquals(categories,search.getListCategories());
}
  @Test
  public void getListByPresenter(){
    String[]categories= new String[]{"Cines","Culturales","Conciertos","Verbenas","Discotecas"};
    assertArrayEquals(categories,searchpr.getCategories());
  }
@Test
  public void getDefaultList(){
  String[]list= new String[]{"Party 1 soon...","Party 2 soon..."};

  assertArrayEquals(list,pbcm.getDefaulParty());
}
}
