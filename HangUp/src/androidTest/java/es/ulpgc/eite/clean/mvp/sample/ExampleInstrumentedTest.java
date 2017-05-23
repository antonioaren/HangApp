package es.ulpgc.eite.clean.mvp.sample;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.ViewAssertion;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Test;
import org.junit.runner.RunWith;

import es.ulpgc.eite.clean.mvp.sample.category.CategoryPresenter;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.supportsInputMethods;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static es.ulpgc.eite.clean.mvp.sample.R.id.textName;
import static java.util.regex.Pattern.matches;
import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

  @Test
  public void useAppContext() throws Exception {
    // Context of the app under test.
    Context appContext = InstrumentationRegistry.getTargetContext();

    assertEquals("es.ulpgc.eite.clean.mvp.dummy", appContext.getPackageName());
  }
@Test
  public void testOnAddClicked()throws Exception{
  CategoryPresenter category= new CategoryPresenter();
 onView(withId(R.id.buttonAdd)).perform(click());
 // onView(withId(R.id.textName)).check(matches(ViewMatchers.isDisplayed()));
}


    @Test
public void testOnSearchCliked()throws Exception{
      // onView(withId(R.id.buttonAdd)).check(matches(ViewMatchers.isDisplayed()));
        //onView(withId(R.id.delete)).check(matches(ViewMatchers.isDisplayed()));
}

}
